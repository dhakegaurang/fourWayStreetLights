package fourWayStreetLights.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import fourWayStreetLights.entity.Vehicle;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Results;

/**
 * @author Gaurang Dhake
 *
 */
public class NorthGreenState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;
	private String myState;
	
	public NorthGreenState(StreetLightsContext streetLightsContext, Results resultObj) {
		Logger.writeMessage("entering NorthGreenState constructor", Logger.setDebugValue(9));	
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;
		myState = "NorthGreenState";
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {
		Logger.writeMessage("entering addVehicle in NorthGreenState class", Logger.setDebugValue(9));	
		int iterations = vehicle.getNoOfVehicles();
		for(int i=1;i<=iterations;i++) {
			streetLightsContext.getVehicleQueue().add(vehicle);
		}
		resultObj.storeNewResult("\nState of machine: "+myState);
		resultObj.storeNewResult("\n"+iterations+" car(s) arrived in "+vehicle.getDirection()+" direction");
		toGreenCarPasses(vehicle.getDirection());
		//resultObj.storeNewResult("\n-------------------------------------------");
	}

	@Override
	public void moveVehicle(String direction) {
		Logger.writeMessage("entering moveVehicle in NorthGreenState class", Logger.setDebugValue(9));	
		//Queue<Vehicle> vehicleQueue = streetLightsContext.getVehicleQueue();
		Iterator<Vehicle> vehicleQueueIterator = streetLightsContext.getVehicleQueue().iterator();
		Queue<Vehicle> vehicleQueueAdd = new LinkedList<>();
		int noOfVehicles = 0;
		resultObj.storeNewResult("\nState of machine: "+myState);
		while(vehicleQueueIterator.hasNext()) {
			Vehicle vehicle = vehicleQueueIterator.next();
			if(vehicle.getDirection().equals(direction) && noOfVehicles < 2) {
				//vehicleQueueAdd.add(vehicle);
				vehicleQueueIterator.remove();
				noOfVehicles++;
			}
		}	
		
		if(noOfVehicles <= 0) {
			resultObj.storeNewResult("\nNo cars are waiting in the north direction");
		}
		else {
			resultObj.storeNewResult("\n"+noOfVehicles+" car(s) has passed the North Green Signal");
		}
		streetLightsContext.trackAllVehicles();
		
	}

	@Override
	public void toGreenCarPasses(String direction) {
		Logger.writeMessage("entering toGreenCarPasses in NorthGreenState class", Logger.setDebugValue(9));		
		moveVehicle(direction);
	}

	@Override
	public void toRedCarStops(String direction) {
		Logger.writeMessage("entering toRedCarStops in NorthGreenState class", Logger.setDebugValue(9));
		moveVehicle(direction);
	}

	public String getMyState() {
		return myState;
	}

	public void setMyState(String myState) {
		this.myState = myState;
	}
	
}
