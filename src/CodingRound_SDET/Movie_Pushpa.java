package CodingRound_SDET;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class Movie_Pushpa {
	WebDriver driver;
	@Test(priority=1)
	public void startUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D://Driver//chromedriver.exe");
		driver=new ChromeDriver();
		Reporter.log("Application Open");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.imdb.com/title/tt9389998/");
		Reporter.log("URL Entered");
		driver.findElement(By.xpath("//li[@data-testid='title-details-releasedate']//a[@aria-label='See more']")).click();
		Thread.sleep(2000);
		Reporter.log("clicked on Realeased date");
		
		List<WebElement>listofCountry=driver.findElements(By.xpath("//*[@id='releaseinfo_content']/table[1]/tbody/tr/td/a"));
		List<WebElement>listDates=driver.findElements(By.xpath("//*[@id='releaseinfo_content']/table[1]/tbody/tr/td[2]"));
		String countr= "";
		String date = null;
		
		for(int i=0; i<=listofCountry.size()-1;i++)
		{
			String country=listofCountry.get(i).getText();
			String	dates=listDates.get(i).getText();
			if(country.equals("India")&& dates.equals("17 December 2021"))
			{
				System.out.println(country);
				System.out.println(dates);
				countr= country;
				date=dates;
			}
			
		}
	System.out.println(countr);
	System.out.println(date);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		Thread.sleep(2000);
		Reporter.log("URL Entered");
		String ReleaseDate=driver.findElement(By.xpath("//*[@id='mw-content-text']/div[1]/table[1]/tbody/tr[12]/td/div/ul/li")).getText();
		String Country=driver.findElement(By.xpath("//*[@id='mw-content-text']/div[1]/table[1]/tbody/tr[14]/td")).getText();
		if(ReleaseDate.equals(date)&&Country.equals(countr))
		{
			System.out.println("Test Pass");
		}


		Thread.sleep(2000);
		Reporter.log(" Clicked on Country of origin");
		driver.close();
		
	}
	


}
