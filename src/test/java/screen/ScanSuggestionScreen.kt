package screen

import core.TestHelper

object ScanSuggestionScreen: TestHelper() {

    const val manualButton = "//*[@class='df-button-large ng-star-inserted']" //"//button[contains(text(), ' РУЧНОЕ ЗАПОЛНЕНИЕ')]"
    const val manualButtonText = "РУЧНОЕ ЗАПОЛНЕНИЕ"
    const val recognitionButton = "//*[@class='df-button-large-fill ng-star-inserted']" //"//button[contains(text(), 'РАСПОЗНАВАНИЕ')]"
    const val recognitionButtonText = "РАСПОЗНАВАНИЕ"
    const val scanSuggestHeader = "//div[contains(text(), 'Анкета')]"
    const val scanSuggestHeaderText = "Анкета"
    const val scanSuggestTitle = "//*[@class='choice-form-filling__text']"
    const val scanSuggestTitleText = "Используйте распознавание паспорта по фотографии, чтобы не заполнять всю анкету вручную"


}