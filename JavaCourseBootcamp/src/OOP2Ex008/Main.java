package OOP2Ex008;

public class Main {
    public static void main(String[] args) {

        Chrome chrome = new Chrome("8");
        chrome.callPrint();

        IE ie = new IE("6");
        ie.callPrint();

        Android android = new Android("1", 2341);
        android.callPrint();

        iOS ios = new iOS("2", 598);
        ios.callPrint();
    }
}
