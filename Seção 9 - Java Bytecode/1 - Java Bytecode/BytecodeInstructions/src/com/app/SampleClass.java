public class SampleClass {
  public static int testID = 100;

  void testFor() {
    for(int i = 0; i <= 100; i++) {

    }
  }

  void testWhile() {
    int i = 0;
    while(i <= 100) {
      i++;
    }
  }

  public static int testOne() {
    int x = 99999;
    int y = 1;
    int z = x + y;
    return z;
  }

  public static void testTwo() {
    SampleClass sc = new SampleClass();
    SampleClass.testID = 200;
  }
}