package week3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day3Home {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
				
				// maximize the window 
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Login to the leaftaps
				driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("demosalesmanager");
				driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
		List<WebElement> options= driver.findElements(By.xpath("//li[@class='sectionTabButtonUnselected']"));
		for(WebElement links:options)
		{
			System.out.println(links.getText());
		}
options.get(1).click();
driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[1]")).click();
Set<String> windows=driver.getWindowHandles();
List<String> navi=new ArrayList<String>(windows);
driver.switchTo().window(navi.get(1));
driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
driver.switchTo().window(navi.get(0));
//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//wait.until(ExpectedConditions.elementToBeClickable
//driver.findElement(By.xpath("//input[@name='ComboBox_partyIdTo']")).sendKeys("yeja");
driver.findElement(By.xpath("//input[@name='partyIdTo']/following::img[1]")).click();
Set<String> windows1=driver.getWindowHandles();
List<String> navi1=new ArrayList<String>(windows1);
driver.switchTo().window(navi1.get(1));
driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//div[1]/a[1]")).click();
driver.switchTo().window(navi1.get(0));
driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
Alert alert = driver.switchTo().alert();
alert.accept();
System.out.println(driver.getTitle());
String expected ="Merge Contacts | opentaps CRM";
		String actual =driver.getTitle();
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("verified");
		}
		else
		{
			System.out.println("failed");
		}
		driver.quit();
	}

}
