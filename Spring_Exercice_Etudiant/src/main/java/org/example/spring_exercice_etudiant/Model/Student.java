package org.example.spring_exercice_etudiant.Model;

import jakarta.validation.constraints.*;
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
    @NotBlank
    @NotNull(message=" vous devez remplir ce champs")
    private String lastName;
    @NotBlank
    @NotNull(message=" vous devez remplir ce champs")
    private String firstName;
    @NotNull (message=" vous devez remplir ce champs")
    @Min(16)
    @Min(77)
    private int age;
    @NotNull
    @Email
    private String email;
}
