package com.autocomplete;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
public class autocomplete {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C://Users//thasleem//Dropbox//PC//Downloads//edgedriver_win64 (1)//EdgeDriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.way2automation.com/demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[text()='Registration'])[1]")).click();
		Thread.sleep(3000);
		Set<String> wh=driver.getWindowHandles();
		Iterator<String> i1=wh.iterator();
		String mainwindow=driver.getWindowHandle();
		System.out.print(mainwindow);
		System.out.print(wh);

		while(i1.hasNext())
		{
			String childwindow=i1.next(); 
			if(!mainwindow.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='load_box']//a[@class='fancybox'][normalize-space()='ENTER TO THE TESTING WEBSITE']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div/div[2]/ul/li[2]/a/figure")).click();
				Set<String> wh1=driver.getWindowHandles();
				Iterator<String> i2=wh1.iterator();
				while(i2.hasNext())
				{
					String childwindow1=i2.next(); 
					if(!mainwindow.equalsIgnoreCase(childwindow1) && !childwindow.equalsIgnoreCase(childwindow1))
					{
						driver.switchTo().window(childwindow1);
						Thread.sleep(3000);
						driver.switchTo().frame(0);
						WebElement e=driver.findElement(By.xpath("(//*[@id='tags'])[1]"));
						Actions a =new Actions(driver);
						a.sendKeys(e," a").build().perform();
						Thread.sleep(1000);
						for(int i=0;i<4;i++)
						{
							a.sendKeys(Keys.DOWN).build().perform();

						}
						a.sendKeys(Keys.ENTER).build().perform();
						driver.switchTo().defaultContent();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//a[normalize-space()='Multiple Values']")).click();
						Thread.sleep(3000);
						driver.switchTo().frame(1);

						WebElement e1=driver.findElement(By.xpath("//input[@id='tags']"));
						Actions b=new Actions(driver);
						b.sendKeys(e1,"b").build().perform();
						Thread.sleep(3000);
						for(int i=0;i<4;i++)
						{
							b.sendKeys(Keys.DOWN).build().perform();
						}
						b.sendKeys(Keys.ENTER).build().perform();
						driver.switchTo().defaultContent();
						Thread.sleep(3000);

					}
					
				}
			}
		}
	}
}


