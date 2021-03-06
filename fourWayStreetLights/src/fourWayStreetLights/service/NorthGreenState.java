package fourWayStreetLights.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import fourWayStreetLights.entity.Vehicle;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Logger.DebugLevel;
import fourWayStreetLights.util.Results;

/**
* NorthGreenState program helps to move all moving vehicles from north directions
*
* @author  Gaurang Dhake
* @version 1.0
* @since   06/27/18
*/
public class NorthGreenState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;
	private String myState;
	private DebugLevel debugLevel;
	
	/**
	   * This is constructor is responsible for initializing debugLevel, local result reference and streetLightsContext object
	   * @param resultObj this resultObj is assigned to local resultObj reference
	   */
	public NorthGreenState(StreetLightsContext streetLightsContext, Results resultObj) {
		this.debugLevel = DebugLevel.NORTHGREENSTATE;
		Logger.writeMessage("entering NorthGreenState constructor", debugLevel);	
		this.streetLightsContext = streetLightsContext;	
		this.resultObj = resultObj;
		myState = "NorthGreenState";
	}
	
	/**
	   * This is addVehicle method is responsible for adding vehicles coming from any direction
	   * @param vehicle vehicle object to be entered in queue waiting to be passed through green signal
	   * @return None since return type is void
	   */
	@Override
	public void addVehicle(Vehicle vehicle) {
		Logger.writeMessage("entering addVehicle in NorthGreenState class", debugLevel);	
		int iterations = vehicle.getNoOfVehicles();
		for(int i=1;i<=iterations;i++) {
			streetLightsContext.getVehicleQueue().add(vehicle);
		}
		resultObj.storeNewResult("\nState of machine: "+myState);
		resultObj.storeNewResult("\n"+iterations+" car(s) arrived in "+vehicle.getDirection()+" direction");
		toGreenCarPasses(vehicle.getDirection());
		//resultObj.storeNewResult("\n-------------------------------------------");
	}

	/**
	   * This is moveVehicle method is responsible for adding vehicles coming from any direction
	   * @param direction this parameter specifies direction from which vehicle is coming
	   * @return None since return type is void
	   */
	@Override
	public void moveVehicle(String direction) {
		Logger.writeMessage("entering moveVehicle in NorthGreenState class", debugLevel);	
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

	/**
	   * This is toGreenCarPasses method is tries to pass all the vehicles through signal if it is green
	   * @param direction this parameter specifies direction from which vehicle is coming
	   * @return None since return type is void
	   */
	@Override
	public void toGreenCarPasses(String direction) {
		Logger.writeMessage("entering toGreenCarPasses in NorthGreenState class", debugLevel);		
		moveVehicle(direction);
	}

	/**
	   * This is toRedCarStops method is tries to stop all the vehicles through signal if it is red
	   * @param direction this parameter specifies direction from which vehicle is coming
	   * @return None since return type is void
	   */
	@Override
	public void toRedCarStops(String direction) {
		Logger.writeMessage("entering toRedCarStops in NorthGreenState class", debugLevel);
		moveVehicle(direction);
	}

	public String getMyState() {
		return myState;
	}

	public void setMyState(String myState) {
		this.myState = myState;
	}
	
}
