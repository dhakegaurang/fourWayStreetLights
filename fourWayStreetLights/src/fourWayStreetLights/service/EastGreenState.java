package fourWayStreetLights.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import fourWayStreetLights.entity.Vehicle;
import fourWayStreetLights.util.Results;

/**
 * @author Gaurang Dhake
 *
 */
public class EastGreenState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;
	private String myState;
	
	public EastGreenState(StreetLightsContext streetLightsContext, Results resultObj) {
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;
		myState = "EastGreenState";
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {
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
		resultObj.storeNewResult("\n"+noOfVehicles+" car(s) has passed the East Green Signal");
		streetLightsContext.trackAllVehicles();
		
	}

	@Override
	public void toGreenCarPasses(String direction) {
		moveVehicle(direction);
	}

	@Override
	public void toRedCarStops(String direction) {
		
	}

	public String getMyState() {
		return myState;
	}

	public void setMyState(String myState) {
		this.myState = myState;
	}
	
}
