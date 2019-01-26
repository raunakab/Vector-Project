package model;

import exceptions.InvalidMatrixException;

import java.util.LinkedList;

public class Matrix {
    private UserView userView;



    public Double[][] multiplyMatrices(Double[][] mA, Double[][] mB) throws InvalidMatrixException {
        int mBFirstRowLength = mB[0].length;
        Double[][] mAT = transpose(mA);
        LinkedList<Double[]> newMatrix = new LinkedList<>();
        for (int j=0; j<mB.length; j++) {
            if (mB[j].length != mBFirstRowLength) throw new InvalidMatrixException();
            LinkedList<Double> arrayColumn = new LinkedList<>();
            for (int i=0; i<mAT.length; i++) {
                if (mAT[i].length != mB[j].length) throw new InvalidMatrixException();
                arrayColumn.add(dotProduct(mAT[i],mB[j]));
            }
            newMatrix.add(arrayColumn.toArray(new Double[0]));
        }
        return newMatrix.toArray(new Double[0][0]);
    }



    public Double[] multiplyMatrixVector(Double[][] matrix, Double[] vector) throws InvalidMatrixException {
        if (matrix.length != vector.length) throw new InvalidMatrixException();
        LinkedList<Double> linkedList = new LinkedList<>();
        for (int j=0; j<matrix[0].length; j++) {
            double summation = 0.0;
            for (int i=0; i<matrix.length; i++) {
                summation = summation + matrix[i][j]*vector[i];
            }
            linkedList.add(summation);
        }
        return linkedList.toArray(new Double[0]);
    }



    public Double dotProduct(Double[] rA, Double[] rB) throws InvalidMatrixException {
        if (rA.length != rB.length) {
            throw new InvalidMatrixException();
        }
        double summation = 0.0;
        for (int i=0; i<rA.length; i++) {
            summation = summation + rA[i]*rB[i];
        }
        return summation;
    }



    public Double[][] transpose(Double[][] matrix) throws InvalidMatrixException {
        int firstRowLength = matrix[0].length;
        LinkedList<Double[]> newMatrix = new LinkedList<>();
        for (int j=0; j<matrix[0].length; j++) {
            LinkedList<Double> column = new LinkedList<>();
            for (int i=0; i<matrix.length; i++) {
                if (matrix[i].length != firstRowLength) throw new InvalidMatrixException();
                column.add(matrix[i][j]);
            }
            newMatrix.add(column.toArray(new Double[0]));
        }
        return newMatrix.toArray(new Double[0][0]);
    }



    public Double[][] inverseTwoByTwo(Double[][] matrix) throws InvalidMatrixException {
        if (matrix.length!=2 || matrix[0].length!=2 || matrix[1].length!=2) {
            throw new InvalidMatrixException();
        }
        Double determinant = determinant(matrix);
        return new Double[][]{{matrix[1][1]/determinant,-matrix[0][1]/determinant}, {-matrix[1][0]/determinant,matrix[0][0]/determinant}};
    }



    public Double determinant(Double[][] matrix) throws InvalidMatrixException {
        if (matrix.length!=2 || matrix[0].length!=2 || matrix[1].length!=2) {
            throw new InvalidMatrixException();
        }
        return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
    }



    //Getters:
    public UserView getUserView() {
        return userView;
    }


    //Adders/Setters:
    public void addUserView(UserView userView) {
        if (this.userView==null || !this.userView.equals(userView)) {
            this.userView = userView;
            userView.addMatrix(this);
        }
    }
}