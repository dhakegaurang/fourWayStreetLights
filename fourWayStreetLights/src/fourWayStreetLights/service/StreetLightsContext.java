package fourWayStreetLights.service;

import java.util.LinkedList;
import java.util.Queue;

import fourWayStreetLights.entity.Vehicle;
import fourWayStreetLights.util.Results;

public class StreetLightsContext implements StreetLightsStateI{
	
	private StreetLightsStateI currentState;
	private Queue<Vehicle> vehicleQueue;
	private StreetLightsStateI NorthRedState, NorthGreenState, SouthRedState, SouthGreenState, WestRedState, WestGreenState, EastGreenState, EastRedState;
	private Results resultObj;
	
	public StreetLightsContext(Results resultObj) {
		this.resultObj = resultObj;
		vehicleQueue = new LinkedList<>();
		NorthRedState = new NorthRedState(this,resultObj);
		NorthGreenState = new NorthGreenState(this,resultObj);
		SouthRedState = new SouthRedState(this,resultObj);
		SouthGreenState = new SouthGreenState(this,resultObj);
		WestRedState = new WestRedState(this,resultObj);
		WestGreenState = new WestGreenState(this,resultObj);
		EastGreenState = new EastGreenState(this,resultObj);
		EastRedState = new EastRedState(this,resultObj);
	}
	
	@Override
	public void toGreenCarPasses(String direction) {
		currentState.toGreenCarPasses(direction);
	}

	@Override
	public void toRedCarStops(String direction) {
		currentState.toRedCarStops(direction);
	}

	@Override
	public void addVehicle(Vehicle vehicle) {
		if(currentState == null) {
			int noOfVehicles = vehicle.getNoOfVehicles();
			for(int i=1;i<=noOfVehicles;i++) {
				vehicleQueue.add(vehicle);
			}
			resultObj.storeNewResult("\nState of machine: All signals are red");
			resultObj.storeNewResult("\n"+noOfVehicles+" car(s) arrived in "+vehicle.getDirection()+" direction");
			trackAllVehicles();
		}
		else {
			currentState.addVehicle(vehicle);
		}
	}
	
	@Override
	public void moveVehicle(String direction) {
		
	}	
	
	public void trackAllVehicles() {
		int northVehicles=0;
		int southVehicles = 0;
		int eastVehicles = 0;
		int westVehicles = 0;
		for(Vehicle currentVehicle : vehicleQueue) {
			switch(currentVehicle.getDirection()) {
			case "north":northVehicles++;
				break;
			case "south":southVehicles++;
				break;
			case "east":eastVehicles++;
				break;
			case "west":westVehicles++;
				break;
			}
		}
		resultObj.storeNewResult("\n\nNorth has "+northVehicles+" vehicles");
		resultObj.storeNewResult("\nSouth has "+southVehicles+" vehicles");
		resultObj.storeNewResult("\nEast has "+eastVehicles+" vehicles");
		resultObj.storeNewResult("\nWest has "+westVehicles+" vehicles");
		resultObj.storeNewResult("\n-------------------------------------------");
	}
	
	public StreetLightsStateI getCurrentState() {
		return currentState;
	}

	public void setCurrentState(StreetLightsStateI currentState) {
		this.currentState = currentState;
	}

	public Queue<Vehicle> getVehicleQueue() {
		return vehicleQueue;
	}


	public void setVehicleQueue(Queue<Vehicle> vehicleQueue) {
		this.vehicleQueue = vehicleQueue;
	}


	public StreetLightsStateI getNorthRedState() {
		return NorthRedState;
	}
	
	public void setNorthRedState(StreetLightsStateI northRedState) {
		NorthRedState = northRedState;
	}

	public StreetLightsStateI getNorthGreenState() {
		return NorthGreenState;
	}

	public void setNorthGreenState(StreetLightsStateI northGreenState) {
		NorthGreenState = northGreenState;
	}

	public StreetLightsStateI getSouthRedState() {
		return SouthRedState;
	}

	public void setSouthRedState(StreetLightsStateI southRedState) {
		SouthRedState = southRedState;
	}

	public StreetLightsStateI getSouthGreenState() {
		return SouthGreenState;
	}

	public void setSouthGreenState(StreetLightsStateI southGreenState) {
		SouthGreenState = southGreenState;
	}

	public StreetLightsStateI getWestRedState() {
		return WestRedState;
	}

	public void setWestRedState(StreetLightsStateI westRedState) {
		WestRedState = westRedState;
	}

	public StreetLightsStateI getWestGreenState() {
		return WestGreenState;
	}

	public void setWestGreenState(StreetLightsStateI westGreenState) {
		WestGreenState = westGreenState;
	}

	public StreetLightsStateI getEastGreenState() {
		return EastGreenState;
	}

	public void setEastGreenState(StreetLightsStateI eastGreenState) {
		EastGreenState = eastGreenState;
	}

	public StreetLightsStateI getEastRedState() {
		return EastRedState;
	}

	public void setEastRedState(StreetLightsStateI eastRedState) {
		EastRedState = eastRedState;
	}
	
}
