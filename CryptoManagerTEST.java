import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTest {
	CryptoManager manager;

	@BeforeEach
	void setUp() throws Exception {
		manager=new CryptoManager();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		manager=null;
	}

	@Test
	void testIsStringInBounds() {
		assertEquals(manager.isStringInBounds("ABC"),true);
		
	}

	@Test
	void testCaesarEncryption() {
		assertTrue(manager.caesarEncryption("MATH",4).equals("QEXL"));
		assertTrue(manager.caesarEncryption("math",4).equals("The selected string is not in bounds, Try again."));
	}

	@Test
	void testBellasoEncryption() {
		assertEquals(manager.bellasoEncryption("+*+*","AB"),",,,,");
	}

	@Test
	void testCaesarDecryption() {
		assertEquals(manager.caesarDecryption("QEXL",4),"MATH");
	}

	@Test
	void testBellasoDecryption() {
		assertEquals(manager.bellasoDecryption(",,,,", "ABAB"),"+*+*");
	}

}
