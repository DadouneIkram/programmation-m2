# Programmation M2

Travaux pratiques de Java / persistance de données (Hibernate, JPA, MySQL).

| TP | Sujet | Technologies |
|----|-------|--------------|
| TP2 | ... | Java, MySQL |
| TP3 | ... | Java, MySQL |
| TP4 | Faire persister une classe avec Hibernate/JPA | Java 11, Maven, Hibernate 5.6, MySQL 8 |

## Lancer un TP (exemple TP4)
1. Créer la base : `CREATE DATABASE tp4_db;`
2. Mettre son mot de passe MySQL dans `src/main/resources/META-INF/persistence.xml`
3. `mvn compile exec:java -Dexec.mainClass=com.tp.test.Main`