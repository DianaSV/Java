package OOPExCitizens;

public class Soldier extends Citizen{

    int hogerNumber;
    String weapon;


    @Override
    public String toString() {
        return "Soldier{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                ", hogerNumber=" + hogerNumber +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    public Soldier(String name, int id, int age, int salary, int hogerNumber, String weapon) throws Exception {
        super(name, id, age, salary);

        this.weapon = weapon;

        if(age <18 || age > 21)
            System.out.println("Soldier age should be between 18 - 21.");
        else
            this.age = age;

        int count = 0; // to count how many '9' in the hoger number
        int tempOriginalHoger = hogerNumber, tempHogerForCounting = hogerNumber;
        while(tempOriginalHoger != 0){
            if(tempOriginalHoger % 10 == 9)
                count ++;
            if(count == 3){
                System.out.println("The number of Hoger can't contain more then 3 '9'.");
                throw new Exception("Throwed by exception: The number of Hoger can't contain more then 3 '9'.");
            }
            tempOriginalHoger /= 10;
        }

        this.hogerNumber = hogerNumber;

    }

}
