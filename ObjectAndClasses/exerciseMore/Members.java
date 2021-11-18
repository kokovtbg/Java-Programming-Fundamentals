package ObjectAndClasses.exerciseMore;

import java.util.List;

public class Members {
    private String creator;
    private String teamName;
    private List<String> members;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public Members(String creator, String teamName, List<String> members) {
        this.creator = creator;
        this.teamName = teamName;
        this.members = members;
    }
}
