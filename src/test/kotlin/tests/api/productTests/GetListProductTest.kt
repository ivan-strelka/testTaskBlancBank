package tests.api.productTests

import api.constants.FEATURE_API
import api.constants.PRODUCT_URL
import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import tests.api.BaseTest


@Tag("WEB_API")
@DisplayName("Tests API method GET $PRODUCT_URL -> Получение списка товара ")
class GetListProductTest : BaseTest() {

    @Test
    @DisplayName("Базовый позитивный кейс создания продукта")
    @Description("Создаём видимый продукт со всеми полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun getListProductTest() {

        val response = productService.getAllProduct().execute()
        Assertions.assertThat(response.code()).isEqualTo(200)
        Assertions.assertThat(response.body()?.values?.size).isEqualTo(23)

    }


}