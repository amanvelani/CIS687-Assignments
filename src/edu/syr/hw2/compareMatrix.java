package edu.syr.hw2;

public class compareMatrix {
    private int[] matrix1D;
    private int[][][] matrix3D;

    private int row = 100;
    private int col = 50;
    private int depth = 20;
    private int val;

    private int total_size = row * col * depth;

    public compareMatrix(){
        matrix1D = new int[this.total_size];
        matrix3D = new int[this.row][this.col][this.depth];
    }
    public void reset(){
        matrix1D = new int[this.total_size];
        matrix3D = new int[this.row][this.col][this.depth];
    }

    public int oneDimIndex(int r, int c, int d) {
        return r * (this.col * this.depth) + c * this.depth + d;
    }
    public long[] fillMatrix(){
        // Fill 3D matrix
        long start3D = nanoTime();
        for(int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                for (int k = 0; k < this.depth; k++) {
                    matrix3D[i][j][k] = this.val;
                }
            }
        }
        long end3D = nanoTime();
        // Fill 2D matrix
        long start1D = nanoTime();
        for (int r = 0; r < this.row; r++) {
            for (int c = 0; c < this.col; c++) {
                for (int d = 0; d < this.depth; d++) {
                    int index = oneDimIndex(r,c,d);
                    matrix1D[index] = this.val;
                }
            }
        }
        long end1D = nanoTime();
        reset();

        return new long[]{end3D - start3D, end1D - start1D};
    }

    public long nanoTime(){
        return System.nanoTime();
    }



    public static void main(String[] args){
        compareMatrix compare = new compareMatrix();

        int NUM_TESTS = 1000;

        long[] oneDimTimes = new long[NUM_TESTS];
        long[] threeDimTimes = new long[NUM_TESTS];

        for (int i = 0; i < NUM_TESTS; i++){
            compare.val = i;
            long[] getTime = compare.fillMatrix();
            threeDimTimes[i] = getTime[0];
            oneDimTimes[i] = getTime[1];
            System.gc();
        }

        System.out.println("Simulation done.");

        double avg1DTime = 0, avg3DTime = 0;

        for(int i = 0; i< NUM_TESTS; i++){
            avg1DTime += oneDimTimes[i];
            avg3DTime += threeDimTimes[i];
        }

        System.out.println(
                new StringBuilder("Average time report (ns) for filling matrices: ")
                        .append("\n")
                        .append("Average fill time for One-Dimensional flattened Matrix: ").append(avg1DTime/NUM_TESTS)
                        .append("\n")
                        .append("Average fill time for Three-Dimensional Matrix time: ").append(avg3DTime/NUM_TESTS)
                        .toString()
        );
    }
}
