import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCounter = 10000; // Статический счетчик для уникальных номеров заказов
    private int orderNumber;
    private Customer customer;
    private List<Pizza> pizzas;

    public Order(Customer customer) {
        this.orderNumber = orderCounter++;
        this.customer = customer;
        this.pizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    // Метод для расчета общей суммы заказа
    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (Pizza pizza : pizzas) {
            totalAmount += pizza.calculatePrice();
        }
        return totalAmount;
    }
}
