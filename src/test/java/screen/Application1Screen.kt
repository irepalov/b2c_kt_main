package screen

import bsh.ParserConstants.PLUS
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym.PLUS
import core.TestHelper
import kotlin.*
import javax.management.Query.plus
import sun.util.resources.LocaleData
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern
import javax.management.Query.plus
import javax.swing.text.DateFormatter
import kotlin.coroutines.EmptyCoroutineContext.plus

object Application1Screen: TestHelper() {

    const val application1Header = "//*[contains(text(), 'Паспортные данные')]"
    const val application1HeaderText = "Паспортные данные"
    const val application1CrossButton = "//*[@class='header__exit d-flex justify-content-end ng-star-inserted col-1']"
    const val nameField = "mat-input-3"
    const val nameFieldText = "Имя"
    const val lastNameField = "mat-input-4"
    const val lastNameFieldText = "Фамилия"
    const val midNameField = "mat-input-5"
    const val midNameFieldText = "Отчество"
    const val birthDateField = "mat-input-6"
    const val birthDateFieldText = "Дата рождения"
    const val passNumField = ""
    const val passNumFieldText = ""
    const val toStep2Button = "//*[@class='df-button-large-fill-fixed-bottom ng-star-inserted']"
    const val toStep2ButtonText = "К ШАГУ 2 ИЗ 3"
    const val cyrillicNameFieldError = "//*[contains(text(), 'Введите имя кириллицей')]"
    const val cyrillicNameFieldErrorText = "Введите имя кириллицей"
    const val cyrillicLastNameError = "//*[contains(text(), 'Введите фамилию кириллицей')]"
    const val cyrillicLastNameErrorText = "Введите фамилию кириллицей"
    const val cyrillicMidNameError = "//*[contains(text(), 'Введите отчество кириллицей')]"
    const val cyrillicMidNameErrorText = "Введите отчество кириллицей"
    const val symbQuantityError = "//*[contains(text(), 'Число символов превышает максимальное')]"
    const val symbQuantityErrorText = "Число символов превышает максимальное"
    const val minAgeError = "//*[contains(text(), 'Вы должны быть старше 18 лет')]"
    const val minAgeErrorText = "Вы должны быть старше 18 лет"
    const val maxAgeError = "//*[contains(text(), 'Вы должны быть не старше 100 лет')]"
    const val maxAgeErrorText = "Вы должны быть не старше 100 лет"
    const val notCorrectBirthError = "//*[contains(text(), 'Дата рождения некорректна')]"
    const val notCorrectBirthErrorText = "Дата рождения некорректна"
    const val maleButton = ""
    const val femaleButton = ""
    const val maleButtonName = ""
    const val maleButtonNameText = ""
    const val femaleButtonName = ""
    const val femaleButtonNameText = ""
    const val emptyFieldError = "//*[contains(text(), 'Обязательное поле')]" //Error: "Обязательное поле"
    var formatter = DateTimeFormatter.ofPattern("12-07-2005")
    var maxPeriod = Period.of(101, 0, 0)
    var minPeriod = Period.of(18, 0, 0)
    const val emptyFieldErrorText = "Обязательное поле"
    val validationError = arrayOf(
            "//*[contains(text(), 'Обязательное поле')]",
            "//*[contains(text(), 'Число символов превышает максимальное')]",
            "//*[contains(text(), 'Введите имя кириллицей')]"
    )






}