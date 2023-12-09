package edu.syr.hw5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackAdapterTest {
    edu.syr.hw5.StackAdapter<Integer> out;

    @Test
    public void t1() {
        out =  new edu.syr.hw5.StackAdapter<>();
        for (int i=0; i<5; i++) {
            out.push(i);
        }
        assertEquals(5, out.size(), "push 1 point");
        for (int i=0; i<5; i++) {
            assertEquals(4, out.peek(), "peek 0.5 point");
        }
        for (int i=4; i>=0; i--) {
            assertEquals(i, out.pop(), "pop 1 point");
        }
        assertEquals(0, out.size(), "size 0.5 point");
    }

    @Test
    public void t2() {
        out =  new edu.syr.hw5.StackAdapter<>();
        for (int i=0; i<5; i++) {
            out.push(i);
        }
        List<Integer> copy = out.getData();
        for (int i=0; i<5; i++) {
            assertEquals(i, copy.get(i), "getData 1 point");
        }
    }
}