package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FlexibleDecimalToRoman;
/**
 * Tests FlexibleArabicToRoman class
 * @author David Senerchia
 *
 */
class FlexibleDecimalToRomanTest {

	/**
	 * Tests all arabicToRoman methods
	 */
	@Test
	void testArabicToRoman() {
		// Test standard Roman numerals with constraint of integer being positive
		assertEquals( "X", FlexibleDecimalToRoman.arabicToRoman(10));
		assertEquals( "I", FlexibleDecimalToRoman.arabicToRoman(1));
		assertEquals( "V", FlexibleDecimalToRoman.arabicToRoman(5));
		assertEquals( "L", FlexibleDecimalToRoman.arabicToRoman(50));
		assertEquals( "C", FlexibleDecimalToRoman.arabicToRoman(100));
		assertEquals( "D", FlexibleDecimalToRoman.arabicToRoman(500));
		assertEquals( "M", FlexibleDecimalToRoman.arabicToRoman(1000));
		assertEquals( "MXXIII", FlexibleDecimalToRoman.arabicToRoman(1023));
		assertEquals( "DCCXCVIII", FlexibleDecimalToRoman.arabicToRoman(798));
		assertEquals( "MIV", FlexibleDecimalToRoman.arabicToRoman(1004));
		assertEquals( "LXXXIII", FlexibleDecimalToRoman.arabicToRoman(83));
		assertEquals( "MMMMCMXCIX", FlexibleDecimalToRoman.arabicToRoman(4999));
		assertEquals( "MMMMM", FlexibleDecimalToRoman.arabicToRoman(5000));
		assertEquals( "MMMMMMMMMM", FlexibleDecimalToRoman.arabicToRoman(10000));
		assertEquals( "Integer must be greater than 0", FlexibleDecimalToRoman.arabicToRoman(0));
		assertEquals( "Integer must be greater than 0", FlexibleDecimalToRoman.arabicToRoman(-1));
		
		// Test choosing your own letters to represent the Roman numerals
		assertEquals( "Integer must be greater than 0", FlexibleDecimalToRoman.arabicToRoman(-10, "A", "B", "C", "D", "E", "F", "G"));
		assertEquals( "E", FlexibleDecimalToRoman.arabicToRoman(10, "A", "B", "C", "D", "E", "F", "G"));
		assertEquals( "G", FlexibleDecimalToRoman.arabicToRoman(1));
		assertEquals( "F", FlexibleDecimalToRoman.arabicToRoman(5));
		assertEquals( "D", FlexibleDecimalToRoman.arabicToRoman(50));
		assertEquals( "C", FlexibleDecimalToRoman.arabicToRoman(100));
		assertEquals( "B", FlexibleDecimalToRoman.arabicToRoman(500));
		assertEquals( "A", FlexibleDecimalToRoman.arabicToRoman(1000));
		assertEquals( "AEEGGG", FlexibleDecimalToRoman.arabicToRoman(1023));
		assertEquals( "BCCECFGGG", FlexibleDecimalToRoman.arabicToRoman(798));
		assertEquals( "AGF", FlexibleDecimalToRoman.arabicToRoman(1004));
		assertEquals( "DEEEGGG", FlexibleDecimalToRoman.arabicToRoman(83));
		assertEquals( "AAAACAECGE", FlexibleDecimalToRoman.arabicToRoman(4999));
		assertEquals( "AAAAA", FlexibleDecimalToRoman.arabicToRoman(5000));
		assertEquals( "AAAAAAAAAA", FlexibleDecimalToRoman.arabicToRoman(10000));
		assertEquals( "Integer must be greater than 0", FlexibleDecimalToRoman.arabicToRoman(0));
		assertEquals( "Integer must be greater than 0", FlexibleDecimalToRoman.arabicToRoman(-1));
		
		// Test resetting back to original standard Roman numerals
		FlexibleDecimalToRoman.reset();

		// Test added negative sign to standard Roman numerals to include negative number representations
		assertEquals( "", FlexibleDecimalToRoman.arabicToRoman(0,false));
		assertEquals( "-X", FlexibleDecimalToRoman.arabicToRoman(-10, true));
		assertEquals( "I", FlexibleDecimalToRoman.arabicToRoman(1,false));
		assertEquals( "-V", FlexibleDecimalToRoman.arabicToRoman(-5,true));
		assertEquals( "L", FlexibleDecimalToRoman.arabicToRoman(50,false));
		assertEquals( "-C", FlexibleDecimalToRoman.arabicToRoman(-100,true));
		assertEquals( "D", FlexibleDecimalToRoman.arabicToRoman(500,true));
		assertEquals( "M", FlexibleDecimalToRoman.arabicToRoman(1000,true));
		assertEquals( "-MXXIII", FlexibleDecimalToRoman.arabicToRoman(-1023,true));
		assertEquals( "-DCCXCVIII", FlexibleDecimalToRoman.arabicToRoman(-798,true));
		assertEquals( "-MIV", FlexibleDecimalToRoman.arabicToRoman(-1004,true));
		assertEquals( "-LXXXIII", FlexibleDecimalToRoman.arabicToRoman(-83,true));
		assertEquals( "-MMMMCMXCIX", FlexibleDecimalToRoman.arabicToRoman(-4999,true));

		// Test negative signs with user selected letters for Roman numerals
		assertEquals( "-E", FlexibleDecimalToRoman.arabicToRoman(-10, true, "A", "B", "C", "D", "E", "F", "G"));
		assertEquals( "G", FlexibleDecimalToRoman.arabicToRoman(1, false));
		assertEquals( "-F", FlexibleDecimalToRoman.arabicToRoman(-5, true));
		assertEquals( "D", FlexibleDecimalToRoman.arabicToRoman(50, false));
		assertEquals( "-C", FlexibleDecimalToRoman.arabicToRoman(-100, true));
		assertEquals( "-B", FlexibleDecimalToRoman.arabicToRoman(-500, true));
		assertEquals( "-A", FlexibleDecimalToRoman.arabicToRoman(-1000, true));
		assertEquals( "-AEEGGG", FlexibleDecimalToRoman.arabicToRoman(-1023, true));
		assertEquals( "-BCCECFGGG", FlexibleDecimalToRoman.arabicToRoman(-798, true));
		assertEquals( "-AGF", FlexibleDecimalToRoman.arabicToRoman(-1004, true));
		assertEquals( "-DEEEGGG", FlexibleDecimalToRoman.arabicToRoman(-83, true));
		assertEquals( "-AAAACAECGE", FlexibleDecimalToRoman.arabicToRoman(-4999, true));
		assertEquals( "-AAAAA", FlexibleDecimalToRoman.arabicToRoman(-5000, true));
		assertEquals( "-AAAAAAAAAA", FlexibleDecimalToRoman.arabicToRoman(-10000, true));
		
		FlexibleDecimalToRoman.reset();
	}

}
