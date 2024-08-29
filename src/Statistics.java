import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private List<MatchResult> matchResults;

    public Statistics(String filename) throws FileNotFoundException {
        this.matchResults = new MatchResultFileReader(filename).readFile();
    }

    public Set<String> getGoalScorer(){
        Set<String> goalScorer = new HashSet<>();
        for(MatchResult match : matchResults){
            goalScorer.addAll(match.getGoalScorer());
        }
        return goalScorer;
    }

    public Map<String, Integer> getGoalScorersWithTotals(){
        Map<String, Integer> scoreBoard = new HashMap<>();
        ArrayList<String> uniqNames = new ArrayList<>();
        ArrayList<Integer> nameCounts = new ArrayList<>();
        for(MatchResult goalScorer : matchResults){
            for(String names : goalScorer.getGoalScorer()){
                if(uniqNames.contains(names)){
                    int index = uniqNames.indexOf(names);
                    nameCounts.set(index, nameCounts.get(index) + 1);
                } else {
                    uniqNames.add(names);
                    nameCounts.add(1);
                }
            }
        }
       for(int i = 0; i < uniqNames.size(); i++){
           scoreBoard.put(uniqNames.get(i), nameCounts.get(i));
       }

        return scoreBoard;
    }

    public int getNumberOfGoals(String goalScorer){

        Map<String, Integer> goalscorersWithTotal = getGoalScorersWithTotals();
        return goalscorersWithTotal.get(goalScorer);


//        int goals = 0;
//        for(Map.Entry<String, Integer> m : getGoalScorersWithTotals().entrySet()){
//            if(m.getKey().contains(goalScorer)){
//                goals = m.getValue();
//            }
//        }
//        return goals;
    }
}
