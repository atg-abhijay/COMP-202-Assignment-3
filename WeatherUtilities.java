import java.util.Scanner;
public class WeatherUtilities {
  public static void main(String[] args) {
    /* creating an array of WeatherEntry objects whose size
     * shall be given by the user via command line arguments */
    WeatherEntry[] weatherEntries = new WeatherEntry[Integer.parseInt(args[0])];
    /* making a double variable that will store the temperature
     * in Celsius for each day (initialising it to be 0) */
    double tempInCelsius = 0; 
    /* making a boolean variable that will store the sunniness
     * status for each day. (initialising it to be false) */
    boolean isSunny = false;
    /* making a Scanner object that will be used to
     * take input for temperatures and sunniness */
    Scanner reader = new Scanner(System.in);
    /* we ask the user to enter a temperature and then take the temperature
     * as a double input through our Scanner object using reader.nextDouble().
     * we store that temperature in tempInCelsius.
     * 
     * we ask the user to tell us whether the day was sunny or not and take the
     * sunniness as a boolean input through our Scanner object using reader.nextBoolean().
     * we store that boolean value in isSunny.
     * 
     * we create the elements in the weatherEntries array and assign the values
     * obtained above to the elements of the weatherEntries array */
    for(int i = 0; i < weatherEntries.length; i++){
      System.out.println("Enter temperature in Celsius");
      tempInCelsius = reader.nextDouble();
      System.out.println("Was the day sunny or not? (true/false)");
      isSunny = reader.nextBoolean();
      weatherEntries[i] = new WeatherEntry(tempInCelsius, isSunny); 
    }
    
    /* at this stage, our weatherEntries array is complete. we call the method
     * countGoodDays and give it as input our array weatherEntries. it returns the
     * number of good days in the array of WeatherEntry objects and we store that 
     * result in a variable numGoodDays. */
    int numGoodDays = countGoodDays(weatherEntries);
    /* to the method minMaxTemp, we give as input the array of WeatherEntry objects
     * weatherEntries. we store the result (a double array of size 2) from this in 
     * a new double array minMaxTemp */
    double[] minMaxTemp = minMaxTemp(weatherEntries);
    double minTemp = minMaxTemp[0];
    double maxTemp = minMaxTemp[1];
    System.out.println("There were " + numGoodDays + " nice days.");
    System.out.println("The highest temperature was " + maxTemp + " degrees Celsius and the lowest was " + minTemp);
  }
  
  // ************** METHODS ****************
  
  
  // Question 3.1
  public static int countGoodDays(double[] tempsInCelsius, boolean[] sunniness) {
    /* if the lengths of the arrays storing temperatures and
     * sunniness are not the same, we throw an exception */
    if(tempsInCelsius.length != sunniness.length){
      throw new IllegalArgumentException("The lengths of the arrays are not the same.");
    }
    /* defining a variable that will store the number of
     * days which satisfy the isGoodWeather criteria */
    int goodDays = 0;
    /* if the temperature is greater than -30 degrees Celsius
     * AND it is true that the day is sunny, then only we will
     * update the variable keeping track of the good days */
    for(int i = 0; i < tempsInCelsius.length; i++){
      if(tempsInCelsius[i] > -30 && sunniness[i]){
        goodDays++;
      }
    }
    return goodDays;
  }
  
  // Question 3.2
  public static int countGoodDays(WeatherEntry[] weatherEntries) {
    /* defining a variable that will store the number of
     * days which satisfy the isGoodWeather criteria */
    int goodDays = 0;
    /* the variable goodDays will only be updated
     * if the method isGoodWeather returns true
     * for elements from the weatherEntries array */
    for(int i = 0; i < weatherEntries.length; i++) {
      if(weatherEntries[i].isGoodWeather()){
        goodDays++;
      }
    }
    return goodDays;
  }
  
  /* we use this method to find the minimum and maximum
   * temperatures among all the WeatherEntry objects */
  private static double[] minMaxTemp(WeatherEntry[] weatherEntries) {
    /* the method takes as input a WeatherEntry array that stores
     * all of the WeatherEntry objects.
     * we define a double array of size 2 that will
     * store the minimum and maximum temperatures */
    double[] minMaxTemp = new double[2];
    
    // ****** Finding minium temperature ******
    
    /* we assume that the minimum temperature is
     * the temperature of the first WeatherEntry object */
    double minTemp = weatherEntries[0].getTemperatureCelsius();
    /* we compare this minTemp with the other temperatures.
     * if it is greater than the temperature it 
     * is being compared with, we update minTemp to store that
     * lower temperature. in this way, by the end of the loop,
     * we obtain the lowest temperature out of all the temperatures */
    for(int i = 1; i < weatherEntries.length; i++) {
      if(minTemp > weatherEntries[i].getTemperatureCelsius()){
        minTemp = weatherEntries[i].getTemperatureCelsius();
      }
    }
    /* we store the minimum temperature at the 0th
     * index of our double array minMaxTemp of size 2 */
    minMaxTemp[0] = minTemp;
    
    // ****** Finding maximum temperature ****** 
    
    /* we assume that the maximum temperature is
     * the temperature of the first WeatherEntry object*/
    double maxTemp = weatherEntries[0].getTemperatureCelsius();
    /* we compare this maxTemp with the other temperatures
     * if it is lower than the temperature it 
     * is being compared with, we update maxTemp to store that
     * higher temperature. in this way, by the end of the loop,
     * we obtain the highest temperature out of all the temperatures */
    for(int j = 1; j < weatherEntries.length; j++) {
      if(maxTemp < weatherEntries[j].getTemperatureCelsius()){
        maxTemp = weatherEntries[j].getTemperatureCelsius();
      }
    }
    /* we store the maximum temperature at the 1st
     * index of our double array minMaxTemp of size 2 */
    minMaxTemp[1] = maxTemp;
    /* we return our array storing the
     * minimum and maximum temperatures */
    return minMaxTemp;
  }
}