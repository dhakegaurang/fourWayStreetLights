package fourWayStreetLights.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import fourWayStreetLights.util.Logger.DebugLevel;
/**
* Results program is responsible for storing results
*
* @author  Gaurang Dhake
* @version 1.0
* @since   06/27/18 
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private String resultStr;
	private String outputFilePath;
	private DebugLevel debugLevel;
	
	/**
	   * This constructor sets to local outputFilePath variable, initializes resultStr and sets debugLeve as well
	   * @param outputFilePath brings output file path from driver class
	   */
	public Results(String outputFilePath) {
		this.debugLevel = DebugLevel.RESULTS;
		Logger.writeMessage("entering results constructor in results class", debugLevel);
		resultStr = "";	
		this.outputFilePath = outputFilePath;
	}

	@Override
	public void writeToStdout(String s) {
		
	}
	
	/**
	   * This writeToFile method writes result to output file
	   * @param s this parameter stores all result strings
	   * @return None since return type is void
	   */
	@Override
	public void writeToFile(String s) {
		Logger.writeMessage("entering writeToFile method in results class", debugLevel);
		try {
			Files.write(Paths.get(outputFilePath), s.getBytes());
		}
		catch(IOException e) {
			System.err.println("Exception: writing to output.txt");
			System.err.println("Exiting...");
			System.exit(0);
		}
			
	}
	/**
	   * This storeNewResult method keeps appending new result string in main string
	   * @param newResult this parameter brings new string result
	   * @return None since return type is void
	   */
	public void storeNewResult(String newResult) {
		resultStr += newResult;
	}

	@Override
	public String toString() {
		return resultStr;
	}

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	
	
}
