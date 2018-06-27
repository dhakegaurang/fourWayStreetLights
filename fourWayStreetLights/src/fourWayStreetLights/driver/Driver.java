package fourWayStreetLights.driver;

import java.io.File;
import java.io.FileNotFoundException;

import fourWayStreetLights.service.StreetLightsContext;
import fourWayStreetLights.util.FileProcessor;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Logger.DebugLevel;
import fourWayStreetLights.util.Results;
/**
* Driver program creates instances of fileProcessor,streetLightsContext, Results and prints output
*
* @author  Gaurang Dhake
* @version 1.0
* @since   06/27/18 
*/
public class Driver {
	/**
	   * This is main method which verifies cmd parameters and responsible for creating instances and calling respective methods
	   * @param args this parameter stores all cmd parameters
	   * @return None since return type is void
	   */
	public static void main(String[] args) {
		DebugLevel debugLevel = null;
		
		try {
			// Check if there are exactly three arguments i.e input and output file paths and debugLevel
			if(args.length != 3) {
				throw new IllegalArgumentException("Exception: Two arguments are needed !!");
			}
			// Checking if input file actually exists
			if(!new File(args[0]).exists()) {
				throw new FileNotFoundException("Exception: input file not found!!");
			}
			// Checks third parameters exists and if it does, then checks if it is integer or not
			if(args[2] != null) {
				try {
					debugLevel = Logger.setDebugValue(Integer.parseInt(args[2]));
				}	
				catch(NumberFormatException e) {// if debugLevel is non-integer
					System.err.println("Exception: Please enter only integers(between 1-10) as third argument!!");
					System.out.println("Exiting...");
					System.exit(0);
				}
			}
			// assigns first cmd parameter of local variable
			String inputFilePath = args[0];
			
			// assigns second cmd parameter of local variable
			String outputFilePath = args[1];
			
			// creating result instance and passes output file path for initializing
			Results resultObj = new Results(outputFilePath);
			
			// creating context object and passes result object for storing any result if necessary
			StreetLightsContext streetLightsContext = new StreetLightsContext(resultObj);
			
			// creating FileProcessor object and passes input file path and context object for initialization
			FileProcessor fileProcessorObj = new FileProcessor(inputFilePath,streetLightsContext);
			
			// calling readLine() method for reading input file line by line
			fileProcessorObj.readLine();
			
			//Finally, writing result string to output file
			resultObj.writeToFile(resultObj.getResultStr());
		}

		catch(NumberFormatException e) { // if debugLevel is non-integer
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);
		}
		catch(IllegalArgumentException e) { // catching in case of incorrect number of arguments
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);
		}
		catch(FileNotFoundException e) { // if incorrect input file path
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);
		}
		catch(Exception e) { // For any other exceptions to be caught
			System.err.println("Exception: "+e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);
		}
	}
	
}
