package org.example;

import org.example.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LandMines {

    private final char mineSymbol = 'M';
    private final char clearSymbol = '-';

    private static final int STARTING_X_POS = 0;
    private static final int STARTING_Y_POS = 0;

    private static int fieldCounter = 0;






    public int numClear(String[] layout){

        // CHECK FOR RULES

        // check if nr of fields >=2 && <= 50
        if(!LayoutSizeChecker.checkLayoutSize(layout)){
            throw new InvalidNumberOfFieldsException();
        }


        String firstRow = layout[0];
        char startingField = firstRow.charAt(0);

        //check if 1st field is M
        if(startingField == mineSymbol){
            throw new InvalidStartingFieldException();
        }

        // check for n x n
        if(firstRow.length() != layout.length){
            throw new InvalidLayoutSizeException();
        }

        //Convert

        MineField mineField = new MineField();

        //TODO better names (i,j)
        for(int i = 0; i < layout.length; i++){
            String row = layout[i];
            for(int j = 0; j < row.length(); j++){
                boolean isMined = row.charAt(j) == mineSymbol;
                //TODO isVisited true ha i and j = 0!!!!
                Field field = new Field(new Position(j,i),isMined, false);
                mineField.addField(field);
            }
        }

        mineField.getField(new Position(STARTING_X_POS, STARTING_Y_POS)).setVisited(true);


        floodfill(mineField.getFields(), new Position(STARTING_X_POS,STARTING_Y_POS), EDirection.FIRST);

        System.out.println("Field Counter = " + fieldCounter);

        return fieldCounter;
    }



    //TODO position might just be (0,0)
    private void floodfill(Map<Position, Field> mineField, Position position, EDirection direction){
        if(!mineField.containsKey(position) || mineField.get(position).isMined() ||
                isDangerous(mineField,position,direction)) {
            return;
        }
        fieldCounter++;
        mineField.remove(position);
        //TODO isVisited = true useless?

        floodfill(mineField, new Position(position.getPosX(), position.getPosY() - 1), EDirection.NORTH);
        floodfill(mineField, new Position(position.getPosX(), position.getPosY() + 1), EDirection.SOUTH);
        floodfill(mineField, new Position(position.getPosX() - 1, position.getPosY()), EDirection.WEST);
        floodfill(mineField, new Position(position.getPosX() + 1, position.getPosY()), EDirection.EAST);

    }

    private boolean isDangerous(Map<Position, Field> mineField,Position position, EDirection direction) {

        if(mineField.get(position).isVisited()){
            return false;
        }

        List<Field> fields = new ArrayList<>();
        switch (direction) {
            case NORTH -> {
                for(Field field : mineField.values()){
                    if(field.getPosition().getPosX() == position.getPosX() && field.getPosition().getPosY() < position.getPosY()){
                        fields.add(field);
                    }
                }
            }
            case SOUTH -> {
                for(Field field : mineField.values()){
                    if(field.getPosition().getPosX() == position.getPosX() && field.getPosition().getPosY() > position.getPosY()){
                        fields.add(field);
                    }
                }
            }
            case WEST -> {
                for(Field field : mineField.values()){
                    if(field.getPosition().getPosX() < position.getPosX() && field.getPosition().getPosY() == position.getPosY()){
                        fields.add(field);
                    }
                }
            }
            case EAST -> {
                for(Field field : mineField.values()){
                    if(field.getPosition().getPosX() > position.getPosX() && field.getPosition().getPosY() == position.getPosY()){
                        fields.add(field);
                    }
                }
            }
            case FIRST -> fields.add(mineField.get(position)); //TODO could be better
        }
        return fields.stream().anyMatch(Field::isMined);
    }


}
