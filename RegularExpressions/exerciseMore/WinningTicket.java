package RegularExpressions.exerciseMore;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split(",\\s+");

        String regexSix = "@{6}|#{6}|\\${6}|\\^{6}";
        String regexSeven = "@{7}|#{7}|\\${7}|\\^{7}";
        String regexEight = "@{8}|#{8}|\\${8}|\\^{8}";
        String regexNine = "@{9}|#{9}|\\${9}|\\^{9}";
        String regexTen = "@{10}|#{10}|\\${10}|\\^{10}";

        Pattern patternTen = Pattern.compile(regexTen);
        Pattern patternNine = Pattern.compile(regexNine);
        Pattern patternEight = Pattern.compile(regexEight);
        Pattern patternSeven = Pattern.compile(regexSeven);
        Pattern patternSix = Pattern.compile(regexSix);
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String firstHalf = tickets[i].substring(0, tickets[i].length() / 2);
                String secondHalf = tickets[i].substring(tickets[i].length() / 2);
                Matcher matcherTenFirstHalf = patternTen.matcher(firstHalf);
                Matcher matcherNineFirstHalf = patternNine.matcher(firstHalf);
                Matcher matcherEightFirstHalf = patternEight.matcher(firstHalf);
                Matcher matcherSevenFirstHalf = patternSeven.matcher(firstHalf);
                Matcher matcherSixFirstHalf = patternSix.matcher(firstHalf);

                Matcher matcherTenSecondHalf = patternTen.matcher(secondHalf);
                Matcher matcherNineSecondHalf = patternNine.matcher(secondHalf);
                Matcher matcherEightSecondHalf = patternEight.matcher(secondHalf);
                Matcher matcherSevenSecondHalf = patternSeven.matcher(secondHalf);
                Matcher matcherSixSecondHalf = patternSix.matcher(secondHalf);
                if (matcherTenFirstHalf.find()) {
                    if (matcherTenSecondHalf.find() && matcherTenFirstHalf.group().charAt(0) == matcherTenSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", tickets[i], tickets[i].charAt(0));
                    } else if (matcherNineSecondHalf.find() && matcherTenFirstHalf.group().charAt(0) == matcherNineSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 9%c%n", tickets[i], matcherTenFirstHalf.group().charAt(0));
                    } else if (matcherEightSecondHalf.find() && matcherTenFirstHalf.group().charAt(0) == matcherEightSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 8%c%n", tickets[i], matcherTenFirstHalf.group().charAt(0));
                    } else if (matcherSevenSecondHalf.find() && matcherTenFirstHalf.group().charAt(0) == matcherSevenSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 7%c%n", tickets[i], matcherTenFirstHalf.group().charAt(0));
                    } else if (matcherSixSecondHalf.find() && matcherTenFirstHalf.group().charAt(0) == matcherSixSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 6%c%n", tickets[i], matcherTenFirstHalf.group().charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - no match%n", tickets[i]);
                    }
                } else if (matcherNineFirstHalf.find()) {
                    if ((matcherTenSecondHalf.find() && matcherNineFirstHalf.group().charAt(0) == matcherTenSecondHalf.group().charAt(0))
                            || (matcherNineSecondHalf.find() && matcherNineFirstHalf.group().charAt(0) == matcherNineSecondHalf.group().charAt(0))) {
                        System.out.printf("ticket \"%s\" - 9%c%n", tickets[i], matcherNineFirstHalf.group().charAt(0));
                    } else if (matcherEightSecondHalf.find() && matcherNineFirstHalf.group().charAt(0) == matcherEightSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 8%c%n", tickets[i], matcherNineFirstHalf.group().charAt(0));
                    } else if (matcherSevenSecondHalf.find() && matcherNineFirstHalf.group().charAt(0) == matcherSevenSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 7%c%n", tickets[i], matcherNineFirstHalf.group().charAt(0));
                    } else if (matcherSixSecondHalf.find() && matcherNineFirstHalf.group().charAt(0) == matcherSixSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 6%c%n", tickets[i], matcherNineFirstHalf.group().charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - no match%n", tickets[i]);
                    }
                } else if (matcherEightFirstHalf.find()) {
                    if ((matcherTenSecondHalf.find() && matcherEightFirstHalf.group().charAt(0) == matcherTenSecondHalf.group().charAt(0))
                    || (matcherNineSecondHalf.find() && matcherEightFirstHalf.group().charAt(0) == matcherNineSecondHalf.group().charAt(0))
                    || (matcherEightSecondHalf.find() && matcherEightFirstHalf.group().charAt(0) == matcherEightSecondHalf.group().charAt(0))) {
                        System.out.printf("ticket \"%s\" - 8%c%n", tickets[i], matcherEightFirstHalf.group().charAt(0));
                    } else if (matcherSevenSecondHalf.find() && matcherEightFirstHalf.group().charAt(0) == matcherSevenSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 7%c%n", tickets[i], matcherEightFirstHalf.group().charAt(0));
                    } else if (matcherSixSecondHalf.find() && matcherEightFirstHalf.group().charAt(0) == matcherSixSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 6%c%n", tickets[i], matcherEightFirstHalf.group().charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - no match%n", tickets[i]);
                    }
                } else if (matcherSevenFirstHalf.find()) {
                    if ((matcherTenSecondHalf.find() && matcherSevenFirstHalf.group().charAt(0) == matcherTenSecondHalf.group().charAt(0))
                    || (matcherNineSecondHalf.find() && matcherSevenFirstHalf.group().charAt(0) == matcherNineSecondHalf.group().charAt(0))
                    || (matcherEightSecondHalf.find() && matcherSevenFirstHalf.group().charAt(0) == matcherEightSecondHalf.group().charAt(0))
                    || (matcherSevenSecondHalf.find() && matcherSevenFirstHalf.group().charAt(0) == matcherSevenSecondHalf.group().charAt(0))) {
                        System.out.printf("ticket \"%s\" - 7%c%n", tickets[i], matcherSevenFirstHalf.group().charAt(0));
                    } else if (matcherSixSecondHalf.find() && matcherSevenFirstHalf.group().charAt(0) == matcherSixSecondHalf.group().charAt(0)) {
                        System.out.printf("ticket \"%s\" - 6%c%n", tickets[i], matcherSevenFirstHalf.group().charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - no match%n", tickets[i]);
                    }
                } else if (matcherSixFirstHalf.find()) {
                    if ((matcherTenSecondHalf.find() && matcherSixFirstHalf.group().charAt(0) == matcherTenSecondHalf.group().charAt(0))
                    || (matcherNineSecondHalf.find() && matcherSixFirstHalf.group().charAt(0) == matcherNineSecondHalf.group().charAt(0))
                    || (matcherEightSecondHalf.find() && matcherSixFirstHalf.group().charAt(0) == matcherEightSecondHalf.group().charAt(0))
                    || (matcherSevenSecondHalf.find() && matcherSixFirstHalf.group().charAt(0) == matcherSevenSecondHalf.group().charAt(0))
                    || (matcherSixSecondHalf.find() && matcherSixFirstHalf.group().charAt(0) == matcherSixSecondHalf.group().charAt(0))) {
                        System.out.printf("ticket \"%s\" - 6%c%n", tickets[i], matcherSixFirstHalf.group().charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - no match%n", tickets[i]);
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", tickets[i]);
                }
            }

        }
    }
}
