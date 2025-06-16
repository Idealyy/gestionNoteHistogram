package com.ideal.gestion_note.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * @author ideal
 * @author iamniaina34
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String numEt;
    private String nom;
    private double moyenne;

    public Student(String numEt, String nom, double moyenne) {
        this.numEt = numEt;
        this.nom = nom;
        setMoyenne(moyenne);
    }

    public Obs getObservation() {
        return moyenne >= 10
                ? Obs.Admis
                : moyenne >= 5 ? Obs.Redouble : Obs.Exclus;
    }

    public void setMoyenne(double moyenne) {
        if (moyenne < 0 || moyenne > 20)
            throw new RuntimeException("Moyenne can't be lower than 0 or higher than 20");
        this.moyenne = moyenne;
    }
}

