package OOPS02Ex004;

public class FamilyMain {
    public static void main(String[] args) {
        Child1 firstChild = new Child1("Choubaev", "Diana");
        Child2 secondChild = new Child2("Choubaev", "kuku");

        firstChild.printData();
        secondChild.printData();
    }
}
