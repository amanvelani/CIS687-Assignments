package edu.syr.hw1;

public class IntMatrix {
    private int[] data;
    private int t_rows;
    private int t_cols;
    public IntMatrix(int r, int c) {
        if(r <= 0 || c <= 0){
            throw new UnsupportedOperationException("");
        }
        this.t_rows = r;
        this.t_cols = c;
        data = new int[t_rows * t_cols];
        initialize(0);
    }
    public int get(int r, int c) {
        //Check if the argument is inbound
        check_valid(r, c);
        int local_index = r * t_cols + c;
        return data[local_index];
    }

    public void set(int r, int c, int val) {
        check_valid(r, c);
        int local_index = r * t_cols + c;
        data[local_index] = val;
    }

    private void check_valid(int row, int col){
        if(row < 0 || row >= t_rows || col < 0 || col >= t_cols){
            throw new IllegalArgumentException("Invalid cell: Row - " + row + " Column - " + col);
        }
    }

    public void initialize(int val) {
        for(int i = 0; i<data.length; i++){
            data[i] = val;
        }
    }

    public void print_data(){
        System.out.print("Data: ");
        for(int i = 0; i<data.length; i++){
            System.out.print(data[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args){
        IntMatrix mat = new IntMatrix(2,3);
        mat.print_data();
        mat.set(0,0,1);
        mat.set(0,1,2);
        mat.set(0,2,3);
        mat.print_data();
        mat.set(1,0,4);
        mat.set(1,1,5);
        mat.set(1,2,6);
        mat.print_data();
    }



}

