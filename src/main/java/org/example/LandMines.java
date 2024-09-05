package org.example;

import org.example.exceptions.*;

import java.util.Map;

public class LandMines {

    private final char mineSymbol = 'M';
    private final char clearSymbol = '-';





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

        //FLOODFILL










        return layout.length;
    }



    //TODO position might just be (0,0)
    //TODO prohibited logic (!visited && row/column has M)
    private  void floodfill(Map<Position, Field> mineField, Position position){
        boolean prohibited = false;
        if(!mineField.containsKey(position) || mineField.get(position).isMined() ||
        prohibited) {
            return;
        }
        mineField.remove(position);

        floodfill(mineField, new Position(position.getPosX(), position.getPosY() - 1));
        floodfill(mineField, new Position(position.getPosX(), position.getPosY() + 1));
        floodfill(mineField, new Position(position.getPosX() - 1, position.getPosY()));
        floodfill(mineField, new Position(position.getPosX() + 1, position.getPosY()));

    }


}
