public class BirthdayParadox {
  public static void main(String[] args) {
    for(int size = 1; size <= 100; size++) {
      double ratio = runExperiment(size);
      System.out.println(size + ". " + ratio);
    }
  }
  
  // *********** METHODS *************
  
  
  // Question 1
  public static int[] generateArray(int size, int range) {
    // the array should have its length equal to 'size'
    int[] arrayOfRandomInts = new int[size];
    /* assigning random int values to the elements of 
     * the array using a loop.
     * multiplying Math.random() with range to get a random value
     * between 0 and range. Casting that random value to int
     * so that the only possible outputs are 
     * 0,1,2,3.....(range-1) */
    for (int i = 0; i < arrayOfRandomInts.length; i++) {
      arrayOfRandomInts[i] = (int) (range * Math.random());
    }
    return arrayOfRandomInts;
  }
  
  // Question 2
  public static int[][] generateAllData(int iterations, int size, int range) {
    /* the 2d array will have 'iteration' number of arrays in it
     * each array within the 2d array has a length equal to 'size' */
    int[][] arrayWithData = new int[iterations][size];
    /* using the method generateArray to create arrays
     * of random integers and store them in the 2d array */
    for (int i = 0; i < arrayWithData.length; i++) {
      arrayWithData[i] = generateArray(size, range);
    }
    return arrayWithData;
  }
  
  // Question 3
  public static int countElement(int[][] arrayOfInts, int element) {
    // initializing a variable 'count' and setting it as zero
    int count = 0;
    /* iterating through the entries of
     * the 2d array using 2 for loops */ 
    for(int i = 0; i < arrayOfInts.length; i++) {
      for(int j = 0; j < arrayOfInts[i].length; j++) {
        /* count will only be updated when the
         * entry of the array equals 'element' */
        if(arrayOfInts[i][j] == element) {
          count++;
        }
      }
    }
    return count;
  }
  
  // Question 4
  public static int maxDay(int[][] arrayOfInts) {
    /* ASSUMING that the very first entry 
     * of the 2d array is the mode */
    int mode = arrayOfInts[0][0];
    /* finding the count for this assumed
     * mode using the method countElement
     * and storing it in a variable */
    int maxCount = countElement(arrayOfInts, mode);
    /* since the 2d array can contain entries with int
     * values anywhere between 0(incl.) and 365(excl.),
     * we loop 365 times checking the count for each number
     * between 0 and 365. We store the count in a temp variable
     * and compare this count with maxCount. 
     * 
     * 
     * If the new count is greater than maxCount, we update maxCount to
     * the new count and update the mode to the number that
     * gave us this new count. Thus, at the end of the loop we are
     * able to obtain the mode(along with its count). */
    for(int i = 0; i < 365; i++) {
      int tempCount = countElement(arrayOfInts, i);
      if (maxCount < tempCount) {
        maxCount = tempCount;
        mode = i;
      }
    }
    return mode;
  }
  
  // Question 5
  public static boolean hasDuplicates(int[] intArray) {
    /* making a 2d array which has only 1 entry.
     * But that entry is an array itself */
    int[][] arrayOfInts = new int[1][];
    /* storing the one-dimensional array in
     * a 2d array so that NOW we can give this array
     * as input to the method countElement (since 
     * countElement requires as input a 2d array) */
    arrayOfInts[0] = intArray;
    /* we check the count for all numbers between
     * 0(incl.) and 365(excl.) and if at any stage
     * the count > 1, that means we have a duplicate
     * of that number. We then return true. If the 
     * count is never greater than 1, that means we don't
     * have any duplicates and we return false. */
    for (int i = 0; i < 365; i++) {
      if(countElement(arrayOfInts, i) > 1) {
        return true;
      }
    }
    return false;
  }
  
  // Question 6
  public static double runExperiment(int size) {
    if (size < 1) {
      throw new IllegalArgumentException("The size should not be less than 1");
    }
    /* making a 2d array by calling generateAllData
     * with 200 iterations and range as 365 */
    int[][] arrayWithData = generateAllData(200, size, 365);
    
    /* creating a variable that will keep track of 
     * the number of arrays having duplicate entries */
    int duplicateArrays = 0;
    /* calling the method hasDuplicates repeatedly to check
     * if the arrays have duplicate entries or not. If they do,
     * we update the variable duplicateArrays which is keeping
     * count of the number of arrays having duplicate entries */
    for(int i = 0; i < arrayWithData.length; i++) {
      if(hasDuplicates(arrayWithData[i])) {
        duplicateArrays++;
      }
    }
    /* the result will be: the number of arrays having
     * duplicate entries divided by the total number of
     * arrays, which in this case is 200 arrays */
    double result = (double) duplicateArrays/200;
    return result;
  }
}