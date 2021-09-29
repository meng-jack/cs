/*
 * Remove this package declaration
 */
package src.MatrixMethods;

/* Name: Jack Meng 
 * Class: APCS 2021-2022 
 * File Name: Matrix.java 
 * Purpose: Todemonstrate the use of class to perform certain functions
 */
public class Matrix {
  /**
   * Properties that will be used
   */
  private int[][] matrix;
  private int rows, cols;

  /**
   * Initiate the matrix through the constructor
   * 
   * @param matrix the matrix to be set to var matrix Otherwise overload the
   *               constructor in which the user can then use the setMatrix()
   */
  public Matrix(int[][] matrix) {
    this.matrix = matrix;
    rows = matrix.length;
    cols = matrix[0].length;
  }

  public Matrix() {
  }

  /*
   * Setter & Mutator Methods
   */
  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return cols;
  }

  /* If the user did not use the proper overloaded method
   * 
   */
  public void setMatrix(int[][] matrix) {
    if(matrix == null)
      this.matrix = matrix;
  }

  public int[][] getMatrix() {
    if(matrix == null)
      return null;
    return matrix;
  }

  /**
   * @return the final array after it's columns and rows have been inversed
   */
  public int[][] transpose() {
    int[][] temp = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[i].length; j++)
        /* Inverse the rows and columns from the original array to the new array */
        temp[i][j] = matrix[j][i];
    return temp;
  }
  public int[][] transpose(int[][] arr) {
    int[][] temp = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++)
      for (int j = 0; j < arr[i].length; j++)
        /* Inverse the rows and columns from the original array to the new array */
        temp[i][j] = arr[j][i];
    return temp;
  }

  /*
   * Helper method for the rotateArray() method and thus is privated
   */
  private int[][] rotateOnce(int[][] ar) {
    /* Store the modified array here with the sizes of the array inverse */
    int[][] temp = new int[ar[0].length][ar.length];
    final int row_length = ar.length;
    /*
     * Loop through the 2D array and append the new values to the new array (temp)
     * in the correct location within a time complexity of O(N^2)
     */
    for (int col = 0; col < ar[0].length; col++)
      for (int row = ar.length - 1; row >= 0; row--)
        temp[col][row_length - 1 - row] = ar[row][col];

    return temp;
  }

  /*
   * Rotates the matrix rot number of times
   */
  public int[][] rotateArray(int rot) {
    if (rot == 90)
      return rotateOnce(matrix);
    else if (rot == 180)
      return rotateOnce(rotateOnce(matrix));
    else if (rot == 270)
      return rotateOnce(rotateOnce(rotateOnce(matrix)));
    else if (rot == 360)
      /* Just to make sure */
    return rotateOnce(rotateOnce(rotateOnce(rotateOnce(matrix))));

    return null;
  }
  /*
   * Overloaded Version
   */ 
  public int[][] rotateArray(int[][] arr, int rot) {
    if (rot == 90)
      return rotateOnce(arr);
    else if (rot == 180)
      return rotateOnce(rotateOnce(arr));
    else if (rot == 270)
      return rotateOnce(rotateOnce(rotateOnce(arr)));
    else if (rot == 360)
      /* Just to make sure */
      return rotateOnce(rotateOnce(rotateOnce(rotateOnce(arr))));

    return null;
  }

  /**
   * @param toAdd this is the 2D array that will be added to the current 2D array
   * @return the sum of the 2 2D arrays
   */
  public int addArrays(int[][] toAdd) {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[i].length; j++)
        sum += toAdd[i][j] + matrix[i][j];
    return sum;
  }

  /**
   * @param rotations the amount of rotations needed for the rotateArray() method
   * @param addMatrix this is the 2D array that will be used for the addArrays()
   * @return the final value returned to the user without the user having to set
   *         everything up
   */
  public String toString(int[][] addMatrix, int rotations) {
    String con = "";
    con += "Add 2D arrays: " + addArrays(addMatrix) + "\n";
    con += "Rotate Arrays with degrees " + rotations + " : \n" + arrayToString(rotateArray(rotations)) + "\n";
    con += "Transpose the Array: \n" + arrayToString(transpose()) + "\n";
    con += "Matrix Properties, Rows : " + rows + " Columns : " + cols + "\n";

    return con;
  }

  /*
   * Helper method for the main toString() Only converts 2D arrays of integers to
   * String
   */
  private String arrayToString(int[][] arr) {
    String con = "\n";
    for (int[] el : arr) {
      for (int e : el) {
        con += e + " ";
      }
      con += "\n";
    }
    return con;
  }
}
