/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.pack.model;

/**
 *
 * @author ideal
 */
public class Student {
    private int num;
    private String nom;
    private double moyenne;

    public Student() {}

    // Getters
    public int getNum() {
        return num;
    }

    public String getNom() {
        return nom;
    }

    public double getMoyenne() {
        return moyenne;
    }
    //Setters
    public void setNum(int num) {
        this.num = num;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
}

