package com.autocomplete1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class autocomplete1 {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\thasleem\\.cache\\selenium\\chromedriver\\win32\\chrome-win64 (1)\\chrome-win64\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.way2automation.com/demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[text()='Registration'])[1]")).click();
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
						Actions a=new Actions(driver);
						a.sendKeys(e,"a").build().perform();
						Thread.sleep(1000);
						List<WebElement> list=driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
						String s="fortran";
						for(int i=0;i<list.size();i++)
						{
							Thread.sleep(1000);
							a.sendKeys(Keys.DOWN).build().perform();
							JavascriptExecutor js=(JavascriptExecutor)driver;
							String ss=	(String) js.executeScript("return arguments[0].value", e);
							String s1=list.get(i).getText();
							System.out.print(ss);
							if(s.equalsIgnoreCase(s1))
							{
								System.out.print(s1);
								break;
							
							}
										
						}
						
						a.sendKeys(Keys.ENTER).build().perform();
						driver.switchTo().defaultContent();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//a[normalize-space()='Multiple Values']")).click();
						driver.switchTo().frame(1);

						WebElement e1=driver.findElement(By.xpath("//input[@id='tags']"));
						Actions b=new Actions(driver);
						b.sendKeys(e1,"b").build().perform();
						List<WebElement> list1=driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]/li"));
						String s1="Ruby";
						for(int i=0;i<list1.size();i++)
						{
							Thread.sleep(1000);
							a.sendKeys(Keys.DOWN).build().perform();
							JavascriptExecutor js=(JavascriptExecutor)driver;
							String ss1=	(String) js.executeScript("return arguments[0].value", e1);
							String s2=list.get(i).getText();
							System.out.print(ss1);
							if(s.equalsIgnoreCase(s2))
							{
								System.out.print(s2);
								break;
							}
						}

						b.sendKeys(Keys.ENTER).build().perform();
						driver.switchTo().defaultContent();
						Thread.sleep(3000);
						

						
						
						

							}

						}
			}
		}
		 driver.quit();
	}
}





