package OOP02Ex005;

public class MainTraditional {
    public static void main(String[] args) {
        Israel israeli = new Israel();
        USA american = new USA();
        China chinese = new China();

        System.out.println("Traditional food for Israelis: " + israeli.myTraditionalFood());
        System.out.println("Traditional vacation for Israelis: " + israeli.myTraditionalVacation());
        System.out.println("Traditional language for Israelis: " + israeli.myTraditionalLanguage());

        System.out.println("Traditional food for American: " + american.myTraditionalFood());
        System.out.println("Traditional vacation for American: " + american.myTraditionalVacation());
        System.out.println("Traditional language for American: " + american.myTraditionalLanguage());

        System.out.println("Traditional food for Chinese: " + chinese.myTraditionalFood());
        System.out.println("Traditional vacation for Chinese: " + chinese.myTraditionalVacation());
        System.out.println("Traditional language for Chinese: " + chinese.myTraditionalLanguage());
    }
}
