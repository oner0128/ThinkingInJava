package enumerated;

import java.util.EnumMap;

/**
 * Created by hrong on 2016/9/12.
 */
interface Commond{boolean handle(Mail m);}
public class E09_PostOffice2 {
    enum MailHandler {
        GENERAL_DELIVERY,MACHINE_SCAN,VISUAL_INSPECTION,FORWARD_ADDRESS,RETURN_TO_SENDER
    }
    static EnumMap<MailHandler,Commond> em=new EnumMap<MailHandler, Commond>(MailHandler.class);
    static {
        em.put(MailHandler.GENERAL_DELIVERY, new Commond() {
            @Override
            public boolean handle(Mail m) {
                switch (m.generalDelivery){
                    case YES:
                        System.out.println("Using general delivery for"+ m);
                        return true;
                    default:return false;
                }
            }
        });
        em.put(MailHandler.MACHINE_SCAN, new Commond() {
            @Override
            public boolean handle(Mail m) {
                switch (m.scannability){
                    case UNSCANNABLE:return false;
                    default:
                        switch (m.address){
                            case INCORRECT:return false;
                            default:
                                System.out.println("Delivering "+m+" automatically");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.VISUAL_INSPECTION, new Commond() {
            @Override
            public boolean handle(Mail m) {
                switch (m.readability){
                    case ILLEGIBLE:return false;
                    default:
                        switch (m.address){
                            case INCORRECT:return false;
                            default:
                                System.out.println("Delivery "+m+" normally");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.FORWARD_ADDRESS, new Commond() {
            @Override
            public boolean handle(Mail m) {
                switch (m.forwardAddress){
                    case MISSING:return false;
                    default:
                        System.out.println("Forward "+m+"to other address");
                        return true;
                }
            }
        });
        em.put(MailHandler.RETURN_TO_SENDER, new Commond() {
            @Override
            public boolean handle(Mail m) {
                switch (m.returnAddress){
                    case MISSING:return false;
                    default:
                        System.out.println("Returning "+m+" to sender");
                        return true;
                }
            }
        });
    }
    static void handle(Mail m){
        for (MailHandler handler:MailHandler.values()){
            if (em.get(handler).handle(m))
                return;
        }
        System.out.println(m+" is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail mail:Mail.generator(10)){
            System.out.println(mail.details());
            handle(mail);
            System.out.println("--------------");
        }
    }
}
