package filmstudio.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public FileReader() {
    }

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
