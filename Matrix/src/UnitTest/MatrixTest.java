package UnitTest;

import Matrix.Matrix;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MatrixTest {

  @Test
  public void createMatrixTest() {
    Matrix matrix = new Matrix(4);

    assertEquals(matrix.getElems()[0][0], 0d);
  }
}
