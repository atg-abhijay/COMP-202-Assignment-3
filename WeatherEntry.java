public class WeatherEntry {
  /* defining the private properties temperatureInCelsius
   * and isSunny for objects of type WeatherEntry */
  private double temperatureInCelsius;
  private boolean isSunny;
  
  /* defining the constructor for WeatherEntry. It takes as input
   * values for both of the attributes of WeatherEntry. */
  public WeatherEntry(double tempInCelsius, boolean isSunny){
    this.temperatureInCelsius = tempInCelsius;
    this.isSunny = isSunny;
  }
  
  // **** PART 1 ****
  
  /* method for returning the temperature in Celsius of
   * the object that this method was called on */
  public double getTemperatureCelsius() {
    return this.temperatureInCelsius;
  }
  
  // **** PART 2 ****
  
  /* method that tells us whether it is a good day or not.
   * A good day is one where the temperature is above -30
   * degrees Celsius and it is sunny. */
  public boolean isGoodWeather() {
    if(this.temperatureInCelsius > -30 && this.isSunny) {
      return true;
    }
    return false;
  }
  
  // **** PART 3 ****
  
  /* method that displays the temperature in the
   * requested unit, whether or not its sunny and
   * also whether or not it is a nice day. */
  public void display(boolean isCelsius) {
    /* defining a variable that stores the temperature in
     * Celsius of the object that this method was called on. */
    double temperature = this.temperatureInCelsius;
    String temperatureUnit = "Celsius";
    /* if the user does not request the temperature in Celsius,
     * we need to change the temperature from Celsius to 
     * Fahrenheit and also the units from Celsius to Fahrenheit */
    if(!isCelsius) {
      temperature = ((1.8 * temperature) + 32);
      temperatureUnit = "Fahrenheit";
    }
    /* if the day is not sunny, we need to change
     * the string storing "sunny" to "not sunny" */ 
    String sunnyOrNot = "sunny";
    if(!this.isSunny){
      sunnyOrNot = "not sunny";
    }
    /* if the day is not a nice day, we need to change the
     * string storing "a good day" to "not a good day" */
    String niceDayOrNot = "a good day";
    if(!(this.isGoodWeather())){
      niceDayOrNot = "not a good day";
    }
    // we print this statement based on what values we get from above
    System.out.println("It is " + temperature + " degrees " + temperatureUnit + " and is " + sunnyOrNot + ". It is " + niceDayOrNot + ".");
  }
}