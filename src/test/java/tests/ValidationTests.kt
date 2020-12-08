package tests

import actions.TestActions
import com.codeborne.selenide.Selenide.*
import core.DriverSettings
import org.junit.Before
import org.junit.Test
import screen.*
import screen.Application1Screen.application1Header
import screen.Application1Screen.birthDateField
import screen.Application1Screen.cyrillicLastNameError
import screen.Application1Screen.cyrillicLastNameErrorText
import screen.Application1Screen.cyrillicMidNameError
import screen.Application1Screen.cyrillicMidNameErrorText
import screen.Application1Screen.cyrillicNameFieldError
import screen.Application1Screen.cyrillicNameFieldErrorText
import screen.Application1Screen.emptyFieldError
import screen.Application1Screen.emptyFieldErrorText
import screen.Application1Screen.lastNameField
import screen.Application1Screen.maxAgeError
import screen.Application1Screen.maxAgeErrorText
import screen.Application1Screen.midNameField
import screen.Application1Screen.minAgeError
import screen.Application1Screen.minAgeErrorText
import screen.Application1Screen.nameField
import screen.Application1Screen.notCorrectBirthError
import screen.Application1Screen.notCorrectBirthErrorText
import screen.Application1Screen.symbQuantityError
import screen.Application1Screen.symbQuantityErrorText
import java.time.LocalDate
import javax.management.Query.plus


class ValidationTests: DriverSettings()  {
                                         //тестовые данные\\
    private val valid30Symbols = "Эй цирюльникъ ёжик выстриги да"
    private val valid1Symbol = "Ю"
    private val valid29Symbols = "Южно-эфиопский грач увёл мышь"
    private val valid16Symbols = "ряхи сбрей феном"
    private val valid2Symbols = "фя"
    private val notValid31Symbols = "Эй цирюльникъ ёжик выстриги дай"
    private val notValid3Spaces = "   "
    private val notValid8Spaces = "        "
    private val notValid7Digits = "010198"
    private val notValid9Digits = "08.11.1920"
    private val latinSymbols = "Brick quiz whangs jumpy veldt"
    private val specSymbols = "!@#\$%^&*()_+=}[\"'|\\</?№#;,.:~`"
    private val chineseSymbols = "幸福"
    private val digitalSymbols = "1234567890"
    //private val validMaxBirth = LocalDate.plus(Application1Screen.maxPeriod)
    //private val validMinBirth = LocalDate.toString.plus(Application1Screen.minPeriod)
    private val validMinBirth = "10.11.2002"
    private val validMaxBirth = "10.11.1920"
    private val validBirth = "10.11.1985"
    private val notValidMinBirth = "11.11.2002"
    private val notValidMaxBirth = "08.11.1920"





    @Before
    fun setUp() {
        open("")
        //close();
        //Configuration.baseUrl = "";
        //Configuration.proxyEnabled = true;
        //Configuration.fileDownload = PROXY;
        //Configuration.reportsFolder = "/Users/Ivan/Desktop/webSelenideReports";
    }


        @Test
        fun validationNameField() {
                        //\\Проверка валидации поля "Имя" на экране Application Step 1//\\

                                          //\\КОЛИЧЕСТВО СИМВОЛОВ В ПОЛЕ ИМЯ//\\
            //0. дойти до экрана "Application 1"\\
            TestActions().toApplication1()
            //1. Ввести в поле "Имя" значение: "Эй цирюльникъ ёжик выстриги да" (30 символов)
            Application1Screen.sendKeysById(nameField, valid30Symbols)
            //Assert: символы вводятся в поле
            Application1Screen.hasEnteredTextById(nameField, valid30Symbols)
            //2. Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: Система принимает значение. Сообщений об ошибке не появляется. Нужны все тексты ошибок, чтобы проверять что ни один из них не появляется?
            //Application1Screen.isNotVisibleByXpath(symbQuantityError)
            //Application1Screen.isNotVisibleByXpath(emptyFieldError)
            //Application1Screen.isNotVisibleByXpath(cyrillicOnlyError)
            //3. Удалить значение в поле "Имя"
            Application1Screen.clearFieldById(nameField)
            //Assert: в поле не отображается никаких значений
            Application1Screen.isEmptyById(nameField)
            //4. Ввести в поле "Имя" значение: "фя" (2 символа)
            Application1Screen.sendKeysById(nameField, valid2Symbols)
            //5.Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: система принимает значение. Сообщений об ошибках не появляется
            Application1Screen.isNotVisibleByXpath(symbQuantityError)
            Application1Screen.isNotVisibleByXpath(emptyFieldError)
            Application1Screen.isNotVisibleByXpath(cyrillicNameFieldError)
            //6. Очистить поле
            Application1Screen.clearFieldById(nameField)
            //Assert: в поле не отображается никаких значений
            Application1Screen.isEmptyById(nameField)
            //7. Ввести в поле "Имя" значение: "Южно-эфиопский грач увёл мышь" (29 символов)
            Application1Screen.sendKeysById(nameField, valid29Symbols)
            //8.Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: система принимает значение. Сообщений об ошибках не появляется
            Application1Screen.isNotVisibleByXpath(symbQuantityError)
            Application1Screen.isNotVisibleByXpath(emptyFieldError)
            Application1Screen.isNotVisibleByXpath(cyrillicNameFieldError)
            //9. Очистить поле
            Application1Screen.clearFieldById(nameField)
            //Assert: в поле не отображается никаких значений
            Application1Screen.isEmptyById(nameField)
            //10. Ввести в поле "Имя" значение: "ряхи сбрей феном" (16 символов)
            Application1Screen.sendKeysById(nameField, valid16Symbols)
            //11.Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)//Application1Screen.pressTab(nameField)
            //Assert: система принимает значение. Сообщений об ошибках не появляется
            Application1Screen.isNotVisibleByXpath(symbQuantityError)
            Application1Screen.isNotVisibleByXpath(emptyFieldError)
            Application1Screen.isNotVisibleByXpath(cyrillicNameFieldError)
            //12. Очистить поле
            Application1Screen.clearFieldById(nameField)
            //Assert: в поле не отображается никаких значений
            Application1Screen.isEmptyById(nameField)
            //13. Ввести в поле "Имя" значение: "Ю" (1 символ)
            Application1Screen.sendKeysById(nameField, valid1Symbol)
            //14.Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: система принимает значение. Сообщений об ошибках не появляется
            Application1Screen.isNotVisibleByXpath(symbQuantityError)

                                //НЕГАТИВНЫЕ ПРОВЕРКИ КОЛИЧЕСТВА СИМВОЛОВ В ПОЛЕ "ИМЯ"\\Thread.sleep(3000)
            //15. Очистить поле нажав клавишу Backspace
            //Application1Screen.clearFieldById(nameField) ??????
            Application1Screen.pressBackSpaceById(nameField)
            //Assert: в поле не отображается никаких значений
            Application1Screen.isEmptyById(nameField)
            //Assert: появилось сообщение об ошибке "Обязательное поле
            Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
            //16. Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: появилось сообщение об ошибке "Обязательное поле
            Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
            //17. Ввести в поле "Имя" только пробелы (3 пробела)
            //Application1Screen.sendKeysById(nameField, notValid3Spaces)
            //18.Снять фокус
            //Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: появилось сообщение об ошибке "Обязательное поле"
            //!!!!БАГ!!! Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
            //19. Ввести в поле "Имя" значение: "Эй цирюльникъ ёжик выстриги дай" (31 символ)
            Application1Screen.sendKeysById(nameField, notValid31Symbols)
            //20.Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: появилось сообщение об ошибке "Число символов превышает максимальное"
            Application1Screen.isTextVisibleByXpath(symbQuantityError, symbQuantityErrorText)
            //21. Нажать Backspace
            Application1Screen.pressBackSpaceById(nameField)
            //Assert: сообщение об ошибке "Число символов превышает максимальное" исчезло
            Application1Screen.disappearedByXpath(symbQuantityError)
            //22. Очистить поле
            Application1Screen.clearFieldById(nameField)

            //ОБРАБОТКА ПРОБЕЛОВ (пока не реализована)
            //23. Ввести в поле "Имя" значение с пробелом в начале: " Евлампий"
            //28. Снять фокус
            //Assert: Пробел удалился из поля.
            //Assert: В поле отображается только значение "Евлампий" без пробелов
            //29. Ввести в поле "Имя" значение с пробелом в конце: "Евлампий "
            //30. Снять фокус
            //Assert: Пробел удалился из поля.
            //Assert: В поле отображается только значение "Евлампий" без пробелов
            //31. Выделить значение в поле двойным кликом
            //32. Нажать Backspace
            //Assert: в поле не отображается никаких значений

                              //\\НЕДОПУСТИМЫЕ СИМВОЛЫ//\\
            //37. Ввести в поле "Имя" значение: "Brick quiz whangs jumpy veldt"
            Application1Screen.sendKeysById(nameField, latinSymbols)
            //38. Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: поле подсветилось красным
            //Assert: под полем появилось сообщение: "Введите имя кириллицей"
            Application1Screen.isTextVisibleByXpath(cyrillicNameFieldError, cyrillicNameFieldErrorText)
            //39. Очистить поле
            Application1Screen.clearFieldById(nameField)
            //Assert: в поле не отображается никаких значений
            Application1Screen.isEmptyById(nameField)
            //41. Ввести в поле "Имя" значение: "!@#$%^&*()_+=}["'|\</?№#;,.:~`"
            Application1Screen.sendKeysById(nameField, specSymbols)
            //42. Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: поле подсветилось красным
            //Assert: под полем появилось сообщение: "Введите имя кириллицей"
            Application1Screen.isTextVisibleByXpath(cyrillicNameFieldError, cyrillicNameFieldErrorText)
            //43. Очистить поле
            Application1Screen.clearFieldById(nameField)
            //Assert: в поле не отображается никаких значений
            Application1Screen.isEmptyById(nameField)
            //45. Ввести в поле китайские иероглифы значение: "幸福"
            Application1Screen.sendKeysById(nameField, chineseSymbols)
            //46. Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: под полем появилось сообщение: "Введите имя кириллицей"
            Application1Screen.isTextVisibleByXpath(cyrillicNameFieldError, cyrillicNameFieldErrorText)
            //47. Выделить введенное значение двойным кликом
            Application1Screen.doubleClickById(nameField)
            //48. Нажать BackSpace
            Application1Screen.pressBackSpaceById(nameField)
            //Assert: в поле не отображается никаких значений
            Application1Screen.isEmptyById(nameField)
            //49. Ввести в поле "Имя" значение: "1234567890"
            Application1Screen.sendKeysById(nameField, digitalSymbols)
            //50. Снять фокус
            Application1Screen.clickNotClickableByXpath(application1Header)
            //Assert: поле подсветилось красным
            //Assert: под полем появилось сообщение: "Введите имя кириллицей"
            Application1Screen.isTextVisibleByXpath(cyrillicNameFieldError, cyrillicNameFieldErrorText)

        }

    @Test
    fun validationLastNameField() {
        //\\Проверка валидации поля "Фамилия" на экране Application Step 1//\\

                      //\\КОЛИЧЕСТВО СИМВОЛОВ В ПОЛЕ ФАМИЛИЯ//\\
        //0. Дойти до экрана "Application 1"
        TestActions().toApplication1()
        //1. Ввести в поле "Фамилия" значение: "Эй цирюльникъ ёжик выстриги да" (30 символов)
        Application1Screen.sendKeysById(lastNameField, valid30Symbols)
        //Assert: символы вводятся в поле
        Application1Screen.hasEnteredTextById(lastNameField, valid30Symbols)
        //2. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: Система принимает значение. Сообщений об ошибке не появляется.
        //Application1Screen.isNotVisibleByXpath(symbQuantityError)
        //Application1Screen.isNotVisibleByXpath(emptyFieldError)
        //Application1Screen.isNotVisibleByXpath(cyrillicOnlyError)
        //3. Удалить значение в поле "Фамилия"
        Application1Screen.clearFieldById(lastNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(lastNameField)
        //4. Ввести в поле "Фамилия" значение: "фя" (2 символа)
        Application1Screen.sendKeysById(lastNameField, valid2Symbols)
        //5.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicNameFieldError)
        //6. Очистить поле
        Application1Screen.clearFieldById(lastNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(lastNameField)
        //7. Ввести в поле "Фамилия" значение: "Южно-эфиопский грач увёл мышь" (29 символов)
        Application1Screen.sendKeysById(lastNameField, valid29Symbols)
        //8.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicNameFieldError)
        //9. Очистить поле
        Application1Screen.clearFieldById(lastNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(lastNameField)
        //10. Ввести в поле "Фамилия" значение: "ряхи сбрей феном" (16 символов)
        Application1Screen.sendKeysById(lastNameField, valid16Symbols)
        //11.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)//Application1Screen.pressTab(nameField)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicNameFieldError)
        //12. Очистить поле
        Application1Screen.clearFieldById(lastNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(lastNameField)
        //13. Ввести в поле "Фамилия" значение: "Ю" (1 символ)
        Application1Screen.sendKeysById(lastNameField, valid1Symbol)
        //14.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
                      //НЕГАТИВНЫЕ ПРОВЕРКИ КОЛИЧЕСТВА СИМВОЛОВ В ПОЛЕ "ФАМИЛИЯ"\\Thread.sleep(3000)
        //15. Очистить поле нажав клавишу Backspace
        //Application1Screen.clearFieldById(nameField) ??????
        Application1Screen.pressBackSpaceById(lastNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(lastNameField)
        //Assert: появилось сообщение об ошибке "Обязательное поле
        Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
        //16. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Обязательное поле
        Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
        //17. Ввести в поле "Фамилия" только пробелы (3 пробела)
        //Application1Screen.sendKeysById(nameField, notValid3Spaces)
        //18.Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Обязательное поле"
        //!!!!БАГ!!! Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
        //19. Ввести в поле "Фамилия" значение: "Эй цирюльникъ ёжик выстриги дай" (31 символ)
        Application1Screen.sendKeysById(lastNameField, notValid31Symbols)
        //20.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Число символов превышает максимальное"
        Application1Screen.isTextVisibleByXpath(symbQuantityError, symbQuantityErrorText)
        //21. Нажать Backspace
        Application1Screen.pressBackSpaceById(lastNameField)
        //Assert: сообщение об ошибке "Число символов превышает максимальное" исчезло
        Application1Screen.disappearedByXpath(symbQuantityError)
        //22. Очистить поле
        Application1Screen.clearFieldById(lastNameField)

                            //ОБРАБОТКА ПРОБЕЛОВ В ПОЛЕ "ФАМИЛИЯ"
        //23. Ввести в поле "Фамилия" значение с пробелом в начале: " Евлампий"
        //28. Снять фокус
        //Assert: Пробел удалился из поля.
        //Assert: В поле отображается только значение "Евлампий" без пробелов
        //29. Ввести в поле "Фамилия" значение с пробелом в конце: "Евлампий "
        //30. Снять фокус
        //Assert: Пробел удалился из поля.
        //Assert: В поле отображается только значение "Евлампий" без пробелов
        //31. Выделить значение в поле двойным кликом
        //32. Нажать Backspace
        //Assert: в поле не отображается никаких значений

                         //\\НЕДОПУСТИМЫЕ СИМВОЛЫ В ПОЛЕ "ФАМИЛИЯ"//\\
        //37. Ввести в поле "Фамилия" значение: "Brick quiz whangs jumpy veldt"
        Application1Screen.sendKeysById(lastNameField, latinSymbols)
        //38. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Введите фамилию кириллицей"
        Application1Screen.isTextVisibleByXpath(cyrillicLastNameError, cyrillicLastNameErrorText)
        //39. Очистить поле
        Application1Screen.clearFieldById(lastNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(lastNameField)
        //41. Ввести в поле "Фамилия" значение: "!@#$%^&*()_+=}["'|\</?№#;,.:~`"
        Application1Screen.sendKeysById(lastNameField, specSymbols)
        //42. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Введите фамилию кириллицей"
        Application1Screen.isTextVisibleByXpath(cyrillicLastNameError, cyrillicLastNameErrorText)
        //43. Очистить поле
        Application1Screen.clearFieldById(lastNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(lastNameField)
        //45. Ввести в поле "Фамилия" китайские иероглифы значение: "幸福"
        Application1Screen.sendKeysById(lastNameField, chineseSymbols)
        //46. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: под полем появилось сообщение: "Введите фамилию кириллицей"
        Application1Screen.isTextVisibleByXpath(cyrillicLastNameError, cyrillicLastNameErrorText)
        //47. Выделить введенное значение двойным кликом
        Application1Screen.doubleClickById(lastNameField)
        //48. Нажать BackSpace
        Application1Screen.pressBackSpaceById(lastNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(lastNameField)
        //49. Ввести в поле "Фамилия" значение: "1234567890"
        Application1Screen.sendKeysById(lastNameField, digitalSymbols)
        //50. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Введите фамилию кириллицей"
        Application1Screen.isTextVisibleByXpath(cyrillicLastNameError, cyrillicLastNameErrorText)

    }

    @Test
    fun validationMidNameField() {
               //\\Проверка валидации поля "Отчество" на экране Application Step 1//\\

                          //\\КОЛИЧЕСТВО СИМВОЛОВ В ПОЛЕ ОТЧЕСТВО//\\
        //0. Дойти до экрана "Application 1"//\\
        TestActions().toApplication1()
        //1. Ввести в поле "Отчество" значение: "Эй цирюльникъ ёжик выстриги да" (30 символов)
        Application1Screen.sendKeysById(midNameField, valid30Symbols)
        //Assert: символы вводятся в поле
        Application1Screen.hasEnteredTextById(midNameField, valid30Symbols)
        //2. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: Система принимает значение. Сообщений об ошибке не появляется.
        //Application1Screen.isNotVisibleByXpath(symbQuantityError)
        //Application1Screen.isNotVisibleByXpath(emptyFieldError)
        //Application1Screen.isNotVisibleByXpath(cyrillicOnlyError)
        //3. Удалить значение в поле "Отчество"
        Application1Screen.clearFieldById(midNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(midNameField)
        //4. Ввести в поле "Отчество" значение: "фя" (2 символа)
        Application1Screen.sendKeysById(midNameField, valid2Symbols)
        //5.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicMidNameError)
        //6. Очистить поле
        Application1Screen.clearFieldById(midNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(midNameField)
        //7. Ввести в поле "Отчество" значение: "Южно-эфиопский грач увёл мышь" (29 символов)
        Application1Screen.sendKeysById(midNameField, valid29Symbols)
        //8.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicMidNameError)
        //9. Очистить поле
        Application1Screen.clearFieldById(midNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(midNameField)
        //10. Ввести в поле "Отчество" значение: "ряхи сбрей феном" (16 символов)
        Application1Screen.sendKeysById(midNameField, valid16Symbols)
        //11.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)//Application1Screen.pressTab(nameField)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicMidNameError)
        //12. Очистить поле
        Application1Screen.clearFieldById(midNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(midNameField)
        //13. Ввести в поле "Отчество" значение: "Ю" (1 символ)
        Application1Screen.sendKeysById(midNameField, valid1Symbol)
        //14.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicMidNameError)
        //15. Очистить поле нажав клавишу Backspace
        //Application1Screen.clearFieldById(nameField) ??????
        Application1Screen.pressBackSpaceById(midNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(midNameField)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicMidNameError)
        //16. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(symbQuantityError)
        Application1Screen.isNotVisibleByXpath(emptyFieldError)
        Application1Screen.isNotVisibleByXpath(cyrillicMidNameError)
                        //НЕГАТИВНЫЕ ПРОВЕРКИ КОЛИЧЕСТВА СИМВОЛОВ В ПОЛЕ "ОТЧЕСТВО"\\Thread.sleep(3000)
        //17. Ввести в поле "Отчество" только пробелы (3 пробела)
        //Application1Screen.sendKeysById(nameField, notValid3Spaces)
        //18.Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Обязательное поле"
        //!!!!БАГ!!! Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
        //19. Ввести в поле "Отчество" значение: "Эй цирюльникъ ёжик выстриги дай" (31 символ)
        Application1Screen.sendKeysById(midNameField, notValid31Symbols)
        //20.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Число символов превышает максимальное"
        Application1Screen.isTextVisibleByXpath(symbQuantityError, symbQuantityErrorText)
        //21. Нажать Backspace
        Application1Screen.pressBackSpaceById(midNameField)
        //Assert: сообщение об ошибке "Число символов превышает максимальное" исчезло
        Application1Screen.disappearedByXpath(symbQuantityError)
        //22. Очистить поле
        Application1Screen.clearFieldById(midNameField)

                              //ОБРАБОТКА ПРОБЕЛОВ В ПОЛЕ "ОТЧЕСТВО" (пока не реализованно)
        //23. Ввести в поле "Отчество" значение с пробелом в начале: " Евлампий"
        //28. Снять фокус
        //Assert: Пробел удалился из поля.
        //Assert: В поле отображается только значение "Евлампий" без пробелов
        //29. Ввести в поле "Отчество" значение с пробелом в конце: "Евлампий "
        //30. Снять фокус
        //Assert: Пробел удалился из поля.
        //Assert: В поле отображается только значение "Евлампий" без пробелов
        //31. Выделить значение в поле двойным кликом
        //32. Нажать Backspace
        //Assert: в поле не отображается никаких значений

                           //\\НЕДОПУСТИМЫЕ СИМВОЛЫ В ПОЛЕ ОТЧЕСТВО//\\
        //37. Ввести в поле "Отчество" значение: "Brick quiz whangs jumpy veldt"
        Application1Screen.sendKeysById(midNameField, latinSymbols)
        //38. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Введите фамилию кириллицей"
        Application1Screen.isTextVisibleByXpath(cyrillicMidNameError, cyrillicMidNameErrorText)
        //39. Очистить поле
        Application1Screen.clearFieldById(midNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(midNameField)
        //41. Ввести в поле "Отчество" значение: "!@#$%^&*()_+=}["'|\</?№#;,.:~`"
        Application1Screen.sendKeysById(midNameField, specSymbols)
        //42. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Введите отчество кириллицей"
        Application1Screen.isTextVisibleByXpath(cyrillicMidNameError, cyrillicMidNameErrorText)
        //43. Очистить поле
        Application1Screen.clearFieldById(midNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(midNameField)
        //45. Ввести в поле "Отчество" китайские иероглифы значение: "幸福"
        Application1Screen.sendKeysById(midNameField, chineseSymbols)
        //46. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: под полем появилось сообщение: "Введите отчество кириллицей"
        Application1Screen.isTextVisibleByXpath(cyrillicMidNameError, cyrillicMidNameErrorText)
        //47. Выделить введенное значение двойным кликом
        Application1Screen.doubleClickById(midNameField)
        //48. Нажать BackSpace
        Application1Screen.pressBackSpaceById(midNameField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(midNameField)
        //49. Ввести в поле "Отчество" значение: "1234567890"
        Application1Screen.sendKeysById(midNameField, digitalSymbols)
        //50. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Введите отчество кириллицей"
        Application1Screen.isTextVisibleByXpath(cyrillicMidNameError, cyrillicMidNameErrorText)

    }

    @Test
    fun validationBirthField() {
        //\\Проверка валидации поля "Дата рождения" на экране Application Step 1//\\

                            //\\КОЛИЧЕСТВО СИМВОЛОВ В ПОЛЕ ДАТА РОЖДЕНИЯ//\\
        //0. Дойти до экрана "Application 1"
        TestActions().toApplication1()
        Application1Screen.ctrlABackSpaceById(birthDateField)// КОСТЫЛЬ пока не проясняться требования по очистке полей после сессии
        //Application1Screen.clickNotClickableByXpath(application1Header) // КОСТЫЛЬ
        //1. Ввести в поле "Дата рождения" значение: "08111985" (8 символов)
        Application1Screen.sendKeysById(birthDateField, validBirth)
        //Assert: символы вводятся в поле
        Application1Screen.hasEnteredTextById(birthDateField, validBirth)
        //2. Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: Система принимает значение. Сообщений об ошибке не появляется.
        Application1Screen.isNotVisibleByXpath(minAgeError)
        Application1Screen.isNotVisibleByXpath(maxAgeError)
        Application1Screen.isNotVisibleByXpath(notCorrectBirthError)
        //3. Удалить значение в поле "Дата рождения"
        Application1Screen.ctrlABackSpaceById(birthDateField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(birthDateField)
        //4. Ввести в поле "Дата рождения" значение, соответствующее максимально допустимому возрасту
        Application1Screen.sendKeysById(birthDateField, validMaxBirth)
        //5.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(minAgeError)
        Application1Screen.isNotVisibleByXpath(maxAgeError)
        Application1Screen.isNotVisibleByXpath(notCorrectBirthError)
        //6. Очистить поле
        Application1Screen.ctrlABackSpaceById(birthDateField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(birthDateField)
        //7. Ввести в поле "Дата рождения" значение, соответствующее минимально допустимому возрасту
        Application1Screen.sendKeysById(birthDateField, validMinBirth)
        //8.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        Application1Screen.isNotVisibleByXpath(minAgeError)
        Application1Screen.isNotVisibleByXpath(maxAgeError)
        Application1Screen.isNotVisibleByXpath(notCorrectBirthError)
        //9. Очистить поле //ТУТ БАГА!!!! Поле не чиститься с помощью clear - это странно. Надо выяснить почему.
        Application1Screen.ctrlABackSpaceById(birthDateField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(birthDateField)

                //НЕГАТИВНЫЕ ПРОВЕРКИ В ПОЛЕ "Дата рождения"\\Thread.sleep(3000)
        //9. Очистить поле "Дата рождения" нажав клавишу Backspace
        Application1Screen.ctrlABackSpaceById(birthDateField)
        //Assert: в поле не отображается никаких значений
        Application1Screen.isEmptyById(birthDateField)
        //10. Снять фокус. Проверка (ОБЯЗАТЕЛЬНОСТЬ ПОЛЯ)
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Обязательное поле"
        Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
        //11. Ввести в поле "Дата рождения" значение, соответствующее возрасту младше минимально допустимого (МИНИМАЛЬНЫЙ ВОЗРАСТ)
        Application1Screen.sendKeysById(birthDateField, notValidMinBirth)
        //12.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Вы должны быть старше 18 лет"
        Application1Screen.isTextVisibleByXpath(minAgeError, minAgeErrorText)
        //13. Ввести в поле "Дата рождения" значение, соответствующее возрасту старше максимально допустимого (МАКСИМАЛЬНЫЙ ВОЗРАСТ)
        Application1Screen.sendKeysById(birthDateField, notValidMaxBirth)
        //14.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Вы должны быть не старше 100 лет"
        Application1Screen.isTextVisibleByXpath(maxAgeError, maxAgeErrorText)

                      //ОБРАБОТКА ПРОБЕЛОВ В ПОЛЕ "ОТЧЕСТВО"
        //17. Ввести в поле "Дата рождения" только пробелы (8 пробелов)
        Application1Screen.sendKeysById(birthDateField, notValid8Spaces)
        Thread.sleep(3000)
        //18.Снять фокус
        Application1Screen.clickNotClickableByXpath(application1Header)
        Thread.sleep(3000)
        //Assert: появилось сообщение об ошибке "Некорректная дата"
        Application1Screen.isTextVisibleByXpath(notCorrectBirthError, notCorrectBirthErrorText)

                     //КОЛИЧЕСТВО СИМВОЛОВ\\
        //19. Ввести в поле "Дата рождения" 9 символов ТУТ БАГА!!!
        //Application1Screen.sendKeysById(birthDateField, notValid9Digits)
        //Thread.sleep(3000)
        //Application1Screen.hasEnteredTextById(birthDateField, notValid9Digits)
        //20.Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Thread.sleep(3000)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        //Application1Screen.isNotVisibleByXpath(minAgeError)
        //Application1Screen.isNotVisibleByXpath(maxAgeError)
        //Application1Screen.isNotVisibleByXpath(notCorrectBirthError)
        //21. Ввести в поле "Дата рождения" 7 символов ТУТ БАГА!!!
        //Application1Screen.sendKeysById(birthDateField, notValid7Digits)
        //22.Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Некорректная дата"
        //Application1Screen.isTextVisibleByXpath(notCorrectBirthError, notCorrectBirthErrorText)
        //временная очистка поля
        //Application1Screen.ctrlABackSpaceById(birthDateField)


                 //\\НЕДОПУСТИМЫЕ СИМВОЛЫ В ПОЛЕ ОТЧЕСТВО//\\ ВКЛЮЧАТЬ КОГДА ИСПРАВЯТ БАГИ В ТЕСТИНГЕ
        //23. Ввести в поле "Дата рождения" БУКВЫ ЛАТИНИЦЫ
        //Application1Screen.sendKeysById(birthDateField, latinSymbols)
        //assert: Символы не отображаются в поле
        //Application1Screen.isEmptyById(birthDateField)
        //24. Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Обязательное поле"
        //Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
        //25. Очистить поле
        //Application1Screen.ctrlABackSpaceById(birthDateField)
        //26. Ввести в поле "Дата рождения" БУКВЫ КИРИЛЛИЦЫ (фя)
        //Application1Screen.sendKeysById(birthDateField, valid2Symbols)
        //assert: Символы не отображаются в поле
        //Application1Screen.isEmptyById(birthDateField)
        //27. Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Обязательное поле"
        //Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
        //28. Очистить поле
        //Application1Screen.ctrlABackSpaceById(birthDateField)
        //29. Ввести в поле "Дата рождения" СПЕЦСИМВОЛЫ (!@#$%^&*()_+=}["'|\</?№#;,.:~`)
        //Application1Screen.sendKeysById(birthDateField, specSymbols)
        //assert: Символы не отображаются в поле
        //Application1Screen.isEmptyById(birthDateField)
        //30. Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Обязательное поле"
        //Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
        //31. Очистить поле
        //Application1Screen.ctrlABackSpaceById(birthDateField)




    }

}
