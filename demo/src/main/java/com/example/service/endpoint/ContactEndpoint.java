package com.example.service.endpoint;

import java.util.List;

import com.example.service.representation.ContactRepresentation;

/**
 * This endpoint class exposes the actions that the web service allows: 1) Create a contact record 2) Retrieve a contact record 3) Update a contact record and 4) Delete a contact record
 * Assumptions: contact name can be used to get a contact or contacts. However, contact name is not a unique in the list of contacts in the database. However, contact id's are unique to each contact. 
 * Additional Assumptions: delete operation requires a unique value, i.e. contact id, instead of a value that has multiple possible matches, e.g. contact name 
 * @author lbo
 *
 */
public interface ContactEndpoint {

	ContactRepresentation create(ContactRepresentation contactRepresentation);

	List<ContactRepresentation> get(String contactName);

	ContactRepresentation get(int contactId);

	ContactRepresentation update(ContactRepresentation contactRepresentation);

	ContactRepresentation delete(int contactId);
	
}
