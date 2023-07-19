package org.btaTests;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class travelPolicies {

    @Test
    public void travelPolicyTest() {

        //can be changed for whichever type of countries/activities are necessary
        String country = "Indija";
        String targetCountry = "Visa Pasaule";
        String activity = "Sports";

        System.setProperty("selenide.browser", "firefox"); //I used firefox for testing, can be commented out if firefox is not installed
        open("https://www.bta.lv/");
        $(By.xpath("/html/body/div[1]/section/div/div[3]/button[3]")).click(); //accepts the cookies, can be commented out if the cookie pop-up isn't active
        $(By.xpath("/html/body/div[1]/main/section[1]/div/div/div[3]/a[2]")).click();
        $(By.id("regionalSelectorRegion-open")).click();
        $(By.id("regionalSelectorCountry-showListSearch")).click();
        $(By.id("regionalSelectorCountry-addCountry")).click();
        $(By.id("regionalSelectorCountry-typedValue")).val(country);
        $(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[1]/div/div/div[2]/div/div/aside/div/span/div/div[3]/aside/div/div[2]/div[2]/div[2]/button[79]")).click();
        $(By.id("regionalSelectorCountry-applyButton")).click();
        //check if the form has changed from choosing India
            $(By.cssSelector(".select>.button .text-icon")).shouldHave(exactText(targetCountry));
        $(By.id("travelActivities-open")).click();
        $(By.id("travelActivities-popup-select-option-3")).click();
        //check if activity is changed to "sport"
            $(By.id("travelActivities-open")).shouldHave(exactText(activity));
        $(By.xpath("/html/body/div[1]/main/section[2]/div/div/section/div[7]/div")).click();
        $(By.id("form-travel-policy")).shouldBe(visible);
        $(By.xpath("//*[@id=\"form-travel-policy\"]/section/div[2]/button[2]")).click();
        //check for the pop-up form
            $(By.xpath("//*[@id=\"page-one-travel\"]/div[1]/aside/div/button")).click();
        $(By.xpath("//*[@id=\"form-travel-policy\"]/section/div[2]/button[1]")).click();
        //check if the name, last name and identity number fields are empty
            $(By.id("travelerFirstName0-text")).shouldBe(empty);
            $(By.id("travelerLastName0-text")).shouldBe(empty);
            $(By.id("travelerIdentityNumber0-text")).shouldBe(empty);

    }

}
