package enumerated;

/**
 * Created by hrong on 2016/9/11.
 */
public class E03_Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (Course course: Course.values()){
                Food food=course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---------");
        }
    }
}
