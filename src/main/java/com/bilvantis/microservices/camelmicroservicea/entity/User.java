package com.bilvantis.microservices.camelmicroservicea.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String phNumber;
    private String Address;

}
