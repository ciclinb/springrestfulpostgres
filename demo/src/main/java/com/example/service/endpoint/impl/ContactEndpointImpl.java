package com.example.service.endpoint.impl;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.constant.Constant;
import com.example.constant.HTTPVerb;
import com.example.service.bo.ContactService;
import com.example.service.bo.impl.ContactServiceImpl;
import com.example.service.endpoint.ContactEndpoint;
import com.example.service.representation.ContactRepresentation;
import com.example.service.representation.Link;
import com.example.util.ContactUtil;

@RestController
@RequestMapping(value = "/contacts")
public class ContactEndpointImpl implements ContactEndpoint {

	private ContactService contactService = new ContactServiceImpl();

	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json")
	@Override
	public ContactRepresentation create(ContactRepresentation contactRepresentation) {
		contactService.add(ContactUtil.buildContactBean(contactRepresentation));
		return setLinks(contactRepresentation);
	}

	@RequestMapping(value = "/{contactName}", method = RequestMethod.GET, headers = "Accept=application/json")
	@Override
	public List<ContactRepresentation> get(@PathParam("contactName") String contactName) {
		List<ContactRepresentation> contactRepresentationList = ContactUtil.buildContactRepresentationList(contactService.get(contactName));
		List<ContactRepresentation> contactRepresentationListWithLinks = new ArrayList<ContactRepresentation>();

		for (ContactRepresentation contactRepresentation : contactRepresentationList) {
			ContactRepresentation contactRepresentationWithLink = setLinks(contactRepresentation);
			contactRepresentationListWithLinks.add(contactRepresentationWithLink);
		}
			
		return contactRepresentationListWithLinks;
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET, headers = "Accept=application/json")
	@Override
	public ContactRepresentation get(@PathParam("contactId") int contactId) {
		return setLinks(ContactUtil.buildContactRepresentation(contactService.get(contactId)));
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, headers = "Accept=application/json")
	@Override
	public ContactRepresentation update(ContactRepresentation contactRepresentation) {
		contactService.update(ContactUtil.buildContactBean(contactRepresentation));
		return setLinks(contactRepresentation);
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	@Override
	public ContactRepresentation delete(@PathParam("contactId") int contactId) {
		contactService.delete(contactId);	
		return setLinks();
	}
	
	/**
	 * This returns links for an individual contact. The links available are create, retrieve, delete, and update.
	 * @param contactRepresentation
	 * @return
	 */
	private ContactRepresentation setLinks(ContactRepresentation contactRepresentation) {
		if (contactRepresentation != null) {
			Link deleteContact = new Link(HTTPVerb.DELETE.toString(), Constant.BASE_PATH + "/contact/", "", Constant.MEDIA_TYPE_XML );
			Link updateContact =  new Link(HTTPVerb.PUT.toString(), Constant.BASE_PATH + "/contact/", "", Constant.MEDIA_TYPE_XML );
			Link createContact = new Link(HTTPVerb.POST.toString(), Constant.BASE_PATH + "/contact/", "", Constant.MEDIA_TYPE_XML );
			Link retrieveContact = new Link(HTTPVerb.GET.toString(), Constant.BASE_PATH + "/contact/", "", Constant.MEDIA_TYPE_XML );
		
			contactRepresentation.setLinks(deleteContact, updateContact, createContact, retrieveContact);
		}
		
		return contactRepresentation;
	}
	
	/**
	 * This sets the links for the create and retrieve actions. 
	 * @return
	 */
	private ContactRepresentation setLinks() {
		Link createContact = new Link(HTTPVerb.POST.toString(), Constant.BASE_PATH + "/contact/", "", Constant.MEDIA_TYPE_XML );
		Link retrieveContact = new Link(HTTPVerb.GET.toString(), Constant.BASE_PATH + "/contact/", "", Constant.MEDIA_TYPE_XML );
		ContactRepresentation contactRepresentation = new ContactRepresentation();
		contactRepresentation.setLinks(createContact, retrieveContact);
		return contactRepresentation;
	}

}
