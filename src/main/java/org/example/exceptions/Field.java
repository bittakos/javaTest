package org.example.exceptions;

public class Field {

    private Position position;
    boolean isMined;
    boolean isVisited;

    public Field(Position position, boolean isMined, boolean isVisited) {
        this.position = position;
        this.isMined = isMined;
        this.isVisited = isVisited;
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

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
