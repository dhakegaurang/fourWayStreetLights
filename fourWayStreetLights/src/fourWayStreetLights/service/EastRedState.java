package fourWayStreetLights.service;
import fourWayStreetLights.entity.Vehicle;import fourWayStreetLights.util.Results;

/**
 * @author Gaurang Dhake
 *
 */
public class EastRedState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;	private String myState;
	
	public EastRedState(StreetLightsContext streetLightsContext, Results resultObj) {
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;		myState = "EastRedState";
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {
		int iterations = vehicle.getNoOfVehicles();		for(int i=1;i<=iterations;i++) {			streetLightsContext.getVehicleQueue().add(vehicle);		}		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\n"+iterations+" cars arrived in "+vehicle.getDirection()+" direction");		toGreenCarPasses(vehicle.getDirection());
	}
	
	@Override
	public void moveVehicle(String direction) {		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\nCannot move vehicles since east signal is red");		streetLightsContext.trackAllVehicles();
	}
	
	@Override
	public void toGreenCarPasses(String direction) {
		moveVehicle(direction);
	}
	
	@Override
	public void toRedCarStops(String direction) {
		resultObj.storeNewResult("\nState of machine: "+myState);		streetLightsContext.trackAllVehicles();
	}		public String getMyState() {		return myState;	}	public void setMyState(String myState) {		this.myState = myState;	}
	
}
