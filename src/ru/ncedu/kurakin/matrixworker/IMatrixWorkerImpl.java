//Copyright Mikhail Kurakin 2020
package ru.ncedu.kurakin.matrixworker;

public class IMatrixWorkerImpl implements IMatrixWorker {
    public void print(double[][] m) {
        for (double[] row : m) {
            for (double elem : row) {
                System.out.printf("%8s", elem);
            }
            System.out.println();
        }
    }

    public boolean haveSameDimension(double[][] m1, double[][] m2) {
        if (m1.length != m2.length) {
            return false;
        }
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }
        }
        return true;
    }

    public double[][] add(double[][] m1, double[][] m2) {
        double[][] result = new double[m1.length][m1[0].length];
        if (haveSameDimension(m1, m2)) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[i].length; j++) {
                    result[i][j] = m1[i][j] + m2[i][j];
                }
            }
        }
        return result;
    }

    public double[][] subtract(double[][] m1, double[][] m2) {
        double[][] result = null;
        if (haveSameDimension(m1, m2)) {
            result = new double[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[i].length; j++) {
                    result[i][j] = m1[i][j] - m2[i][j];
                }
            }
        }
        return result;
    }

    public double[][] multiply(double[][] m1, double[][] m2) {
        double[][] result = null;
        for (int i = 0; i < m2.length; i++) {
            if (m1[i].length != m2.length) {
                return result;
            }
        }
        if (m1[0].length == m2.length) {
            result = new double[m1.length][m2[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[i].length; j++) {
                    for (int k = 0; k < m1[j].length; k++) {
                        result[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
        }
        return result;
    }

    public double getDeterminant(double[][] m, int len) {
        double det = 0;
        if (!isSquare(m)) {
            throw new IllegalArgumentException("matrix should be square");
        }
        if (len == 2) {
            return ((m[0][0] * m[1][1]) - (m[1][0] * m[0][1]));
        } else {
            double[][] subMatrix = new double[len][len];
            for (int i = 0; i < len; i++) {
                int subj = 0;
                for (int j = 1; j < len; j++) {
                    int subk = 0;
                    for (int k = 0; k < len; k++) {
                        if (k == i)
                            continue;
                        subMatrix[subj][subk] = m[j][k];
                        subk++;
                    }
                    subj++;
                }
                det = det + (Math.pow(-1, i) * m[0][i] * getDeterminant(subMatrix, len - 1));
            }
        }
        return det;
    }

    private boolean isSquare(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i].length != m.length) {
                return false;
            }
        }
        return true;
    }
}
