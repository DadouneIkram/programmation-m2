package com.tp.dao;

import com.tp.entity.Personne;
import java.util.List;

public interface PersonneDao extends Dao<Personne> {
  List<Personne> findByNom(String nom);

  List<Personne> trouveTout();

  Personne findById(long id);

}