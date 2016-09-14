package enumerated;

/**
 * Created by hrong on 2016/9/11.
 */
public enum  E04_Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    BEVERAGE(Food.Beverage.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    E04_Meal2(Class<? extends Food> kind) {
        values=kind.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(values);
    }
    public interface Food {
        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROLLS;
        }

        enum MainCourse implements Food {
            LASAGNE, BURRITO, PAD_THAI;
        }

        enum Beverage implements Food {
            BEER, VINE, JUICE, COLA, WATER;
        }

        enum Dessert implements Food {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT;
        }

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (E04_Meal2 course: E04_Meal2.values()){
                Food food=course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---------");
        }
    }
}
