package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert.*;
import java.time.Duration;
import org.openqa.selenium.Keys;


public class AboutRentPage {
    private WebDriver driver;
    //Конструктор

    public AboutRentPage(WebDriver driver) {

        this.driver=driver;
    }

    //Локатор формы "Про аренду"
    private By deliveryDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']"); //локатор поля "Когда привезти самокат"
    private By rentalPeriod = By.className("Dropdown-control");;//Локатор поля "Cрок аренды"
    private By scooterColor = By.className("Order_Checkboxes__3lWSI");//Локатор поля "цвет самоката"
    private By colorBlackPearl = By.id("black");  //Локатор цвета чекбокса "серая безысходность"
    private By colorGrayDesolation = By.id("grey");//Локатор цвета чекбокса "черный жемчуг"
    private By commentCourierField = By.xpath("//input[@placeholder='Комментарий для курьера']");//локатор поля "комментарий для курьера"
    private By orderButton = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']"); // локатор кнопки "заказать"
    private By backButton = By.xpath("//button[contains(text(),'Назад')]");// локатор кнопки "назад"
    private By checkStatusButton = By.xpath("//button[contains(text(),'Посмотреть статус')]"); //локатор кнопки посмотреть статус

    private By confirmOrder = By.xpath("//button[contains(text(),'Да')]");//локатор окна "Хотите оформить заказ?"
    private By yesButton = By.xpath("//button[contains(text(),'Да')]"); // локатор кнопки "да"
        private By noButton = By.xpath("//button[contains(text(),'Нет')]");   //локатор кнопки "нет"
    private By orderDoneText = By.xpath("//*[contains(text(),'Заказ оформлен')]");//локатор заголовка "Заказ оформлен"

    //методы заполнения полей данными
    public void setDeliveryDate(String deliveryDate) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement date = wait.until(
                ExpectedConditions.elementToBeClickable(deliveryDateField));
        date.click();
        date.sendKeys(deliveryDate);
        date.sendKeys(Keys.ENTER);
    }
    public void setRentalPeriod(String period) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(rentalPeriod)).click();
        By option = By.xpath("//div[contains(text(),'" + period + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void setScooterColor(String scooterColor){
        if (scooterColor.equals("черный жемчуг")) {
            driver.findElement(colorBlackPearl).click();
        }
        if (scooterColor.equals("серая безысходность")) {
            driver.findElement(colorGrayDesolation).click();
        }
    }
    public void setCommentCourier(String comment){
driver.findElement(commentCourierField).sendKeys(comment);
}

    //заполнение всех полей одним методом
    public void fillOrderForm2(String deliveryDate,String rentalPeriod, String scooterColor, String commentCourier){
    setDeliveryDate(deliveryDate);
    setRentalPeriod(rentalPeriod);
    setScooterColor(scooterColor);
    setCommentCourier(commentCourier);
}

//клики
//клик по кнопке "да"
public void clickYesButton() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
}

    //клик по кнопке "назад"
    public void clickBackButton() {
        driver.findElement(backButton).click();
    }
        //клик по кнопке "нет"
        public void clickNoButton () {
            driver.findElement(noButton).click();
        }
            // клик по кнопке "заказать"
            public void clickOrderButton() {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(orderButton)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrder));
            }

    //клик по кнопке "посмотреть статус"
            public void clickCheckStatusButton () {
                driver.findElement(checkStatusButton).click();
            }

            //проверка, что в окне "заказ оформлен" появляется кнопка "посмотреть статус"
            public void assertCheckStatusButtonVisible() {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement button = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(checkStatusButton)
                );
                Assert.assertTrue("Кнопка 'Посмотреть статус' не видна",
                        button.isDisplayed());
            }

            //проверка, что заголовок "заказ оформлен" виден
            public void assertOrderDoneTextVisible () {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
                WebElement checkStatusTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(orderDoneText));
                Assert.assertTrue("Текст 'Заказ оформлен' не виден", checkStatusTextElement.isDisplayed());


        }
    }
