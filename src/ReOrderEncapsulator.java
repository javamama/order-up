import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Main purpose of this class is to perform an encapsulation of an array of Strings. However, this class
 * will find the shortest, reorderable encapsulations. Therefore, the order of the Strings in the array
 * do not matter because this class's encapsulate method will always find the shortest reorderable
 * encapsulation. This is done by calling Encapsulator.encapsulate() on all permutations of the inputed
 * array. As a result, this class includes various utility methods for creating those permutations.
 *   
 * @author Koushik Krishnan
 *
 */
public class ReOrderEncapsulator extends Encapsulator{
	
	/**
	 * A String used to output the permutations. All permutations are concatenated to this
	 * String then returned at the end. 
	 */
	private static String output = "";
	
	/**
	 * Calls the permute(String[], String[]) method by making the first array
	 * an empty array and having the second array be the given array of Strings.
	 * 
	 * @param arrayToBePermuted the array whose permutations need to be generated
	 * @return A String representation of all permutations separated by new lines/
	 * Each element of a permutation is separated by an underscore
	 */
	public static String getPermutations(String[] input){
		String[] emptyArray = {};
		return permute(emptyArray,input);
	}
	
	/**
	 * Finds all permutations of an array of Strings. All permutations are stored in 
	 * a String then returned at the end. Method works by creating subarrays of n-1 then
	 * permuting those arrays.
	 * 
	 * @param startArray method begins with this array being empty and ends when it is of size n-1
	 * @param endArray method beings with this as the array to be permuted.
	 * At the end, this will only have one element.
	 */
	public static String permute(String[] startArray, String[] endArray){
		if(endArray.length <= 1)
			output += print(startArray, endArray) + "---";
		else{
			for(int i = 0; i < endArray.length; i++){
				String[] part1 = Arrays.copyOfRange(endArray, 0, i);
				String[] part2 = Arrays.copyOfRange(endArray, i+1, endArray.length);
				String[] newArray = merge(part1,part2);
				String[] theSingleOne = {endArray[i]};
				permute( merge(startArray,theSingleOne), newArray);
			}
		}
		return output;
	}
	
	/**
	 * Method merges two arrays of Strings then converts the the merged array into a String
	 * with each element separated by an underscore.
	 * 
	 * @param array1 first array to be added
	 * @param array2 second array to be added
	 * @return a String representation of the merged array with underscores separating each element
	 */
	private static String print(String[] array1, String[] array2){
		String[] newArray = merge(array1,array2);
		String output = "";
		for(int i = 0; i < newArray.length; i++){
			output += newArray[i];
			if(i != newArray.length -1)
				output += " ";
		}

		return output;
	}
	
	/**
	 * Combines two arrays of Strings into one array. The new array will have size
	 * array1.length + array2.length.
	 * 
	 * @param array1 first array to be added
	 * @param array2 second array to be added
	 * @return an array of Strings whose elements will begin with those from array1
	 * and end with those from array2
	 */
	private static String[] merge(String[] array1, String[] array2){
		String[] newArray = new String[array1.length + array2.length];
		int newArrayCounter = 0;
		for(int i = 0; i < array1.length; i++){
			newArray[newArrayCounter] = array1[i];
			newArrayCounter++;
		}
		for(int i = 0; i < array2.length; i++){
			newArray[newArrayCounter] = array2[i];
			newArrayCounter++;
		}
		return newArray;
	}
	
	/**
	 * Method will find the shortest reorderable encapsulation of an array of Strings.
	 * For example: aabb and bbcc will be encapsulated to abbcc,
	 * 		        abcedff and dfftty will encapsulate to abcdfftty.
	 * The method will find all permutations of input, and call Encapsulator.encapsulate() 
	 * on each permutation. The shortest encapsulation is then returned.
	 * 
	 * @param input array of Strings to be encapsulated
	 * @return shortest reorderable encapsulation of input[]
	 */
	public static String encapsulate(String[] input){
		String permutations = getPermutations(input);
		//System.out.println(permutations);
		String delim = "---";
		StringTokenizer st = new StringTokenizer(permutations, delim);
		String shortestString = null;
		
		while(st.hasMoreTokens()){
			String token = st.nextToken();
			String[] elements = token.split(" ");
			String encapsulated = Encapsulator.encapsulate(elements);
			if(shortestString == null || (encapsulated.length() < shortestString.length() && !encapsulated.equals("0")))
				shortestString = encapsulated;
		}
		return shortestString;
	}
	
}
