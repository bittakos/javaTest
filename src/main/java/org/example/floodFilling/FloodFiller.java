package org.example.floodFilling;

import org.example.enums.EDirection;
import org.example.mineFieldMap.Field;
import org.example.mineFieldMap.Position;

import java.util.Map;

public class FloodFiller {
    public static int floodfill(Map<Position, Field> mineField, Position position, EDirection direction) {
        return processFloodfill(mineField, position, direction, 0);
    }
    // Added extra private function to separate fieldCounter values between tests
    private static int processFloodfill(Map<Position, Field> mineField, Position position, EDirection direction, int fieldCounter) {
        if (!mineField.containsKey(position) || mineField.get(position).isMined() ||
                DangerChecker.isDangerous(mineField, position, direction)) {
            return fieldCounter;
        }

        fieldCounter++;
        mineField.remove(position);

        fieldCounter = processFloodfill(mineField, new Position(position.posX(), position.posY() - 1), EDirection.NORTH, fieldCounter);
        fieldCounter = processFloodfill(mineField, new Position(position.posX(), position.posY() + 1), EDirection.SOUTH, fieldCounter);
        fieldCounter = processFloodfill(mineField, new Position(position.posX() - 1, position.posY()), EDirection.WEST, fieldCounter);
        fieldCounter = processFloodfill(mineField, new Position(position.posX() + 1, position.posY()), EDirection.EAST, fieldCounter);

        return fieldCounter;
    }
}

