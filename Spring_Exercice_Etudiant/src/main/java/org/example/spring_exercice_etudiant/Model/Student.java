package org.example.spring_exercice_etudiant.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private String email;
}
