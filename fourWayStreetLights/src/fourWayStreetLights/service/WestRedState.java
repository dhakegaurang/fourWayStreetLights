package fourWayStreetLights.service;
import fourWayStreetLights.entity.Vehicle;

/**
 * @author Gaurang Dhake
 *
 */
public class WestRedState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;
	
	public WestRedState(StreetLightsContext streetLightsContext, Results resultObj) {
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {
		int iterations = vehicle.getNoOfVehicles();
	}
	
	@Override
	public void moveVehicle(String direction) {
	}
	
	@Override
	public void toGreenCarPasses(String direction) {
		moveVehicle(direction);
	}
	
	@Override
	public void toRedCarStops(String direction) {
		resultObj.storeNewResult("\nState of machine: "+myState);
	}
	
}