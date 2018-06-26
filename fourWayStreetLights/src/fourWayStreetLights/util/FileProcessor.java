package fourWayStreetLights.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fourWayStreetLights.entity.Vehicle;
import fourWayStreetLights.service.StreetLightsContext;


public class FileProcessor {
	private String inputFilePath;
	private BufferedReader bReaderObj;
	private StreetLightsContext streetLightsContext;
	
	public FileProcessor(String inputFilePath, StreetLightsContext streetLightsContext) {
		this.inputFilePath = inputFilePath;
		this.streetLightsContext = streetLightsContext;
	}
	
	public void readLine() {
		try{
			bReaderObj = new BufferedReader(new FileReader(inputFilePath));
		    String line;
		    int lineNo = 0;
		    while ((line = bReaderObj.readLine()) != null) {
		    	lineNo++;
		       String[] dataArray = line.split("-");
		       parseLine(dataArray,lineNo);       
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

	public void parseLine(String[] dataArray, int lineNo) {
		if(dataArray.length == 4) {
	    	   String type;
	    	   String carNumber;
	    	   String direction; 
	    	   String signal;
	    	   int iterations = -1;
	    	   if(dataArray[0] != null) {
	    		   type = dataArray[0];
	    	   }
	    	   else {
	    		   throw new IllegalArgumentException("Exception: missing type (vehicle/car) at line no: "+lineNo);
	    	   }
	    	   if(dataArray[3] != null) {
	    		   try {
	    			   iterations = Integer.parseInt(dataArray[3]);
	    			   if(iterations <= 0) {
	    				   throw new NumberFormatException();
	    			   }
	    		   }
	    		   catch(NumberFormatException e) {
	    			   System.err.println("Exception: parsing error at line no: "+lineNo);
	    		   }
	    	   }
	    	   else {
	    		   throw new IllegalArgumentException("Exception: missing status (0/1) at line no: "+lineNo);
	    	   }
	    	   
			   if(type.equals("vehicle")) {
				   
					   if(dataArray[1] != null) {
			    		   carNumber = dataArray[1];
			    	   }
			    	   else {
			    		   throw new IllegalArgumentException("Exception: missing car number at line no: "+lineNo);
			    	   }
			    	   if(dataArray[2] != null) {
			    		   direction = dataArray[2];
			    	   }
			    	   else {
			    		   throw new IllegalArgumentException("Exception: missing car direction at line no: "+lineNo);
			    	   }
			    	   streetLightsContext.addVehicle(new Vehicle(carNumber, direction,iterations));
				   
			   }
			   else if(dataArray[0].equals("signal")) {
				   if(dataArray[1] != null) {
		    		   direction = dataArray[1];
		    	   }
		    	   else {
		    		   throw new IllegalArgumentException("Exception: missing car direction at line no: "+lineNo);
		    	   }
				   if(dataArray[2] != null) {
		    		   signal = dataArray[2];
		    	   }
		    	   else {
		    		   throw new IllegalArgumentException("Exception: missing car direction at line no: "+lineNo);
		    	   }
				   switch(direction) {
 				   case "north":
 					   if(signal.equalsIgnoreCase("red")) {
 						   streetLightsContext.setCurrentState(streetLightsContext.getNorthRedState()); 
 						  streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   else {
 						   streetLightsContext.setCurrentState(streetLightsContext.getNorthGreenState());
 						   streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   
 					   break;
 				   case "east":
 					   if(signal.equalsIgnoreCase("red")) {
 						   streetLightsContext.setCurrentState(streetLightsContext.getEastRedState()); 
 						  streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   else {
 						   streetLightsContext.setCurrentState(streetLightsContext.getEastGreenState());
 						   streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   break;
 				   case "south":
 					   if(signal.equalsIgnoreCase("red")) {
 						   streetLightsContext.setCurrentState(streetLightsContext.getSouthRedState()); 
 						  streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   else {
 						   streetLightsContext.setCurrentState(streetLightsContext.getSouthGreenState());
 						   streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   break;
 				   case "west":
 					   if(signal.equalsIgnoreCase("red")) {
 						   streetLightsContext.setCurrentState(streetLightsContext.getWestRedState()); 
 						  streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   else {
 						   streetLightsContext.setCurrentState(streetLightsContext.getWestGreenState());
 						   streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   break;
					   default: throw new IllegalArgumentException("Exception: invalid direction at line no: "+lineNo);
					   
				   }
			   }
	       }
	       else {
	    	   throw new IllegalArgumentException("Exception: incorrect input format at line no: "+lineNo);
	       }
		
	}

}
