package com.tp.test;

import com.tp.dao.ActiviteDao;
import com.tp.dao.ActiviteDaoImpl;
import com.tp.dao.PersonneDao;
import com.tp.dao.PersonneDaoImpl;
import com.tp.entity.Activite;
import com.tp.entity.Adresse;
import com.tp.entity.Info;
import com.tp.entity.Personne;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonneDao dao = new PersonneDaoImpl();
        ActiviteDao activiteDao = new ActiviteDaoImpl();

        // Activités
        Activite foot = new Activite("Football");
        Activite danse = new Activite("Danse");
        Activite lecture = new Activite("Lecture");
        activiteDao.create(foot);
        activiteDao.create(danse);
        activiteDao.create(lecture);

        // Personne 1
        Info info1 = new Info();
        info1.setObservation("Etudiante M2");
        info1.setSexe('F');
        info1.setAge(22);

        Personne p1 = new Personne();
        p1.setNom("Dadoune");
        p1.setPrenom("Ikram");
        p1.setAdresse(new Adresse("12 rue de la Paix", "Paris"));
        p1.setInfo(info1);
        p1.getActivites().add(foot);
        p1.getActivites().add(danse);
        dao.create(p1);

        // Personne 2
        Info info2 = new Info();
        info2.setObservation("Stagiaire");
        info2.setSexe('M');
        info2.setAge(25);

        Personne p2 = new Personne();
        p2.setNom("Martin");
        p2.setPrenom("Paul");
        p2.setAdresse(new Adresse("5 avenue Foch", "Lyon"));
        p2.setInfo(info2);
        p2.getActivites().add(foot);
        p2.getActivites().add(lecture);
        dao.create(p2);

        System.out.println("=== trouveTout ===");
        List<Personne> laListe = dao.trouveTout();
        for (Personne p : laListe) {
            System.out.println(p + " -> activités : " + p.getActivites());
        }

        System.out.println("=== findById (1) ===");
        Personne trouve = dao.findById(1);
        System.out.println(trouve + " -> " + trouve.getActivites());

        System.out.println("=== findByNom (Martin) ===");
        for (Personne p : dao.findByNom("Martin")) System.out.println(p);

        System.exit(0);
    }
}