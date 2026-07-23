import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.AboutRentPage;
import pages.OrderPage;
import org.junit.Assert.*;
import java.awt.*;



    @RunWith(Parameterized.class)
    public class OrderTestParameterized{

        private WebDriver driver;
        private MainPage mainPage;
        private OrderPage OrderPage;
        private AboutRentPage AboutRentPage;

        private final String firstName;
        private final String lastName;
        private final String address;
        private final String metroStation;
        private final String phoneNumber;
        private final String deliveryDate;
        private final String rentalPeriod;
        private final String scooterColor;
        private final String commentCourier;

        public static final String SCOOTER_URL ="https://qa-scooter.praktikum-services.ru/";

        //конструктор
        public OrderTestParameterized(String firstName, String lastName,String address, String metroStation, String phoneNumber,String deliveryDate,String rentalPeriod, String scooterColor, String commentCourier){
            this.firstName=firstName;
            this.lastName=lastName;
            this.address=address;
            this.metroStation=metroStation;
            this.phoneNumber=phoneNumber;
            this.deliveryDate=deliveryDate;
            this.rentalPeriod=rentalPeriod;
            this.scooterColor=scooterColor;
            this.commentCourier=commentCourier;
        }

        @Parameterized.Parameters
        public static Object [][] getOrderData() {
            return new Object[][]{
                    {"Настя", "Жучок", "Москва", "Лубянка", "898923123123", "25.07.2026", "двое суток", "черный жемчуг", "Привет"},
                    {"Ким", "Пухлый", "Питер", "Лубянка", "898923123123", "28.07.2026", "трое суток", "серая безысходность", "Привет"}
            };
        }

        @Before
        public void setUp() {
            driver = new ChromeDriver(); // не проходит тест
            driver = new FirefoxDriver(); //тест проходит только в firefox
            mainPage=new MainPage(driver);
            OrderPage = new OrderPage(driver);
            AboutRentPage= new AboutRentPage(driver);
            driver.get(SCOOTER_URL);
            driver.manage().window().maximize(); // полноэкранный режим
            mainPage.clickButtonCookie(); // клик на куки

        }
        //Клик на верхнюю кнопку "заказать" и заполнение форм
        @Test
        public void testFullOrderByFirstButton() {
            mainPage.clickOrderUpButton();
            OrderPage.fillOrderForm1(firstName, lastName, address, phoneNumber);
            OrderPage.clickNextButton();
            AboutRentPage.fillOrderForm2(
                    deliveryDate,
                    rentalPeriod,
                    scooterColor,
                    commentCourier
            );
            AboutRentPage.clickOrderButton();
            AboutRentPage.clickYesButton();
            AboutRentPage.assertCheckStatusButtonVisible();
            AboutRentPage.assertCheckStatusButtonVisible();
            AboutRentPage.assertOrderDoneTextVisible();
        }
        @After
        public void tearDown(){

            driver.quit();
        }
    }
