package comp1110.mse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class Q2PlaneTest {

  private void constructorTest(Q2Plane o, int v1, String v2) {
    assertNotNull(o,"Expected non-null object, but got null.");
    assertEquals(v1, o.in, "Incorrect in");
    assertEquals(v2, o.tailNumber, "Incorrect tail number");
  }

  private void setterTest(Q2Plane o, String value) {
    o.setTailNumber(value);
    assertEquals(value, o.tailNumber, "Setter method did not set value correctly.");
  }

  private void getterTest(Q2Plane o, String value) {
    o.tailNumber = value;
    assertEquals(value, o.getTailNumber(), "Getter method did not return value correctly.");
  }

  private void functionTest(Q2Plane o, int[] val) {
    int sum = 0;
    for (int i = 0; i < val.length; i++) {
      o.milesFlown(val[i]);
      sum += val[i];
    }
    int expected = val.length == 0 ? 0 : sum/val.length;
    assertEquals(expected, o.averageMilesPerDay(), "Incorrect output for averageMilesPerDay() given: "+Arrays.toString(val));
  }

  private void toStringTest(Q2Plane o, String expected) {
    assertEquals(expected, o.toString(), "toString() method gave unexpected value");
  }

  public void factoryTest(int[] v1, String[] v2) {
    Q2Plane[] out = Q2Plane.makePlanes(v1, v2);
    if (v1 == null || v2 == null) {
      assertNull(out, "Expected null for inputs '"+v1+"' and '"+v2+"'");
    } else if (v1.length == 0 || v2.length == 0 || v1.length != v2.length) {
      assertNull(out,"Expected to return null for inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but did not.");
    } else {
      assertNotNull(out, "Expected to return non-null value for inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but did not.");
      for (int i = 0; i < v1.length; i++) {
        assertNotNull(out[i], "Expected non-null value for entry ["+i+"] and inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but got null entry.");
        assertEquals(v1[i], out[i].in, "Did not get expected in for entry "+i+", given inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2));
        assertEquals(v2[i], out[i].tailNumber, "Did not get expected tail number for entry "+i+", given inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2));
      }
    }
  }

  static String[] names = {"N16-100", "YA-FAR", "7T-VEE", "LV-HGW", "VH-AAV", "VH-100", "VH-UMF"};

  @Test
  public void testConstructor() {
    Q2Plane o = new Q2Plane(10, names[1]);
    constructorTest(o, 10, names[1]);
  }

  @Test
  public void testGetterSetter() {
    Q2Plane o = new Q2Plane(10, names[1]);
    constructorTest(o, 10, names[1]);
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
      int v = r.nextInt(names.length);
      setterTest(o, names[v]);
      getterTest(o, names[v]);
    }
  }

  @Test
  public void testFunction() {
    Q2Plane o = new Q2Plane(10, names[1]);
    constructorTest(o, 10, names[1]);
    Random r = new Random();
    int[] z = {};
    functionTest(o, z);
    for (int i = 0; i < 10; i++) {
      o = new Q2Plane(10, names[1]);
      constructorTest(o, 10, names[1]);
      int l = r.nextInt(12);
      z = new int[l];
      for (int j = 0; j < l; j++)
        z[j] = r.nextInt(12);
      functionTest(o, z);
    }
  }

  @Test
  public void testToString() {
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
      String n = names[r.nextInt(names.length)];
      int v = 10+r.nextInt(60);
      Q2Plane o = new Q2Plane(10, names[1]);
      constructorTest(o, 10, names[1]);
      o.milesFlown(200+r.nextInt(1000));
      o.milesFlown(200+r.nextInt(3000));
      toStringTest(o, "Plane "+o.in+" has tail number '"+o.tailNumber+"' and averages "+o.averageMilesPerDay()+" miles per day");
    }
  }

  private String[] newRandString(int size) {
    Random r = new Random();
    String[] rtn = new String[size];
    for (int i = 0; i < size; i++) {
      rtn[i] = names[r.nextInt(names.length)];
    }
    return rtn;
  }
  private int[] newRandInt(int size) {
    Random r = new Random();
    int[] rtn = new int [size];
    for (int i = 0; i < size; i++) {
      rtn[i] = 1+r.nextInt(20);
    }
    return rtn;
  }

  @Test
  public void testFactory() {
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
      int l1 = 1+r.nextInt(7);
      String[] n = newRandString(l1);
      int[] v;
      int c = r.nextInt(6);
      if (c == 0) {
        v = null;
      } else if (c == 1) {
        v= newRandInt(n.length + 1);
      } else
        v = newRandInt(n.length);
      factoryTest(v,n);
    }
  }

}
