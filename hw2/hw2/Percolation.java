package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;

public class Percolation {
    private boolean grid[][];
    private int N;
    private int numberOfOpen;
    private int top;
    private int bottom;

    private WeightedQuickUnionUF WQU;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        grid = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = false;
            }
        }
        this.N = N;
        top = N * N;
        bottom = N * N + 1;
        numberOfOpen = 0;
        WQU = new WeightedQuickUnionUF(N * N + 2);
    }

    private int xyTo1D(int r, int c) {
        return r * N * c;
    }

    private void validate(int row, int col) {
        if (row >= N || row < 0 || col >= N || col < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);

        if (!isOpen(row, col)) {
            grid[row][col] = true;
            numberOfOpen += 1;
            connect(row, col);
        }

    }

    private void connect(int p, int q) {
        int currentSite = xyTo1D(p, q);
        if (p == 0) {
            WQU.union(currentSite, top);
        }
        if (p == N) {
            WQU.union(currentSite, bottom);
        }

        if (p != 0 && isOpen(p - 1, q)) {
            WQU.union(currentSite, xyTo1D(p - 1, q));
        }
        if (p != N - 1 && isOpen(p + 1, q)) {
            WQU.union(currentSite, xyTo1D(p + 1, q));
        }
        if (q != 0 && isOpen(p, q - 1)) {
            WQU.union(currentSite, xyTo1D(p, q - 1));
        }
        if (q != N - 1 && isOpen(p, q + 1)) {
            WQU.union(p, q + 1);
        }
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        return WQU.connected(xyTo1D(row, col), top);
    }

    public int numberOfOpenSites() {
        return numberOfOpen;
    }

    public boolean percolates() {
        return WQU.connected(top, bottom);
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(12);
        p.open(3, 4);
        p.open(0, 2);
        p.open(1, 2);
        System.out.println(p.isFull(1, 2));
        System.out.println(p.numberOfOpenSites());
    }

}
