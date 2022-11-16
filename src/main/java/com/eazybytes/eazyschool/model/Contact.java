package com.eazybytes.eazyschool.model;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Contact {
    @NotBlank(message="Name must not be blank")
    @Size(min = 3, message =  "name must be at least 3 character long!")
    private String name;

    @NotBlank(message="Moblie number must not be blank.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "email must not be blank")
    @Email(message = "Please provide valid email address.")
    private String email;

    @NotBlank(message = "subject must not be blank.")
    @Size(min = 5, message = "Subject must be at least 5 characters long.")
    private String subject;

    @NotBlank(message = "Message must not be blank.")
    @Size(min = 10, message = "message must be at least 10 characters long.")
    private String message;
}
