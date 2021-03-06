package commonLibs.implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementControl {
    WebDriver driver;
    public ElementControl(WebDriver driver){
        this.driver=driver;
    }

    protected void waitUntilElementIsClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void waitUntilElementIsVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void setText(WebElement element,String text){
        waitUntilElementIsClickable(element);
        element.sendKeys(text);
    }
    public void clickElement(WebElement element){
        waitUntilElementIsClickable(element);
        element.click();
    }
    protected void clickLink(WebElement element) {
        waitUntilElementIsVisible(element);
    }
    public String getText(WebElement element){
        waitUntilElementIsVisible(element);
       return element.getText();
    }
    public void clearText(WebElement element){
        element.clear();
    }
    public boolean isVisible(WebElement element){
      return  element.isDisplayed();
    }
    public boolean isEnabled(WebElement element){
        return  element.isEnabled();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public boolean isDisplayed(WebElement element){
        return  element.isDisplayed();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String getTextFromAlert(){
       return driver.switchTo().alert().getText();
    }
    public  void selectViaVisibleText(WebElement element,String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public  void selectViaValue(WebElement element,String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public  void selectViaIndex(WebElement element,int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    protected void clickElementByJavascriptExecutor(String xpath){
        WebElement element=driver.findElement(By.xpath(xpath));
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", element);
    }
    public Long scrollYPositionByJavascriptExecutor(){
        JavascriptExecutor j = (JavascriptExecutor) driver;
        Long value = (Long) j.executeScript("return window.pageYOffset;");
        return value;
    }
    public void scrollElementIntoViewByJavascriptExecutor(WebElement element){
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    public void freeze(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
