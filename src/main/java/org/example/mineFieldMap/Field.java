package org.example.mineFieldMap;

public class Field {
    private final Position position;
    boolean isMined;

    public Field(Position position, boolean isMined) {
        this.position = position;
        this.isMined = isMined;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isMined() {
        return isMined;
    }

    @Override
    public String toString() {
        return "Field{" +
                "position=" + position +
                ", isMined=" + isMined +
                '}';
    }
}
