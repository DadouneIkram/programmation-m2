package controleur;

import java.io.InputStream;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MaFactory {
    
    // La HashMap reste la même
    private static HashMap<String, String> map = new HashMap<>();

    // Le bloc statique s'exécute une seule fois au démarrage
    static {
        try {
            // 1. On charge le fichier mapping.xml depuis le dossier resources
            InputStream is = MaFactory.class.getClassLoader().getResourceAsStream("mapping.xml");
            
            // 2. On prépare les outils Java pour lire du XML (DOM Parser)
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();

            // 3. On récupère toutes les balises <mapping>
            NodeList nodeList = doc.getElementsByTagName("mapping");

            // 4. On fait une boucle sur chaque <mapping> trouvé dans le XML
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                
                // On extrait le texte à l'intérieur des balises <provenance> et <action>
                String provenance = element.getElementsByTagName("provenance").item(0).getTextContent();
                String action = element.getElementsByTagName("action").item(0).getTextContent();
                
                // On remplit notre dictionnaire dynamiquement !
                map.put(provenance, action);
            }
            System.out.println("Le fichier XML a été lu avec succès. Map : " + map);
            
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier mapping.xml : " + e.getMessage());
            e.printStackTrace();
        }
    }

    // La méthode getAction ne change pas du tout !
    public static IAction getAction(String provenance) {
        try {
            String nomClass = map.get(provenance);
            if (nomClass != null) {
                return (IAction) Class.forName(nomClass).newInstance();
            }
        } catch (Exception e) {
            System.out.println("Erreur de création de la classe : " + e.getMessage());
        }
        return null;
    }
}