package model;

import exceptions.InvalidMatrixException;

import java.util.LinkedList;
import java.util.List;

public class UserView {
    private ThreeVector vertBasis;
    private ThreeVector horBasis;
    private List<ThreeVector> threeVectors = new LinkedList<>();
    private List<TwoVector> projectedThreeVectors = new LinkedList<>();
    private Matrix matrix;



    public UserView(ThreeVector vertBasis, ThreeVector horBasis) {
        addMatrix(new Matrix());
        this.vertBasis = vertBasis;
        this.horBasis = horBasis;
    }



    //Getters:
    public ThreeVector getVertBasis() {
        return vertBasis;
    }
    public ThreeVector getHorBasis() {
        return horBasis;
    }
    public List<ThreeVector> getThreeVectors() {
        return threeVectors;
    }
    public Matrix getMatrix() {
        return matrix;
    }
    public List<TwoVector> getProjectedThreeVectors() {
        return projectedThreeVectors;
    }



    //Adders/Setters:
    public void setVertBasis(ThreeVector vertBasis) {
        this.vertBasis = vertBasis;
    }
    public void setHorBasis(ThreeVector horBasis) {
        this.horBasis = horBasis;
    }
    public void addThreeVector(ThreeVector threeVector) throws InvalidMatrixException {
        if (!threeVectors.contains(threeVector)) {
            threeVectors.add(threeVector);
            threeVector.addUserView(this);
            projectedThreeVectors.add(threeVector.project());
        }
    }
    public void addMatrix(Matrix matrix) {
        if (this.matrix==null || !this.matrix.equals(matrix)) {
            this.matrix = matrix;
            matrix.addUserView(this);
        }
    }
}