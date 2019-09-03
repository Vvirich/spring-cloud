package com.training.customer.request;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
public class CustomerRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String secondName;
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, max = 10)
    private String password;
}
