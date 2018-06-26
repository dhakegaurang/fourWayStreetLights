package fourWayStreetLights.service;
import fourWayStreetLights.entity.Vehicle;import fourWayStreetLights.util.Logger;import fourWayStreetLights.util.Results;

/**
 * @author Gaurang Dhake
 *
 */
public class NorthRedState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;	private String myState;
	
	public NorthRedState(StreetLightsContext streetLightsContext, Results resultObj) {		Logger.writeMessage("entering constructor in NorthRedState class", Logger.setDebugValue(10));
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;		myState = "NorthRedState";
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {		Logger.writeMessage("entering addVehicle in NorthRedState class", Logger.setDebugValue(10));
		int iterations = vehicle.getNoOfVehicles();		for(int i=1;i<=iterations;i++) {			streetLightsContext.getVehicleQueue().add(vehicle);		}		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\n"+iterations+" car(s) arrived in "+vehicle.getDirection()+" direction");		toGreenCarPasses(vehicle.getDirection());
	}
	
	@Override
	public void moveVehicle(String direction) {		Logger.writeMessage("entering moveVehicle in NorthRedState class", Logger.setDebugValue(10));		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\nCannot move vehicles since north signal is red");		streetLightsContext.trackAllVehicles();
	}
	
	@Override
	public void toGreenCarPasses(String direction) {		Logger.writeMessage("entering toGreenCarPasses in NorthRedState class", Logger.setDebugValue(10));
		moveVehicle(direction);
	}
	
	@Override
	public void toRedCarStops(String direction) {		Logger.writeMessage("entering toRedCarStops in NorthRedState class", Logger.setDebugValue(10));
		resultObj.storeNewResult("\nState of machine: "+myState);		streetLightsContext.trackAllVehicles();
	}		public String getMyState() {		return myState;	}	public void setMyState(String myState) {		this.myState = myState;	}
	
}
