package model;

import exceptions.InvalidMatrixException;

public class ThreeVector {
    private Double x;
    private Double y;
    private Double z;
    private UserView userView;
    private Matrix matrix;



    public ThreeVector(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }



    public TwoVector project() throws InvalidMatrixException {
        Double[][] matrixA = {{userView.getHorBasis().getX(), userView.getHorBasis().getY(), userView.getHorBasis().getZ()}, {userView.getVertBasis().getX(), userView.getVertBasis().getY(), userView.getVertBasis().getZ()}};
        Double[][] matrixATranspose = matrix.transpose(matrixA);
        Double[][] projectionMatrix = matrix.multiplyMatrices(matrix.inverseTwoByTwo(matrix.multiplyMatrices(matrixATranspose, matrixA)),matrixATranspose);
        Double[] vector = {x, y, z};
        Double[] projectedVector = matrix.multiplyMatrixVector(projectionMatrix, vector);
        return new TwoVector(projectedVector[0], projectedVector[1]);
    }



    //Getters:
    public Double getX() {
        return x;
    }
    public Double getY() {
        return y;
    }
    public Double getZ() {
        return z;
    }



    //Adders/Setters:
    public void setX(Double x) {
        this.x = x;
    }
    public void setY(Double y) {
        this.y = y;
    }
    public void setZ(Double z) {
        this.z = z;
    }
    public void addUserView(UserView userView) throws InvalidMatrixException {
        if (this.userView==null || !this.userView.equals(userView)) {
            this.userView = userView;
            matrix = userView.getMatrix();
            userView.addThreeVector(this);
        }
    }
}