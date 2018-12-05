package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FlexibleIntegerToRoman;
/**
 * Tests FlexibleArabicToRoman class
 * @author David Senerchia
 *
 */
class FlexibleIntegerToRomanTest {

	/**
	 * Tests all arabicToRoman methods
	 */
    @Test
    void testInt() {
        try {
    		// Test standard Roman numerals with constraint of integer being positive
            assertEquals( "X", FlexibleIntegerToRoman.arabicToRoman(10));
            assertEquals( "I", FlexibleIntegerToRoman.arabicToRoman(1));
            assertEquals( "V", FlexibleIntegerToRoman.arabicToRoman(5));
            assertEquals( "L", FlexibleIntegerToRoman.arabicToRoman(50));
            assertEquals( "C", FlexibleIntegerToRoman.arabicToRoman(100));
            assertEquals( "D", FlexibleIntegerToRoman.arabicToRoman(500));
            assertEquals( "M", FlexibleIntegerToRoman.arabicToRoman(1000));
            assertEquals( "MXXIII", FlexibleIntegerToRoman.arabicToRoman(1023));
            assertEquals( "DCCXCVIII", FlexibleIntegerToRoman.arabicToRoman(798));
            assertEquals( "MIV", FlexibleIntegerToRoman.arabicToRoman(1004));
            assertEquals( "LXXXIII", FlexibleIntegerToRoman.arabicToRoman(83));
            assertEquals( "MMMMCMXCIX", FlexibleIntegerToRoman.arabicToRoman(4999));
            assertEquals( "MMMMM", FlexibleIntegerToRoman.arabicToRoman(5000));
            assertEquals( "MMMMMMMMMM", FlexibleIntegerToRoman.arabicToRoman(10000));
            FlexibleIntegerToRoman.arabicToRoman(0);
            FlexibleIntegerToRoman.arabicToRoman(-1);
        } catch (IllegalArgumentException e) {
            assertEquals( e.getMessage(), "Integer must be greater than 0");
        }
    }
    
    @Test
    void testIntCustomize() {
        try {
    		// Test choosing your own letters to represent the Roman numerals
            assertEquals( "Integer must be greater than 0", FlexibleIntegerToRoman.arabicToRoman(-10, "A", "B", "C", "D", "E", "F", "G"));
            assertEquals( "E", FlexibleIntegerToRoman.arabicToRoman(10, "A", "B", "C", "D", "E", "F", "G"));
            assertEquals( "G", FlexibleIntegerToRoman.arabicToRoman(1));
            assertEquals( "F", FlexibleIntegerToRoman.arabicToRoman(5));
            assertEquals( "D", FlexibleIntegerToRoman.arabicToRoman(50));
            assertEquals( "C", FlexibleIntegerToRoman.arabicToRoman(100));
            assertEquals( "B", FlexibleIntegerToRoman.arabicToRoman(500));
            assertEquals( "A", FlexibleIntegerToRoman.arabicToRoman(1000));
            assertEquals( "AEEGGG", FlexibleIntegerToRoman.arabicToRoman(1023));
            assertEquals( "BCCECFGGG", FlexibleIntegerToRoman.arabicToRoman(798));
            assertEquals( "AGF", FlexibleIntegerToRoman.arabicToRoman(1004));
            assertEquals( "DEEEGGG", FlexibleIntegerToRoman.arabicToRoman(83));
            assertEquals( "AAAACAECGE", FlexibleIntegerToRoman.arabicToRoman(4999));
            assertEquals( "AAAAA", FlexibleIntegerToRoman.arabicToRoman(5000));
            assertEquals( "AAAAAAAAAA", FlexibleIntegerToRoman.arabicToRoman(10000));
            FlexibleIntegerToRoman.arabicToRoman(0);
            FlexibleIntegerToRoman.arabicToRoman(-1);
        } catch (IllegalArgumentException e) {
            assertEquals( e.getMessage(), "Integer must be greater than 0");
        }

        // Test resetting back to original standard Roman numerals
        FlexibleIntegerToRoman.reset();
    }
    
    @Test
    void testIntBoolean() {
        // Test added negative sign to standard Roman numerals to include negative number representations
        assertEquals( "", FlexibleIntegerToRoman.arabicToRoman(0,false));
        assertEquals( "-X", FlexibleIntegerToRoman.arabicToRoman(-10, true));
        assertEquals( "I", FlexibleIntegerToRoman.arabicToRoman(1,false));
        assertEquals( "-V", FlexibleIntegerToRoman.arabicToRoman(-5,true));
        assertEquals( "L", FlexibleIntegerToRoman.arabicToRoman(50,false));
        assertEquals( "-C", FlexibleIntegerToRoman.arabicToRoman(-100,true));
        assertEquals( "D", FlexibleIntegerToRoman.arabicToRoman(500,true));
        assertEquals( "M", FlexibleIntegerToRoman.arabicToRoman(1000,true));
        assertEquals( "-MXXIII", FlexibleIntegerToRoman.arabicToRoman(-1023,true));
        assertEquals( "-DCCXCVIII", FlexibleIntegerToRoman.arabicToRoman(-798,true));
        assertEquals( "-MIV", FlexibleIntegerToRoman.arabicToRoman(-1004,true));
        assertEquals( "-LXXXIII", FlexibleIntegerToRoman.arabicToRoman(-83,true));
        assertEquals( "-MMMMCMXCIX", FlexibleIntegerToRoman.arabicToRoman(-4999,true));
    }
    
    @Test
    void testIntBooleanCustomize() {
        // Test negative signs with user selected letters for Roman numerals
        assertEquals( "-E", FlexibleIntegerToRoman.arabicToRoman(-10, true, "A", "B", "C", "D", "E", "F", "G"));
        assertEquals( "G", FlexibleIntegerToRoman.arabicToRoman(1, false));
        assertEquals( "-F", FlexibleIntegerToRoman.arabicToRoman(-5, true));
        assertEquals( "D", FlexibleIntegerToRoman.arabicToRoman(50, false));
        assertEquals( "-C", FlexibleIntegerToRoman.arabicToRoman(-100, true));
        assertEquals( "-B", FlexibleIntegerToRoman.arabicToRoman(-500, true));
        assertEquals( "-A", FlexibleIntegerToRoman.arabicToRoman(-1000, true));
        assertEquals( "-AEEGGG", FlexibleIntegerToRoman.arabicToRoman(-1023, true));
        assertEquals( "-BCCECFGGG", FlexibleIntegerToRoman.arabicToRoman(-798, true));
        assertEquals( "-AGF", FlexibleIntegerToRoman.arabicToRoman(-1004, true));
        assertEquals( "-DEEEGGG", FlexibleIntegerToRoman.arabicToRoman(-83, true));
        assertEquals( "-AAAACAECGE", FlexibleIntegerToRoman.arabicToRoman(-4999, true));
        assertEquals( "-AAAAA", FlexibleIntegerToRoman.arabicToRoman(-5000, true));
        assertEquals( "-AAAAAAAAAA", FlexibleIntegerToRoman.arabicToRoman(-10000, true));

        FlexibleIntegerToRoman.reset();
    }

}
