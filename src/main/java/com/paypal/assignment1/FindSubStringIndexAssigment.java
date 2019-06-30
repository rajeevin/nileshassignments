package com.paypal.assignment1;

public class FindSubStringIndexAssigment {

	private static final int NOT_FOUND_INDEX = -1;
	private static final int BEGINING_INDEX = 0;
	public static int strstr( String mainString, String subString){
		System.out.println("{mainString:"+mainString + ", subString:"+ subString+"}" );
		
		if(mainString == null || subString == null) {
			return NOT_FOUND_INDEX;
		}
		
		if(mainString.length() < subString.length()) {
			return NOT_FOUND_INDEX;
		}
		
		if(mainString.length() == 0){
			return BEGINING_INDEX;
		}
		
		if(subString.length() == 0){
			return NOT_FOUND_INDEX;
		}
		
		return internalStrSubStr(mainString, subString);
	}

	private static int internalStrSubStr(String mainString, String subString) {
		int[] piTable = generatePiTable(subString);
		int indexInMainString = BEGINING_INDEX;
		int indexInSubString = BEGINING_INDEX;
		boolean matchFound = false;
		while(indexInMainString < mainString.length() && indexInSubString < subString.length()) {
			if(mainString.charAt(indexInMainString) == subString.charAt(indexInSubString)) {
				indexInMainString++;
				indexInSubString++;
				if(indexInSubString == subString.length()) {
					matchFound = true;
					break;
				}
			}else{				
				if(indexInSubString > BEGINING_INDEX) { 
					indexInSubString = piTable[ indexInSubString - 1 ] + 1;
				}
				if(indexInSubString == BEGINING_INDEX) {
					indexInMainString++;
				}
			}
		}
		if(!matchFound) {
			return NOT_FOUND_INDEX;
		}else {
			return indexInMainString - indexInSubString;
		}
	}
	
	private static int[] generatePiTable(String subString) {
		int[] piTable = new int[subString.length()] ;
		
		int indexInSubstring = BEGINING_INDEX + 1;
		int indexInRepetedPrefix = BEGINING_INDEX;
		piTable[BEGINING_INDEX] = NOT_FOUND_INDEX;
		
		while(indexInSubstring < subString.length()) {
			if(subString.charAt(indexInSubstring) == subString.charAt(indexInRepetedPrefix)) {
				piTable[indexInSubstring] = indexInRepetedPrefix;
				indexInRepetedPrefix++;
			} else {
				indexInRepetedPrefix = BEGINING_INDEX;
				piTable[indexInSubstring] = NOT_FOUND_INDEX;
			}
			indexInSubstring++;
		}
		return piTable;
		
	}
	
	public static boolean test(){
		return strstr("PayPal", "Pay") == 0
			&& strstr("PayPal", "Pal") == 3
			&& strstr("", "") == 0
			&& strstr("Test", "Pay") == -1
			&& strstr(null, null) == -1
			&& strstr("Test", null) == -1
			&& strstr(null, "Test") == -1
			&& strstr("Test", "Test") == 0
			&& strstr("Test", "") == -1
			&& strstr("Test", "Tester") == -1
			&& strstr("Test", "t") == 3
			&& strstr("PayPaymentWithPayPal", "PayPal") == 14
			&& strstr("aaaaaaaaaaaaab", "aaaab") == 9
			&& strstr("aaaaaaaaaaabaab", "aabaab") == 9;
	}
	
	public static void main(String[] args) {
		System.out.println("All tests passed : " + test());
	}
}
