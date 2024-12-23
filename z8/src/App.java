import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных клиента
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(customerName, phoneNumber);

        // Создаем заказ
        Order order = new Order(customer);

        // Добавляем пиццы в заказ
        boolean addingPizzas = true;
        while (addingPizzas) {
            System.out.println("Choose pizza type: 1. Regular 2. Calzone");
            int pizzaTypeChoice = scanner.nextInt();
            scanner.nextLine();  // Считывание оставшегося символа новой строки после nextInt()

            PizzaType pizzaType = (pizzaTypeChoice == 1) ? PizzaType.REGULAR : PizzaType.CALZONE;

            System.out.print("Enter pizza name: ");
            String pizzaName = scanner.nextLine();

            Pizza pizza = new Pizza(pizzaName, pizzaType);

            boolean addingIngredients = true;
            while (addingIngredients) {
                System.out.println("Add ingredient: 1. Tomato Paste 2. Cheese 3. Salami 4. Bacon 5. Corn 6. Pepperoni");
                int ingredientChoice = scanner.nextInt();
                scanner.nextLine();  // Считывание оставшегося символа новой строки после nextInt()

                Ingredient ingredient = null;
                switch (ingredientChoice) {
                    case 1:
                        ingredient = Ingredient.TOMATO_PASTE;
                        break;
                    case 2:
                        ingredient = Ingredient.CHEESE;
                        break;
                    case 3:
                        ingredient = Ingredient.SALAMI;
                        break;
                    case 4:
                        ingredient = Ingredient.BACON;
                        break;
                    case 5:
                        ingredient = Ingredient.CORN;
                        break;
                    case 6:
                        ingredient = Ingredient.PEPPERONI;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        continue;
                }

                pizza.addIngredient(ingredient);

                System.out.print("Do you want to add another ingredient? (y/n): ");
                String continueAdding = scanner.nextLine();
                if (!continueAdding.equalsIgnoreCase("y")) {
                    addingIngredients = false;
                }
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // Считывание оставшегося символа новой строки после nextInt()
            pizza.setQuantity(quantity);

            order.addPizza(pizza);

            System.out.print("Do you want to add another pizza? (y/n): ");
            String continueAddingPizza = scanner.nextLine();
            if (!continueAddingPizza.equalsIgnoreCase("y")) {
                addingPizzas = false;
            }
        }

        // Печать чека
        Printer.printCheck(order);

        scanner.close();
    }
}
