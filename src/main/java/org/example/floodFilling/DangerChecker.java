package org.example.floodFilling;

import org.example.enums.EDirection;
import org.example.mineFieldMap.Field;
import org.example.mineFieldMap.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DangerChecker {
    public static boolean isDangerous(Map<Position, Field> mineField, Position position, EDirection direction) {

        List<Field> fields = new ArrayList<>();
        switch (direction) {
            case NORTH -> {
                for(Field field : mineField.values()){
                    if(field.getPosition().posX() == position.posX() && field.getPosition().posY() < position.posY()){
                        fields.add(field);
                    }
                }
            }
            case SOUTH -> {
                for(Field field : mineField.values()){
                    if(field.getPosition().posX() == position.posX() && field.getPosition().posY() > position.posY()){
                        fields.add(field);
                    }
                }
            }
            case WEST -> {
                for(Field field : mineField.values()){
                    if(field.getPosition().posX() < position.posX() && field.getPosition().posY() == position.posY()){
                        fields.add(field);
                    }
                }
            }
            case EAST -> {
                for(Field field : mineField.values()){
                    if(field.getPosition().posX() > position.posX() && field.getPosition().posY() == position.posY()){
                        fields.add(field);
                    }
                }
            }
            case FIRST -> fields.add(mineField.get(position));
        }
        return fields.stream().anyMatch(Field::isMined);
    }
}
