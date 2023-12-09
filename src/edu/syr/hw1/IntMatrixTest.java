package edu.syr.hw1;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntMatrixTest {

    IntMatrix m1;
    int rows = 2;
    int cols = 3;

    @BeforeEach
    public  void setup() {

        m1 = new IntMatrix(rows, cols);
    }

    @Test
    public void intializeMatrix1() {
        m1.initialize(2);
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                Assert.assertEquals(m1.get(i, j), 2);
            }
        }
    }

    @Test
    public void intializeMatrix2() {
        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(0, 2, 3);
        m1.set(1, 0, 4);
        m1.set(1, 1, 5);
        m1.set(1, 2, 6);
        Assert.assertEquals(m1.get(0,0), 1);
        Assert.assertEquals(m1.get(0,1), 2);
        Assert.assertEquals(m1.get(0,2), 3);
        Assert.assertEquals(m1.get(1,0), 4);
        Assert.assertEquals(m1.get(1,1), 5);
        Assert.assertEquals(m1.get(1,2), 6);
    }

    @Test
    public void throwException() {
        assertThrows(Exception.class, () -> {
            m1.set(0, 3, 4);
        });
    }
}