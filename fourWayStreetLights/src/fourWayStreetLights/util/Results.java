package fourWayStreetLights.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import fourWayStreetLights.util.Logger.DebugLevel;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private String resultStr;
	private String outputFilePath;
	private DebugLevel debugLevel;
	
	public Results(String outputFilePath) {
		this.debugLevel = DebugLevel.RESULTS;
		Logger.writeMessage("entering results constructor in results class", debugLevel);
		resultStr = "";	
		this.outputFilePath = outputFilePath;
	}

	@Override
	public void writeToStdout(String s) {
		
	}

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
