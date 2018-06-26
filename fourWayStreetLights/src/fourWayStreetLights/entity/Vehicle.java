package fourWayStreetLights.entity;

public class Vehicle {
	private String vehicleNumber;
	private String direction;
	private int noOfVehicles;
	
	public Vehicle(String vehicleNumber, String direction, int noOfVehicles) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.direction = direction;
		this.noOfVehicles = noOfVehicles;
	}

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
