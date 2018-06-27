package fourWayStreetLights.entity;
/**
* Vehicle program helps to set car name and direction in which car has arrived
*
* @author  Gaurang Dhake
* @version 1.0
* @since   06/27/18
*/
public class Vehicle {
	private String vehicleNumber;
	private String direction;
	private int noOfVehicles;
	
	/**
	   * This is constructor is responsible for initializing debugLevel, local result reference and streetLightsContext object
	   * @param vehicleNumber stores the name of car if any
	   * @param direction states the direction in which car is coming from
	   * @param noOfVehicles 
	   */
	public Vehicle(String vehicleNumber, String direction, int noOfVehicles) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.direction = direction;
		this.noOfVehicles = noOfVehicles;
	}
	/*
	 * getters and setters for private members of the class
	 * */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public int getNoOfVehicles() {
		return noOfVehicles;
	}

	public void setNoOfVehicles(int noOfVehicles) {
		this.noOfVehicles = noOfVehicles;
	}

	@Override
	public String toString() {
		return "Vehicle [" + (vehicleNumber != null ? "vehicleNumber=" + vehicleNumber + ", " : "")
				+ (direction != null ? "direction=" + direction + ", " : "") + "noOfVehicles=" + noOfVehicles + "]";
	}
	
}
