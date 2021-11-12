package Methods.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        String command = scan.nextLine();
        while (!command.equals("end")) {
            if (command.contains("exchange")) {
                boolean isValid = true;
                String[] exchange = command.split(" ");
                for (int i = 0; i < exchange[1].length(); i++) {
                    if (exchange[1].charAt(i) < 48 || exchange[1].charAt(i) > 57) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) {
                    System.out.println("Invalid index");
                } else {
                    int exchangeNumber = Integer.parseInt(exchange[1].replaceAll("[^0-9]", ""));
                    if (exchangeNumber >= 0 && exchangeNumber <= numbers.length - 1) {
                        for (int rotation = 1; rotation <= exchangeNumber + 1; rotation++) {
                            //Ротация
                            //1. Вземам първи елемент
                            int firstElement = numbers[0];
                            //2. Местя всички елементи с един наляво(индексът на елементът = индекс - 1)
                            for (int index = 0; index < numbers.length - 1; index++) {
                                numbers[index] = numbers[index + 1];
                            }
                            //3. Последният индекс = първия елемент
                            numbers[numbers.length - 1] = firstElement;
                        }
                    } else {
                        System.out.println("Invalid index");
                    }
                }
            }
            if (command.equals("max even") || command.equals("max odd")) {
                int maxValue = Integer.MIN_VALUE;
                int bestIndex = 0;
                int count = 0;
                if (command.equals("max even")) {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] >= maxValue && numbers[i] % 2 == 0) {
                            maxValue = numbers[i];
                            bestIndex = i;
                            count++;
                        }
                    }
                }
                if (command.equals("max odd")) {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] >= maxValue && numbers[i] % 2 != 0) {
                            maxValue = numbers[i];
                            bestIndex = i;
                            count++;
                        }
                    }
                }
                if (count > 0) {
                    System.out.println(bestIndex);
                } else {
                    System.out.println("No matches");
                }
            }
            if (command.equals("min even") || command.equals("min odd")) {
                int minValue = Integer.MAX_VALUE;
                int bestIndex = 0;
                int count = 0;
                if (command.equals("min even")) {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] <= minValue && numbers[i] % 2 == 0) {
                            minValue = numbers[i];
                            bestIndex = i;
                            count++;
                        }
                    }
                }
                if (command.equals("min odd")) {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] <= minValue && numbers[i] % 2 != 0) {
                            minValue = numbers[i];
                            bestIndex = i;
                            count++;
                        }
                    }
                }
                if (count > 0) {
                    System.out.println(bestIndex);
                } else {
                    System.out.println("No matches");
                }
            }

            if ((command.contains("first") && command.contains("even")) || (command.contains("first") && command.contains("odd"))) {
                String[] firstCommand = command.split(" ");
                int firstIndex = Integer.parseInt(firstCommand[1].replaceAll("[^0-9]", ""));
                List<Integer> firstArray = new ArrayList<>();
                int count = 0;
                boolean isValid = true;
                for (int i = 0; i < firstCommand[1].length(); i++) {
                    if (firstCommand[1].charAt(i) < 48 || firstCommand[1].charAt(i) > 57) {
                        isValid = false;
                        break;
                    }
                }
                if (firstIndex > numbers.length || !isValid) {
                    System.out.println("Invalid count");
                }
                if (command.contains("first") && command.contains("even") && firstIndex <= numbers.length && isValid) {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 == 0) {
                            firstArray.add(numbers[i]);
                            firstIndex--;
                            count++;
                            if (firstIndex == 0) {
                                break;
                            }
                        }
                    }
                    System.out.print("[");
                    for (int i = 0; i < firstArray.size(); i++) {
                        if (count == 1) {
                            count--;
                            System.out.printf("%d", firstArray.get(i));
                        }
                        if (count > 1) {
                            count--;
                            System.out.printf("%d, ", firstArray.get(i));
                        }
                    }
                    System.out.println("]");
                }
                if (command.contains("first") && command.contains("odd") && firstIndex <= numbers.length && isValid) {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 != 0) {
                            firstArray.add(numbers[i]);
                            firstIndex--;
                            count++;
                            if (firstIndex == 0) {
                                break;
                            }
                        }
                    }
                    System.out.print("[");
                    for (int i = 0; i < firstArray.size(); i++) {
                        if (count == 1) {
                            count--;
                            System.out.printf("%d", firstArray.get(i));
                        }
                        if (count > 1) {
                            count--;
                            System.out.printf("%d, ", firstArray.get(i));
                        }
                    }
                    System.out.println("]");
                }
            }

            if ((command.contains("last") && command.contains("even")) || (command.contains("last") && command.contains("odd"))) {
                String[] lastCommand = command.split(" ");
                int lastIndex = Integer.parseInt(lastCommand[1].replaceAll("[^0-9]", ""));
                List<Integer> lastArray = new ArrayList<>();
                int count = 0;
                boolean isValid = true;
                for (int i = 0; i < lastCommand[1].length(); i++) {
                    if (lastCommand[1].charAt(i) < 48 || lastCommand[1].charAt(i) > 57) {
                        isValid = false;
                        break;
                    }
                }
                if (lastIndex > numbers.length || !isValid) {
                    System.out.println("Invalid count");
                }
                if (command.contains("last") && command.contains("even") && lastIndex <= numbers.length && isValid) {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 == 0) {
                            lastArray.add(numbers[i]);
                            lastIndex--;
                            count++;
                            if (lastIndex == 0) {
                                break;
                            }
                        }
                    }
                    System.out.print("[");
                    for (int i = 0; i < lastArray.size(); i++) {
                        if (count == 1) {
                            count--;
                            System.out.printf("%d", lastArray.get(i));
                        }
                        if (count > 1) {
                            count--;
                            System.out.printf("%d, ", lastArray.get(i));
                        }
                    }
                    System.out.println("]");
                }
                if (command.contains("last") && command.contains("odd") && lastIndex <= numbers.length && isValid) {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 != 0) {
                            lastArray.add(numbers[i]);
                            lastIndex--;
                            count++;
                            if (lastIndex == 0) {
                                break;
                            }
                        }
                    }
                    System.out.print("[");
                    for (int i = 0; i < lastArray.size(); i++) {
                        if (count == 1) {
                            count--;
                            System.out.printf("%d", lastArray.get(i));
                        }
                        if (count > 1) {
                            count--;
                            System.out.printf("%d, ", lastArray.get(i));
                        }
                    }
                    System.out.println("]");
                }
            }


            command = scan.nextLine();
        }
        int count = numbers.length;
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            if (count == 1) {
                System.out.printf("%d", numbers[i]);
            }
            if (count > 1) {
                count--;
                System.out.printf("%d, ", numbers[i]);
            }
        }
        System.out.println("]");
    }
}
