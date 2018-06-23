package fourWayStreetLights.service;

import java.util.LinkedList;
import java.util.Queue;

import microwaveOven.service.Car;
import microwaveOven.service.NorthRedState;
import microwaveOven.service.NorthGreenState;
import microwaveOven.service.SouthRedState;
import microwaveOven.service.SouthGreenState;
import microwaveOven.service.WestRedState;
import microwaveOven.service.WestGreenState;
import microwaveOven.service.EastGreenState;
import microwaveOven.service.EastRedState;

public class MicrowaveContext implements MicrowaveStateI{
	
	private MicrowaveStateI currentState;
	private Queue<Car> carQueue;
	private MicrowaveStateI NorthRedState, NorthGreenState, SouthRedState, SouthGreenState, WestRedState, WestGreenState, EastGreenState, EastRedState;
	
	public MicrowaveContext() {
		
		carQueue = new LinkedList<>();
		NorthRedState = new NorthRedState(this);
		NorthGreenState = new NorthGreenState(this);
		SouthRedState = new SouthRedState(this);
		SouthGreenState = new SouthGreenState(this);
		WestRedState = new WestRedState(this);
		WestGreenState = new WestGreenState(this);
		EastGreenState = new EastGreenState(this);
		EastRedState = new EastRedState(this);
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
	public void addVehicle(String vehicleNumber, String inDirection) {
		currentState.addVehicle(vehicleNumber, inDirection); 
	}
	
	@Override
	public void moveVehicle(String vehicleNumber) {
		currentState.moveVehicle(vehicleNumber); 
	}
	
	
	public MicrowaveStateI getCurrentState() {
		return currentState;
	}

	public void setCurrentState(MicrowaveStateI currentState) {
		this.currentState = currentState;
	}

	public Queue<Car> getCarQueue() {
		return carQueue;
	}

	public void setCarQueue(Queue<Car> carQueue) {
		this.carQueue = carQueue;
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

	public MicrowaveStateI getSouthRedState() {
		return SouthRedState;
	}

	public void setSouthRedState(MicrowaveStateI southRedState) {
		SouthRedState = southRedState;
	}

	public MicrowaveStateI getSouthGreenState() {
		return SouthGreenState;
	}

	public void setSouthGreenState(MicrowaveStateI southGreenState) {
		SouthGreenState = southGreenState;
	}

	public MicrowaveStateI getWestRedState() {
		return WestRedState;
	}

	public void setWestRedState(MicrowaveStateI westRedState) {
		WestRedState = westRedState;
	}

	public MicrowaveStateI getWestGreenState() {
		return WestGreenState;
	}

	public void setWestGreenState(MicrowaveStateI westGreenState) {
		WestGreenState = westGreenState;
	}

	public MicrowaveStateI getEastGreenState() {
		return EastGreenState;
	}

	public void setEastGreenState(MicrowaveStateI eastGreenState) {
		EastGreenState = eastGreenState;
	}

	public MicrowaveStateI getEastRedState() {
		return EastRedState;
	}

	public void setEastRedState(MicrowaveStateI eastRedState) {
		EastRedState = eastRedState;
	}
	
}
