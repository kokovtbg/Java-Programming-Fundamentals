package ObjectAndClasses.exerciseMore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Members> teamsWithMembers = new ArrayList<>();
        List<String> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] splitData = scan.nextLine().split("-");
            String creator = splitData[0];
            String teamName = splitData[1];
            Members member = new Members(creator, teamName, members);

            boolean existTeam = false;
            boolean existCreator = false;
            for (int j = 0; j < teamsWithMembers.size(); j++) {
                if (teamsWithMembers.get(j).getTeamName().equals(teamName)) {
                    existTeam = true;
                }
                if (teamsWithMembers.get(j).getCreator().equals(creator)) {
                    existCreator = true;
                }
            }
            if (!existTeam && !existCreator) {
                member.setCreator(creator);
                member.setTeamName(teamName);

                teamsWithMembers.add(member);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator);
            } else if (existTeam && !existCreator) {
                System.out.printf("Team %s was already created!%n", teamName);
            } else if (existCreator && !existTeam) {
                System.out.printf("%s cannot create another team!", creator);
            }
        }

        String command = scan.nextLine();

        while (!command.equals("end of assignment")) {
            String[] splitData = command.split("->");
            String memberName = splitData[0];
            String teamNameCommand = splitData[1];
            boolean existMember = false;
            boolean existTeam = false;
            for (int i = 0; i < teamsWithMembers.size(); i++) {
                if (teamsWithMembers.get(i).getTeamName().equals(teamNameCommand)) {
                    existTeam = true;
                    if (teamsWithMembers.get(i).getCreator().equals(memberName)) {
                        existMember = true;
                    }
                }
            }
            if (!existMember && existTeam) {
                for (int i = 0; i < teamsWithMembers.size(); i++) {
                    if (teamsWithMembers.get(i).getTeamName().equals(teamNameCommand)) {
                        members.add(memberName);
                    }
                }
            } else if (existMember) {
                System.out.printf("Member %s cannot join team %s!%n", memberName, teamNameCommand);
            } else {
                System.out.printf("Team %s does not exist!%n", teamNameCommand);
            }

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
