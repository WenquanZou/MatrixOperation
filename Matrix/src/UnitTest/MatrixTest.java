package UnitTest;

import Matrix.Matrix;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MatrixTest {
  private Matrix matrix = new Matrix(4);
  @Test
  public void createMatrixTest() {

    assertEquals(matrix.getElems()[0][0], 0);
  }

  @Test
  public void enableToChangeElem() {
    matrix.changeValue(2,3,8);
    assertEquals(matrix.getElem(2, 3), 8);
  }

  @Test
  public void plusTwoMatrix() {
    int[][] numbers = {{0, 0, 0, 0}, {1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}};
    Matrix m1 = new Matrix(numbers);
    int[][] numbers2 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
    Matrix m2 = new Matrix(numbers2);
    int[][] numbers3 = {{1, 1, 1, 1}, {3, 3, 3, 3}, {5, 5, 5, 5}, {7, 7, 7, 7}};
    assertEquals(m1.plus(m2), new Matrix(numbers3));
  }

  @Test
  public void multiplyTwoMatrix() {
    int[][] numbers = {{1, 1, 1, 1}, {2, 2, 2, 2}};
    Matrix m1 = new Matrix(numbers);
    int[][] numbers2 = {{0, 0}, {1, 1}, {2, 2}, {3, 3}};
    Matrix m2 = new Matrix(numbers2);

    int[][] numbers3 = {{6,6}, {12, 12}};
    Matrix m3 = new Matrix(numbers3);

    Matrix result = m1.multiply(m2);

    assertEquals(m3, result);
  }

  @Test
  public void transposeTest() {
    int[][] numbers = {{2, 3, 1, 4}, {1, 1, 2, 3}, {3, 5, 7, 1}, {2, 7, 6, 7}};
    Matrix m = new Matrix(numbers);

    int[][] r = {{2, 1, 3, 2}, {3, 1, 5, 7}, {1, 2, 7, 6}, {4, 3, 1, 7}};

    assertEquals(m.transpose(), new Matrix(r));
  }

  @Test
  public void scaleTest() {
    int[][] numbers = {{1, 1, 1, 1}, {2, 2, 2, 2}};
    Matrix m = new Matrix(numbers);
    int[][] n = {{2, 2, 2, 2}, {4, 4, 4, 4}};
    assertEquals(m.scale(2), new Matrix(n));
  }
}
