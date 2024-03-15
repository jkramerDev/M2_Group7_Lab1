package template;

/**
 *   model a PhonebookEntry 
 *   
 *   PhonebookEntry has a phoneNumber and type
 *   
 *   
 */

class PhonebookEntry {
	String phoneNumber;
	String type;

	// Constructor
	PhonebookEntry(String phoneNumber, String type) {
		this.phoneNumber = phoneNumber;
		this.type = type;
	}
	
	// Method to retrieve phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	// Method to retrieve type
	public String getType() {
		return type;
	}
	
	// Method to override toString()
	public String toString() {
		return getPhoneNumber() + " " + getType();
	}
 
}