package MyTestNG;

import org.testng.annotations.Test;

public class MyTestNG1 {

    @Test
    public void test01(){
        System.out.println("MyTestNG1: test01 call NONE");
    }

    @Test(groups = "sanity")
    public void test02(){
        System.out.println("MyTestNG1: test02 call SANITY");
    }

    @Test
    public void test03(){
        System.out.println("MyTestNG1: test03 call NONE");
    }
}
