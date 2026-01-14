package dev.enseor.MEH.IO;

import GBAUtils.BitConverter;
import GBAUtils.GBARom;
import GBAUtils.ISaveable;
import dev.enseor.MEH.IO.Map.Map;
import dev.enseor.MEH.IO.Map.MapData;

public class BorderMap implements ISaveable {

    private final MapData mapData;
	private final BorderTileData mapTileData;
	public boolean isEdited = false;

	public BorderMap(GBARom rom, Map m) {
        mapData = m.getMapData();
		mapTileData = new BorderTileData(rom, BitConverter.shortenPointer(mapData.borderTilePtr),mapData);
	}
	
	public MapData getMapData() {return mapData;}
	public BorderTileData getMapTileData() {return mapTileData;}
	public void save() {mapTileData.save();}
}