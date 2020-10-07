//Copyright Mikhail Kurakin 2020
package ru.ncedu.kurakin.matrixworker;

import java.util.Arrays;

/**
 * Realisation of pojo matrix class
 *
 * @author Mikhail Kurakin
 */
public class Matrix {
    private double[][] m;

    public Matrix() {

    }

    public Matrix(double[][] m) {
        setMatrix(m);
    }

    public void setMatrix(double[][] m) {
        if (m != null) {
            if (this.m == null || !haveSameDimension(m)) {
                this.m = new double[m.length][m[0].length];
            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    this.m[i][j] = m[i][j];
                }
            }
        }
    }

    public double[][] getMatrix() {
        return m;
    }

    public double[] getRow(int i) {
        if (m == null) {
            throw new NullPointerException();
        } else if (i >= m.length) {
            throw new IllegalArgumentException();
        } else {
            return m[i];
        }
    }

    public double get(int i, int j) {
        if (m == null) {
            throw new NullPointerException();
        } else if (i >= m.length || j >= m[0].length) {
            throw new IllegalArgumentException();
        } else {
            return m[i][j];
        }
    }

    public int getLength() {
        if (m != null) {
            return m.length;
        }
        return 0;
    }

    public void print() {
        System.out.println(this.toString());
    }

    public boolean haveSameDimension(Matrix m2) {
        if (m.length != m2.getLength()) {
            return false;
        }
        for (int i = 0; i < getLength(); i++) {
            if (m[i].length != m2.getRow(i).length) {
                return false;
            }
        }
        return true;
    }

    public boolean haveSameDimension(double[][] m2) {
        if (getLength() != m2.length) {
            return false;
        }
        for (int i = 0; i < getLength(); i++) {
            if (m[i].length != m2[i].length) {
                return false;
            }
        }
        return true;
    }

    public Matrix add(Matrix m2) {
        if (haveSameDimension(m2)) {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = m[i][j] + m2.get(i, j);
                }
            }
        }
        return this;
    }

    public Matrix subtract(Matrix m2) {
        if (haveSameDimension(m2)) {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = m[i][j] - m2.get(i, j);
                }
            }
        }
        return this;
    }

    public Matrix multiply(Matrix m2) {
        double[][] result = null;
        for (int i = 0; i < m2.getLength(); i++) {
            if (m[i].length != m2.getLength()) {
                return null;
            }
        }
        if (m[0].length == m2.getLength()) {
            result = new double[m.length][m2.getRow(0).length];
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    for (int k = 0; k < m[j].length; k++) {
                        result[i][j] += m[i][k] * m2.get(k, j);
                    }
                }
            }
        }
        m = result;
        return this;
    }

    public double getDeterminant() {
        if (!isSquare()) {
            throw new IllegalArgumentException("matrix should be square");
        }
        return computeDeterminant(m, m.length);
    }

    private double computeDeterminant(double[][] m, int len) {
        double det = 0;
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
                det = det + (Math.pow(-1, i) * m[0][i] * computeDeterminant(subMatrix, len - 1));
            }
        }
        return det;
    }

    private boolean isSquare() {
        for (int i = 0; i < m.length; i++) {
            if (m[i].length != m.length) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        for (int i = 0; i < getLength(); i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != matrix.get(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(m);
    }

    @Override
    public String toString() {
        if (m != null) {
            StringBuilder strBuilder = new StringBuilder();
            for (double[] row : m) {
                for (double elem : row) {
                    strBuilder.append(String.format("%8s", elem));
                }
                strBuilder.append("\n");
            }
            return strBuilder.toString();
        }
        return "";
    }
}
