package main;
/**
 * Definition of relation between Roman and decimal taken from https://en.wikipedia.org/wiki/Roman_numerals
 * This class uses the StringBuilder class a lot because these calculations depend heavily
 *   on concatenating strings. The StringBuilder class is more efficient and straightforward
 *   than directly working with strings.
 * @author David Senerchia
 *
 */
public class FlexibleIntegerToRoman {
	/** Numeral representation of 1000 */
    private static String thousand = "M";
	/** Numeral representation of 500 */
    private static String fiveHun = "D";
	/**  Numeral representation of 100 */
    private static String hundred = "C";
	/** Numeral representation of 50 */
    private static String fifty = "L";
	/** Numeral representation of 10 */
    private static String ten = "X";
	/** Numeral representation of 5 */
    private static String five = "V";
	/** Numeral representation of 1 */
    private static String one = "I";
	
	/**
	 * Converts decimal in standard Arabic numbers to a Roman numeral representation. 
	 * There is no limit to the size of the number the numerals will represent.
	 * Decimal input can not be 0 or below;
	 * @param num int greater than 0 to convert
	 * @return String of Roman numerals
	 */
    public static String arabicToRoman(int num) {
        if (num <= 0) { // error handling
            return "Integer must be greater than 0";
        }
        return arabicToRoman(num, false);
    }
	
	/**
	 * Converts decimal in standard Arabic numbers to a Roman numeral representation. 
	 * There is no limit to the size of the number the numerals will represent.
	 * If number is signed, all numbers are accepted and a '-' will be appended at the 
	 *   front of the Roman numerals to show that the number is negative.
	 * If number is unsigned. Integer num must be 0 or greater.
	 * @param num int to convert
	 * @param signed boolean true if signed, false if unsigned
	 * @return String of Roman numerals
	 */
    public static String arabicToRoman(int num, boolean signed) {
        StringBuilder sb = new StringBuilder();
        if (signed && num < 0) {
            num = Math.abs(num);
            sb.append('-');
        }
        String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // list of possible digits for the 100ths decimal place
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // list of possible digits for the 10ths decimal place
        String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // list of possible digits for the ones decimal place

        sb.append(printMs(num/1000)); // Check thousands place of integer
        sb.append(calculateDigit(hundreds[(num % 1000) / 100])); //Check hundreds place of integer and get Roman numeral from list
        sb.append(calculateDigit(tens[(num % 100) / 10])); // Check tens place of integer and get Roman numeral from list
        sb.append(calculateDigit(ones[num % 10])); // Check ones place of integer and get Roman numeral from list
        return sb.toString(); // Concatenate all numerals and return String
    }
	
	/**
	 * Converts decimal in standard Arabic numbers to a Roman numeral representation. 
	 * There is no limit to the size of the number the numerals will represent.
	 * Decimal input can not be 0 or below;
	 * A user may provide their own letters to customize their own numerals with this method
	 * @param num int greater than 0 to convert
	 * @param thousands letter to represent 1000
	 * @param fiveHundreds letter to represent 500
	 * @param hundreds letter to represent 100
	 * @param fifties letter to represent 50
	 * @param tens letter to represent 10
	 * @param fives letter to represent 5
	 * @param ones letter to represent 1
	 * @return String of customized Roman numerals
	 */
    public static String arabicToRoman(int num, String thousands, String fiveHundreds, String hundreds, String fifties, String tens, String fives, String ones) {
        if (num <= 0) { // error handling
            return "Integer must be greater than 0";
        }
        thousand = thousands;
        fiveHun = fiveHundreds;
        hundred = hundreds;
        fifty = fifties;
        ten = tens;
        five = fives;
        one = ones;
        return arabicToRoman(num, false);
    }
	
	/**
	 * Converts decimal in standard Arabic numbers to a Roman numeral representation. 
	 * There is no limit to the size of the number the numerals will represent.
	 * If number is signed, all numbers are accepted and a '-' will be appended at the 
	 *   front of the Roman numerals to show that the number is negative.
	 * If number is unsigned. Integer num must be 0 or greater.
	 * A user may provide their own letters to customize their own numerals with this method
	 * @param num int to convert
	 * @param signed boolean true if signed, false if unsigned
	 * @param thousands letter to represent 1000
	 * @param fiveHundreds letter to represent 500
	 * @param hundreds letter to represent 100
	 * @param fifties letter to represent 50
	 * @param tens letter to represent 10
	 * @param fives letter to represent 5
	 * @param ones letter to represent 1
	 * @return String of customized Roman numerals
	 */
    public static String arabicToRoman(int num, boolean signed, String thousands, String fiveHundreds, String hundreds, String fifties, String tens, String fives, String ones) {
        thousand = thousands;
        fiveHun = fiveHundreds;
        hundred = hundreds;
        fifty = fifties;
        ten = tens;
        five = fives;
        one = ones;
        return arabicToRoman(num, signed);
    }
	
	/**
	 * Reset Roman numerals back to original MDCLXVI format
	 */
    public static void reset() {
        thousand = "M";
        fiveHun = "D";
        hundred = "C";
        fifty = "L";
        ten = "X";
        five = "V";
        one = "I";
    }
	
	/**
	 * Helper method to append to the appropriate number of letters in the 1000ths place.
	 * This function is required in order to make the size of formatable Roman numerals limitless.
	 * @param letters amount of letters to add
	 * @return StringBuilder with appropriate amount of 1000ths letters
	 */
    private static StringBuilder printMs(int letters) {
        StringBuilder m = new StringBuilder();
        for (int i = 0; i < letters; i++) {
            m.append(thousand);
        }
        return m;
    }
	
	/**
	 * Helper function to append whatever set of Roman numerals (customized or standard) the user has elected to use.
	 * @param digit String presentations of original Roman numerals to convert to local set of numerals
	 * @return StringBuilder appropriate representation of numerals with current settings
	 */
    private static StringBuilder calculateDigit(String digit) {
        StringBuilder numeral = new StringBuilder();
        for (int i = 0; i < digit.length(); i++) {
            if (digit.charAt(i) == 'D') {
                numeral.append(fiveHun);
            } else if (digit.charAt(i) == 'C') {
                numeral.append(hundred);
            } else if (digit.charAt(i) == 'L') {
                numeral.append(fifty);
            } else if (digit.charAt(i) == 'X') {
                numeral.append(ten);
            } else if (digit.charAt(i) == 'V') {
                numeral.append(five);
            } else if (digit.charAt(i) == 'I') {
                numeral.append(one);
            } if (digit.charAt(i) == 'M') {
                numeral.append(thousand);
            }
        }
        return numeral;
    }
}
