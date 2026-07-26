package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPage {
    private WebDriver driver;

    //конструктор
    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    private By logoYandex = By.xpath("//img[@alt='Scooter']"); //локатор логотипа самоката
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    } //клик на логотип
    private By orderUpButton = By.xpath("//button[contains(@class,'Button_Button')]");    //локатор верхней кнопки заказать
    //клик на верхнюю кнопку заказать
    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }

    private By statusOrder = By.xpath("//a[@class='Header_Link_1TAG7']");    //локатор кнопки "статус заказа"

    //клик по статусу заказа
    public void clickStatusOrder() {

        driver.findElement(statusOrder).click();
    }

    private By orderDownButton = By.xpath("(//button[contains(text(),'Заказать')])[2]");  //локатор нижней кнопки "заказать"

    //скролл до нижней кнопки "заказать" и клик на нее
    public void scrollAndClickOrderDownButton() {
        WebElement element = driver.findElement(orderDownButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        //ожидание
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(orderDownButton));
        element.click();
    }

    //клик на нижнюю кнопку "заказать"
    public void clickOrderDownButton() {
        driver.findElement(orderDownButton).click();
    }

    private final By buttonCookie = By.id("rcc-confirm-button");  //локатор кнопки куки

    //клик на кнопку куки
    public void clickButtonCookie() {
        driver.findElement(buttonCookie).click();
    }

    //локаторы списка-вопросы
    private By howMuchDoesItCostButton = By.id("accordion__heading-0");//Сколько это стоит?И как оплатить?
    private By iWantAFewScootersButton = By.id("accordion__heading-1");//Хочу сразу несколько самокатов! Так можно?
    private By calculateRentalTimeButton = By.id("accordion__heading-2");//Как рассчитывается время аренды?
    private By orderScooterTodayButton = By.id("accordion__heading-3");//Можно ли заказать самокат прямо на сегодня?
    private By extendTheRentalOfReturnButton = By.id("accordion__heading-4");//Можно ли продлить заказ или вернуть самокат раньше?
    private By youBringTheChangerButton = By.id("accordion__heading-5");//Вы привозите зарядку вместе с самокатом?
    private By canICancelTheOrderButton = By.id("accordion__heading-6");//Можно ли отменить заказ?
    private By iLiveOutsideButton = By.id("accordion__heading-7");  //Я живу за МКАДом, привезёте?
    //локаторы списка-ответы
    private By howMuchDoesItCostAnswer = By.xpath("//p[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или картой.')]"); //Локатор текста первой кнопки
    private By iWantAFewScootersAnswer = By.id("accordion__panel-1"); //Локатор текста второй кнопки
    private By calculateRentalTimeAnswer = By.id("accordion__panel-2"); //Локатор текста третьей кнопки
    private By orderScooterTodayAnswer = By.id("accordion__panel-3");//Локатор текста четвертой кнопки
    private By extendTheRentalOfReturnAnswer = By.id("accordion__panel-4");//Локатор текста пятой кнопки
    private By youBringTheChangerAnswer = By.id("accordion__panel-5");//Локатор текста шестой кнопки
    private By canICancelTheOrderAnswer = By.id("accordion__panel-6");//Локатор текста седьмой кнопки
    private By iLiveOutsideAnswer = By.id("accordion__panel-7"); //Локатор текста восьмой кнопки


    //методы для клика по кнопкам
    public void clickHowMuchDoesItCostButton() {
        driver.findElement(howMuchDoesItCostButton).click();
    }

    public void clickIWantAFewScootersButton() {
        driver.findElement(iWantAFewScootersButton).click();
    }

    public void clickCalculateRentalTimeButton() {
        driver.findElement(calculateRentalTimeButton).click();
    }

    public void clickOrderScooterTodayButton() {
        driver.findElement(orderScooterTodayButton).click();
    }

    public void clickExtendTheRentalOfReturnButton() {
        driver.findElement(extendTheRentalOfReturnButton).click();
    }

    public void clickYouBringTheChangerButton() {
        driver.findElement(youBringTheChangerButton).click();
    }

    public void clickCanICancelTheOrderButton() {
        driver.findElement(canICancelTheOrderButton).click();
    }

    public void clickILiveOutsideButton() {
        driver.findElement(iLiveOutsideButton).click();
    }

    //методы появляющего текста-ответов

    public String getHowMuchDoesItCostAnswer() {
        return driver.findElement(howMuchDoesItCostAnswer).getText();
    }
    public String getIWantAFewScootersAnswer() {
        return driver.findElement(iWantAFewScootersAnswer).getText();
    }
    public String getCalculateRentalTimeAnswer() {
        return driver.findElement(calculateRentalTimeAnswer).getText();
    }
    public String getOrderScooterTodayAnswer() {
        return driver.findElement(orderScooterTodayAnswer).getText();
    }
    public String getExtendTheRentalOfReturnAnswer() {
        return driver.findElement(extendTheRentalOfReturnAnswer).getText();
    }

    public String getYouBringTheChangerAnswer() {
        return driver.findElement(youBringTheChangerAnswer).getText();
    }

    public String getCanICancelTheOrderAnswer() {
        return driver.findElement(canICancelTheOrderAnswer).getText();
    }
    public String getILiveOutsideAnswer() {
        return driver.findElement(iLiveOutsideAnswer).getText();
    }
    private String closeDropDownLocatorFormat = "accordion__heading-%d";
    private String textInputLocatorFormat = "accordion__panel-%d";

    //Метод для клика по выпадающему тексту
    public void clickClosedDropDownByIndex(int index) {
        driver.findElement(
                By.id(String.format(closeDropDownLocatorFormat, index))).click();
    }
//метод для получение текста из поля
    public String getTextFromTextInputByIndex(int index) {
        By panel = By.id(String.format(textInputLocatorFormat, index));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(panel)
        );

        return element.getText();
    };

//метод скролла до начала таблицы и клика на первый элемент
public void scrollToTable(){
    WebElement element = driver.findElement(By.id("accordion__heading-0"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
}}