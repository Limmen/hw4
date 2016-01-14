/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limmen.hw4.view;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author kim
 */
public class ViewTest {
    private WebDriver driver;
    private String baseUrl;
    public ViewTest() {
    }
    
    @Before
    public void setUp() {
        driver  = new FirefoxDriver();
    }
    //This test need to be run after deployment to application server
    @Ignore
    @Test
    public void testView(){
        driver.navigate().to("http://localhost:8080/hw4/");        
        Assert.assertEquals("HomeWork4 - Currency converter", driver.getTitle());
        //FromCurrencySelector
        Assert.assertTrue(driver.findElements(By.name("j_idt6:j_idt11")).size() > 0);
        //ToCurrencySelector
        Assert.assertTrue(driver.findElements(By.name("j_idt6:j_idt13")).size() > 0);
        //AmountFrom
        Assert.assertTrue(driver.findElements(By.id("j_idt6:convertFrom")).size() > 0);
        //AmountTo
        Assert.assertTrue(driver.findElements(By.id("j_idt6:convertTo")).size() > 0);
        //SubmitButton
        Assert.assertTrue(driver.findElements(By.name("j_idt6:j_idt17")).size() > 0);
        
        Select CurrencyFrom = new Select(driver.findElement(By.name("j_idt6:j_idt11")));
        Select CurrencyTo = new Select(driver.findElement(By.name("j_idt6:j_idt13")));
        CurrencyFrom.selectByValue("SEK");
        CurrencyTo.selectByValue("GBP");
        driver.findElement(By.id("j_idt6:convertFrom")).sendKeys("421.89");
        driver.findElement(By.name("j_idt6:j_idt17")).click();
        Assert.assertEquals(72.42572F, Float.parseFloat(driver.findElement(By.id("j_idt6:convertTo")).getAttribute("value")),0);
        
        CurrencyFrom = new Select(driver.findElement(By.name("j_idt6:j_idt11")));
        CurrencyTo = new Select(driver.findElement(By.name("j_idt6:j_idt13")));
        CurrencyFrom.selectByValue("USD");
        CurrencyTo.selectByValue("EUR");
        driver.findElement(By.id("j_idt6:convertFrom")).sendKeys("22.9");
        driver.findElement(By.name("j_idt6:j_idt17")).click();
        Assert.assertEquals(21.652866F, Float.parseFloat(driver.findElement(By.id("j_idt6:convertTo")).getAttribute("value")),0);
        
        
        
    }

}
