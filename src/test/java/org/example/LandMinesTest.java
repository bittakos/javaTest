package org.example;

import org.example.exceptions.InvalidLayoutSizeException;
import org.example.exceptions.InvalidNumberOfFieldsException;
import org.example.exceptions.InvalidStartingFieldException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandMinesTest {

    @Test
    void whenInvalidStartingField_thenThrowException(){
        String row = "M--";
        String[] layout = {row};
        LandMines landMines = new LandMines();
        assertThrows(InvalidStartingFieldException.class, () -> landMines.numClear(layout));

    }

    @Test
    void whenInvalidNumberOfFieldsLess_thenThrowsException() {
        String row0 = "-";

        String[] layout = {row0};
        LandMines landMines = new LandMines();
        assertThrows(InvalidNumberOfFieldsException.class, () -> landMines.numClear(layout));
    }

    @Test
    void whenInvalidNumberOfFieldsMore_thenThrowsException() {
        String row0 = "--------";
        String row1 = "--------";
        String row2 = "--------";
        String row3 = "--------";
        String row4 = "--------";
        String row5 = "--------";
        String row6 = "--------";
        String row7 = "--------";
        String[] layout = {row0, row1, row2, row3, row4, row5, row6, row7};
        LandMines landMines = new LandMines();
        assertThrows(InvalidNumberOfFieldsException.class, () -> landMines.numClear(layout));
    }

    @Test
    void whenInvalidLayoutSize_thenThrowException() {
        String row0 = "--";
        String row1 = "--";
        String row2 = "--";
        String[] layout = {row0, row1, row2};
        LandMines landMines = new LandMines();
        assertThrows(InvalidLayoutSizeException.class, () -> landMines.numClear(layout));
    }


    @Test
    void exampleTestCase1_thenReturns1() {
        String row0 = "-M-";
        String row1 = "---";
        String row2 = "M--";
        String[] layout = {row0, row1, row2};
        LandMines landMines = new LandMines();
        assertEquals(1, landMines.numClear(layout));
    }

    @Test
    void exampleTestCase2_thenReturns3(){
        String row0 = "-M-";
        String row1 = "-M-";
        String row2 = "--M";
        String[] layout = {row0, row1, row2};
        LandMines landMines = new LandMines();
        assertEquals(3, landMines.numClear(layout));
    }

    @Test
    void exampleTestCase3_thenReturns12(){
        String row0 = "--M-";
        String row1 = "-MM-";
        String row2 = "----";
        String row3 = "----";
        String[] layout = {row0, row1, row2, row3};
        LandMines landMines = new LandMines();
        assertEquals(12, landMines.numClear(layout));
    }

    @Test
    void exampleTestCase4_thenReturns21(){
        String row0 = "-----";
        String row1 = "--M-M";
        String row2 = "-----";
        String row3 = "-M---";
        String row4 = "---M-";
        String[] layout = {row0, row1, row2, row3, row4};
        LandMines landMines = new LandMines();
        assertEquals(21, landMines.numClear(layout));
    }

}