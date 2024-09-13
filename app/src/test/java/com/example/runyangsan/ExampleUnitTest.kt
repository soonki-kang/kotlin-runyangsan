package com.example.runyangsan

import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.AfterEach
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val driver:WebDriver = ChromeDriver()

    @Test
    fun testLoginForm() {
        driver.get("https://yangsancc.co.kr/_mobile/index.asp")
        driver.findElement(By.xpath("//*[@id='content']/div[2]/ul[1]/li[1]/a/img")).click()
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}