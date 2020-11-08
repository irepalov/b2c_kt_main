package screen

import core.TestHelper


object ConfirmPhoneScreen: TestHelper() {
    //smsCodeTitle
    const val smsCodeTitle = "//div[contains(text(),'Для продолжения введите код, отправленный на номер')]" //xpath
    const val smsCodeTitleText = "Для продолжения введите код, отправленный на номер"
    const val smsCodeField = "mat-input-0"

}