package org.example.fieldConverting;

import org.example.mineFieldMap.Field;
import org.example.mineFieldMap.MineField;
import org.example.mineFieldMap.Position;

public class FieldConverter {
    public static MineField convertField(String[] layout){
        char mineSymbol = 'M';
        MineField mineField = new MineField();
        for(int row = 0; row < layout.length; row++){
            String currentRow = layout[row];
            for(int column = 0; column < currentRow.length(); column++){
                boolean isMined = currentRow.charAt(column) == mineSymbol;
                Field field = new Field(new Position(column,row),isMined);
                mineField.addField(field);
            }
        }
        return mineField;
    }
}
