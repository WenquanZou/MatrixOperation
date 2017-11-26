package UnitTest;

import Matrix.Matrix;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MatrixTest {
  Matrix matrix = new Matrix(4);
  @Test
  public void createMatrixTest() {

    assertEquals(matrix.getElems()[0][0], 0d);
  }

  @Test
  public void enableToChangeElem() {
    matrix.changeValue(2,3,8d);

    assertEquals(matrix.getElem(2, 3), 8d);
  }

  @Test
  public void plusTwoMatrix() {
    double[][] m = {{0, 0, 0, 0}, {1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}};
    matrix.plus(new Matrix(m));

    assertEquals(matrix, new Matrix(m));
  }
}
