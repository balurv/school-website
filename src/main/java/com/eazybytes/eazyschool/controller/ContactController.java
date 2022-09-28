package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class ContactController {
//    private static Logger log = (Logger) LoggerFactory.getLogger(ContactController.class);
    @RequestMapping("/contact")
    public String displayContact(){
        return "contact.html";
    }
    private final ContactService contactService;
    @Autowired
    ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    /*@RequestMapping(value = "/saveMsg", method = POST )
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
                                    @RequestParam String email, @RequestParam String subject, @RequestParam String message){
        System.out.println(name);
        System.out.println(mobileNum);
        return new ModelAndView("redirect:/contact");
    }
     */
@RequestMapping(value = "/saveMsg", method =  POST)
    public ModelAndView saveMessage(Contact contact){
        log.info("Name:" +contact.getName());
        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
