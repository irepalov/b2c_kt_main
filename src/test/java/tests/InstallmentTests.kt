package tests

import actions.TestActions
import com.codeborne.selenide.Selenide.*
import core.DriverSettings
import org.junit.Before
import org.junit.Test
import screen.ConfirmPassportScreen
import screen.ConfirmPhoneScreen
import screen.InstallmentScreen
import screen.ScanSuggestionScreen

class InstallmentTests: DriverSettings() {

                                          //Тестовые данные\\
    private val button6 = ""
    private val button6Text = ""
    private val button12 = ""
    private val button12Text = ""
    private val button18 = ""
    private val button18Text = ""
    private val button24 = ""
    private val button24Text = ""
    private val smsCode000 = "0000"

    @Before
    fun setUp() {
        open("http://185.141.227.202")
        //close();
        //Configuration.baseUrl = "http://185.141.227.202";
        //Configuration.proxyEnabled = true;
        //Configuration.fileDownload = PROXY;
        //Configuration.reportsFolder = "/Users/Ivan/Desktop/webSelenideReports";
    }



    @Test
    fun button6Test() {
        //Assert: Открылся экран с надписью "Рассрочка, мес." (isVisible)

        //Assert: Кнопка "ОФОРМИТЬ ЗАЯВКУ" отображается
        InstallmentScreen.isDisplayedByXpath(InstallmentScreen.sendRequestButton)
        //Assert: Кнопка имеет текст "ОФОРМИТЬ ЗАЯВКУ", текст в верном регистре
        InstallmentScreen.hasTextByXpath(InstallmentScreen.sendRequestButton, InstallmentScreen.sendRequestButtonText)
        //1.Нажать на кнопку "ОФОРМИТЬ ЗАЯВКУ" на экране Installment Screen
        InstallmentScreen.clickByXpath(InstallmentScreen.sendRequestButton)
        //Assert: открылся экран Number Verification с надписью "Для продолжения введите код, отправленный на номер". Ожидание 3000м
        ConfirmPhoneScreen.isTextVisibleByXpath(ConfirmPhoneScreen.smsCodeTitle, ConfirmPhoneScreen.smsCodeTitleText)
        //Assert: поле для ввода sms-кода отображается
        ConfirmPhoneScreen.isVisibleById(ConfirmPhoneScreen.smsCodeField)
        //Assert: поле для ввода sms-кода не заполнено (пустое)
        ConfirmPhoneScreen.isEmptyById(ConfirmPhoneScreen.smsCodeField)
        //2. Ввести код "0000" в поле для ввода СМС-кода
        ConfirmPhoneScreen.sendKeysById(ConfirmPhoneScreen.smsCodeField, smsCode000)
        //Assert: открылся экран "Passport Verification for identified user" с надписью "Алексей, в целях безопасности введите..."
        ConfirmPassportScreen.isTextVisibleByXpath(ConfirmPassportScreen.confirmPassNumTitle, ConfirmPassportScreen.confirmPassNumTitleText)
        ConfirmPassportScreen.isDisplayedByXpath(ConfirmPassportScreen.newUserButton)
        //3. Нажать на кнопку "Нет, я новый клиент"
        ConfirmPassportScreen.clickByXpath(ConfirmPassportScreen.newUserButton)
        //Assert: отображается экран "Passport Verification for identified user" с надписью "Продолжите оформление как новый клиент"
        ConfirmPassportScreen.isTextVisibleByXpath(ConfirmPassportScreen.passNumNotMatchTitle, ConfirmPassportScreen.passNumNotMatchTitleText)
        //Assert: отображается кнопка с текстом "ПРОДОЛЖИТЬ КАК НОВЫЙ КЛИЕНТ"
        ConfirmPassportScreen.isTextVisibleByXpath(ConfirmPassportScreen.proceedNewUserButton, ConfirmPassportScreen.proceedNewUserButtonText)
        //4. Нажать на кнопку "ПРОДОЛЖИТЬ КАК НОВЫЙ КЛИЕНТ"
        ConfirmPassportScreen.clickByXpath(ConfirmPassportScreen.proceedNewUserButton)
        //Assert: Открылся экран "Scan suggestion for a new user" с названием "Анкета"
        //ScanSuggestionScreen.isTextVisibleByXpath(scanSuggestHeader, scanSuggestHeaderText)
        //Assert: кнопка РУЧНОЕ ЗАПОЛНЕНИЕ отображается и активна
        ScanSuggestionScreen.isDisplayedByXpath(ScanSuggestionScreen.manualButton)
        //5. Нажать кнопку "РУЧНОЕ ЗАПОЛНЕНИЕ"
        ScanSuggestionScreen.clickByXpath(ScanSuggestionScreen.manualButton)
        //Assert: открылся экран "Application Step 1" с названием "Паспортные данные"



    }








}