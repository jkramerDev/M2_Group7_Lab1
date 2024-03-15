package template;

import java.util.*;

/**
 * PhonebookHandler - supports 
 * Phonebook operations
 * 
 * Use a map to build the Phonebook
 * key: Contact
 * value: List<phonebookEntries>
 */

public class PhonebookHandler implements iPhonebookHander{
	Map<Contact, List<PhonebookEntry>> phonebook;
	
	// Constructor
	PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook) {
		this.phonebook = phonebook;
	}
	
	// Method to implement Bubble sort or merge sort
	@Override
	public List<Contact> sortByName() {
		// Create a list to hold the sorted contacts
		List<Contact> sortedContacts = new ArrayList<>();	
		
		// Add all of the keys of phonebook map to sorted contacts list
		sortedContacts.addAll(phonebook.keySet());
		
		// Initialise current variable to be 0
		int current = 0;
		
		// Ensure within range of sorted contacts list
		while (current < (sortedContacts.size() - 1)) {
			for (int index = sortedContacts.size() - 1; index > current; index--) {
				if ((sortedContacts.get(index).getName()).compareTo((sortedContacts.get(index - 1).getName())) < 0) {
					// Create temporary variable to hold value at index in the sorted contacts list
					Contact temp = sortedContacts.get(index);
					// Set the value of index - 1 equal to the value of the sorted contacts at index
					sortedContacts.set(index, sortedContacts.get(index - 1));
					// Set the value of index equal to the value of the sorted contacts at index - 1
					sortedContacts.set((index - 1), temp);
				}
			}
			// Update current variable 
			current++;
		}
		return sortedContacts;
	}
	
	// Method to implement Binary search, where Key: contact name
	@Override
	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
		// Create a list to hold the selected contacts based on the provided name
		List<PhonebookEntry> selectedContacts = new ArrayList<>();
		
		// Establish lower and upper bounds
		int lower = 0;
        int upper = sortedContacts.size() - 1;
        
        // Ensure within range of lower and upper bound
        while (lower <= upper) {
        	// Determine the middle of sortedContacts
            int middle = lower + (upper - lower) / 2;
            
            // If the name associated with the middle is equal to the name being searched
            if ((sortedContacts.get(middle).getName()).equalsIgnoreCase(name)) {
            	// Then add the phonebook entries of that name to the selected contacts list
                selectedContacts.addAll(sortedContacts.get(middle).getPhonebookEntries());
            }
            
            // If the middle value is less than the name provided
            if ((sortedContacts.get(middle).getName()).compareTo(name) < 0) {
            	// Adjust the lower bound to be one more than middle
                lower = middle + 1;
            } 
            
         // Otherwise, adjust the upper bound to be one less than middle
            else {
                upper = middle - 1;
            }
        }
		
        // Return the list of selected contacts
		return selectedContacts;
	}
	
	// Method to display the sorted contacts
	@Override
	public void display(List<Contact> sortedContacts) {
		System.out.println("Sorted Phonebook (Bubble Sort): ");
		
		for (Contact contact : sortedContacts) {
			System.out.println(contact.getName());
		}
	}
 
}
