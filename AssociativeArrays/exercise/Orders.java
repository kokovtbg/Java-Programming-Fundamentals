package AssociativeArrays.exercise;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Double> productPrice = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productQuantity = new LinkedHashMap<>();

        String command = scan.nextLine();
        while (!command.equals("buy")) {
            String[] splitData = command.split(" ");
            String product = splitData[0];
            double price = Double.parseDouble(splitData[1]);
            int quantity = Integer.parseInt(splitData[2]);
            productPrice.put(product, price);
            if (productQuantity.containsKey(product)) {
                productQuantity.put(product, productQuantity.get(product) + quantity);
            } else {
                productQuantity.put(product, quantity);
            }

            command = scan.nextLine();
        }
        List<String> products = new ArrayList<>();
        List<Double> totalPrice = new ArrayList<>();
        List<Integer> totalQuantity = new ArrayList<>();
        for (Map.Entry<String, Double> entry : productPrice.entrySet()) {
            totalPrice.add(entry.getValue());
            products.add(entry.getKey());
        }
        for (Map.Entry<String, Integer> entry : productQuantity.entrySet()) {
            totalQuantity.add(entry.getValue());
        }
        for (int i = 0; i < totalPrice.size(); i++) {
            totalPrice.set(i, totalPrice.get(i) * totalQuantity.get(i));
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%s -> %.2f%n", products.get(i), totalPrice.get(i));
        }
    }
}
