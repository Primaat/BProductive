package com.bproductive.enums;

/** 
 * @author Sebastiaan van den Berg
 * Enum to be used by the ToDOModel class as variables
*/

public enum Priorities {		
	
	LOW("Low"), 
	MEDIUM("Medium"), 
	HIGH("High");
	
	private final String displayValue;
    
    private Priorities(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
