/** Class that determines whether or not a year is a leap year.
 *  @author nicolexxcc
 */
public class LeapYear {
	public static boolean isLeapYear(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 4 != 0)) {
			return true;
		}
		return false;
	}

    public static void main(String[] args) {
    	int year = 1203;
    	if (isLeapYear(year) == true) {
    		System.out.println(year + " is a leap year.");
    	}
    	else {
    		System.out.println(year + " is not a leap year.");
    	}
    	
    }
}

