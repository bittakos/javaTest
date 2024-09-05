package org.example.exceptions;

import java.util.Map;

public class MineField {
    private Map<Position, Field> fields;

    public MineField() {
//        this.fields = fields;
    }

    public void addField(Field field){
        fields.put(field.getPosition(), field);
    }

    public Field getField(Position position){
        return fields.get(position);
    }
}
