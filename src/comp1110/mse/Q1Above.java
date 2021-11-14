package comp1110.mse;

public class Q1Above {
  /**
   * Return the product of the first three array elements that are higher than
   * the threshold value (ie multiply each of these elements together).  If
   * there are no values above the threshold, return zero.  If there is only one
   * value above the threshold, return it.   If there are only two above the
   * threshold, return their product.  Otherwise return the product
   * of the first three above the threshold.
   *
   * If the array is of size zero or is null, return zero.
   *
   * @param values an array of double values
   * @param threshold only multiply the first three array elements higher than
   *                 this value
   * @return the product of the first three array elements that are higher than
   * the threshold value (ie multiply each of these elements together).  If
   * there are no values above the threshold, return zero.  If there is only one
   * value above the threshold, return it.   If there are only two above the
   * threshold, return their product.  Otherwise return the product
   *  of the first three above the threshold.
   */
  public static double above(double[] values, double threshold) {

    //dsfdasfadsf1111ddd
    double product = 1.0;
    int count = 0;
    if(values==null){
      return 0;
    }
    if (values.length==0 || values.equals(null) ){
      return 0;
    }



    if (values.length>=3){
      for (double i : values){
        if(i>threshold){
          count++;
          if (count<=3){
            product *= i;
          }
        }

      }
    } else if (values.length==0 || values.equals(null) ){
      return 0;
    } else if (values.length==1){

    } else {
      //2
    }

    if (count==0){
      return 0.0;
    }
    return product; // FIXME Q1
  }
}
