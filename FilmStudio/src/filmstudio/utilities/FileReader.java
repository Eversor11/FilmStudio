package filmstudio.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FileReader-luokka, jonka avulla voidaan lukea tiedostoista tietoa
 *
 * @author Eversor
 */
public class FileReader {

    public FileReader() {
    }

    /**
     * Metodi, joka lukee parametrina annetusta tiedostopolusta rivi kerrallaan
     * merkkijonona tietoa listaan. Tiedoston sisältö merkkijono-listana
     * palautetaan lopuksi.
     * 
     * @param path Tiedostopolku merkkijonona, josta tietoa luetaan
     * @return Palauttaa tiedoston sisällön merkkijono-listana
     * @throws Exception Mahdollinen poikkeus, joka heitetään tiedoston luvun
     *                   epäonnistuttua
     */
    public List<String> readFile(String path) throws Exception {
        File file = new File(path);
        List<String> lines = new ArrayList<String>();

        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            lines.add(line);
        }
        reader.close();

        return lines;
    }
}
