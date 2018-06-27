package fourWayStreetLights.service;
import fourWayStreetLights.entity.Vehicle;import fourWayStreetLights.util.Logger;import fourWayStreetLights.util.Logger.DebugLevel;import fourWayStreetLights.util.Results;

/*** EastRedState program helps to stop all moving vehicles from north directions** @author  Gaurang Dhake* @version 1.0* @since   06/27/18*/
public class EastRedState implements StreetLightsStateI{
	private StreetLightsContext streetLightsContext;
	private Results resultObj;	private String myState;
	private DebugLevel debugLevel;		/**	   * This is constructor is responsible for initializing debugLevel, local result reference and streetLightsContext object	   * @param resultObj this resultObj is assigned to local resultObj reference	   */
	public EastRedState(StreetLightsContext streetLightsContext, Results resultObj) {		this.debugLevel = DebugLevel.EASTREDSTATE;		Logger.writeMessage("entering constructor in EastRedState", debugLevel);
		this.streetLightsContext = streetLightsContext;
		this.resultObj = resultObj;		myState = "EastRedState";
	}
		/**	   * This is addVehicle method is responsible for adding vehicles coming from any direction	   * @param vehicle vehicle object to be entered in queue waiting to be passed through green signal	   * @return None since return type is void	   */
	@Override
	public void addVehicle(Vehicle vehicle) {		Logger.writeMessage("entering addVehicle in EastRedState", debugLevel);
		int iterations = vehicle.getNoOfVehicles();		for(int i=1;i<=iterations;i++) {			streetLightsContext.getVehicleQueue().add(vehicle);		}		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\n"+iterations+" cars arrived in "+vehicle.getDirection()+" direction");		toGreenCarPasses(vehicle.getDirection());
	}
		/**	   * This is moveVehicle method is responsible for adding vehicles coming from any direction	   * @param direction this parameter specifies direction from which vehicle is coming	   * @return None since return type is void	   */
	@Override
	public void moveVehicle(String direction) {		Logger.writeMessage("entering moveVehicle in EastRedState", debugLevel);		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\nCannot move vehicles since east signal is red");		streetLightsContext.trackAllVehicles();
	}
		/**	   * This is toGreenCarPasses method is tries to pass all the vehicles through signal if it is green	   * @param direction this parameter specifies direction from which vehicle is coming	   * @return None since return type is void	   */
	@Override
	public void toGreenCarPasses(String direction) {		Logger.writeMessage("entering toGreenCarPasses in EastRedState", debugLevel);
		moveVehicle(direction);
	}
		/**	   * This is toRedCarStops method is tries to stop all the vehicles through signal if it is red	   * @param direction this parameter specifies direction from which vehicle is coming	   * @return None since return type is void	   */
	@Override
	public void toRedCarStops(String direction) {		Logger.writeMessage("entering toRedCarStops in EastRedState", debugLevel);	
		resultObj.storeNewResult("\nState of machine: "+myState);		resultObj.storeNewResult("\nCannot move vehicles since east signal is red");		streetLightsContext.trackAllVehicles();
	}		public String getMyState() {		return myState;	}	public void setMyState(String myState) {		this.myState = myState;	}
	
}
