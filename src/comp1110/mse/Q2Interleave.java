package comp1110.mse;

/**
 * COMP1110 Mid-Semester Exam, Question 2
 */
public class Q2Interleave {

    /**
     * This function takes two arrays of strings and returns a new array of strings where
     * the elements from a and be are interleaved.
     * For example:
     *    a = {"a", "b", "c", "d"}
     *    b = {"e", "f", "g", "h"}
     * the result will be
     *        {"a", "e", "b", "f", "c", "g", "d", "h"}
     * in the case where one array is longer than the other, the remaining elements
     * will be added to the end of the result:
     *    a = {"a", "b", "c"}
     *    b = {"e"}
     * the result will be
     *        {"a", "e", "b", "c"}
     */
    public static String[] interleave(String[] a, String[] b) {
        String[] result = new String[a.length+b.length];
        if (a.length==b.length){
            for (int i = 0,j=0;i<a.length;i++){
                result[j]=a[i];
                result[j+1] = b[i];
                j=j+2;
            }
            return result;

        } else if (a.length>b.length){
            for (int i = 0,j=0;i<b.length;i++,j=j+2){
                result[j]=a[i];
                result[j+1] = b[i];

            }
            for (int k=b.length +b.length;k<a.length+b.length;k++){
                result[k] = a[k-b.length];
            }
            return result;
        } else {
            for (int i = 0,j=0;i<a.length;i++){
                result[j]=a[i];
                result[j+1] = b[i];
                j=j+2;
            }
            for (int k=a.length +a.length;k<b.length+a.length;k++){
                result[k] = b[k-a.length];
            }
            return result;
        }

//        return null;  // FIXME Question 2: complete this function
    }
}
