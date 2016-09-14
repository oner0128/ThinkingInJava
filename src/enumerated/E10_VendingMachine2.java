package enumerated;

import io.TextFile;
import sun.nio.cs.Surrogate;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import static enumerated.Input.*;
/**
 * Created by hrong on 2016/9/12.
 */
enum Category{
    MONEY(NICKEL,DIME,QUARTER,DOLLAR),
    ITEM_SELECTION(TOOTHPASTE,CHIPS,SODA,SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;
    Category(Input... types) {
        values=types;
    }
    private static EnumMap<Input,Category> categories=new EnumMap<Input, Category>(Input.class);
    static {
        for (Category c:Category.values()){
            for (Input type:Input.values())
                categories.put(type,c);
        }
    }
    public static Category categorize(Input input){
        return categories.get(input);
    }
}
 class VendingMachine2 {
    private static class Context {
        private State state = State.RESTING;
        private int amount;
        private Input selection;
    }private static Map<Machine,Context> em =
            Collections.synchronizedMap(
                    new EnumMap<Machine,Context>(Machine.class));
    static {
        for(Machine m : Machine.values())
            em.put(m, new Context());
    }
    enum Machine { M1, M2, M3 }
    private static final ReentrantLock lock =
            new ReentrantLock();
    private static State state;
    private static int amount;
    private static Input selection;
    enum StateDuration { TRANSIENT } // Tagging enum
    enum State {
        RESTING {
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },ADDING_MONEY {
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if(amount < selection.amount())
                            System.out.println("Insufficient money for " + selection);
                        else state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:}
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if(amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },TERMINAL { void output() {
            System.out.println("Halted"); } };
        private boolean isTransient = false;
        State() {}
        State(StateDuration trans) { isTransient = true; }
        void next(Input input) {
            throw new RuntimeException("Only call " +
                    "next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }
        void output() {
            System.out.println(amount); }
    }
//    static void run(Surrogate.Generator<Input> gen, Machine m) {
//        Context ctx = em.get(m);
//        while(ctx.state != State.TERMINAL) {
//            lock.lock();
//            state = ctx.state;
//            amount = ctx.amount;
//            selection = ctx.selection;
//            try {
//                state.next(gen.next());
//                while(state.isTransient)
//                    state.next();
//                state.output();ctx.state = state;
//                ctx.amount = amount;
//                ctx.selection = selection;
//                em.put(m, ctx);
//            } finally {
//                lock.unlock();
//            }
//            Thread.yield();
//        }
//    }



}
//public class E10_VendingMachine2{
//    public static void main(String[] args) {
//        for(final VendingMachine2.Machine m :
//                VendingMachine2.Machine.values()) {
////            Surrogate.Generator<Input> gen = new RandomInputGenerator();
//            if(args.length == 1)
//                gen = new FileInputGenerator(args[0]);
////            final Surrogate.Generator<Input> g = gen;
//            new Thread(new Runnable() {
//                public void run() { VendingMachine2.run(g, m); }
//            }).start();
//
//        }
//    }
//}
//class RandomInputGenerator implements Surrogate.Generator<Input>{
//    public Input next(){
//        return Input.randomSelection();
//    }
//}
//class FileInputGenerator implements Surrogate.Generator<Input>{
//    private Iterator<String> input;
//
//    public FileInputGenerator(String fileName) {
//        input =new TextFile(fileName,";").iterator();
//    }
//    public Input next(){
//        if (!input.hasNext())return null;
//        return Enum.valueOf(Input.class,input.next().trim());
//    }
//}
