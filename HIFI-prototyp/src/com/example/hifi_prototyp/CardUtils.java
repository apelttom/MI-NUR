package com.example.hifi_prototyp;

public class CardUtils {

	public static String getKind(final int index) {
		switch (index) {
	    case 0: return "s";
	    case 1: return "h";
	    case 2: return "c";
	    case 3: return "d";
	    }
		System.err.println("Wrong kind index="+index);
		return null;
	}
	
	public static int getKindIndex(final String s) {
		switch (s) {
	    case "s": return 0;
	    case "h": return 1;
	    case "c": return 2;
	    case "d": return 3;
	    }
		return -1;
	}
	
	public static String getValue(final int index) {
		switch (index) {
		case 13: return "cancel";
		case 12: return "1";
		case 11: return "k";
		case 10: return "q";
		case 9: return "j";
		case -1: System.err.println("Wrong kind index="+index);
		default: return String.valueOf(index+2);
		}
	}
	
	public static String getCard(final int kindIdx, final int valueIdx) {
		return getKind(kindIdx) + getValue(valueIdx);
	}
}
