package org.example.floodFilling;

import org.example.EDirection;
import org.example.exceptions.Field;
import org.example.exceptions.Position;

import java.util.Map;

public class FloodFiller {
    public static int floodfill(Map<Position, Field> mineField, Position position, EDirection direction) {
        return floodfill(mineField, position, direction, 0);
    }
    private static int floodfill(Map<Position, Field> mineField, Position position, EDirection direction, int fieldCounter) {
        if (!mineField.containsKey(position) || mineField.get(position).isMined() ||
                DangerChecker.isDangerous(mineField, position, direction)) {
            return fieldCounter;
        }

        fieldCounter++;
        mineField.remove(position);

        fieldCounter = floodfill(mineField, new Position(position.getPosX(), position.getPosY() - 1), EDirection.NORTH, fieldCounter);
        fieldCounter = floodfill(mineField, new Position(position.getPosX(), position.getPosY() + 1), EDirection.SOUTH, fieldCounter);
        fieldCounter = floodfill(mineField, new Position(position.getPosX() - 1, position.getPosY()), EDirection.WEST, fieldCounter);
        fieldCounter = floodfill(mineField, new Position(position.getPosX() + 1, position.getPosY()), EDirection.EAST, fieldCounter);

        return fieldCounter;
    }
}

