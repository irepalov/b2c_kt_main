package screen

import core.TestHelper

object ConfirmPassportScreen: TestHelper() {

    const val newUserButton = "//button[contains(text(),'Я НОВЫЙ КЛИЕНТ')]"
    const val newUserButtonText = "НЕТ, Я НОВЫЙ КЛИЕНТ"
    const val confirmPassNumTitle = "//div[contains(text(),'в целях безопасности, введите номер паспорта')]"
    const val confirmPassNumTitleText = "Алексей, в целях безопасности, введите номер паспорта, остальные данные мы загрузим из вашей прошлой анкеты"
    const val passNumNotMatchTitle = "//div[contains(text(), 'номер паспорта не соответствует номеру телефона')]"
    const val passNumNotMatchTitleText = "Данный номер паспорта не соответствует номеру телефона. Продолжите оформление как новый клиент."
    const val proceedNewUserButton = "//button[contains(text(), ' ПРОДОЛЖИТЬ КАК НОВЫЙ КЛИЕНТ')]"
    const val proceedNewUserButtonText = "ПРОДОЛЖИТЬ КАК НОВЫЙ КЛИЕНТ"
}