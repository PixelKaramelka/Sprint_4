package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Assert.*;
import java.time.Duration;



public class OrderPage {
    private WebDriver driver;
    //конструктор
    public OrderPage (WebDriver driver){

        this.driver = driver;
    }

    private By forWhomScooterText = By.xpath("//*[text()='Для кого самокат']");//локатор заголовка "Для кого самокат"
    private By firstNameField = By.xpath("//input[@placeholder='* Имя']");//локатор поля "Имя"
    private By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");//локатор поля "Фамилия"
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");//локатор поля "Адрес:Куда привезти"
    private By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");//локатор поля "Станция метро"
    private By metroStation = By.xpath("//*[text()='Сокольники']"); // выбор станции
    private By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");//Локатор поля "телефон"

   private By nextButton = By.xpath("//button[contains(text(),'Далее') and contains(@class,'Button_Button__ra12g')]");

    //клик по кнопке Далее
    public void clickNextButton(){

        driver.findElement(nextButton).click();
    }

    //методы заполнения полей данными
    public void setFirstname(String firstName){

        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName){

        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddress(String address){

        driver.findElement(addressField).sendKeys(address);
    }
    public void setMetroStation(){
        driver.findElement(metroStationField).click();
        driver.findElement(metroStation).click();
    }

    public void setPhoneNumber(String phoneNumber){

        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    //заполнение всех полей одним методом
    public void fillOrderForm1 (String firstName, String lastName, String address, String phoneNumber){
        setFirstname(firstName);
        setLastName(lastName);
        setAddress(address);
        setMetroStation();
        setPhoneNumber(phoneNumber);
    }

    //проверка,что форма для кого самокат открылась
public void assertOrderDoneTextVisible(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement checkStatusTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(forWhomScooterText));
    Assert.assertTrue("Текст 'Заказ оформлен' не виден", checkStatusTextElement.isDisplayed());
}
}
