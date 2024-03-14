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
		List<Contact> sortedContacts = new ArrayList<>();	
		sortedContacts.addAll(phonebook.keySet());
		
		int current = 0;
		
		while (current < (sortedContacts.size() - 1)) {
			for (int index = sortedContacts.size() - 1; index > current; index--) {
				if ((sortedContacts.get(index).getName()).compareTo((sortedContacts.get(index - 1).getName())) < 0) {
					Contact temp = sortedContacts.get(index);
					sortedContacts.set(index, sortedContacts.get(index - 1));
					sortedContacts.set((index - 1), temp);
				}
			}
			current++;
		}
		
		
		
		return sortedContacts;
	}
	
	// Method to implement Binary search, where Key: contact name
	@Override
	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
		List<PhonebookEntry> selectedContacts = new ArrayList<>();
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
