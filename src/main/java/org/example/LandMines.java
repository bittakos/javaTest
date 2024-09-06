package org.example;

import org.example.exceptions.*;
import org.example.fieldConverting.FieldConverter;
import org.example.floodFilling.FloodFiller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LandMines {
    private static final int STARTING_X_POS = 0;
    private static final int STARTING_Y_POS = 0;
    private int fieldCounter = 0;

    public int numClear(String[] layout){

        //TODO check comments

        // CHECK FOR RULES

        // check if nr of fields >=2 && <= 50
        if(!LayoutSizeChecker.checkLayoutSize(layout)){
            throw new InvalidNumberOfFieldsException();
        }


        String firstRow = layout[0];
        char startingField = firstRow.charAt(0);

        //check if 1st field is M
        char mineSymbol = 'M';
        if(startingField == mineSymbol){
            throw new InvalidStartingFieldException();
        }

        // check for n x n
        if(firstRow.length() != layout.length){
            throw new InvalidLayoutSizeException();
        }

        //Convert

        MineField mineField = FieldConverter.convertField(layout);

//        for(int row = 0; row < layout.length; row++){
//            String currentRow = layout[row];
//            for(int column = 0; column < currentRow.length(); column++){
//                boolean isMined = currentRow.charAt(column) == mineSymbol;
//                Field field = new Field(new Position(column,row),isMined);
//                mineField.addField(field);
//            }
//        }

       //mineField.getField(new Position(STARTING_X_POS, STARTING_Y_POS)).setVisited(true);


        fieldCounter = FloodFiller.floodfill(mineField.getFields(), new Position(STARTING_X_POS,STARTING_Y_POS), EDirection.FIRST);

        //System.out.println("Field Counter = " + fieldCounter);

        return fieldCounter;
    }

//    private void floodfill(Map<Position, Field> mineField, Position position, EDirection direction){
//        if(!mineField.containsKey(position) || mineField.get(position).isMined() ||
//                isDangerous(mineField,position,direction)) {
//            return;
//        }
//        fieldCounter++;
//        mineField.remove(position);
//
//        floodfill(mineField, new Position(position.getPosX(), position.getPosY() - 1), EDirection.NORTH);
//        floodfill(mineField, new Position(position.getPosX(), position.getPosY() + 1), EDirection.SOUTH);
//        floodfill(mineField, new Position(position.getPosX() - 1, position.getPosY()), EDirection.WEST);
//        floodfill(mineField, new Position(position.getPosX() + 1, position.getPosY()), EDirection.EAST);
//
//    }

//    private boolean isDangerous(Map<Position, Field> mineField,Position position, EDirection direction) {
//
//        List<Field> fields = new ArrayList<>();
//        switch (direction) {
//            case NORTH -> {
//                for(Field field : mineField.values()){
//                    if(field.getPosition().getPosX() == position.getPosX() && field.getPosition().getPosY() < position.getPosY()){
//                        fields.add(field);
//                    }
//                }
//            }
//            case SOUTH -> {
//                for(Field field : mineField.values()){
//                    if(field.getPosition().getPosX() == position.getPosX() && field.getPosition().getPosY() > position.getPosY()){
//                        fields.add(field);
//                    }
//                }
//            }
//            case WEST -> {
//                for(Field field : mineField.values()){
//                    if(field.getPosition().getPosX() < position.getPosX() && field.getPosition().getPosY() == position.getPosY()){
//                        fields.add(field);
//                    }
//                }
//            }
//            case EAST -> {
//                for(Field field : mineField.values()){
//                    if(field.getPosition().getPosX() > position.getPosX() && field.getPosition().getPosY() == position.getPosY()){
//                        fields.add(field);
//                    }
//                }
//            }
//            case FIRST -> fields.add(mineField.get(position));
//        }
//        return fields.stream().anyMatch(Field::isMined);
//    }


}
