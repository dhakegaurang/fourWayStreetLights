package fourWayStreetLights.service;

import microwaveOven.service.Vehicle;

public interface MicrowaveStateI {
	// Adding the vehicle
	void addVehicle(Vehicle vehicle, int status);
	
	// Moving vehicle when green
	void moveVehicle(String vehicleNumber);
	
	// When signal becomes green, then before it turns red, two cars should go through
	void toGreenCarPasses();
	
	// After two car passes through green signal, then current signal becomes red and other signal becomes green
	void toRedCarStops();
	
}
