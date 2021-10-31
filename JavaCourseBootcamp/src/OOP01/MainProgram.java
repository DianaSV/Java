package OOP01;

public class MainProgram {
    public static void main(String[] args) {

        MobileDevice myMobile = new MobileDevice("MI Pocophone", 'A',
                8.23, true, 1400, 6, 13);

        MobileDevice momMobile = new MobileDevice("MI Pocophone", 'A',
                8.23, true, 1400, 3,10);
        int returnedArea;

        myMobile.printParameters();
        returnedArea = myMobile.calculateArea();
        System.out.println(returnedArea);
        myMobile.pictureQuality();


        momMobile.printParameters();
    }
}
