package OOPExCitizens;

abstract public class Citizen {
    String name;
    int id;
    int age;
    int salary;


    public Citizen(String name, int id, int age, int salary){

        this.name = name;

        if(String.valueOf(id).length() > 9 || id % 2 == 0)
            System.out.println("Wrong ID.");
        else
            this.id = id;

        if(age < 0 || age > 120)
            System.out.println("Age has to be between 0 - 120.");
        else
            this.age = age;
        this.salary = salary;
    }
}
