package org.example.exceptions;

import java.util.HashMap;
import java.util.Map;

public class MineField {
    private Map<Position, Field> fields;

    public MineField() {
        this.fields = new HashMap<>();
    }

    public void addField(Field field){
        fields.put(field.getPosition(), field);
    }

    public Field getField(Position position){
        return fields.get(position);
    }

    public Map<Position, Field> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "MineField{" +
                "fields=" + fields +
                '}';
    }
}
