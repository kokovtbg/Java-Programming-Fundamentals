package AssociativeArrays.exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> forceBook = new HashMap<>();
        String command = scan.nextLine();
        while (!command.equals("Lumpawaroo")) {
            if (command.contains("|")) {
                String[] splitData = command.split(" \\| ");
                String forceSide = splitData[0];
                String forceUser = splitData[1];
                boolean forceUserExist = false;
                for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        if (entry.getValue().get(i).equals(forceUser)) {
                            entry.getValue().remove(i);
                            forceUserExist = true;
                            break;
                        }
                    }
                    if (forceUserExist) {
                        break;
                    }
                }
                List<String> users;
                if (!forceBook.containsKey(forceSide)) {
                    users = new ArrayList<>();
                } else {
                    users = forceBook.get(forceSide);
                }
                users.add(0, forceUser);
                forceBook.put(forceSide, users);
            } else {
                String[] splitData = command.split(" -> ");
                String forceUser = splitData[0];
                String forceSide = splitData[1];
                boolean forceUserExist = false;
                for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        if (entry.getValue().get(i).equals(forceUser)) {
                            forceUserExist = true;
                            entry.getValue().remove(i);
                            break;
                        }
                    }
                    if (forceUserExist) {
                        break;
                    }
                }
                List<String> users;
                if (!forceBook.containsKey(forceSide)) {
                    users = new ArrayList<>();
                } else {
                    users = forceBook.get(forceSide);
                }
                users.add(0, forceUser);
                forceBook.put(forceSide, users);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }

            command = scan.nextLine();
        }
        forceBook.entrySet().stream().filter(a -> a.getValue().size() > 0)
                .sorted((a1, a2) -> {
                    String a1String = "" + a1.getValue().size();
                    String a2String = "" + a2.getValue().size();
                    int result = a2String.compareTo(a1String);
                    if (result == 0) {
                        result = a1.getKey().compareTo(a2.getKey());
                    }
                    return result;
                }).forEach(a -> {
            System.out.printf("Side: %s, Members: %d%n", a.getKey(), a.getValue().size());
            for (int i = 0; i < a.getValue().size(); i++) {
                System.out.printf("! %s%n", a.getValue().get(i));
            }
        });
    }
}
