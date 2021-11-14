package comp1110.mse;

public class Q1Third {
  /**
   * Compute the 'third' sum of values in this array by applying the following
   * rule to each value in the array:
   * - if the array index is divisible by three, then subtract the value from the
   *   sum.
   * - if the array index is not divisible by three, then add the value to the
   *   sum.
   *
   * If the array is null or is of length zero, return zero.
   *
   * @param values an array of values
   * @return the 'third' sum of the values in the array, or zero if the
   * array is null or length zero.
   */
  public static int third(int[] values) {
    int sum=0;

    if (values ==null || values.length==0){
      return 0;
    }
    for (int i=0;i< values.length;i++){
      if (i%3 ==0){
        sum-=values[i];

      } else {
        sum+=values[i];
      }
    }
    return sum; // FIXME Q1
  }
}
