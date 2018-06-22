package fourWayStreetLights.service;

public interface MicrowaveStateI {
	// Adding the vehicle
	void addVehicle(String vehicleNumber, String direction);
	
	// Moving vehicle when green
	void moveVehicle(String vehicleNumber);
	
	// When signal becomes green, then before it turns red, two cars should go through
	void twoCarPasses();
	
	// After two car passes through green signal, then current signal becomes red and other signal becomes green
	void immediateTransitionFromGreenToRed();
	
}
