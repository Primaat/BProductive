package com.bproductive.enums;

/** 
 * @author Sebastiaan van den Berg
 * Enum to be used by the ToDOModel class as variables
*/

public enum Status {
	
	DO("Do"), 
	DOING("Doing"), 
	DONE("Done");
	
	private final String displayValue;
    
    private Status(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
