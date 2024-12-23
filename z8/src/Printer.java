public class Printer {
    public static void printCheck(Order order) {
        // Заголовок
        System.out.println("*****************************");
        System.out.println("Order: " + order.getOrderNumber());
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("*****************************");

        // Информация о каждой пицце в заказе
        for (Pizza pizza : order.getPizzas()) {
            System.out.println("Name: " + pizza.getName());
            System.out.println("------------------------");

            // Информация о типе основы пиццы и её стоимости
            System.out.println("Pizza Base: " + pizza.getPizzaType().getName() + " " + pizza.getPizzaType().getPrice() + " $");

            // Ингредиенты
            for (Ingredient ingredient : pizza.getIngredients()) {
                System.out.println(ingredient.getName() + " " + ingredient.getPrice() + " $");
            }

            // Количество пицц
            System.out.println("------------------------");
            System.out.println("Quantity: " + pizza.getQuantity());

            // Итоговая стоимость для этой пиццы
            System.out.println("Amount: " + pizza.calculatePrice() + " $");
            System.out.println("------------------------");
        }

        // Общая сумма заказа
        System.out.println("*****************************");
        System.out.printf("Total Amount: %.2f $", order.calculateTotalAmount());
        System.out.println("\n*****************************");
    }
}
