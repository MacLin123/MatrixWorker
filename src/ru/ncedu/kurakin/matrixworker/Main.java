//Copyright Mikhail Kurakin 2020
package ru.ncedu.kurakin.matrixworker;

public class Main {
    public static void main(String[] args) {
        demonstrationMatrixWorker();
        System.out.println("********************************************************************\n");
        System.out.println("Matrix POJO\n");
        demonstrationMatrix();

    }

    private static void demonstrationMatrix() {
        double[][] m1 = {{1, 2, 4}, {4, 5, 6}, {7, 8, 9}};
        double[][] m2 = {{2, 2, 3}, {8, 5, 8}, {8, 8, 8}};
        Matrix mtrx1 = new Matrix(m1);
        Matrix mtrx2 = new Matrix(m2);
        System.out.println("m1 matrix:");
        mtrx1.print();
        System.out.println("m2 matrix:");
        mtrx2.print();
        System.out.printf("have m1 and m2 the same dimension? - ");
        System.out.println(mtrx1.haveSameDimension(mtrx2));
        System.out.println("\nresult of addition m1 and m2:");
        System.out.println(m1 == mtrx1.getMatrix());
        System.out.println(mtrx1.add(mtrx2));
        mtrx1.setMatrix(m1);
        System.out.println("\nresult of subtraction m1 and m2:");
        System.out.println(mtrx1.subtract(mtrx2));
        mtrx1.setMatrix(m1);
        System.out.println("\nresult of multiplication m1 and m2:");
        System.out.println(mtrx1.multiply(mtrx2));
        mtrx1.setMatrix(m1);
        System.out.println("\n get determinant of m1:");
        System.out.println(mtrx1.getDeterminant());
        System.out.println("\n get determinant of m2:");
        System.out.println(mtrx2.getDeterminant());
    }

    public static void demonstrationMatrixWorker() {
        IMatrixWorker imw = new IMatrixWorkerImpl();
        double[][] m1 = {{1, 2, 4}, {4, 5, 6}, {7, 8, 9}};
        double[][] m2 = {{2, 2, 3}, {8, 5, 8}, {8, 8, 8}};
        System.out.println("m1 matrix:");
        imw.print(m1);
        System.out.println("m2 matrix:");
        imw.print(m2);
        System.out.printf("have m1 and m2 the same dimension? - ");
        System.out.println(imw.haveSameDimension(m1, m2));
        System.out.println("\nresult of addition m1 and m2:");
        imw.print(imw.add(m1, m2));
        System.out.println("\nresult of subtraction m1 and m2:");
        imw.print(imw.subtract(m1, m2));
        System.out.println("\nresult of multiplication m1 and m2:");
        imw.print(imw.multiply(m1, m2));
        System.out.println("\n get determinant of m1:");
        System.out.println(imw.getDeterminant(m1, m1.length));
        System.out.println("\n get determinant of m2:");
        System.out.println(imw.getDeterminant(m2, m2.length));

    }
}
