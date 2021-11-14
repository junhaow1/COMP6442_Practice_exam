package Q2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * You can use this to test your Screen implementation.
 * NOTE: When marking your submission, there can be more tests.
 * 
 * @author huy.pham
 */
public class ScreenTest {

	@Test
	public void testInitialScreenWithUpwardAndPenUp() throws OutOfScreenException {
        Screen s = new Screen(
			11, 
			21, 
			new Pointer(
				new Position(5, 10), 
				Direction.Upward,
				false
			)
		);
        
        assertEquals(
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"##########^##########\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n",
			s.trace()			
		);
	}
	
	@Test
	public void testScreenWithMarkedPositionAndInitialPenDownAndDownwardDirection() throws OutOfScreenException {
        Screen s = new Screen(
			11, 
			21, 
			new Pointer(
				new Position(5, 10), 
				Direction.Downward,
				true
			)
		);
        
        s.markVisistedPos(new Position(5, 5));
        s.markVisistedPos(new Position(10, 10));
        s.pointer.position.x = 4;
        s.pointer.position.y = 4;

        assertEquals(
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"####v################\n" +
			"#####.####.##########\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"##########.##########\n",
			s.trace()
		);
	}
}
