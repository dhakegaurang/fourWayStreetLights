package fourWayStreetLights.service;

import java.util.LinkedList;
import java.util.Queue;

import microwaveOven.service.Car;

public class MicrowaveContext implements MicrowaveStateI{
	
	private States currentState;
	private enum States{
		nothToAllRed, northToAllGreen, southToAllRed, southToAllGreen, eastToAllRed, eastToAllGreen, westToAllRed, westToAllGreen;
		
		public States getNext() {
		     return this.ordinal() < States.values().length - 1
		         ? States.values()[this.ordinal() + 1]
		         : null;
		}
	}
	private Queue<Car> carQueue = new LinkedList<>();
	
	@Override
	public void addVehicle(String vehicleNumber, String inDirection) {
		carQueue.add(new Car(vehicleNumber, inDirection));
		
	}
	
	@Override
	public void moveVehicle(String vehicleNumber) {
		for(Car car : carQueue) {
			if(car.getCarNumber().equals(vehicleNumber)) {
				carQueue.remove(car);
			}
		}
	}
	
	@Override
	public void twoCarPasses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void immediateTransitionFromGreenToRed() {
		// TODO Auto-generated method stub
		
	}

	public Queue<Car> getCarQueue() {
		return carQueue;
	}

	public void setCarQueue(Queue<Car> carQueue) {
		this.carQueue = carQueue;
	}

	public States getCurrentState() {
		return currentState;
	}

	public void setCurrentState(States currentState) {
		this.currentState = currentState;
	}
	
}
