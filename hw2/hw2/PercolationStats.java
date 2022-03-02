package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    public double[] result;
    public int T;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf){
        if(N<= 0 || T<=0) throw new IllegalArgumentException("Illegal!");
        this.T =T;
        result = new double[T];

        for(int i = 0; i<T;i++) {
            int numOpenedSites = 0;
            Percolation p= pf.make(N);
            while (!p.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);

                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                    //numOpenedSites += 1;
                }
            }
            // if no double cast, the division will two integers will round down to a integer
            //System.out.println(p.numberOfOpenSites());
            //System.out.println(numOpenedSites);
            result[i] = (double) p.numberOfOpenSites() / (N*N);
        }
    }
    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(result);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(result);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow(){
        return this.mean() - (1.96*this.stddev()/Math.sqrt(T));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh(){
        return this.mean() + (1.96*this.stddev()/Math.sqrt(T));
    }
    public static void main(String args[]){
        PercolationFactory pf = new PercolationFactory();
        PercolationStats s = new PercolationStats(50,1000, pf);
        System.out.println(s.mean());
    }


}
