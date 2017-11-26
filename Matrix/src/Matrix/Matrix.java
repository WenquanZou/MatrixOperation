package Matrix;

import java.util.Arrays;

public class Matrix {

  private double[][] elems;

  //Create normal matrix.
  public Matrix(double[][] elems) {
    this.elems = elems;
  }

  //Create matrix with dimension.
  public Matrix(int dimension) {
    this.elems = new double[dimension][dimension];
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

  //Create identity matrix
  public Matrix identity(int dimension) {
    double[][] result = new double[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      result[i][i] = 1;
    }
    return new Matrix(result);
  }

  public double[][] getElems() {
    return elems;
  }

  public void changeValue(int x, int y, double v) {
    this.elems[x][y] = v;
  }

  private static boolean checkDimension(Matrix m, Matrix n) {
    return m.getVertDimen() == n.getHoriDimen();
  }

  private int getHoriDimen() {
    return this.elems.length;
  }

  private int getVertDimen() {
    return this.elems[0].length;
  }

  public double getElem(int x, int y) {
    return this.elems[x][y];
  }

  /**
   *
   * @param n matrix to add.
   * @return A matrix of result this plus n.
   */
  public Matrix plus(Matrix n) {

    int h = this.elems.length;
    int v = this.elems[0].length;

    if (n.getHoriDimen() != h || n.getVertDimen() != v) {
      throw new IllegalArgumentException("Matrix dimension mismatched");
    }

    double[][] result = new double[h][v];

    //Plus operation on each matrix.
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < v; j++) {
        result[i][j] = this.getElem(i, j) + n.getElem(i, j);
      }
    }
    return new Matrix(result);

  }


  /**
   *
   * @param n is the matrix to multiply with
   * @return A matrix multiplication of this and n.
   */
  public Matrix multiply(Matrix n) {
    if (!checkDimension(this, n)) {
      throw new IllegalArgumentException("Dimension mismatched");
    }

    //x, y are the horizontal dimension and vertical dimension respectively .
    int x = this.getHoriDimen();
    int y = this.getVertDimen();
    int z = n.getVertDimen();

    double[][] result = new double[x][z];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < z; j++){
        for (int k = 0; k < y; k++) {
          result[i][j] += this.getElem(i, k) * n.getElem(k, j);
        }
      }
    }
    return new Matrix(result);
  }

  public Matrix transpose() {
    int h = this.getHoriDimen();
    int v = this.getVertDimen();

    double[][] result = new double[v][h];

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < v; j++) {
        result[j][i] = this.getElem(i, j);
      }
    }
    return new Matrix(result);
  }

}
