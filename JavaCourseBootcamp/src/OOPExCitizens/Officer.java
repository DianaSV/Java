package OOPExCitizens;

public class Officer extends Soldier {

    String role;
    int bonus;

    @Override
    public String toString() {
        return "Officer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                ", role='" + role + '\'' +
                ", bonus=" + bonus +
                ", hogerNumber=" + hogerNumber +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    public Officer(String name, String role, int id, int age, int salary, int hogerNumber, String weapon) throws Exception {
        super(name, id, age, salary, hogerNumber, weapon);

        this.role = role;

        if(age <21 || age > 57) {
            System.out.println("Officer age should be between 21 - 57.");
            throw new Exception("Throwed by exception: Officer age is wrong");
        }
        else
            this.age = age;

        switch (role){

            case "Modi'in":
                bonus = 2000;
                break;

            case "Hi'r":
                bonus = 5000;
                break;

            case "Eilit":
                bonus = 8000;
                break;

            default: bonus = 0;
        }

    }
}
