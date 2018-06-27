package fourWayStreetLights.util;
/**
* Logger program helps in keeping track of program run
*
* @author  Gaurang Dhake
* @version 1.0
* @since   06/27/18 
*/
public class Logger{
    // These are debugLevel values which represents states or classes
    public static enum DebugLevel { FILE_PROCESSOR, NONE, RESULTS, STREET_LIGHTS_CONTEXT,
    								EASTGREENSTATE, EASTREDSTATE,
    								WESTGREENSTATE, WESTREDSTATE,
    								SOUTHGREENSTATE, SOUTHREDSTATE,
    								NORTHGREENSTATE, NORTHREDSTATE
                                   };
    
    private static DebugLevel debugLevel; // static current debugLevel for the program
    
    /**
	   * This is method which assigns current debugLevel using command line argument
	   * @param levelIn this parameter decides which debugLevel to set from cmd
	   * @return DebugLevel returns debugLevel which was set here
	   */
    public static DebugLevel setDebugValue (int levelIn) {
		switch (levelIn) {
			case 1: debugLevel = DebugLevel.FILE_PROCESSOR; break;
			case 2: debugLevel = DebugLevel.RESULTS; break;
			case 3: debugLevel = DebugLevel.EASTGREENSTATE; break;
			case 4: debugLevel = DebugLevel.EASTREDSTATE; break;
			case 5: debugLevel = DebugLevel.WESTGREENSTATE; break;
			case 6: debugLevel = DebugLevel.WESTREDSTATE; break;
			case 7: debugLevel = DebugLevel.SOUTHGREENSTATE; break;
			case 8: debugLevel = DebugLevel.SOUTHREDSTATE; break;
			case 9: debugLevel = DebugLevel.NORTHGREENSTATE; break;
			case 10: debugLevel = DebugLevel.NORTHREDSTATE; break;
			case 11: debugLevel = DebugLevel.STREET_LIGHTS_CONTEXT; break;
			default: debugLevel = DebugLevel.NONE; break;
		}
		
		return debugLevel;
    }
    
    /**
	   * This is method which writes message incoming from respective class
	   * @param message this is the message to be printed
	   * @param levelIn to check whether current level is the level being passed
	   * @return None since return type is void
	   */
    public static void writeMessage (String message, DebugLevel levelIn ) {
		if (levelIn == debugLevel)
		    System.out.println(message);
    }
    /**
	   * This is method returns string containing debugLevel
	   * @return String it returns string for debugLevel
	   */
    public String toString() {
    	return "The debug level has been set to the following " + debugLevel;
    }
}
