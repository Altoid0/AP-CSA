package com.freekash.springboot.database;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/*
Player is a POJO, Plain Old Java Object.
First set of annotations add functionality to POJO
--- @Setter @Getter @ToString @NoArgsConstructor @RequiredArgsConstructor
The last annotation connect to database
--- @Entity
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Row {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*
    @NonNull: Places this in @RequiredArgsConstructor
    @Size(min=2, max=30): Allows names between 2 and 30 characters long.
     */
    @NonNull
    @Size(min = 2, max = 100, message = "Name")
    private String name;

    @NonNull
    @Size(min = 2, max = 100, message = "Link")
    private String link;

    // Mastery is restricted
    @NonNull
    @Min(1) @Max(10)
    private Integer unit;

    @NonNull
    @Size(min = 2, max = 1000, message = "Text")
    private String text;
}