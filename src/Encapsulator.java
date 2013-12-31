/**
 * Class is able to find encapsulations of a given set of independent Strings. The primary method of
 * this class is the encapsulate method which performs the encapsulation.
 * 
 * @author Koushik Krishnan
 *
 */
public class Encapsulator {
	/**
	 * Method will encapsulate an array of Strings into one String. For example:
	 * Strings aabb and bbcc will be encapsulated to abbcc 
	 * 		   abcedff and dfftty will encapsulate to abcdfftty
	 * If no possible encapsulation is found, the method returns the number 0 as a String. 
	 * Note: input.length must be >= 1
	 * @param input array of Strings to be encapsulated
	 * @return a String that encapsulates input or 0 if no encapsulation can be produced
	 */
	public static String encapsulate(String[] input){
		int counter = 1;
		String output = input[0];
		while(counter < input.length){
			output = encapsulate(output,input[counter]);
			if(output.equals("0"))
				return "0";
			counter++;
		}
		return output;
	}
	/**
	 * Method will merge two Strings based on the ending of the first String, and the beginning
	 * of the second String.
	 * For example: merge("begeg","geget") would return "beet".
	 * If two Strings cannot be merged (such as "bad" and "tag"), the method returns the number
	 * 0 as a String.
	 * @param beg the first String to merge
	 * @param end the second String to merge
	 * @return a merged String or 0 if no merged String can be produced
	 */
	private static String encapsulate(String beg, String end){
		int begCounter = 0;
		int endCounter = 0;
		boolean matchFound = false;
		int matchFoundIndex = -1;
		while(begCounter < beg.length() && endCounter < end.length()){
			if(matchFound && begCounter != beg.length() -1 && endCounter == end.length()-1){
				endCounter = 0;
				begCounter = matchFoundIndex +1;
				matchFoundIndex = -1;
				matchFound = false;
			}
			String begChar = "" + beg.charAt(begCounter);
			String endChar = "" + end.charAt(endCounter);
			if(begChar.equals(endChar)){
				matchFound = true;
				matchFoundIndex = begCounter;
				begCounter++;
				endCounter++;
			}
			else{
				if(matchFound){
					begCounter = matchFoundIndex+1;
					matchFoundIndex = -1;
					matchFound = false;
					endCounter = 0;
				}
				else{
					matchFound = false;
					begCounter++;
					endCounter = 0;
				}
				
			}
		}
		if(matchFound){
			return beg + end.substring(endCounter);
		}
		else return "0";
	}
}
