package controleur;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestDOM {

    // Le "main" demandé par la prof pour tester directement
    public static void main(String[] args) {
        try {
            // 1. Lire le fichier XML
            InputStream is = TestDOM.class.getClassLoader().getResourceAsStream("mapping.xml");
            
            // 2. Construire l'arbre DOM en mémoire
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            
            // 3. Partir de la racine (l'élément <mappings>)
            doc.getDocumentElement().normalize();
            System.out.println("Racine du document : " + doc.getDocumentElement().getNodeName());
            
            // 4. Demander la liste des éléments (comme sa "liste des personnes")
            NodeList noeudListe = doc.getElementsByTagName("mapping");
            System.out.println("Nombre d'actions trouvées : " + noeudListe.getLength());
            System.out.println("----------------------------");

            // 5. Parcourir la NodeList et utiliser Node
            for (int i = 0; i < noeudListe.getLength(); i++) {
                Node noeud = noeudListe.item(i);
                
                // Vérifier que c'est bien un élément (et pas un espace ou un retour à la ligne)
                if (noeud.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) noeud;
                    
                    // Extraire le texte
                    String provenance = element.getElementsByTagName("provenance").item(0).getTextContent();
                    String action = element.getElementsByTagName("action").item(0).getTextContent();
                    
                    // 6. Afficher SANS HashMap
                    System.out.println("Provenance : " + provenance);
                    System.out.println("Action (Classe) : " + action);
                    System.out.println("---");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}