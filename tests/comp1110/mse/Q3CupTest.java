package comp1110.mse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
public class Q3CupTest {

  private void testWFPiecePlacement(String pp, boolean expected) {
    boolean out = Q3Cup.wellFormedPiecePlacement(pp);
    assertEquals(expected, out, "Unexpected result for '"+pp+"'");
  }
  private void testWFGameString(String game, boolean expected) {
    boolean out = Q3Cup.wellFormedGameString(game);
    assertEquals(expected, out, "Unexpected result for '"+game+"'");
  }
  private void testReach(String game, int expected) {
    int out = Q3Cup.cupsGatheringRain(game);
    assertEquals(expected, out, "Unexpected count for "+pretty(game));
  }

  @Test
  public void wellFormedPiecePlacementSimple() {
    testWFPiecePlacement("", false);
    testWFPiecePlacement(null, false);
    testWFPiecePlacement("C20R", true);
    testWFPiecePlacement("C20", false);
    testWFPiecePlacement("U20", true);
    testWFPiecePlacement("U55", false);
  }

  @Test
  public void wellFormedPiecePlacement() {
    testWFPiecePlacement("C20Z", false);
    testWFPiecePlacement("U20R", false);
    testWFPiecePlacement("C44R", true);
    testWFPiecePlacement("C44U", true);
    testWFPiecePlacement("C-4U", false);
  }

  @Test
  public void wellFormedGameString() {
    testWFGameString("C13RU20C11UU30C32UC44UC01UU43U33U04U03U14U10", true);
    testWFGameString("C30UC24UU04U01C14RU03U10U00U21C20RC02UU33U23", true);
    testWFGameString("C32RU34C23UC40UC43UU33U01U03U00U41C21UU02U12", true);
    testWFGameString("C32RU34C23UC40UC43UU33U01U03U00U41C21UU02", false);
    testWFGameString("C32RU34C23UC40UC43UU33U01U03U00U41C21UU02U02", false);
    testWFGameString("C32RU34C23UC40UC43UU33U01U03U00U41C21UU02U32", false);
    testWFGameString("U32U34U23U40C43UU33U01U03U00U41C21UU02U12U11", false);
    testWFGameString(null, false);
  }

  @Test
  public void testReachableA() {
    testReach("U03U02U21U31U01U42C14RC10UC12RU22U20U32U13U44C43UU00C30U", -1);
    testReach("C44UU24U32C20UC41UU43C12UU33C22UU11U23U10U42", 0);
    testReach("C14RC40RC41UC11UU22U42C30RU04U02U12U32U03U00", 0);
    testReach("U00U43C33UU02U01C03RC21RC41RC04UU22U13U42U14", 1);
    testReach("U44U40U32C12UC23UC41UC01RU24U43U14C11UU04U30", 1);
    testReach("U22U33U43U21U04C30UU31U12C11RC01UU44C20UC23R", 1);
    testReach("U01C00RU14U11C12RU22U32C24UU31U44C02UU34C41R", 1);
  }

  @Test
  public void testReachableB() {
    testReach("C21UC40UU01U44U43C14UU33U03C22RC00RU13U23U31", 2);
    testReach("C32RC01RC40RC02UU30U22U00C23RU44U42U24U20U10", 2);
    testReach("U12U21C10RC04RC32RC33RC24UU23U30U22U43U41U20", 2);
    testReach("U32C40UU21U42U33C02RC01RU23U30U00C04RU24C10R", 3);
  }

  static String pretty(String game) {
    String rtn = "game: \""+game+"\""+System.lineSeparator();
    int i = 0;
    int c = 0;
    char[] out = new char[25];
    while (i < 44) {
      int l = ((game.charAt(i+1)-'0')*5)+(game.charAt(i+2)-'0');
      if (game.charAt(i) == 'U') {
        out[l] = '^';
        i += 3;
      } else {
        out[l] = game.charAt(i+3) == 'R' ? 'u' : 'n';
        i+= 4;
      }
    }
    for (i = 0; i < 25; i++) {
      rtn += out[i] == 0 ? "  " : out[i]+" ";
      if (i % 5 == 4) rtn += System.lineSeparator();
    }
    return rtn;
  }

}
