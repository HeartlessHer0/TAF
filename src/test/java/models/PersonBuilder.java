package models;

import lombok.*;


@Builder
@ToString(exclude = "UUID")
@EqualsAndHashCode(exclude = "UUID")
public class PersonBuilder {

    private int age = 10;
    private String name;
    private String surname;
    private int UUID;

}