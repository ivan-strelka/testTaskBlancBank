package tests.api.productTests

import api.constants.FEATURE_API
import api.constants.PRODUCT_URL
import api.utils.data.TestData
import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import tests.api.BaseTest
import tests.api.productTests.steps.checkGetProduct
import tests.api.productTests.steps.checkProductResp
import tests.api.productTests.steps.createRandomBodyProduct


@Tag("WEB_API")
@DisplayName("Tests API method GET $PRODUCT_URL -> Получение товара по id ")
class GetProductTest : BaseTest() {
    private var id: String? = ""

    @Test
    @DisplayName("Базовый позитивный кейс получения продукта")
    @Description("Создаём видимый продукт со всеми полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun visibleBodyPositiveTest() {
        val product = createRandomBodyProduct()
        val response = productService.addProduct(product).execute()
        id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)
        val responseGet = productService.getProduct(id).execute()
        checkGetProduct(responseGet, product)

    }

    @ParameterizedTest(name = "#{index} - Негативный тест получения не существующего объект Product path  -> {0}")
    @DisplayName("Негативный кейс получения не существующего продукта с разными path parameters")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.NORMAL)
    @ArgumentsSource(TestData::class)
    fun diffGetProductTest(input: String) {
        val responseGet = productService.getProduct(input).execute()
        assertThat(responseGet.code()).isEqualTo(400)


    }


}