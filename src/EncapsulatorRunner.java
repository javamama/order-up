import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * A runner class for the Encapsulation class and its subclasses. 
 * @author Koushik Krishnan
 *
 */
public class EncapsulatorRunner {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String delim = " ";
		String input = br.readLine();
		String[] inputArray = input.split(delim);
		if(inputArray[0].equals("shortest_encapsulator"))
			System.out.println(Encapsulator.encapsulate(Arrays.copyOfRange(inputArray, 1, inputArray.length)));
		else System.out.println(ReOrderEncapsulator.encapsulate(Arrays.copyOfRange(inputArray, 1, inputArray.length)));
	}
	
}
