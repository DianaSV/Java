package MyTestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTestNG2 {
    @BeforeClass
    public void beforeSession(){
        System.out.println("Before Class");
    }

    @Test(groups = "regression")
    public void test01(){
        System.out.println("MyTestNG2: test01 call REGRESSION");
    }

    @Test(groups = "sanity")
    public void test02(){
        System.out.println("MyTestNG2: test02 call SANITY");
    }

    @Test(groups = "sanity")
    public void test03(){
        System.out.println("MyTestNG2: test03 call SANITY");
    }


    public void test04(){
        System.out.println("MyTestNG2: test04 call NONE");
    }

    @Test(groups = "regression")
    public void test05(){
        System.out.println("MyTestNG2: test05 call REGRESSION");
    }
}
