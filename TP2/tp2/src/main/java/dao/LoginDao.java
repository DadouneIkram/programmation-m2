package dao;

import java.util.ArrayList;
import java.util.List;
import modele.LoginBean;

public class LoginDao {
    private static List<LoginBean> baseDeDonnees = new ArrayList<>();

    public void insert(String nom, String password) {
        LoginBean user = new LoginBean();
        user.setNom(nom);
        user.setPassword(password);
        baseDeDonnees.add(user);
    }

    public List<LoginBean> findAll() {
        return baseDeDonnees;
    }

    public void delete(String nom) {
        baseDeDonnees.removeIf(user -> user.getNom().equals(nom));
    }
}