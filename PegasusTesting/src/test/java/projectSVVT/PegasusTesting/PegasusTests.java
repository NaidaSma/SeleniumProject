package projectSVVT.PegasusTesting;

import static org.junit.jupiter.api.Assertions.*;


import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
@TestMethodOrder(OrderAnnotation.class)
class PegasusTests {
	private static WebDriver webDriver;
	private static String baseUrl;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mravi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		webDriver=new ChromeDriver();
		baseUrl="https://www.flypgs.com/en";
		webDriver.manage().window().maximize();
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

 @Test 
	@Order(1)
	//RADI
	void radioButtonsTest() throws InterruptedException {
		webDriver.get(baseUrl);
		WebElement radioButtonReturn=webDriver.findElement(By.xpath("//*[@id=\"fligth-searh\"]/div[1]/div[1]/div/div[1]/div"));
		WebElement radioButtonOneWay=webDriver.findElement(By.xpath("//*[@id=\"fligth-searh\"]/div[1]/div[1]/div/div[2]/div"));
		radioButtonOneWay.click();
		Thread.sleep(5000);
	}
	
	@Test
	@Order(2)
	//RADI
	void DropDownMore() throws InterruptedException{
		webDriver.get(baseUrl);
		WebElement dropMore=webDriver.findElement(By.xpath("//*[@id=\"divHeaderCurrency\"]/div/div/div/div[1]/ul/li[6]"));
		dropMore.click();
		WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(5));
		WebElement waitforDropDown=wait.until(
		ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"divHeaderCurrency\"]/div/div/div/div[1]/ul/li[6]/div/div/div/ul/li[1]/div")
				));		
		String keyword=webDriver.getPageSource();
		assertTrue(keyword.contains("Flight Information"));
		Thread.sleep(4000);
	}

	@Test
	@Order(3)
	//RADI
    void searchTest() throws InterruptedException{
		WebElement inputBox = webDriver.findElement(By.xpath("//*[@id=\"divHeaderCurrency\"]/div/div/div/div[2]/ul/li[3]/a"));
		inputBox.click();
		WebElement input=webDriver.findElement(By.cssSelector("#key_search"));
		input.sendKeys("Services");
		Thread.sleep(4000);
		WebElement button=webDriver.findElement(By.cssSelector("#search-form > button"));
		button.click();
		Thread.sleep(5000);
		webDriver.navigate().back();
		Thread.sleep(3000);
	}
	
	
	@Test
	@Order(4)
	//RADI
	void BolBolTesting()throws InterruptedException {
		webDriver.get(baseUrl);
		WebElement bolbol=webDriver.findElement(By.cssSelector("#divHeaderCurrency > div > div > div > div.nxm2_menu > ul > li.nxm2_menu-bolbol"));
		bolbol.click();
		String currentUrl=webDriver.getCurrentUrl();
		assertEquals("https://www.flypgs.com/en/bolbol", currentUrl);
		Thread.sleep(4000);
	}
	
	 @Test
	@Order(5)
	//RADI
	void JoinForFreeButtonTest ()throws InterruptedException {
		 webDriver.get("https://www.flypgs.com/en/bolbol");
		 String handle=webDriver.getWindowHandle();
		JavascriptExecutor js= (JavascriptExecutor) webDriver;
		WebElement buttonJoin=webDriver.findElement(By.linkText("JOIN FOR FREE"));
		js.executeScript("arguments[0].click()", buttonJoin);
		for(String handle2:webDriver.getWindowHandles()) {
			webDriver.switchTo().window(handle2);
			break;
		}
		Thread.sleep(5000);
		webDriver.switchTo().window(handle);
		Thread.sleep(3000);
		
	}
	 
	@Test
	@Order(6)
	//RADI
	void SignUpPageTest()throws InterruptedException {
		webDriver.get("https://web.flypgs.com/signup?language=EN");
		WebElement name=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[1]/div[1]/div/div/div/input"));
		name.sendKeys("Naida");
		Thread.sleep(2000);
		WebElement surname=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[1]/div[2]/div/div/div/input"));
		surname.sendKeys("Smailbegović");
		Thread.sleep(2000);
		WebElement country=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/div/button"));
		country.isSelected();
		WebElement phone=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[1]/div[3]/div/div[2]/div[1]/div/div/input"));
		phone.sendKeys("63");
		Thread.sleep(2000);
		WebElement number=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[1]/div[3]/div/div[2]/div[2]/div/div/input"));
		number.sendKeys("966888");
		Thread.sleep(2000);
		WebElement email=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[1]/div[4]/div/div/div/input"));
		email.sendKeys("naida.sma@gmail.com");
		Thread.sleep(2000);
		WebElement sendsms=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[2]/div[3]/div[1]/label/span[1]/span/input"));
		WebElement sendemail=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[2]/div[3]/div[2]/label/span[1]/span/input"));
		sendemail.click();
		Thread.sleep(2000);
		WebElement agree=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[4]/label/span[1]/span/input"));
		agree.isSelected();
		WebElement button=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[5]/div"));
		button.click();
		Thread.sleep(2000);
		WebElement signIn=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[6]/button/div"));
		signIn.click();
		Thread.sleep(3000);
	}
	@Test
    @Order(7)
	//RADI
	void SignUpToSignIn() throws InterruptedException {
		webDriver.get("https://web.flypgs.com/signup?language=EN");
		WebElement signIn=webDriver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[2]/div/form/div/div[3]/div[6]/button/div"));
		signIn.click();
		webDriver.navigate().to("https://web.flypgs.com/login");
		String signInUrl=webDriver.getCurrentUrl();
		assertEquals("https://web.flypgs.com/login", signInUrl);
		Thread.sleep(3000);
  }
	@Test
	@Order(8)
	//RADI
	void cityPickerTest()throws InterruptedException {
		webDriver.get(baseUrl);
		WebElement from=webDriver.findElement(By.xpath("//*[@id=\"nxm-360-departure\"]/div[1]/div"));
		from.click();
		WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(5));
		WebElement thisCity=webDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[2]/ul/li[1]/div/form/div[2]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[3]/ul/li[1]/div[1]"));
		JavascriptExecutor js= (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].click()", thisCity);
		Thread.sleep(2000);
		WebElement to=webDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[2]/ul/li[1]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[1]"));
		js.executeScript("arguments[0].click()", to);
		Thread.sleep(2000);
		WebElement CityTo=webDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[2]/ul/li[1]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[3]/div[1]/div/input"));
		CityTo.sendKeys("Sarajevo");	
		Thread.sleep(2000);
		WebElement ThisCityTo=webDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[2]/ul/li[1]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[3]/div[2]/div[3]/ul/li/div[1]"));
		ThisCityTo.click();
		Thread.sleep(2000);
	}
	
	  @Test
		@Order(9)
		//RADI
		void datePickerTest()throws InterruptedException {
		  webDriver.get(baseUrl);
		  JavascriptExecutor js= (JavascriptExecutor) webDriver;
		  js.executeScript("window.scrollBy(0, 130)");
		  WebElement openingDatePicker=webDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[2]/ul/li[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/span"));
			js.executeScript("arguments[0].click()", openingDatePicker);
			Thread.sleep(7000);
			WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(5));
			WebElement DepartureDatePicker=wait.until(
					ExpectedConditions.visibilityOfElementLocated
					(By.xpath("/html/body/div[1]/div[5]/div/div/div[2]/ul/li[1]/div/form/div[2]/div[2]/div[1]/div/div[2]/div/div[1]")));	
			Actions builder=new Actions(webDriver);
			Action choosingDateOfDeparture= builder
					.moveToElement(DepartureDatePicker)
					.moveByOffset(-30, 90)
					.click()
					.build();
			choosingDateOfDeparture.perform();
			WebElement ReturningDatePicker=webDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[2]/ul/li[1]/div/form/div[2]/div[2]/div[2]/div/div[2]/div/div[2]"));
			Action choosingReturnDate=builder
					.moveToElement(ReturningDatePicker)
					.moveByOffset(0, 0)
					.click()
					.build();
			choosingReturnDate.perform();
			Thread.sleep(7000);
	  }
	  @Test
    @Order(10)
	//RADI
	void passengersTesting ()throws InterruptedException {
		webDriver.get(baseUrl);
		String startingValue = webDriver.findElement(By.cssSelector("#fligth-searh > div.nxm-360-search-container > div.row.search_flight-datepicker-container > div:nth-child(3) > div > div.nxm2_passenger-select-box > ul > li:nth-child(1) > div > input")).getAttribute("value");
		WebElement result=webDriver.findElement(By.cssSelector("#fligth-searh > div.nxm-360-search-container > div.row.search_flight-datepicker-container > div:nth-child(3) > div > div.nxm2_passenger-select-box > div > span.caption > span"));
		JavascriptExecutor js= (JavascriptExecutor) webDriver;
		WebElement plus=webDriver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div/div[2]/ul/li[1]/div/form/div[2]/div[2]/div[3]/div/div[2]/ul/li[1]/div/a[2]"));
		int beforeClick = Integer.parseInt(startingValue);
		System.out.println("value of the counter before click is: " + beforeClick);
		js.executeScript("arguments[0].click()", plus);
		Thread.sleep(5000);
		String value = webDriver.findElement(By.cssSelector("#fligth-searh > div.nxm-360-search-container > div.row.search_flight-datepicker-container > div:nth-child(3) > div > div.nxm2_passenger-select-box > ul > li:nth-child(1) > div > input")).getAttribute("value");
		int afterClick = Integer.parseInt(value);
		System.out.println("value of the counter after click is : " + afterClick);
		if(afterClick > beforeClick){
		    System.out.println("Value is changed.");
		}else{
		    System.out.println("Value didn't change.");
		}
		Thread.sleep(5000);
		
	}
	 
	
	@Test
    @Order(11)
	//RADI
	void languagePickerTest() throws InterruptedException{
		webDriver.get(baseUrl);
		WebElement language=webDriver.findElement(By.xpath("//*[@id=\"divHeaderCurrency\"]/div/div/div/div[2]/ul/li[4]"));
		language.click();
		WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(5));
		WebElement dropLanguages=wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.cssSelector("#divHeaderCurrency > div > div > div > div.nxm2_header-right > ul > li.nxm2_language > div > ul")
						));
		dropLanguages.findElement(By.linkText("DE")).click();
		Thread.sleep(3000);
	}
	

	
	
	  @Test
	    @Order(12)
		void novi ()throws InterruptedException{
		  
	  }
	  
}

