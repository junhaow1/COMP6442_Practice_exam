package comp1110.mse;

import java.util.Random;

public class Q4Blob {

  /*
   * This problem relates to a puzzle of finding the size of the largest 'blob'.
   *
   * The game consists of an NxN grid composed of tiles that are either
   * 'empty' ('.') or 'blob' ('B').  Blobs are connected horizontally and
   * vertically (but not diagonally).  The goal is to find the largest
   * blob on the board.
   *
   * For example, in the grid drawn below, there are three blobs:
   *   - a blob of size 1 in the top right corner
   *   - a blob of size 2 in the top left corner
   *   - a blob of size 10
   *
   * Notice that the two smaller blobs are NOT connected to the larger blob
   * even though they are diagonally adjacent.
   *
   *   B . . B
   *   B . B .
   *   . B B B
   *   B B B .
   *
   * The grid is represented as an NxN long string consisting of '.' and 'B'
   * characters (only).   The characters in the string are ordered in
   * 'row-major' order:
   *
   *   0  1  2  3
   *   4  5  6  7
   *   8  9  10 11
   *   12 13 14 15
   *
   */

  /**
   * Given a game, return the size of the biggest blob on the grid.
   * Return 0 if there is no blob on the grid.
   *
   * @param game A string composed of M = NxN tiles (a square number), where
   *              is represented by either an '.' or a 'B', as described above.
   * @return the size of the biggest blob on the board, or 0 if there is no path.
   */
  public static int biggestBlob(String game) {
    return -1;
  }
}
