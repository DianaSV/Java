package Lesson01;

public class DataTypesNonPrimitives01 {
    public static void main(String[] args) {

        String firstName = "Diana";
        String lastName = "Choubaev";
        String fullName = firstName + " " + lastName;
        int myAge = 25;

        Integer.toString(myAge);
        System.out.println(("My age is: ") + myAge);
        System.out.println(fullName);
        fullName = fullName.toUpperCase();
        System.out.println(fullName);
        System.out.println(fullName.length());
        System.out.println(fullName.equals(myAge));

    }
}
