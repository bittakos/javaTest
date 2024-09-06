package org.example.mineFieldMap;

public record Position(int posX, int posY) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return posX == position.posX && posY == position.posY;
    }

    @Override
    public String toString() {
        return "Position{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
