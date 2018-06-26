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
public class WestGreenState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;
	private String myState;
	
	public WestGreenState(StreetLightsContext streetLightsContext, Results resultObj) {
		Logger.writeMessage("entering WestGreenState constructor", Logger.setDebugValue(5));
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;
		myState = "WestGreenState";
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {
		Logger.writeMessage("entering addVehicle in WestGreenState", Logger.setDebugValue(5));
		int iterations = vehicle.getNoOfVehicles();
		for(int i=1;i<=iterations;i++) {
			streetLightsContext.getVehicleQueue().add(vehicle);
		}
		resultObj.storeNewResult("\nState of machine: "+myState);
		resultObj.storeNewResult("\n"+iterations+" car(s) arrived in "+vehicle.getDirection()+" direction");
		toGreenCarPasses(vehicle.getDirection());
	}

	@Override
	public void moveVehicle(String direction) {
		Logger.writeMessage("entering moveVehicle in WestGreenState", Logger.setDebugValue(5));
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
		resultObj.storeNewResult("\n"+noOfVehicles+" car(s) has passed the West Green Signal");
		streetLightsContext.trackAllVehicles();
		
	}

	@Override
	public void toGreenCarPasses(String direction) {
		Logger.writeMessage("entering toGreenCarPasses in WestGreenState", Logger.setDebugValue(5));
		moveVehicle(direction);
	}

	@Override
	public void toRedCarStops(String direction) {
		Logger.writeMessage("entering toRedCarStops in WestGreenState", Logger.setDebugValue(5));
		moveVehicle(direction);
	}

	public String getMyState() {
		return myState;
	}

	public void setMyState(String myState) {
		this.myState = myState;
	}
	
}
