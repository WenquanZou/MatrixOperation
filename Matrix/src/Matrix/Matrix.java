package Matrix;

import java.util.Arrays;

public class Matrix {

  private double[][] elems;

  public Matrix(double[][] elems) {
    this.elems = elems;
  }

  public Matrix(int dimension) {
    this.elems = new double[dimension][dimension];
  }

  public Matrix identity(int dimension) {
    double[][] result = new double[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      result[i][i] = 1;
    }
    return new Matrix(result);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Matrix matrix = (Matrix) o;

    return Arrays.deepEquals(elems, matrix.elems);
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(elems);
  }

  public double[][] getElems() {
    return elems;
  }
}
