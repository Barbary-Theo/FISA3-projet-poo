package com.example.Projet1InsaPOO.Model;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plat implements Serializable {

    private List<Ingredient> ingredientlist;
    private String nom;
    private double prix;
    private boolean onlyMenu;

    public Plat(String nom, double prix, List<Ingredient> ingredientlist, boolean onlyMenu){
        this.nom = nom;
        this.prix = prix;
        this.ingredientlist = ingredientlist;
        this.onlyMenu = onlyMenu;
    }


    public List<Ingredient> getIngredientlist() {
        return ingredientlist;
    }

    public void setIngredientlist(List<Ingredient> ingredientlist) {
        this.ingredientlist = ingredientlist;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isOnlyMenu() {
        return onlyMenu;
    }

    public void setOnlyMenu(boolean onlyMenu) {
        this.onlyMenu = onlyMenu;
    }

    public void saveItem() throws IOException {
        FileOutputStream save = new FileOutputStream( "Save/Plat/" + this.nom + ".ser");
        ObjectOutput oos = new ObjectOutputStream(save);

        oos.writeObject(this);

    }



    public static Plat getPlatByName(String name) throws IOException, ClassNotFoundException {
        File save = new File("Save/Plat/" + name + ".ser");
        FileInputStream charger = new FileInputStream(save);
        ObjectInput ois = new ObjectInputStream(charger);

        return (Plat) ois.readObject();
    }
}
