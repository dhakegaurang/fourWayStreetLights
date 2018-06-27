package fourWayStreetLights.service;
import fourWayStreetLights.entity.Vehicle;import fourWayStreetLights.util.Logger;import fourWayStreetLights.util.Logger.DebugLevel;import fourWayStreetLights.util.Results;

/**
 * @author Gaurang Dhake
 *
 */
public class EastRedState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;	private String myState;
	private DebugLevel debugLevel;	
	public EastRedState(StreetLightsContext streetLightsContext, Results resultObj) {		this.debugLevel = DebugLevel.EASTREDSTATE;		Logger.writeMessage("entering constructor in EastRedState", debugLevel);
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;		myState = "EastRedState";
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {		Logger.writeMessage("entering addVehicle in EastRedState", debugLevel);
		int iterations = vehicle.getNoOfVehicles();		for(int i=1;i<=iterations;i++) {			streetLightsContext.getVehicleQueue().add(vehicle);		}		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\n"+iterations+" cars arrived in "+vehicle.getDirection()+" direction");		toGreenCarPasses(vehicle.getDirection());
	}
	
	@Override
	public void moveVehicle(String direction) {		Logger.writeMessage("entering moveVehicle in EastRedState", debugLevel);		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\nCannot move vehicles since east signal is red");		streetLightsContext.trackAllVehicles();
	}
	
	@Override
	public void toGreenCarPasses(String direction) {		Logger.writeMessage("entering toGreenCarPasses in EastRedState", debugLevel);
		moveVehicle(direction);
	}
	
	@Override
	public void toRedCarStops(String direction) {		Logger.writeMessage("entering toRedCarStops in EastRedState", debugLevel);	
		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\nCannot move vehicles since east signal is red");		streetLightsContext.trackAllVehicles();
	}		public String getMyState() {		return myState;	}	public void setMyState(String myState) {		this.myState = myState;	}
	
}
