package fourWayStreetLights.util;

import fourWayStreetLights.entity.Vehicle;
import fourWayStreetLights.service.StreetLightsContext;
/**
* InputProcessor program is responsible for parsing input line by line
*
* @author  Gaurang Dhake
* @version 1.0
* @since   06/27/18 
*/
public class InputProcessor {
	private StreetLightsContext streetLightsContext;
	
	/**
	   * This constructor sets to local streetLightsContext variable
	   * @param streetLightsContext brings streetLightsContext object from driver class
	   */
	public InputProcessor(StreetLightsContext streetLightsContext) {
		this.streetLightsContext = streetLightsContext;
		
	}

	/**
	   * This is method helps in parsing the input read from readline method in fileProcessor
	   * @param vehicle This vehicle object is being added to queue in appropriate direction
	   * @return None Since return type is void
	   */
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
 						  streetLightsContext.toRedCarStops(direction);
 					   }
 					   else {
 						  streetLightsContext.setCurrentState(streetLightsContext.getNorthGreenState());
 						  streetLightsContext.toGreenCarPasses(direction);
 						   
 					   }
 					   
 					   break;
 				   case "east":
 					   if(signal.equalsIgnoreCase("red")) {
 						  streetLightsContext.setCurrentState(streetLightsContext.getEastRedState()); 
 						  streetLightsContext.toRedCarStops(direction);
 					   }
 					   else {
 						  streetLightsContext.setCurrentState(streetLightsContext.getEastGreenState());
 						  streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   break;
 				   case "south":
 					   if(signal.equalsIgnoreCase("red")) {
 						  streetLightsContext.setCurrentState(streetLightsContext.getSouthRedState()); 
 						  streetLightsContext.toRedCarStops(direction);
 					   }
 					   else {
 						  streetLightsContext.setCurrentState(streetLightsContext.getSouthGreenState());
 						  streetLightsContext.toGreenCarPasses(direction);
 					   }
 					   break;
 				   case "west":
 					   if(signal.equalsIgnoreCase("red")) {
 						  streetLightsContext.setCurrentState(streetLightsContext.getWestRedState()); 
 						  streetLightsContext.toRedCarStops(direction);
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
