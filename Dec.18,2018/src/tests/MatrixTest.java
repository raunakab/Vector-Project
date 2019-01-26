package tests;

import exceptions.InvalidMatrixException;
import model.Matrix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MatrixTest {
    private Matrix matrix;



    @BeforeEach
    public void runBefore() {
        matrix = new Matrix();
    }



    //Note:
    //This test will not work since Double[][].equals(Double[][]) is comparing object references at MAXIMUM discriminance. Therefore, different objects with similar contents are returning false when the Object.equals(Object)
    // method is being called on them. Although I know how to override Object.hashCode() and Object.equals(Object), I do not know how to do so for java defined classes.
    @Test
    public void testTransposeValidMatrix() {
        try {
            Double[][] testMatrix = {{1.0,2.0,3.0},{4.0,5.0,6.0}};
            Double[][] testMatrixTranspose = {{1.0,4.0},{2.0,5.0},{3.0,6.0}};
            assertTrue(testMatrixTranspose.equals(matrix.transpose(testMatrix)));
        } catch (InvalidMatrixException ime) {
            fail();
        }
    }



    @Test
    public void testTransposeInvalidMatrix() {
        try {
            Double[][] testMatrix = {{1.0,2.0},{4.0,5.0,6.0}};
            matrix.transpose(testMatrix);
        } catch (InvalidMatrixException ime) {
            System.out.println("Passed");
        }
    }
}