package fourWayStreetLights.service;

import java.util.LinkedList;
import java.util.Queue;

import microwaveOven.service.NorthRedState;
import microwaveOven.service.NorthGreenState;
import microwaveOven.service.Vehicle;

public class MicrowaveContext implements MicrowaveStateI{
	
	private MicrowaveStateI currentState;
	private Queue<Vehicle> vehicleQueue;
	private MicrowaveStateI NorthRedState, NorthGreenState/*, SouthRedState, SouthGreenState, WestRedState, WestGreenState, EastGreenState, EastRedState*/;
	
	public MicrowaveContext() {
		
		vehicleQueue = new LinkedList<>();
		NorthRedState = new NorthRedState(this);
		NorthGreenState = new NorthGreenState(this);
/*		SouthRedState = new SouthRedState(this);
		SouthGreenState = new SouthGreenState(this);
		WestRedState = new WestRedState(this);
		WestGreenState = new WestGreenState(this);
		EastGreenState = new EastGreenState(this);
		EastRedState = new EastRedState(this);*/
		currentState = NorthRedState;
	}
	
	
	@Override
	public void toGreenCarPasses() {
		currentState.toGreenCarPasses();
	}

	@Override
	public void toRedCarStops() {
		currentState.toRedCarStops();		
	}

	
	@Override
	public void addVehicle(Vehicle vehicle, int status) {
		if(status == 0) {
			vehicleQueue.add(vehicle);
		}
		else if(status == 1) {
			currentState.addVehicle(vehicle, status);
		}
		
	}
	
	@Override
	public void moveVehicle(String vehicleNumber) {
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
