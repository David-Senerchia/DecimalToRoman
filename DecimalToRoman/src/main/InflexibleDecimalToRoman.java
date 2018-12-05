package main;
/**
 * 
 * @author David Senerchia
 *
 */
public class InflexibleDecimalToRoman {
	/**
	 * Converts decimal in standard Arabic numbers to a Roman numeral representation. 
	 * Definition of relation between Roman and decimal taken from https://en.wikipedia.org/wiki/Roman_numerals
	 * Roman numerals do not really exceed 3999, so this method caps the conversations at 4999 to be safe.
	 * Decimal input can not be below 0;
	 * @param num int between 1 and 4999
	 * @return String of Roman numerals
	 */
    public static String arabicToRoman(int num) {
        if (num <= 0 || num > 4999) { // error handling
            return "Integer must be between 1 and 4999";
        }
        String thousands[] = {"", "M", "MM", "MMM", "MMMM"}; // list of possible numerals for digits past 1000
        String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // list of possible digits for the 100ths decimal place
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // list of possible digits for the 10ths decimal place
        String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // list of possible digits for the ones decimal place

        String onesDigits = ones[num % 10]; // Check ones place of integer and get Roman numeral from list
        String tensDigits = tens[(num % 100) / 10]; // Check tens place of integer and get Roman numeral from list
        String hundredsDigits = hundreds[(num % 1000) / 100]; //Check hundreds place of integer and get Roman numeral from list
        String thousandsDigits = thousands[num/1000]; // Check thousands place of integer and get Roman numeral from list		
        return thousandsDigits + hundredsDigits + tensDigits + onesDigits; // Concatenate all numerals and return String
    }
}
