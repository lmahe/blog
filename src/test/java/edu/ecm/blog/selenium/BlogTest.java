package edu.ecm.blog.selenium;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BlogTest {
	private WebDriver webDriver;

	
	@Before
	   public void init() {
	       // création du pilote firefox
	       webDriver = new FirefoxDriver();
	   }

	   @After
	   public void close() {
	       // fermeture du navigateur
	       webDriver.close();
	   }
	
	@Test
	public void home() {
	   // on navigue vers la home
		webDriver.navigate().to("http://localhost:8081/index");

	   // on vérifie le title
		Assert.assertEquals("Mon blog", webDriver.getTitle());
	}
}
