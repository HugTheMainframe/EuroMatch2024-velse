import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class UnitTest {
    String filepath = "Euro2024.csv";

    @Test
    void testFileReader() throws FileNotFoundException {
        //Arrange
        List<String> playerList = new ArrayList<>();
        playerList.add("Højlund");
        playerList.add("Højlund");
        playerList.add("Højlund");

        //Act
        MatchResultFileReader reader = new MatchResultFileReader(filepath);
        List<MatchResult> realList = reader.readFile();
        MatchResult expectedResult = realList.get(0);

        //Assert
        MatchResult testMatch = new MatchResult("Denmark-Finland", playerList);

        Assertions.assertEquals(expectedResult.toString(), testMatch.toString());
    }

    @Test
    void testGoalScoresWithTotals() throws FileNotFoundException {
        //Arrange
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("Højlund", 3);


        //Act
        Statistics actualResult = new Statistics(filepath);
        Map<String, Integer> actualList = actualResult.getGoalScorersWithTotals();

        //Assert

        Assertions.assertNotEquals(testMap, actualList);
    }

    @Test
    void testGetGoalScorer() throws FileNotFoundException{
        //Arrange
        Set<String> expectedResults = new HashSet<>();
        expectedResults.add("Højlund");
        expectedResults.add("Wind");
        expectedResults.add("Mæhle");
        expectedResults.add("Eriksen");
        expectedResults.add("Skov");
        expectedResults.add("Poulsen");
        expectedResults.add("Delaney");
        expectedResults.add("Højbjerg");

        //Act
        Statistics actualList = new Statistics(filepath);
        Set<String> actualResults = actualList.getGoalScorer();

        //Assert
        int expectedSetCount = 8;

        Assertions.assertEquals(expectedResults, actualResults);
        Assertions.assertEquals(8, actualResults.size());
    }

    @Test
    void testGetNumberOfGoals() throws FileNotFoundException{
        //Arrange
        String goalScorerKey = "Eriksen";

        //Act
        Statistics actualList = new Statistics(filepath);
        int actualResults = actualList.getNumberOfGoals(goalScorerKey);

        //Assert
        int expectResults = 1;
        Assertions.assertEquals(expectResults, actualResults);
    }
}
