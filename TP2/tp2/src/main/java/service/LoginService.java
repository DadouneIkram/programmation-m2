package service;

import dao.LoginDao;
import modele.LoginBean;
import java.util.List;

public class LoginService {
    private LoginDao dao = new LoginDao();

    public void ajoute(String l, String p) {
        if (l != null && !l.isEmpty() && p != null && !p.isEmpty()) {
            dao.insert(l, p);
        }
    }

    public List<LoginBean> findAll() {
        return dao.findAll();
    }

    public void supprime(String nom) {
        if (nom != null && !nom.isEmpty()) {
            dao.delete(nom);
        }
    }
}