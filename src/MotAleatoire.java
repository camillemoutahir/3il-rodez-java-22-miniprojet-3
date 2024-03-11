import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MotAleatoire {

    private Random random = new Random();
    static TreeMap<String, String> map;

    public MotAleatoire(String fichier) {
        map = new TreeMap<String, String>();
        lireFichier(Paths.get(fichier));
    }

    private void lireFichier(Path fichier){
        try (BufferedReader br = Files.newBufferedReader(fichier)) {
            String line = br.readLine();
            while (line != null){
                String[] bouts = line.split(" ",1);
                 map.put(bouts[0], bouts[1]);
            line = br.readLine();
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map.Entry<String, String> getMot(){
        List<Map.Entry<String, String>> liste = new ArrayList<>(map.entrySet());
        return liste.get(random.nextInt(liste.size()));
    }

}


/* lire les ligne dès que espace mot et après definition */