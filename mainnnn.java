import java.util.*;

class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        // TODO: Initialize fields
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    double calculateFinalPrice() {
        // TODO: Provide base implementation
        return this.price;
    }
}

class Electronics extends Product {
    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return this.price + (this.price * 0.18)+1000;
    }
}

class Clothing extends Product {
    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return this.price + (this.price * 0.05)-(this.price * 0.10);
    }
}

class Book extends Product {
    Book(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return this.price + (this.price * 0.05);
    }
}

public class mainnnn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int productId = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();
            String category = sc.next();

            Product product;
            switch (category) {
                case "Electronics":
                    product = new Electronics(productId, name, price);
                    break;
                case "Clothing":
                    product = new Clothing(productId, name, price);
                    break;
                case "Book":
                    product = new Book(productId, name, price);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid category: " + category);
            }

            System.out.printf(product.name + ": %.2f%n", product.calculateFinalPrice());
        }
    }
}