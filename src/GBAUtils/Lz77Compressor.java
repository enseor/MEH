package GBAUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import dsdecmp.*;

/**
 * Wrapper of debloat's Lz77 algorithm adapted for purposes within GBA ROM Hacking
 * @author maxamillion
 *
 */
public class Lz77Compressor {
	public static int getUncompressedSize(GBARom ROM, int offset)
	{
		return Lz77Algorithm.getLz77DataLength(ROM, offset);
	}
	
	public static int[] decompressLZ77(GBARom ROM, int offset) {
		InputStream stream = new ByteArrayInputStream(ROM.getData());
		HexInputStream hexstream = new HexInputStream(stream);
		try {
			stream.skip(offset);
			return Compression.Decompress(hexstream);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int[] decompressLZ77(byte[] ROM, int offset) {
		InputStream stream = new ByteArrayInputStream(ROM);
		HexInputStream hexstream = new HexInputStream(stream);
		try {
			stream.skip(offset);
			return Compression.Decompress(hexstream);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int[] compressLZ77(byte[] data) {
		byte[] bytes;
		try {
			bytes = Lz77Algorithm.compressLZ10(data);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return BitConverter.ToInts(bytes);
	}
	
	public static byte[] compressLZ77(int[] dats) {
		byte[] bytes = null;
		try {
			bytes = Lz77Algorithm.compressLZ10(BitConverter.toBytes(dats));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bytes;
	}
}
