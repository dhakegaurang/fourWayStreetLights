package fourWayStreetLights.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fourWayStreetLights.service.MicrowaveContext;
import microwaveOven.service.Vehicle;

public class FileProcessor {
	private String inputFilePath;
	private BufferedReader bReaderObj;
	private MicrowaveContext microContextobj;
	
	public FileProcessor(String inputFilePath, MicrowaveContext microContextobj) {
		this.inputFilePath = inputFilePath;
		this.microContextobj = microContextobj;
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
	    	   int status = -1;
	    	   if(dataArray[0] != null) {
	    		   type = dataArray[0];
	    	   }
	    	   else {
	    		   throw new IllegalArgumentException("Exception: missing type (vehicle/car) at line no: "+lineNo);
	    	   }
	    	   if(dataArray[3] != null) {
	    		   try {
	    			   status = Integer.parseInt(dataArray[3]);
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
			    	   microContextobj.addVehicle(new Vehicle(carNumber, direction), status);
				   
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
 						   microContextobj.setCurrentState(microContextobj.getNorthRedState()); 
 						   microContextobj.toRedCarStops();
 					   }
 					   else {
 						   microContextobj.setCurrentState(microContextobj.getNorthGreenState());
 						   microContextobj.toGreenCarPasses();
 					   }
 					   
 					   break;
 				   /*case "east":
 					   if(signal.equalsIgnoreCase("red")) {
 						   microContextobj.setCurrentState(microContextobj.getEastRedState()); 
 						  microContextobj.toRedCarStops();
 					   }
 					   else {
 						   microContextobj.setCurrentState(microContextobj.getEastGreenState());
 						   microContextobj.toGreenCarPasses();
 					   }
 					   break;
 				   case "south":
 					   if(signal.equalsIgnoreCase("red")) {
 						   microContextobj.setCurrentState(microContextobj.getSouthRedState()); 
 						  microContextobj.toRedCarStops();
 					   }
 					   else {
 						   microContextobj.setCurrentState(microContextobj.getSouthGreenState());
 						   microContextobj.toGreenCarPasses();
 					   }
 					   break;
 				   case "west":
 					   if(signal.equalsIgnoreCase("red")) {
 						   microContextobj.setCurrentState(microContextobj.getWestRedState()); 
 						  microContextobj.toRedCarStops();
 					   }
 					   else {
 						   microContextobj.setCurrentState(microContextobj.getWestGreenState());
 						   microContextobj.toGreenCarPasses();
 					   }
 					   break;*/
					   default: throw new IllegalArgumentException("Exception: invalid direction at line no: "+lineNo);
					   
				   }
			   }
	       }
	       else {
	    	   throw new IllegalArgumentException("Exception: incorrect input format at line no: "+lineNo);
	       }
		
	}

}
