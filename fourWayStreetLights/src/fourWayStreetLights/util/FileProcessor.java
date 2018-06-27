package fourWayStreetLights.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fourWayStreetLights.entity.Vehicle;
import fourWayStreetLights.service.StreetLightsContext;
import fourWayStreetLights.util.Logger.DebugLevel;
/**
* FileProcessor program is responsible for reading input file line by line
*
* @author  Gaurang Dhake
* @version 1.0
* @since   06/27/18 
*/
public class FileProcessor {
	private String inputFilePath;
	private BufferedReader bReaderObj;
	private StreetLightsContext streetLightsContext;
	private InputProcessor inputProcessorObj;
	private DebugLevel debugLevel;
	
	/**
	   * This constructor assigns debugLevel, input file path, context object and creates object inputprocessor
	   * @param inputFilePath this parameter is passed from driver classes
	   * @param streetLightsContext assigns to local variable
	   */
	public FileProcessor(String inputFilePath, StreetLightsContext streetLightsContext) {
		this.debugLevel = DebugLevel.FILE_PROCESSOR;;
		Logger.writeMessage("entering fileprocessor constructor", debugLevel);
		this.inputFilePath = inputFilePath;
		this.streetLightsContext = streetLightsContext;	
		inputProcessorObj = new InputProcessor(streetLightsContext);
	}
	
	/**
	   * This is readLine method reads input file line by line
	   * @return None since return type is void
	   */
	public void readLine() {
		Logger.writeMessage("entering fileprocessor readline method", debugLevel);
		try{
			bReaderObj = new BufferedReader(new FileReader(inputFilePath));
		    String line;
		    int lineNo = 0;
		    while ((line = bReaderObj.readLine()) != null) {
		    	lineNo++;
		       String[] dataArray = line.split("-");
		       inputProcessorObj.parseLine(dataArray,lineNo);
		    }
		}
		catch(IOException  e) { //handling in case of bufferedReader goes wrong
			System.err.println("Exception: while reading input file");
			System.out.println("Exiting...");
			System.exit(0); 
		}
	}


}
