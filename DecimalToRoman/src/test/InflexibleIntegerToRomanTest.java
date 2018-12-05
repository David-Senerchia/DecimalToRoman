package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.InflexibleIntegerToRoman;
/**
 * Tests InflexibleArabicToRoman class
 * @author David Senerchia
 *
 */
class InflexibleIntegerToRomanTest {

	/**
	 * Tests arabicToRoman method
	 */
    @Test
    void testArabicToRoman() {
        try {
            assertEquals( "X", InflexibleIntegerToRoman.arabicToRoman(10));
            assertEquals( "I", InflexibleIntegerToRoman.arabicToRoman(1));
            assertEquals( "V", InflexibleIntegerToRoman.arabicToRoman(5));
            assertEquals( "L", InflexibleIntegerToRoman.arabicToRoman(50));
            assertEquals( "C", InflexibleIntegerToRoman.arabicToRoman(100));
            assertEquals( "D", InflexibleIntegerToRoman.arabicToRoman(500));
            assertEquals( "M", InflexibleIntegerToRoman.arabicToRoman(1000));
            assertEquals( "MXXIII", InflexibleIntegerToRoman.arabicToRoman(1023));
            assertEquals( "DCCXCVIII", InflexibleIntegerToRoman.arabicToRoman(798));
            assertEquals( "MIV", InflexibleIntegerToRoman.arabicToRoman(1004));
            assertEquals( "LXXXIII", InflexibleIntegerToRoman.arabicToRoman(83));
            assertEquals( "MMMMCMXCIX", InflexibleIntegerToRoman.arabicToRoman(4999));
            InflexibleIntegerToRoman.arabicToRoman(5000);
            InflexibleIntegerToRoman.arabicToRoman(0);
            InflexibleIntegerToRoman.arabicToRoman(-1);
        } catch (IllegalArgumentException e) {
            assertEquals( e.getMessage(), "Integer must be between 1 and 4999");
        }
    }
}
