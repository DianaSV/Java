package Lesson02;

public class DebugExample {
    public static void main(String[] args) {
        String[] names = {"Rami", "Diana", "Jondi", "Yonatan", "Rolan", "Eldar" };
        String maxName = names[0];

        for(int i = 0; i < names.length; i++){
            if(names[i].length() > maxName.length())
                maxName = names[i];

        }

        System.out.println("The name is: " + maxName);
        System.out.println("The length is: " + maxName.length());
    }
}
