package com.tp.test;

import com.tp.dao.PersonneDao;
import com.tp.entity.Personne;

public class Main {
    public static void main(String[] args) {
        PersonneDao dao = new PersonneDao();

        Personne p1 = new Personne();
        p1.setNom("Dadoune");
        p1.setPrenom("Ikram");

        Personne p2 = new Personne();
        p2.setNom("Tuxedo");
        p2.setPrenom("Coucou");

        dao.sauve(p1);
        dao.sauve(p2);

        System.out.println("Personnes enregistrées !");
        System.exit(0);
    }
}