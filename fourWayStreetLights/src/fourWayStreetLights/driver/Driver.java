package fourWayStreetLights.driver;

import java.io.File;
import java.io.FileNotFoundException;

import fourWayStreetLights.service.StreetLightsContext;
import fourWayStreetLights.util.FileProcessor;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Logger.DebugLevel;
import fourWayStreetLights.util.Results;

public class Driver {
	
	
	public static void main(String[] args) {
		DebugLevel debugLevel = null;
		try {
			// Check if there are exactly two arguments i.e input and output file paths
			if(args.length != 3) {
				throw new IllegalArgumentException("Exception: Two arguments are needed !!");
			}
			// Checking if file actually exists
			if(!new File(args[0]).exists()) {
				throw new FileNotFoundException("Exception: input file not found!!");
			}
			if(args[2] != null) {
				try {
					debugLevel = Logger.setDebugValue(Integer.parseInt(args[2]));
				}	
				catch(NumberFormatException e) {
					System.err.println("Exception: Please enter only integers(between 1-10) as third argument!!");
					System.out.println("Exiting...");
					System.exit(0);
				}
			}
			String inputFilePath = args[0];
			String outputFilePath = args[1];
			Results resultObj = new Results(outputFilePath);
			StreetLightsContext streetLightsContext = new StreetLightsContext(resultObj);
			FileProcessor fileProcessorObj = new FileProcessor(inputFilePath,streetLightsContext);
			fileProcessorObj.readLine();
			resultObj.writeToFile(resultObj.getResultStr());
		}

		catch(NumberFormatException e) { // if incorrect input file path
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
		catch(Exception e) { // Any other exceptions
			System.err.println("Exception: "+e.getMessage());
			System.exit(0);
		}
	}
	
}
