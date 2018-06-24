package fourWayStreetLights.driver;

import java.io.File;
import java.io.FileNotFoundException;

import fourWayStreetLights.service.MicrowaveContext;
import fourWayStreetLights.util.FileProcessor;
import fourWayStreetLights.util.Results;
import microwaveOven.service.Vehicle;

public class Driver {

	public static void main(String[] args) {
		
		String inputFilePath="input.txt";
		String outputFilePath = "output.txt";
		
		Results resultObj = new Results(outputFilePath);
		MicrowaveContext microContextobj = new MicrowaveContext(resultObj);
		FileProcessor fileProcessorObj = new FileProcessor(inputFilePath,microContextobj);
		fileProcessorObj.readLine();
		System.out.println(resultObj.toString());		
	}
	
}
