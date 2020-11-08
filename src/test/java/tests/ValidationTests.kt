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
import screen.Application1Screen.midNameField
import screen.Application1Screen.minAgeError
import screen.Application1Screen.nameField
import screen.Application1Screen.notCorrectBirth
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
    private val latinSymbols = "Brick quiz whangs jumpy veldt"
    private val specSymbols = "!@#\$%^&*()_+=}[\"'|\\</?№#;,.:~`"
    private val chineseSymbols = "幸福"
    private val digitalSymbols = "1234567890"
    //private val validMaxBirth = LocalDate.plus(Application1Screen.maxPeriod)
    //private val validMinBirth = LocalDate.toString.plus(Application1Screen.minPeriod)
    private val validMinBirth = "08.11.2002"
    private val validMaxBirth = "08.11.2083"
    private val validBirth = "08.11.1985"
    private val notValidMinBirth = "08.11.2002"
    private val notValidMaxBirth = "08.11.2083"



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
        Thread.sleep(3000)
        Application1Screen.pressBackSpaceTillEmpty(birthDateField)// КОСТЫЛЬ пока не проясняться требования по очистке полей после сессии

        //Application1Screen.clickNotClickableByXpath(application1Header) // КОСТЫЛЬ
        //1. Ввести в поле "Дата рождения" значение: "08111985" (8 символов)
        Thread.sleep(6000)
        Application1Screen.sendKeysById(birthDateField, validBirth)
        Thread.sleep(3000)
        //Assert: символы вводятся в поле
        Application1Screen.hasEnteredTextById(birthDateField, validBirth)
        //2. Снять фокус

        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Thread.sleep(3000)
        //Assert: Система принимает значение. Сообщений об ошибке не появляется.
        //Application1Screen.isNotVisibleByXpath(minAgeError)
        //Application1Screen.isNotVisibleByXpath(maxAgeError)
        //Application1Screen.isNotVisibleByXpath(notCorrectBirth)
        //3. Удалить значение в поле "Дата рождения"
        //Application1Screen.pressBackSpaceTillEmpty(birthDateField)
        //Assert: в поле не отображается никаких значений
        //Application1Screen.isEmptyById(birthDateField)
        //4. Ввести в поле "Дата рождения" значение, соответствующее максимально допустимому возрасту
        //Application1Screen.sendKeysById(birthDateField, validMaxBirth)

        //5.Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        //Application1Screen.isNotVisibleByXpath(minAgeError)
        //Application1Screen.isNotVisibleByXpath(maxAgeError)
        //Application1Screen.isNotVisibleByXpath(notCorrectBirth)
        //6. Очистить поле
        //Application1Screen.pressBackSpaceTillEmpty(birthDateField)
        //Assert: в поле не отображается никаких значений
        //Application1Screen.isEmptyById(birthDateField)
        //7. Ввести в поле "Дата рождения" значение, соответствующее минимально допустимому возрасту
        //Application1Screen.sendKeysById(birthDateField, validMinBirth)
        //8.Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: система принимает значение. Сообщений об ошибках не появляется
        //Application1Screen.isNotVisibleByXpath(minAgeError)
        //Application1Screen.isNotVisibleByXpath(maxAgeError)
        //Application1Screen.isNotVisibleByXpath(notCorrectBirth)
        //9. Очистить поле
        //Application1Screen.clearFieldById(birthDateField)
        //Assert: в поле не отображается никаких значений
        //Application1Screen.isEmptyById(birthDateField)

                //НЕГАТИВНЫЕ ПРОВЕРКИ КОЛИЧЕСТВА СИМВОЛОВ В ПОЛЕ "ОТЧЕСТВО"\\Thread.sleep(3000)
        //9. Очистить поле нажав клавишу Backspace
        //Application1Screen.pressBackSpaceTillEmpty(birthDateField)
        //Assert: в поле не отображается никаких значений
        //Application1Screen.isEmptyById(birthDateField)
        //10. Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Обязательное поле"
        //Application1Screen.isTextVisibleByXpath(emptyFieldError, emptyFieldErrorText)
        //17. Ввести в поле "Дата рождения" только пробелы (8 пробелов)
        //Application1Screen.sendKeysById(nameField, notValid3Spaces)
        //18.Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Некоректная дата"
        // Application1Screen.isTextVisibleByXpath(notCorrectBirthError, notCorrectBirthErrorText)
        //19. Ввести в поле "Дата рождения" значение: "Эй цирюльникъ ёжик выстриги дай" (31 символ)
        //Application1Screen.sendKeysById(midNameField, notValid31Symbols)
        //20.Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: появилось сообщение об ошибке "Число символов превышает максимальное"
        //Application1Screen.isTextVisibleByXpath(symbQuantityError, symbQuantityErrorText)
        //21. Нажать Backspace
        //Application1Screen.pressBackSpaceById(midNameField)
        //Assert: сообщение об ошибке "Число символов превышает максимальное" исчезло
        //Application1Screen.disappearedByXpath(symbQuantityError)
        //22. Очистить поле
        //Application1Screen.clearFieldById(midNameField)

        //ОБРАБОТКА ПРОБЕЛОВ В ПОЛЕ "ОТЧЕСТВО"
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
        //Application1Screen.sendKeysById(midNameField, latinSymbols)
        //38. Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Введите фамилию кириллицей"
        //Application1Screen.isTextVisibleByXpath(cyrillicMidNameError, cyrillicMidNameErrorText)
        //39. Очистить поле
        //Application1Screen.clearFieldById(midNameField)
        //Assert: в поле не отображается никаких значений
        //Application1Screen.isEmptyById(midNameField)
        //41. Ввести в поле "Отчество" значение: "!@#$%^&*()_+=}["'|\</?№#;,.:~`"
        //Application1Screen.sendKeysById(midNameField, specSymbols)
        //42. Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Введите отчество кириллицей"
        //Application1Screen.isTextVisibleByXpath(cyrillicMidNameError, cyrillicMidNameErrorText)
        //43. Очистить поле
        //Application1Screen.clearFieldById(midNameField)
        //Assert: в поле не отображается никаких значений
        //Application1Screen.isEmptyById(midNameField)
        //45. Ввести в поле "Отчество" китайские иероглифы значение: "幸福"
        //Application1Screen.sendKeysById(midNameField, chineseSymbols)
        //46. Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: под полем появилось сообщение: "Введите отчество кириллицей"
        //Application1Screen.isTextVisibleByXpath(cyrillicMidNameError, cyrillicMidNameErrorText)
        //47. Выделить введенное значение двойным кликом
        //Application1Screen.doubleClickById(midNameField)
        //48. Нажать BackSpace
        //Application1Screen.pressBackSpaceById(midNameField)
        //Assert: в поле не отображается никаких значений
        //Application1Screen.isEmptyById(midNameField)
        //49. Ввести в поле "Отчество" значение: "1234567890"
        //Application1Screen.sendKeysById(midNameField, digitalSymbols)
        //50. Снять фокус
        //Application1Screen.clickNotClickableByXpath(application1Header)
        //Assert: поле подсветилось красным
        //Assert: под полем появилось сообщение: "Введите отчество кириллицей"
        //Application1Screen.isTextVisibleByXpath(cyrillicMidNameError, cyrillicMidNameErrorText)

    }

}