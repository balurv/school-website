package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        System.out.println(contact.toString());
        return isSaved;
    }
}
