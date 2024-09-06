package org.example.fieldConverting;

import org.example.exceptions.Field;
import org.example.exceptions.MineField;
import org.example.exceptions.Position;

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
