package fourWayStreetLights.util;

public class Logger{
    // FIXME: Add more enum values as needed for the assignment
    public static enum DebugLevel { FILE_PROCESSOR, NONE, RESULTS, STREET_LIGHTS_CONTEXT,
    								EASTGREENSTATE, EASTREDSTATE,
    								WESTGREENSTATE, WESTREDSTATE,
    								SOUTHGREENSTATE, SOUTHREDSTATE,
    								NORTHGREENSTATE, NORTHREDSTATE
                                   };

    private static DebugLevel debugLevel;
    
    // FIXME: Add switch cases for all the levels
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

    public static void writeMessage (String message, DebugLevel levelIn ) {
		if (levelIn == debugLevel)
		    System.out.println(message);
    }

    public String toString() {
    	return "The debug level has been set to the following " + debugLevel;
    }
}
