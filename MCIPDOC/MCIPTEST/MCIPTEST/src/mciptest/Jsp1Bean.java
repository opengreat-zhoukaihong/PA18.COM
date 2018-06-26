package mciptest;

public class Jsp1Bean {
  private String sample = "Start value";
  /**Access sample property*/
  public String getSample() {
    return sample;
  }
  /**Access sample property*/
  public void setSample(String newValue) {
    if (newValue!=null) {
      sample = newValue;
    }
  }
}