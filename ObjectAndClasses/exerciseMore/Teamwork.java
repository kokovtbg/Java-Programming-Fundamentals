package ObjectAndClasses.exerciseMore;

public class Teamwork {
    private String creator;
    private String team;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Teamwork(String creator, String team) {
        this.creator = creator;
        this.team = team;
    }
}
