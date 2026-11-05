package GBAUtils;

import java.util.HashMap;
import java.util.Map;

public class ROMManager {
	public static Map<Integer, GBARom> screenStore = new HashMap<>();
	public static GBARom currentROM = null;
	
	public static GBARom getActiveROM()
	{
		return currentROM;
	}

	public static void AddROM(int stateId, GBARom rom) {
		screenStore.put(stateId,rom);
	}

	public static void ChangeROM(int stateId) {
		currentROM = (GBARom) screenStore.get(stateId);
	}

	public static Boolean Exists(int stateId)
	{
		return (screenStore.containsKey(stateId));
	}

	public static int getID() {
		int i = 0;
		while(screenStore.containsKey(i)) {
			i++;
		}
		return i;
	}
}