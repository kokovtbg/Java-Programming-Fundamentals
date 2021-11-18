package ObjectAndClasses.exerciseMore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Teamwork> teams = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] splitData = scan.nextLine().split("-");
            String creator = splitData[0];
            String teamName = splitData[1];
            Teamwork team = new Teamwork(creator, teamName);
            boolean existTeam = false;
            boolean existCreator = false;
            for (int j = 0; j < teams.size(); j++) {
                if (teams.get(j).getTeam().equals(teamName)) {
                    existTeam = true;
                }
                if (teams.get(j).getCreator().equals(creator)) {
                    existCreator = true;
                }
            }
            if (!existTeam && !existCreator) {
                team.setCreator(creator);
                team.setTeam(teamName);

                teams.add(team);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator);
            } else if (existTeam && !existCreator) {
                System.out.printf("Team %s was already created!%n", teamName);
            } else if (existCreator && !existTeam) {
                System.out.printf("%s cannot create another team!", creator);
            }
        }
        String command = scan.nextLine();
        List<Members> teamsWithMembers = new ArrayList<>();
        while (!command.equals("end of assignment")) {
            String[] splitData = command.split("->");
            String memberName = splitData[0];
            String teamName = splitData[1];
            String creator = "";
            boolean existMember = false;
            boolean existTeam = false;
            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getCreator().equals(memberName)) {
                    existMember = true;
                }
                if (teams.get(i).getTeam().equals(teamName)) {
                    existTeam = true;
                    if (!existMember) {
                        creator = teams.get(i).getCreator();
                    }
                }
            }
            List<String> members = new ArrayList<>();
            Members member = new Members(creator, teamName, members);
            member.setCreator(creator);
            member.setTeamName(teamName);
            if (!existMember && existTeam) {
                members.add(memberName);
            } else if (existMember && existTeam) {
                System.out.printf("Member %s cannot join team %s!%n", memberName, teamName);
            } else if (!existMember && !existTeam) {
                System.out.printf("Team %s does not exist!%n", teamName);
            }
            teamsWithMembers.add(member);

            command = scan.nextLine();
        }
        for (int i = 0; i < teamsWithMembers.size(); i++) {
            if (teamsWithMembers.get(i).getMembers().size() > 0) {
                System.out.printf("%s%n", teamsWithMembers.get(i).getTeamName());
                System.out.printf("- %s%n", teamsWithMembers.get(i).getCreator());
                for (int j = 0; j < teamsWithMembers.get(i).getMembers().size(); j++) {
                    System.out.printf("-- %s%n", teamsWithMembers.get(i).getMembers().get(j));
                }
            } else {
                System.out.printf("Teams to disband:%n");
                System.out.printf("%s%n", teamsWithMembers.get(i).getTeamName());
            }
        }
    }
}
