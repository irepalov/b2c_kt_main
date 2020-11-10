package core

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.conditions.ExactTextCaseSensitive
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement


open class TestHelper: DriverSettings() {

    /**********
     * Клики
     */


    fun clickByXpath(elementXpath: String) { //ВОТ ЭТОТ РАБОТАЕТ
        `$`(By.xpath(elementXpath)).shouldBe(enabled).click()
    }

    fun clickNotClickableById(id: String) {
        `$`(By.id(id)).click()
    }

    fun clickNotClickableByXpath(xpath: String) {
        `$`(By.xpath(xpath)).click()
    }


                                      //DOUBLE CLICKS\\

    fun doubleClickById(id: String) {
        `$`(By.id((id))).doubleClick()
    }




                                      //IS DISPLAYED\\

    fun isDisplayedByXpath(elementXpath: String): Boolean {
        `$`(By.xpath(elementXpath)).isDisplayed
        return true
    }

    fun isDisplayedById(id: String): Boolean {
        `$`("#$id").isDisplayed
        return true
    }

    fun isDisplayedByLinkText(text: String): Boolean {
        `$`(byLinkText("#$text")).isDisplayed
        return true
    }

    fun isDisplayedByClass(className: String): Boolean {
        `$`(byClassName("#$className")).isDisplayed
        return true
    }

    fun isDisplayedByText(text: String): Boolean {
        `$`(byText("#$text")).isDisplayed
        return true
    }

                                          //NOT VISIBLE\\
    fun isNotVisibleByXpath(xpath: String) {
        `$`(By.xpath(xpath)).shouldNotBe(visible)
    }

    fun areNotVisibleByXpath(xpath: String) {
        `$`(By.xpath(xpath)).shouldNotBe(visible)
    }



    fun isNotVisibleById(id: String) {
        `$`(By.id(id)).shouldNotBe(visible)
    }

                                          //HAS TEXT\\

    fun hasTextByXpath(elementXpath: String, elementText: String) {
        `$`(By.xpath(elementXpath)).shouldHave(exactTextCaseSensitive(elementText))
    }

    fun hasTextById(elementId: String, text: String) {
        `$`(By.id(elementId)).shouldHave(exactTextCaseSensitive(text))
    }


                                       //SHOULD BE EMPTY\\

    fun isEmptyByXpath(elementXpath: String) {
        `$`(By.xpath(elementXpath)).shouldBe(empty)
    }


    fun isEmptyById(elementId: String) {
        `$`(By.id(elementId)).shouldBe(empty)
    }

                                        //SHOULD NOT BE EMPTY AND SHOULD HAVE VALUE/TEXT\\
    fun hasEnteredTextById(id: String, text: String) {
        `$`(By.id(id)).has(ExactTextCaseSensitive(text))
    }

    fun isNotEmptyById(id: String) {
        `$`(By.id(id)).shouldNotBe(empty)
    }

                                           //PRESS SOME KEYS\\
    fun pressTab(id: String) {
        `$`(By.id(id)).pressTab()
    }

    fun pressBackSpaceById(id: String) {
        `$`(By.id(id)).sendKeys(Keys.BACK_SPACE)
    }

    fun pressBackSpaceByClass(className: String) {
        `$`(By.className(className)).sendKeys(Keys.BACK_SPACE)
    }

    fun ctrlABackSpaceById(id: String) {
        `$`(By.id(id)).sendKeys(Keys.chord(Keys.CONTROL, "a"))
        `$`(By.id(id)).sendKeys(Keys.BACK_SPACE)
    }


    //fun pressBackSpaceTillDisplayedByClass (id: String, changesAttribute: String) {
        //var elementStatus = `$`(By.id(id)).has(exactText(changesAttribute)
        //while (!elementStatus) {
           // pressBackSpaceById(id)++

       // }

   // }




                                        //\\IS DISAPPEARED\\
    fun disappearedById(id: String, text: String) {
        `$`(By.id(id)).should(disappear)
    }

    fun disappearedByXpath(xpath: String) {
        `$`(By.xpath(xpath)).should(disappear)
    }

                                        //\\IS APPEARED\\
    fun textAppearedById(id: String, text: String){
         `$`(By.id(id)).should(appear).has(exactTextCaseSensitive(text))
    }


                                       //\\IS VISIBLE//\\

    fun isVisibleByXpath(elementXpath: String) {
        `$`(By.xpath(elementXpath)).shouldBe(visible)
    }

    fun isVisibleById(elementId: String) {
        `$`(By.id(elementId)).shouldBe(visible)
    }

    fun isVisibleByClass(elementClass: String) {
        `$`(By.className(elementClass)).shouldBe(visible)
    }


    fun isTextVisibleByClass(elementClass: String, elementText: String) {
        `$`(By.className(elementClass)).shouldBe(visible).shouldBe(exactTextCaseSensitive(elementText))
    }

    fun isTextVisibleByXpath(elementXpath: String, elementText: String) {
        `$`(By.xpath(elementXpath)).shouldBe(visible).shouldBe(exactTextCaseSensitive(elementText))
    }



                                          //SEND KEYS\\

    fun sendKeysById(elementId: String, typeText: String) {
        `$`(By.id(elementId)).setValue(typeText)
    }


                                         //CLEAR FIELD\\

    fun clearFieldById(id: String) {
        `$`(By.id(id)).clear()
    }




    //ждем пока элемент исчезнет
    fun waitUntilDisappearsById(id: String) {
        `$`("#$id").should(disappear)
    }

    //ждем, когда элемент получит текст
   // fun waitWhenElementGetTextById(id: String, text: String?) {
    //    `$`("#$id").shouldHave(text)
    //}

    protected open fun findByText(text: String?) {

    }


    protected open fun clickWithTimeOut(id: String?) {
        var timeout = 0
        while (timeout < 30) {
            timeout = try {
                `$`(id).shouldBe(enabled).click()
                30
            } catch (e: Exception) {
                `$`(id).shouldBe(enabled).click()
                timeout + 2
            }
        }
    }







    /*fun assertCodeError() {
        val element = getDriver().findElement(By.ById(errorCodeID)).text
        Assert.assertEquals(element, errorCodeText)
    }

    fun clickConfirmCode() {
        getDriver().findElement(By.ById(confirmCodeBtnID)).click()
    }
     */


}