import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderPage;
import org.junit.Assert.*;

public class SecondOrferButton {
    private WebDriver driver;
    private pages.MainPage mainPage;
    private OrderPage orderPage;
    public static final String SCOOTER_URL ="https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        driver.get(SCOOTER_URL);
        driver.manage().window().maximize();
        mainPage.clickButtonCookie();
    }
//Скролл и клик на нижнюю кнопку "Заказать" и проверка наличия ожидаемого текста
    @Test
    public void testSecondOrderButton() {
        mainPage.scrollAndClickOrderDownButton();
        orderPage.assertOrderDoneTextVisible();
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
