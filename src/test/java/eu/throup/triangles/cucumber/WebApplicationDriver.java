package eu.throup.triangles.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.junit.Assert.assertEquals;

public class WebApplicationDriver implements ApplicationDriver {
    private final EventFiringWebDriver webDriver;

    public WebApplicationDriver() {
        this.webDriver = new EventFiringWebDriver(new HtmlUnitDriver(true));
    }

    @Override
    public void enterSides(double side1, double side2, double side3) {
        webDriver.get("http://localhost:9988/");
        setFieldValue("side1", side1);
        setFieldValue("side2", side2);
        setFieldValue("side3", side3);
    }

    private void setFieldValue(String field, double value) {
        String stringValue;

        if (Double.isNaN(value)) {
            stringValue = "NaN";
        } else if (Double.isInfinite(value)) {
            if (value > 0) {
                stringValue = "Infinity";
            } else {
                stringValue = "-Infinity";
            }
        } else {
            stringValue = String.valueOf(value);
        }

        setFieldValue(field, stringValue);
    }

    private void setFieldValue(String field, String value) {
        WebElement element = webDriver.findElement(By.id(field));
        element.clear();
        element.click();
        element.sendKeys(value);
    }

    @Override
    public void classify() {
        webDriver.findElement(By.id("classify")).submit();
    }

    @Override
    public void confirmResult(String expectedString) {
        String result = webDriver.findElement(By.id("result")).getText();
        assertEquals(result, "The triangle is " + expectedString + ".");
    }

    @Override
    public void close() {
        webDriver.close();
        webDriver.quit();
    }

    @Override
    public void confirmError(String errorMessage) {
        String result = webDriver.findElement(By.id("result")).getText();
        assertEquals(result, errorMessage);
    }
}

