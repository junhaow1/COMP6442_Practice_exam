package comp1110.mse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class Q1ThirdTest {
  private void test(int[] values, int expected) {
    double out = Q1Third.third(values);
    assertEquals(expected, out, "Unexpected result for values " + Arrays.toString(values));
  }

  @Test
  public void testNull() {
    test(null, 0);
  }

  @Test
  public void testEmpty() {
    int[] v = {};
    test(v, 0);
  }

  @Test
  public void testSmall() {
    int[] v0 = {0, 2, 8};
    test(v0, 10);
    int[] v1 = {9, 9, 5};
    test(v1, 5);
    int[] v2 = {2, 9, 1};
    test(v2, 8);
    int[] v3 = {4, 5, 6};
    test(v3, 7);
    int[] v4 = {1, 2, 9};
    test(v4, 10);
    int[] v5 = {9, 1, 1};
    test(v5, -7);
    int[] v6 = {3, 2, 0};
    test(v6, -1);
    int[] v7 = {9, 0, 0};
    test(v7, -9);
    int[] v8 = {1, 7, 6};
    test(v8, 12);
    int[] v9 = {2, 1, 4};
  }

  @Test
  public void testMedium() {
    int[] v0 = {9, -3, -8, 0, 2};
    test(v0, -18);
    int[] v1 = {8, -5, 5, -7, -2};
    test(v1, -3);
    int[] v2 = {-3, -6, -4, 5, -4};
    test(v2, -16);
    int[] v3 = {9, -9, 0, 0, -8};
    test(v3, -26);
    int[] v4 = {6, -6, 1, 0, 4};
    test(v4, -7);
    int[] v5 = {-8, 5, 0, -2, 4};
    test(v5, 19);
    int[] v6 = {-3, -4, 9, 2, -6};
    test(v6, 0);
    int[] v7 = {-7, 9, -8, 0, 5};
    test(v7, 13);
    int[] v8 = {-9, -9, -8, -5, 1};
    test(v8, -2);
    int[] v9 = {8, -5, 0, -2, -3};
    test(v9, -14);
  }

  @Test
  public void testLarge() {
    int[] v0 = {9, -6, 1, -3, 2, -6, 3, 1, 0, -8, -3, -7, 7, -4, 0};
    test(v0, -30);
    int[] v1 = {3, 6, 0, 0, -9, -9, -9, 2, 0, 9, 1, 6, 2, -2, -6};
    test(v1, -16);
    int[] v2 = {0, 5, 8, -3, -1, 7, -1, 1, 3, 8, 8, 8, -6, 3, 0};
    test(v2, 44);
    int[] v3 = {9, -4, -5, 4, -8, 8, 2, 7, 0, 9, -2, -7, 6, 4, 0};
    test(v3, -37);
    int[] v4 = {9, 4, -1, 2, 1, -3, -9, -8, -1, -9, 3, 4, -6, -2, -4};
    test(v4, 6);
    int[] v5 = {-1, 1, 9, 2, 7, -2, 2, -3, 1, 7, -4, 1, 8, 2, 2};
    test(v5, -4);
    int[] v6 = {0, 2, 0, -3, -3, -1, 5, 8, -9, 4, 4, -2, -9, -1, 5};
    test(v6, 6);
    int[] v7 = {-5, 9, 2, -7, -3, 8, -9, -2, 0, 8, 5, -2, 2, -5, -8};
    test(v7, 15);
    int[] v8 = {-7, 6, -6, 9, 4, 4, -9, 9, 9, 6, -7, 2, -3, 6, 4};
    test(v8, 35);
    int[] v9 = {1, 5, 8, -4, 6, 8, -3, -4, -6, -6, 9, -2, 5, -4, 3};
    test(v9, 30);
  }
}
