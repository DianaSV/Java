package Collections;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static List createNewList(String[] arr){

        List<String> tempList = new ArrayList<String>();

        for(int i =0; i<arr.length; i++){
            tempList.add(arr[i]);
        }

        return tempList;
    }

    public static void main(String[] args) {

        String[] myCountries = {"China", "Czech Republic", "Russia", "Hungary"};
        List<String> countries = createNewList(myCountries);

        // 2
        for(String country : countries)
            System.out.print(country + ", ");

        // 3
        System.out.println("\n" + countries.size());

        // 4
        countries.set(3, "Germany");
        for(String country : countries)
            System.out.print(country + ", ");

        // 5
        if(countries.contains("Germany"))
            System.out.println("\n" + countries.indexOf("Germany"));
        else
            System.out.println("NO");

        // 6
        System.out.println(countries.get(countries.size()-1));
        System.out.println();

        // 7
        String[] countriesIWantToGo = {"USA", "England", "Poland"};
        List<String> countriesIWantToGoTo = createNewList(countriesIWantToGo);

        countries.addAll(countriesIWantToGoTo);
        for(String country : countries)
            System.out.print(country + ", ");
    }
}
