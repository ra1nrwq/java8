public class Pizza {
    private static final int MAX_ALLOWED_INGREDIENTS = 7;

    private String name;
    private PizzaType pizzaType;
    private Ingredient[] ingredients;
    private int ingredientsCount;
    private int quantity;

    // Конструктор для создания пустой пиццы
    public Pizza(String name, PizzaType pizzaType) {
        this.name = name;
        this.pizzaType = pizzaType;
        this.ingredients = new Ingredient[MAX_ALLOWED_INGREDIENTS];
        this.ingredientsCount = 0;
        this.quantity = 1; // По умолчанию количество 1
    }

    // Конструктор для создания пиццы с готовым набором ингредиентов
    public Pizza(String name, PizzaType pizzaType, Ingredient[] ingredients, int quantity) {
        this.name = name;
        this.pizzaType = pizzaType;
        this.ingredients = ingredients;
        this.ingredientsCount = ingredients.length;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    // Устанавливаем количество пицц
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Метод для добавления ингредиента
    public void addIngredient(Ingredient ingredient) {
        // Проверяем, что не добавляем больше ингредиентов, чем разрешено
        if (ingredientsCount < MAX_ALLOWED_INGREDIENTS) {
            // Проверяем на наличие дубликатов
            for (int i = 0; i < ingredientsCount; i++) {
                if (ingredients[i] == ingredient) {
                    System.out.println("The pizza already contains this ingredient");
                    return;
                }
            }
            // Добавляем ингредиент в список
            ingredients[ingredientsCount] = ingredient;
            ingredientsCount++;
        } else {
            System.out.println("Cannot add more ingredients. Max limit reached.");
        }
    }

    // Метод для расчета стоимости пиццы
    public double calculatePrice() {
        double totalPrice = pizzaType.getPrice();
        for (int i = 0; i < ingredientsCount; i++) {
            totalPrice += ingredients[i].getPrice();
        }
        return totalPrice * quantity; // Учитываем количество пицц
    }
}
