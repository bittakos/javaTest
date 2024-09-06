package org.example.mineFieldMap;

import java.util.HashMap;
import java.util.Map;

public class MineField {
    private final Map<Position, Field> fields;

    public MineField() {
        this.fields = new HashMap<>();
    }

    public void addField(Field field){
        fields.put(field.getPosition(), field);
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
