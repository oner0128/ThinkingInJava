package enumerated;

/**
 * Created by hrong on 2016/9/11.
 */
public interface Food  {
    enum Appetizer implements Food{
        SALAD,SOUP,SPRING_ROLLS;
    }
    enum MainCourse implements Food{
        LASAGNE,BURRITO,PAD_THAI;
    }
    enum Beverage implements Food {
        BEER, VINE, JUICE, COLA, WATER;
    }
    enum Dessert implements Food{
        TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT;
    }
    enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,LATTE;
    }
}
