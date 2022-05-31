package com.devistorm.personneregister;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {

    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty mail;

    public Personne(String nom, String prenom, String mail) {
        this.nom = new SimpleStringProperty("");
        this.prenom = new SimpleStringProperty("");
        this.mail = new SimpleStringProperty("");

        setNom(nom);
        setPrenom(prenom);
        setMail(mail);
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom.toUpperCase());
    }

    public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(Character.toUpperCase(prenom.charAt(0)) + prenom.substring(1).toLowerCase());
    }

    public void setMail(String mail) {
        this.mail.setValue(mail);
    }

    public StringProperty getNom() {
        return nom;
    }

    public StringProperty getPrenom() {
        return prenom;
    }

    public StringProperty getMail() {
        return mail;
    }
}
