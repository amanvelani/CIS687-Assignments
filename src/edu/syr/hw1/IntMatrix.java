package edu.syr.hw1;

import java.util.Arrays;

public class IntMatrix {
    private int[] data;
    private int t_rows;
    private int t_cols;
    public IntMatrix(int r, int c) {
        if(r <= 0 || c <= 0){
            throw new UnsupportedOperationException("Rows and cols cannot be <= 0");
        }
        this.t_rows = r;
        this.t_cols = c;
        data = new int[t_rows * t_cols];
        initialize(0);
    }
    public int get(int r, int c) {
        //Check if the argument is inbound
        try{
            check_valid(r, c);
            int local_index = r * t_cols + c;
            return data[local_index];
        }catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public void set(int r, int c, int val) {
        try {
            check_valid(r, c);
            int local_index = r * t_cols + c;
            data[local_index] = val;
        }catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }

    private void check_valid(int row, int col){
        if(row < 0 || row >= t_rows || col < 0 || col >= t_cols){
            throw new UnsupportedOperationException("Invalid Cells: Out of bounds");
        }

    }

    public void initialize(int val) {
        if(val >= 0) {
            Arrays.fill(data, val);
        }else{
            System.out.println("Not valid input!");
        }
    }
}

