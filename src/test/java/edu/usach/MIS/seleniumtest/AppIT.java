package edu.usach.MIS.seleniumtest;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class AppIT {
    
    private static WebDriver driver = null;
    
    public AppIT() {
    }
    
    @BeforeClass
    public static void setUpClass() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver", "/home/nikonegima/Escritorio/selenium/chromedriver");
        ChromeDriverManager.getInstance().setup();
        //FirefoxDriverManager.getInstance().setup();
        driver = new ChromeDriver(); 
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability("jenkins.nodeName","(master)");
        driver = new RemoteWebDriver(new URL("http://10.42.219.14:4444/wd/hub"), capability);
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void comprobarFlujo() throws InterruptedException {
        driver.get("http://0.0.0.0/");
        //Creo un WebElement para encontrar una "input" determinado (Nombre)
        WebElement nombreElem = driver.findElement(By.id("nombre"));
        //Le digo a este elemento que mande las teclas que necesito para el Test
        nombreElem.sendKeys("Persona Test");
        //Lo hago con todas los "input" del formulario
        WebElement rutElem = driver.findElement(By.id("rut"));
        rutElem.sendKeys("111111111");
        WebElement emailElem = driver.findElement(By.id("email"));
        emailElem.sendKeys("test@test.com");
        WebElement carreraElem = driver.findElement(By.id("carrera"));
        carreraElem.sendKeys("Carrera imaginario para el Test");
        WebElement ingresoElem = driver.findElement(By.id("ingreso"));
        ingresoElem.sendKeys("1900");
        WebElement passwordElem = driver.findElement(By.id("password"));
        passwordElem.sendKeys("test");
        //Para probar la verificacion, debemos saber cuantos elementos hay en la tabla
            //El colapso de la tabla *seguramente* cuenta en el largo.
        int entradasPre = driver.findElements(By.xpath("//table[@name='tablaDatos']/tbody/tr")).size() * 2;
        //Realizo el click del boton Submit.
        WebElement btnSubmit = driver.findElement(By.name("aceptar"));
        btnSubmit.click();
        //Acepto la alerta emitida al enviar los datos
        Alert alerta = driver.switchTo().alert();
        alerta.accept();
        //Realizo la espera para que todo se procese (1.25 segundos)
        Thread.sleep(3250);
        //Ahora deberia revisar si hay un nuevo elemento en la tabla que muestra todos los elementos de la BD
        int entradasPost = driver.findElements(By.xpath("//table[@name='tablaDatos']/tbody/tr")).size() * 2;
        //Pasamos a la verificacion
        Assert.assertTrue("Se agrego un elemento en la base de datos", 
                entradasPost == entradasPre + 4);
        
    }
    
}
