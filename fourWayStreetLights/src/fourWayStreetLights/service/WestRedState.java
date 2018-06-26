package fourWayStreetLights.service;
import fourWayStreetLights.entity.Vehicle;import fourWayStreetLights.util.Logger;import fourWayStreetLights.util.Results;

/**
 * @author Gaurang Dhake
 *
 */
public class WestRedState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;	private String myState;
	
	public WestRedState(StreetLightsContext streetLightsContext, Results resultObj) {		Logger.writeMessage("entering  WestRedState constructor", Logger.setDebugValue(6));
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;		myState = "WestRedState";
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {		Logger.writeMessage("entering  addVehicle in WestRedState", Logger.setDebugValue(6));
		int iterations = vehicle.getNoOfVehicles();		for(int i=1;i<=iterations;i++) {			streetLightsContext.getVehicleQueue().add(vehicle);		}		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\n"+iterations+" cars arrived in "+vehicle.getDirection()+" direction");		toGreenCarPasses(vehicle.getDirection());
	}
	
	@Override
	public void moveVehicle(String direction) {		Logger.writeMessage("entering in WestRedState", Logger.setDebugValue(6));		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\nCannot move vehicles since west signal is red");		streetLightsContext.trackAllVehicles();
	}
	
	@Override
	public void toGreenCarPasses(String direction) {		Logger.writeMessage("entering toGreenCarPasses in WestRedState", Logger.setDebugValue(6));
		moveVehicle(direction);
	}
	
	@Override
	public void toRedCarStops(String direction) {		Logger.writeMessage("entering toRedCarStops in WestRedState", Logger.setDebugValue(6));
		resultObj.storeNewResult("\nState of machine: "+myState);		streetLightsContext.trackAllVehicles();
	}		public String getMyState() {		return myState;	}	public void setMyState(String myState) {		this.myState = myState;	}
	
}
