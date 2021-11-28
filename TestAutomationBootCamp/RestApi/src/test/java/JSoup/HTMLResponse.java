package JSoup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class HTMLResponse {
    Document doc;

    @BeforeClass
    public void startSession() throws IOException {
        WebDriverManager.chromedriver().setup();
        doc = Jsoup.connect("https://www.ebay.com/").get();
    }

    @Test
    public void test01(){
        Assert.assertEquals(doc.getElementById("gh-logo").attr("width"), "250");
    }

    @Test
    public void test02(){
        Assert.assertEquals(doc.getElementById("gh-logo").attr("height"), "200");
    }

    @Test
    public void test03(){
        Assert.assertEquals(doc.getElementsByAttributeValue("id", "gh-cat").get(0).text(), "All Categories");
    }
}
