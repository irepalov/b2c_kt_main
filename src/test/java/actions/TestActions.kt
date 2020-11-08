package actions

import core.DriverSettings
import screen.*
import screen.Application1Screen.cyrillicLastNameError
import screen.Application1Screen.cyrillicMidNameError
import screen.Application1Screen.cyrillicNameFieldError
import screen.Application1Screen.emptyFieldError
import screen.Application1Screen.symbQuantityError

class TestActions {

    private val smsCode000 = "0000"
    var errorMessages: Array<String> = arrayOf(
            symbQuantityError,
            emptyFieldError,
            cyrillicMidNameError,
            cyrillicLastNameError,
            cyrillicNameFieldError)

    fun toApplication1() {
        InstallmentScreen.clickByXpath(InstallmentScreen.sendRequestButton)
        ConfirmPhoneScreen.sendKeysById(ConfirmPhoneScreen.smsCodeField, smsCode000)
        ConfirmPassportScreen.clickByXpath(ConfirmPassportScreen.newUserButton)
        ConfirmPassportScreen.clickByXpath(ConfirmPassportScreen.proceedNewUserButton)
        ScanSuggestionScreen.clickByXpath(ScanSuggestionScreen.manualButton)
        }

    fun errorsNotVisibleApp1() {
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicMidNameError)
        Application1Screen.isNotVisibleByXpath(cyrillicLastNameError)
        Application1Screen.isNotVisibleByXpath(cyrillicNameFieldError)

    }
}