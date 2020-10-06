//Copyright Mikhail Kurakin 2020
package ru.ncedu.kurakin.matrixworker;

/**
 * This interface provides the ability to perform operations on matrices of double numbers
 * @author Mikhail Kurakin
 */
public interface IMatrixWorker {
    /**
     * This method prints the matrix to the console
     * @param m - double matrix you want to print
     */
    public void print(double[][] m);

    /**
     * This method compares dimensions of two matrix, dimensions are equal,
     * if number of columns and number of rows are equal in both matrix
     * @param m1 - double matrix 1
     * @param m2 - double matrix 2
     * @return true if dimensions are equal, otherwise return false
     */
    public boolean haveSameDimension(double[][] m1, double[][] m2);

    /**
     * This method adds two matrices
     * @param m1 - double matrix 1
     * @param m2 - double matrix 2
     * @return result of addition
     */
    public double[][] add(double[][] m1, double[][] m2);

    /**
     * This method subtracts m2 from m1
     * @param m1 - double matrix 1
     * @param m2 - double matrix 2
     * @return result of subtraction
     */

    public double[][] subtract(double[][] m1, double[][] m2);

    /**
     * This method multiplies two matrices
     * @param m1 - double matrix 1
     * @param m2 - double matrix 2
     * @return result of multiplication
     */

    public double[][] multiply(double[][] m1, double[][] m2);

    /**
     * This method return determinant of matrix
     * @param m - matrix n*n
     * @param len - size of matrix
     * @return determinant of matrix
     */
    public double getDeterminant(double[][] m, int len);

}
