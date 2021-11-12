package Lists.lab;

import java.util.*;

public class ListProducts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<String> products = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String productName = scan.nextLine();
            products.add(productName);
        }
        Collections.sort(products);
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, products.get(i));
        }
    }
}
