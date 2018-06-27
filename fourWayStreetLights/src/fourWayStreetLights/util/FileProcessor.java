package fourWayStreetLights.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fourWayStreetLights.entity.Vehicle;
import fourWayStreetLights.service.StreetLightsContext;
import fourWayStreetLights.util.Logger.DebugLevel;


public class FileProcessor {
	private String inputFilePath;
	private BufferedReader bReaderObj;
	private StreetLightsContext streetLightsContext;
	private DebugLevel debugLevel;
	
	public FileProcessor(String inputFilePath, StreetLightsContext streetLightsContext) {
		this.debugLevel = DebugLevel.FILE_PROCESSOR;;
		Logger.writeMessage("entering fileprocessor constructor", debugLevel);
		this.inputFilePath = inputFilePath;
		this.streetLightsContext = streetLightsContext;	
	}
	
	public void readLine() {
		Logger.writeMessage("entering fileprocessor readline method", debugLevel);
		try{
			bReaderObj = new BufferedReader(new FileReader(inputFilePath));
		    String line;
		    int lineNo = 0;
		    while ((line = bReaderObj.readLine()) != null) {
		    	lineNo++;
		       String[] dataArray = line.split("-");
		       streetLightsContext.parseLine(dataArray,lineNo);  
		    }
		}
		catch(IOException  e) {
			System.err.println("Exception: while reading input file");
			System.out.println("Exiting...");
			System.exit(0); 
		}
		catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0); 
		}
	}


}
