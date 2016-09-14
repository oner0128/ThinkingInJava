package string;

import java.util.Formatter;

/**
 * Created by hrong on 2016/7/13.
 */
public class Receipt {
    private double total=0;
    private Formatter formatter=new Formatter(System.out);
    private static final int itemWidth=15;
    private static final int qtyWidth=5;
    private static final int priceWidth=10;
    private static final String TITLE_FORMAT="%-"+itemWidth+"s %-"+qtyWidth+"s %-"+priceWidth+"s\n";
    private static final String PRINT_FORMAT="%-"+itemWidth+".15s %-"+qtyWidth+"d %-"+priceWidth+".2f\n";
    private static final String TOTAL_FORMAT="%-"+itemWidth+"s %-"+qtyWidth+"s %-"+priceWidth+".2f\n";
    public void printTitle(){
        formatter.format(TITLE_FORMAT,"Item","Qty","Price");
        formatter.format(TITLE_FORMAT,"----","----","----");
    }
    public void print(String name,int qty,double price){
        formatter.format(PRINT_FORMAT,name,qty,price);
        total+=price;
    }
    public void printTotal(){
        formatter.format(TOTAL_FORMAT,"Tax","",total*0.06);
        formatter.format(TITLE_FORMAT,"----","","----");
        formatter.format(TOTAL_FORMAT,"Total","",total*1.06);
    }

    public static void main(String[] args) {
        Receipt receipts=new Receipt();
        receipts.printTitle();
        receipts.print("apple dsf dssdf sdf sfd ",5,5.10);
        receipts.print("Beans",4,7.25);
        receipts.print("Three Bears Porridge",1,14.29);
        receipts.printTotal();
    }
}
