package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int size;       //N
    private int openNum;    // number of open sites
    private boolean[][] matrix; //矩阵
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufromTop; //为了避免backwash
    private int top;        //表示顶端
    private int bottom;      //表示末端

    // int[]是一共N^2+2个数，top是0，bottom是最末
    // connected(top,bottom) = true的话，表示是渗透成功的


    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException("Not a valid N!");
        size = N;
        uf = new WeightedQuickUnionUF(N * N + 2);
        ufromTop = new WeightedQuickUnionUF(N * N + 1);
        top = 0;
        bottom = N * N + 1;
        matrix = new boolean[N][N];
    }

    //xyTo1D(int r, int c) method, e.g. xyTo1D(2, 4) = 14+1
    // top是0
    /* 二维数组存储，转成一维的用于查找 */
    public int xyTo1D(int row, int col) {
        return row * size + col + 1;
    }

    // open the site (row, col) if it is not open already
    // 保证连接union
    public void open(int row, int col) {
        if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
            throw new IndexOutOfBoundsException("Out of Bounds!");

        if (!isOpen(row, col)) {
            // Matrix对应位置为true
            matrix[row][col] = true;
            // 计数
            openNum++;
        }

        // 当前位置的上下左右
        if (row == 0) {
            uf.union(xyTo1D(row, col), top);
            ufromTop.union(xyTo1D(row, col), top);
        }
        //bottom
        if (row == size - 1) {
            uf.union(xyTo1D(row, col), bottom);
        }

        // 上
        if (row > 0 && isOpen(row - 1, col)) {
            uf.union(xyTo1D(row, col), xyTo1D(row - 1, col));
            ufromTop.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
        // 下
        if (row < size - 1 && isOpen(row + 1, col)) {
            uf.union(xyTo1D(row, col), xyTo1D(row + 1, col));
            ufromTop.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        // 左
        if (col > 0 && isOpen(row, col - 1)) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col - 1));
            ufromTop.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
        // 右
        if (col < size - 1 && isOpen(row, col + 1)) {
            uf.union(xyTo1D(row, col), xyTo1D(row, col + 1));
            ufromTop.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }


    }

    // is the site (row, col) open?
    // isOpen 只要看有没有选中这个grid
    public boolean isOpen(int row, int col) {
        if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
            throw new IndexOutOfBoundsException("Out of Bounds!");
        return matrix[row][col];
    }

    // is the site (row, col) full?
    // Be careful with backwash！！！
    public boolean isFull(int row, int col) {
        if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
            throw new IndexOutOfBoundsException("Out of Bounds!");
        return ufromTop.connected(top, xyTo1D(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openNum;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    // use for unit testing (not required, but keep this here for the autograder)
    public static void main(String[] args) {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        p.open(2, 1);
        p.open(0, 2);
        System.out.println(p.numberOfOpenSites());
        p.open(0, 1);
        System.out.println(p.percolates());

    }
}
