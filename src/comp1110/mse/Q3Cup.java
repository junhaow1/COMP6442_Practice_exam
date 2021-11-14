package comp1110.mse;

public class Q3Cup {
  /*
   * This problem is concerned with the placement of pieces in a simple game.
   *
   * You are advised to implement the missing code in the order given.
   *
   * Be sure to take into account piece orientation.
   */

  /**
   * Return true if the piece string represents a well-formed piece placement.
   *
   * To be well-formed, the piece must either be:
   *  a) A 'cup' piece represented by exactly four characters:
   *    - The letter 'C'
   *    - A digit representing the row ('0' - '4')
   *    - A digit representing the column ('0' - '4'),
   *    - A letter describing its orientation ('R' - right way up, or 'U',
   *      upside down).
   *     or,
   *  b) An 'umbrella' piece represented by exactly three characters:
   *    - The letter 'U'
   *    - A digit representing the row ('0' - '4')
   *    - A digit representing the column ('0' - '4')
   *
   * @param piece A string describing the placement of a single piece
   * @return true if the string represents a well-formed piece placement.
   */
  public static boolean wellFormedPiecePlacement(String piece) {
    if (piece ==null || piece .length()==0){
      return false;
    }

    if (piece.length()==3){
      if (piece.charAt(0)!='U'){
        return false;
      }
      if( (piece.charAt(1)!='0') && (piece.charAt(1)!='1')&& (piece.charAt(1)!='2') && (piece.charAt(1)!='3') && (piece.charAt(1)!='4')){
        return false;
      }
      if( (piece.charAt(2)!='0') && (piece.charAt(2)!='1')&& (piece.charAt(2)!='2') && (piece.charAt(2)!='3') && (piece.charAt(2)!='4')){
        return false;
      }
    }

    if(piece.length()==4){
      if (piece.charAt(0)!='C'){
        return false;
      }
      if( (piece.charAt(1)!='0') && (piece.charAt(1)!='1')&& (piece.charAt(1)!='2') && (piece.charAt(1)!='3') && (piece.charAt(1)!='4')){
        return false;
      }
      if( (piece.charAt(2)!='0') && (piece.charAt(2)!='1')&& (piece.charAt(2)!='2') && (piece.charAt(2)!='3') && (piece.charAt(2)!='4')){
        return false;
      }
      if( (piece.charAt(3)!='R') && (piece.charAt(3)!='U')  ){
        return false;
      }
    }

    return true; // FIXME 3a: complete this method
  }

  /**
   * Return true if the game string represents a well-formed game string.
   *
   * To be well-formed, the puzzle string must:
   * - Have exactly 5 cups ('C' see above)
   * - Have exactly 8 umbrellas ('U' see above)
   * - Have all pieces on the board
   * - Have no overlapping pieces.
   *
   * @param game A string of piece placements.
   * @return true if the string is a well-formed game string.
   */
  public static boolean wellFormedGameString(String game) {
//    if(game == null||game)
    int uNum=0;
    int cNum = 0;
    boolean[][] uTaken = new boolean[5][5];
    boolean[][] cTaken = new boolean[5][5];
    for (int i = 0; i<game.length();i++){
      if (game.charAt(i)=='C'){
        String aa = game.substring(i,i+4);
//        if (!wellFormedPiecePlacement(aa)){
//          return false;
//        }
        int l1 = Integer.parseInt(aa.substring(1,2));
        int l2 = Integer.parseInt(aa.substring(2,3));

        if(cTaken[l1][l2]){
          return false;
        } else {
          cTaken[l1][l2] = true;
        }

        cNum++;
      }
      if (game.charAt(i)=='U'){
        String aa1 = game.substring(i,i+3);
//        if (!wellFormedPiecePlacement(aa1)){
//          return false;
//        }
        int l1 = Integer.parseInt(aa1.substring(1,2));
        int l2 = Integer.parseInt(aa1.substring(2,3));

        if(uTaken[l1][l2]){
          return false;
        } else {
          uTaken[l1][l2] = true;
        }
        uNum++;
      }
    }


    if(cNum!=5 || uNum!=8){
      return false;
    }
    return false; // FIXME 3b: complete this method
  }

  /**
   * Given a game string, return the number of cups that will gather
   * rain, or -1 if the game string is not well formed.
   *
   * Rain falls from the top of the board directly downwards.   Therefore,
   * for a cup to gather rain:
   *  - It must not have something blocking rain by being directly above it
   *    (either a cup or an umbrella), and
   *  - the cup must be right way up ('R'), since upside-down cups can't
   *    gather rain.
   *
   * - If the game string is not well-formed, return -1
   *
   * @param game A string of piece placements.
   * @return the number of cups that can gather rain, or
   * -1 if the game string is not well formed.
   */
  public static int cupsGatheringRain(String game) {
    return -1; // FIXME 3c: complete this method
  }

}