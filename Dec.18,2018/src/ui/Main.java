package ui;

import exceptions.InvalidMatrixException;
import model.ThreeVector;
import model.UserView;


public class Main {
    private static ThreeVector xBasis;
    private static ThreeVector yBasis;
    private static UserView userView;



    public static void main(String[] args) throws InvalidMatrixException {
        xBasis = new ThreeVector(1.0,0.0,0.0);
        yBasis = new ThreeVector(0.0,1.0,0.0);
        userView = new UserView(xBasis, yBasis);
        ThreeVector vector1 = new ThreeVector(1.0,1.0,1.0);
        userView.addThreeVector(vector1);
        projectVectors();
    }

    public static void projectVectors() {
        System.out.println(userView.getProjectedThreeVectors().get(0).getHorizontal()+"\n"+userView.getProjectedThreeVectors().get(0).getVertical());
    }
}