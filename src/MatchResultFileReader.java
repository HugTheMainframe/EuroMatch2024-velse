import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchResultFileReader {
    private Scanner read;

    public MatchResultFileReader(String fileName) throws FileNotFoundException {
        this.read = new Scanner(new File(fileName));
    }
    public List<MatchResult> readFile(){
        List<MatchResult> matchResults = new ArrayList<>();

        MatchResult game;
        while(read.hasNextLine()){
            String line = read.nextLine();
            String[] attribute = line.split(";");
            List<String> playersList = new ArrayList<>();

            if(attribute.length > 1 && !attribute[1].isEmpty()) {
                String[] goalScorers = attribute[1].split(",");
                playersList.addAll(List.of(goalScorers));
            }
            game = new MatchResult(attribute[0], playersList);
            matchResults.add(game);
        }
        read.close();
        return matchResults;
    }
}
