package org.example;

import org.example.enums.EDirection;
import org.example.exceptions.*;
import org.example.fieldConverting.FieldConverter;
import org.example.floodFilling.FloodFiller;
import org.example.mineFieldMap.MineField;
import org.example.mineFieldMap.Position;
import org.example.ruleChecking.LayoutSizeChecker;

public class LandMines {
    private static final int STARTING_X_POS = 0;
    private static final int STARTING_Y_POS = 0;

    public int numClear(String[] layout){

        if(!LayoutSizeChecker.checkLayoutSize(layout)){
            throw new InvalidNumberOfFieldsException();
        }

        String firstRow = layout[0];
        char startingField = firstRow.charAt(0);

        char mineSymbol = 'M';
        if(startingField == mineSymbol){
            throw new InvalidStartingFieldException();
        }

        if(firstRow.length() != layout.length){
            throw new InvalidLayoutSizeException();
        }

        //Convert input to Fields
        MineField mineField = FieldConverter.convertField(layout);

        return FloodFiller.floodfill(mineField.getFields(), new Position(STARTING_X_POS, STARTING_Y_POS), EDirection.FIRST);
    }

}
