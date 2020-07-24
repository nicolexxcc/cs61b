package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int count;
    private double[] summary;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
             throw new IllegalArgumentException();
        }

        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                p.open(row, col);
                count += 1;
            }
            summary[i] = count;
        }
    }

    public double mean() {
        return StdStats.mean(summary);
    }

    public double stddev() {
        return StdStats.stddev(summary);
    }

    public double confidenceLow() {
        return mean() - 1.96 * Math.sqrt(stddev() / summary.length);
    }


    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * Math.sqrt(stddev() / summary.length);
    }
}
