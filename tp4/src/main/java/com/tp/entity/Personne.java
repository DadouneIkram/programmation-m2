package com.tp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Personnes")
public class Personne {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_personne")
  private Long id;
  private String nom;
  private String prenom;

  @Embedded
  private Adresse adresse;
  @OneToOne(cascade = CascadeType.ALL)
  private Info info;
  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinTable(name = "personne_activite", joinColumns = { @JoinColumn(name = "id_personne") }, inverseJoinColumns = {
      @JoinColumn(name = "id_activite") })
  private Set<Activite> activites = new HashSet<>();

  public Personne() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Adresse getAdresse() {
    return adresse;
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  @Override
  public String toString() {
    return id + " " + nom + " " + prenom;
  }

  public Set<Activite> getActivites() {
    return activites;
  }

  public void setActivites(Set<Activite> activites) {
    this.activites = activites;
  }
}