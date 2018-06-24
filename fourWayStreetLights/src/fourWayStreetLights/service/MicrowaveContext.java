package fourWayStreetLights.service;

import java.util.LinkedList;
import java.util.Queue;

import fourWayStreetLights.util.Results;
import microwaveOven.service.NorthRedState;
import microwaveOven.service.NorthGreenState;
import microwaveOven.service.Vehicle;

public class MicrowaveContext implements MicrowaveStateI{
	
	private MicrowaveStateI currentState;
	private Queue<Vehicle> vehicleQueue;
	private MicrowaveStateI NorthRedState, NorthGreenState/*, SouthRedState, SouthGreenState, WestRedState, WestGreenState, EastGreenState, EastRedState*/;
	private Results resultObj;
	
	public MicrowaveContext(Results resultObj) {
		this.resultObj = resultObj;
		vehicleQueue = new LinkedList<>();
		NorthRedState = new NorthRedState(this,resultObj);
		NorthGreenState = new NorthGreenState(this,resultObj);
/*		SouthRedState = new SouthRedState(this);
		SouthGreenState = new SouthGreenState(this);
		WestRedState = new WestRedState(this);
		WestGreenState = new WestGreenState(this);
		EastGreenState = new EastGreenState(this);
		EastRedState = new EastRedState(this);*/
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
	public void addVehicle(Vehicle vehicle, int status) {
		if(status == 0) {
			vehicleQueue.add(vehicle);
			resultObj.storeNewResult(vehicle.getVehicleNumber()+" arrived in "+vehicle.getDirection()+" direction !!");
		}
		else if(status == 1) {
			currentState.addVehicle(vehicle, status);
		}
		
	}
	
	@Override
	public void moveVehicle(String direction) {
		/*for(Car car : carQueue) {
			if(car.getCarNumber().equals(vehicleNumber)) {
				carQueue.remove(car);
				System.out.println(car.getCarNumber()+" has passed the "+car.getDirection()+" signal!!");
			}
		}*/ 
	}	
	
	public MicrowaveStateI getCurrentState() {
		return currentState;
	}

	public void setCurrentState(MicrowaveStateI currentState) {
		this.currentState = currentState;
	}

	public Queue<Vehicle> getVehicleQueue() {
		return vehicleQueue;
	}


	public void setVehicleQueue(Queue<Vehicle> vehicleQueue) {
		this.vehicleQueue = vehicleQueue;
	}


	public MicrowaveStateI getNorthRedState() {
		return NorthRedState;
	}

	public void setNorthRedState(MicrowaveStateI northRedState) {
		NorthRedState = northRedState;
	}

	public MicrowaveStateI getNorthGreenState() {
		return NorthGreenState;
	}

	public void setNorthGreenState(MicrowaveStateI northGreenState) {
		NorthGreenState = northGreenState;
	}
	
}
