package OOPExCitizens;

public class Main {
    public static void main(String[] args) throws Exception {

        Soldier Roni = null;
        Officer Natalie = null;

        try {
            Roni = new Soldier("Roni", 372856192, 20,
                    2000, 459239979, "M16");
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            Natalie = new Officer("Natalie", "Hi'r", 316401765, 54,
                    5000, 678345231, "Kalashnikov");
        }
        catch (Exception e) {}

        if(Roni != null)
            Roni.toString();
        if(Natalie != null)
            System.out.println(Natalie.toString());
    }
}
