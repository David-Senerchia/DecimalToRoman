package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.InflexibleDecimalToRoman;
/**
 * Tests InflexibleArabicToRoman class
 * @author David Senerchia
 *
 */
class InflexibleDecimalToRomanTest {

	/**
	 * Tests arabicToRoman method
	 */
	@Test
	void testArabicToRoman() {
		assertEquals( "X", InflexibleDecimalToRoman.arabicToRoman(10));
		assertEquals( "I", InflexibleDecimalToRoman.arabicToRoman(1));
		assertEquals( "V", InflexibleDecimalToRoman.arabicToRoman(5));
		assertEquals( "L", InflexibleDecimalToRoman.arabicToRoman(50));
		assertEquals( "C", InflexibleDecimalToRoman.arabicToRoman(100));
		assertEquals( "D", InflexibleDecimalToRoman.arabicToRoman(500));
		assertEquals( "M", InflexibleDecimalToRoman.arabicToRoman(1000));
		assertEquals( "MXXIII", InflexibleDecimalToRoman.arabicToRoman(1023));
		assertEquals( "DCCXCVIII", InflexibleDecimalToRoman.arabicToRoman(798));
		assertEquals( "MIV", InflexibleDecimalToRoman.arabicToRoman(1004));
		assertEquals( "LXXXIII", InflexibleDecimalToRoman.arabicToRoman(83));
		assertEquals( "MMMMCMXCIX", InflexibleDecimalToRoman.arabicToRoman(4999));
		assertEquals( "Integer must be between 1 and 4999", InflexibleDecimalToRoman.arabicToRoman(5000));
		assertEquals( "Integer must be between 1 and 4999", InflexibleDecimalToRoman.arabicToRoman(0));
		assertEquals( "Integer must be between 1 and 4999", InflexibleDecimalToRoman.arabicToRoman(-1));
	}
}
