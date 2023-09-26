package task_3;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Order createOrderWithDiscount(double discount) {
        return new Order() {
            @Override
            public double calculateTotalPrice(int quantity) {
                double discountedPrice = price * (1 - discount);
                return quantity * discountedPrice;
            }
        };
    }

    public Order createOrderWithTax(double taxRate) {
        return (quantity) -> {
            double totalPrice = price * quantity;
            double taxAmount = totalPrice * taxRate;
            return totalPrice + taxAmount;
        };
    }

    interface Order {
        double calculateTotalPrice(int quantity);
    }

    public static void main(String[] args) {
        Book book = new Book("Книга 1", "Автор 1", 1);

        Order anonymousOrder = book.createOrderWithDiscount(0.2);
        double anonymousTotalPrice = anonymousOrder.calculateTotalPrice(1);
        System.out.println("Заказ с анонимным классом: " + anonymousTotalPrice);

        Order lambdaOrder = book.createOrderWithTax(0.08);
        double lambdaTotalPrice = lambdaOrder.calculateTotalPrice(1);
        System.out.println("Заказ с лямбда выражением: " + lambdaTotalPrice);
    }
}
