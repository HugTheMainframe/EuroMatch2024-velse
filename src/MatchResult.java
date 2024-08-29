import java.util.ArrayList;
import java.util.List;

public class MatchResult {
    private String teams;
    private List<String> goalScorer;

    public MatchResult(String teams, List<String> goalScorer){
        this.teams = teams;
        this.goalScorer = goalScorer;
    }

    public List<String> getGoalScorer(){
        return goalScorer;
    }

    public String getTeams(){
        return teams;
    }

    @Override
    public String toString(){
        return teams + getGoalScorer();
    }
}
