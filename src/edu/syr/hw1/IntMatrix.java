package edu.syr.hw1;

public class IntMatrix {
    private int[] data;
    private int rows;
    private int cols;
    public IntMatrix(int r, int c) {
        if(r <= 0 || c <= 0){
            throw new UnsupportedOperationException("");
        }
        this.rows = r;
        this.cols = c;
        data = new int[rows * cols];
        initialize(0);
    }
    public int get(int r, int c) {
        //TODO
        throw new UnsupportedOperationException("");
    }

    public void set(int r, int c, int val) {
        //TODO
        throw new UnsupportedOperationException("");
    }

    public void initialize(int val) {
        for(int i = 0; i<data.length; i++){
            data[i] = val;
        }
    }
}

