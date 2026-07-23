import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderPage;
import org.junit.Assert.*;

//Проверка,что при нажатии на логотип попадаем на главную страницу
public class ScooterLogoTest {
    private WebDriver driver;
    private pages.MainPage mainPage;
    private pages.OrderPage orderPage;
    public static final String SCOOTER_URL ="https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp(){
        driver=new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage=new OrderPage(driver);
        driver.get(SCOOTER_URL);
        driver.manage().window().maximize(); //полноэкранный режим
        mainPage.clickButtonCookie(); // клик на кнопку куки
    }
    //Ожидаемый и Фактический результат не совпадает. Тест не пройден
    @Test
    public void testSecondOrderButton(){
        mainPage.scrollAndClickOrderDownButton(); //клик на логотип
        String expectedUrl ="https://qa-scooter.praktikum-services.ru/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);//проверка, что текущий url соответствует ожидаемому
    }
    @After
    public void tearDown(){

        driver.quit();
    }}
