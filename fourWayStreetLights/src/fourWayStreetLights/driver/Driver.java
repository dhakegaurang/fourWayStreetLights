package fourWayStreetLights.driver;


import fourWayStreetLights.service.StreetLightsContext;
import fourWayStreetLights.util.FileProcessor;
import fourWayStreetLights.util.Results;

public class Driver {

	public static void main(String[] args) {
		
		String inputFilePath="input.txt";
		String outputFilePath = "output.txt";
		
		Results resultObj = new Results(outputFilePath);
		StreetLightsContext streetLightsContext = new StreetLightsContext(resultObj);
		FileProcessor fileProcessorObj = new FileProcessor(inputFilePath,streetLightsContext);
		fileProcessorObj.readLine();
		//System.out.println(resultObj.toString());
		resultObj.writeToFile(resultObj.getResultStr());
	}
	
}
