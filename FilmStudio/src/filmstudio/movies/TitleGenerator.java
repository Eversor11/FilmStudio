package filmstudio.movies;

import filmstudio.utilities.FileReader;
import java.util.List;
import java.util.Random;

public class TitleGenerator {

    private Random random;
    private FileReader fileReader;

    public TitleGenerator(FileReader fileReader, Random random) {
        this.fileReader = fileReader;
        this.random = random;
    }

    public String generateTitle(String adjectivesPath, String nounsPath) throws Exception {
        String title = "";

        List<String> adjectiveList = fileReader.readFile(adjectivesPath);
        List<String> nounList = fileReader.readFile(nounsPath);

        int dice = random.nextInt(9);

        if (dice > 0) {
            title = adjectiveNoun(adjectiveList, nounList);
        } else {
            title = articleNoun(nounList);
        }

        return title;
    }

    private String adjectiveNoun(List<String> adjectiveList, List<String> nounList) {
        String title = "";

        title += adjectiveList.get(random.nextInt(adjectiveList.size()));
        title += " ";
        title += nounList.get(random.nextInt(nounList.size()));

        return title;
    }

    private String articleNoun(List<String> nounList) {
        String title = "";

        title += "The ";
        title += nounList.get(random.nextInt(nounList.size()));

        return title;
    }
}
