package org.example.exceptions;

public class Field {

    //TODO remove needless sets

    private Position position;
    boolean isMined;

    public Field(Position position, boolean isMined) {
        this.position = position;
        this.isMined = isMined;;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isMined() {
        return isMined;
    }

    public void setMined(boolean mined) {
        isMined = mined;
    }

    @Override
    public String toString() {
        return "Field{" +
                "position=" + position +
                ", isMined=" + isMined +
                '}';
    }
}
