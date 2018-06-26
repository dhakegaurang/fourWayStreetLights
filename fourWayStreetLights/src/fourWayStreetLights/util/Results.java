package fourWayStreetLights.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private String resultStr;
	private String outputFilePath;
	
	public Results(String outputFilePath) {
		Logger.writeMessage("entering results constructor in results class", Logger.setDebugValue(2));
		resultStr = "";
		this.outputFilePath = outputFilePath;
	}

	@Override
	public void writeToStdout(String s) {
		
	}

	@Override
	public void writeToFile(String s) {
		Logger.writeMessage("entering writeToFile method in results class", Logger.setDebugValue(2));
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
