package fourWayStreetLights.driver;

import java.io.File;
import java.io.FileNotFoundException;

import fourWayStreetLights.service.MicrowaveContext;
import fourWayStreetLights.util.FileProcessor;
import microwaveOven.service.Vehicle;

public class Driver {

	public static void main(String[] args) {
		
		String inputFilePath="input.txt";
		String outputFilePath = "output.txt";
		
		MicrowaveContext microContextobj = new MicrowaveContext();
		FileProcessor fileProcessorObj = new FileProcessor(inputFilePath,microContextobj);
		fileProcessorObj.readLine();

		for(Vehicle vehicle : microContextobj.getVehicleQueue()) {
			System.out.println(vehicle.getVehicleNumber()+" arrived in "+vehicle.getDirection()+" direction !!");
		}
	}

}
