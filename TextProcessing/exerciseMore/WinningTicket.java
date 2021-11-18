package TextProcessing.exerciseMore;

import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split(",\\s+");
        String[] ticketsJackpot = new String[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            boolean leftSideJackpot = false;
            boolean rightSideJackpot = false;
            boolean leftSideFullJackpot = false;
            boolean rightSideFullJackpot = false;
            int matchLeft = 0;
            int matchRight = 0;
            String matchSymbolLeft = "";
            if (tickets[i].length() == 20) {
                for (int j = 0; j < tickets[i].length() / 2; j++) {
                    if (tickets[i].charAt(j) == '@' && j <= 4) {
                        int count = 1;
                        for (int k = j + 1; k < tickets[i].length() / 2; k++) {
                            if (tickets[i].charAt(k) == '@') {
                                count++;
                            }
                        }
                        if (count >= 6 && count < 10) {
                            leftSideJackpot = true;
                            matchLeft = count;
                            matchSymbolLeft = "@";
                        } else if (count == 10) {
                            leftSideFullJackpot = true;
                            matchLeft = count;
                            matchSymbolLeft = "@";
                        }
                    }
                    if (tickets[i].charAt(j) == '#' && j <= 4) {
                        int count = 1;
                        for (int k = j + 1; k < tickets[i].length() / 2; k++) {
                            if (tickets[i].charAt(k) == '#') {
                                count++;
                            }
                        }
                        if (count >= 6 && count < 10) {
                            leftSideJackpot = true;
                            matchLeft = count;
                            matchSymbolLeft = "#";
                        } else if (count == 10) {
                            leftSideFullJackpot = true;
                            matchLeft = count;
                            matchSymbolLeft = "#";
                        }
                    }
                    if (tickets[i].charAt(j) == '$' && j <= 4) {
                        int count = 1;
                        for (int k = j + 1; k < tickets[i].length() / 2; k++) {
                            if (tickets[i].charAt(k) == '$') {
                                count++;
                            }
                        }
                        if (count >= 6 && count < 10) {
                            leftSideJackpot = true;
                            matchLeft = count;
                            matchSymbolLeft = "$";
                        } else if (count == 10) {
                            leftSideFullJackpot = true;
                            matchLeft = count;
                            matchSymbolLeft = "$";
                        }
                    }
                    if (tickets[i].charAt(j) == '^' && j <= 4) {
                        int count = 1;
                        for (int k = j + 1; k < tickets[i].length() / 2; k++) {
                            if (tickets[i].charAt(k) == '^') {
                                count++;
                            }
                        }
                        if (count >= 6 && count < 10) {
                            leftSideJackpot = true;
                            matchLeft = count;
                            matchSymbolLeft = "^";
                        } else if (count == 10) {
                            leftSideFullJackpot = true;
                            matchLeft = count;
                            matchSymbolLeft = "^";
                        }
                    }
                }
                for (int j = 10; j < tickets[i].length(); j++) {
                    if (tickets[i].charAt(j) == '@' && j <= 14 && matchSymbolLeft.equals("@")) {
                        int count = 1;
                        for (int k = j + 1; k < tickets[i].length(); k++) {
                            if (tickets[i].charAt(k) == '@') {
                                count++;
                            }
                        }
                        if (count >= 6 && count < 10) {
                            rightSideJackpot = true;
                            matchRight = count;
                        } else if (count == 10) {
                            rightSideFullJackpot = true;
                            matchRight = count;
                        }
                    }
                    if (tickets[i].charAt(j) == '#' && j <= 14 && matchSymbolLeft.equals("#")) {
                        int count = 1;
                        for (int k = j + 1; k < tickets[i].length(); k++) {
                            if (tickets[i].charAt(k) == '#') {
                                count++;
                            }
                        }
                        if (count >= 6 && count < 10) {
                            rightSideJackpot = true;
                            matchRight = count;
                        } else if (count == 10) {
                            rightSideFullJackpot = true;
                            matchRight = count;
                        }
                    }
                    if (tickets[i].charAt(j) == '$' && j <= 14 && matchSymbolLeft.equals("$")) {
                        int count = 1;
                        for (int k = j + 1; k < tickets[i].length(); k++) {
                            if (tickets[i].charAt(k) == '$') {
                                count++;
                            }
                        }
                        if (count >= 6 && count < 10) {
                            rightSideJackpot = true;
                            matchRight = count;
                        } else if (count == 10) {
                            rightSideFullJackpot = true;
                            matchRight = count;
                        }
                    }
                    if (tickets[i].charAt(j) == '^' && j <= 14 && matchSymbolLeft.equals("^")) {
                        int count = 1;
                        for (int k = j + 1; k < tickets[i].length(); k++) {
                            if (tickets[i].charAt(k) == '^') {
                                count++;
                            }
                        }
                        if (count >= 6 && count < 10) {
                            rightSideJackpot = true;
                            matchRight = count;
                        } else if (count == 10) {
                            rightSideFullJackpot = true;
                            matchRight = count;
                        }
                    }
                }
            }
            if (leftSideJackpot && rightSideJackpot && !leftSideFullJackpot && !rightSideFullJackpot) {
                ticketsJackpot[i] = "ticket " + "\"" + tickets[i] + "\" - " + Math.min(matchLeft, matchRight) + matchSymbolLeft;
            } else if (leftSideFullJackpot && rightSideFullJackpot) {
                ticketsJackpot[i] = "ticket " + "\"" + tickets[i] + "\" - " + matchLeft + matchSymbolLeft + " Jackpot!";
            } else if (tickets[i].length() < 20) {
                ticketsJackpot[i] = "invalid ticket";
            } else if (tickets[i].length() == 20) {
                ticketsJackpot[i] = "ticket \"" + tickets[i] + "\" - no match";
            }
        }
        for (int i = 0; i < ticketsJackpot.length; i++) {
            System.out.printf("%s%n", ticketsJackpot[i]);
        }
    }
}
