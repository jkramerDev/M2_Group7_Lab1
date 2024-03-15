package template;

/**
 * model a Contact 
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

import java.util.List;
import java.util.ArrayList;

class Contact {
	String name; 
	List<PhonebookEntry> phonebookEntry;
	
	// Constructor
	Contact(String name) {
		this.name = name;
		this.phonebookEntry = new ArrayList<>();
	}
	
	// Method to add phone numbers to list
	public void addPhonebookEntry(String phoneNumber, String type) {
		phonebookEntry.add(new PhonebookEntry(phoneNumber, type));
	}
	
	// Method to retrieve phonebook entries
	public List<PhonebookEntry> getPhonebookEntries() {
		return phonebookEntry;
	}
	
	// Method to retrieve name
	public String getName() {
		return name;
	}
	
	// Method to override toString()
	public String toString() {
		return "Name: " + name + ", Phone Number(s): " + phonebookEntry.toString();
	}
	
	// Method to override equals
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

        if (!(obj instanceof Contact)) {
        	return false;
        }

        Contact contact = (Contact) obj;
        
        return contact.getName() == this.getName()
                && contact.getPhonebookEntries() == this.getPhonebookEntries();
	}
	
	// Method to override hashCode
	@Override
	public int hashCode() {
        // Initialise constant
    	int result = 10;
    	
    	// Variable
    	int variable = name.length();
        
    	// Adjust 
        result = 2 * result + variable; 
        
        return result;
    }

}