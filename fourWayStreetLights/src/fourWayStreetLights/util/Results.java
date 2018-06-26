package fourWayStreetLights.util;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private String resultStr;
	private String outputFilePath;
	
	public Results(String outputFilePath) {
		resultStr = "";
		this.outputFilePath = outputFilePath;
	}

	@Override
	public void writeToStdout(String s) {
		System.out.println(s);
		
	}

	@Override
	public void writeToFile(String s) {
		
		
	}
	
	public void storeNewResult(String newResult) {
		resultStr += newResult;
	}

	@Override
	public String toString() {
		return resultStr;
	}

	
	
}
