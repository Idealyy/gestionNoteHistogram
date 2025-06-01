package gestion.pack.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ideal
 * @author iamniaina34
 */
@Getter
@Setter
@NoArgsConstructor
public class Student {
    private int num;
    private String nom;
    private double moyenne;

    public String getObs() {
        return moyenne >= 10
                ? "Admis"
                : moyenne >= 5 ? "Redouble" : "Exclus";
    }
}

