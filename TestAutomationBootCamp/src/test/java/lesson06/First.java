package lesson06;

import org.testng.annotations.*;

public class First {

    @BeforeClass
    public void test01(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void test02(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void test03(){
        System.out.println("test03");
    }

    @Test
    public void test04(){
        System.out.println("test04");
    }

    @AfterMethod
    public void test05(){
        System.out.println("AfterMethod");
    }

    @AfterClass
    public void test06(){
        System.out.println("AfterClass");
    }



}
