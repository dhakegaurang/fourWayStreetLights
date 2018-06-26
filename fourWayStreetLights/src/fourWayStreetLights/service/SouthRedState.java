package fourWayStreetLights.service;
import fourWayStreetLights.entity.Vehicle;import fourWayStreetLights.util.Logger;import fourWayStreetLights.util.Results;

/**
 * @author Gaurang Dhake
 *
 */
public class SouthRedState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;	private String myState;
	
	public SouthRedState(StreetLightsContext streetLightsContext, Results resultObj) {		Logger.writeMessage("entering SouthRedState constructor", Logger.setDebugValue(8));
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;		myState = "SouthRedState";
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {		Logger.writeMessage("entering addVehicle in SouthRedState", Logger.setDebugValue(8));
		int iterations = vehicle.getNoOfVehicles();		for(int i=1;i<=iterations;i++) {			streetLightsContext.getVehicleQueue().add(vehicle);		}		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\n"+iterations+" cars arrived in "+vehicle.getDirection()+" direction");		toGreenCarPasses(vehicle.getDirection());
	}
	
	@Override
	public void moveVehicle(String direction) {		Logger.writeMessage("entering moveVehicle in SouthRedState", Logger.setDebugValue(8));		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\nCannot move vehicles since south signal is red");		streetLightsContext.trackAllVehicles();
	}
	
	@Override
	public void toGreenCarPasses(String direction) {		Logger.writeMessage("entering toGreenCarPasses in SouthRedState", Logger.setDebugValue(8));
		moveVehicle(direction);
	}
	
	@Override
	public void toRedCarStops(String direction) {		Logger.writeMessage("entering toRedCarStops in SouthRedState", Logger.setDebugValue(8));
		resultObj.storeNewResult("\nState of machine: "+myState);		streetLightsContext.trackAllVehicles();
	}		public String getMyState() {		return myState;	}	public void setMyState(String myState) {		this.myState = myState;	}
	
}
