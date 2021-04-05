package io.cucumber.higea;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.pt.*;


public class testeGamaSteps{

    public WebDriver browser;

    public testeGamaSteps() {
        System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
        browser = new EdgeDriver();
    } 

   @Dado("que estou no site da gama academy {string}")
    public void que_estou_no_site_da_gama_academy(String string) {
        browser.get(string);
        browser.manage().window().maximize();
    }

    @Dado("fecho a popup")
    public void fecho_a_popup() throws InterruptedException{
        Thread.sleep(4000);
        WebElement input = browser.findElement( By.cssSelector(".ub-emb-close"));
        input.click();
    }
    
    @Dado("clico na opcao {string}")
    public void clico_na_opcao(String string) {
        WebElement input = browser.findElement( By.cssSelector("a[href='/sobre']"));
        input.click();
    }

    
    @Entao("devo ver o item {string}")
      public void devo_ver_o_item(String string) {
  		//assertEquals(true,Config.selectorQueryCss("manifesto.h1.heading.lado"));
        WebElement input = browser.findElement( By.xpath("/html/body/div[3]/div/div/div[1]/h1") );
  		assertEquals(string, input.getText());
  		input.click();
        browser.quit();
    }

}