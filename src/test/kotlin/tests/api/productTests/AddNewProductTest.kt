package tests.api.productTests

import api.constants.FEATURE_API
import api.constants.PRODUCT_URL
import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import tests.api.BaseTest
import tests.api.productTests.steps.checkProductResp
import tests.api.productTests.steps.createEmptyBodyProduct
import tests.api.productTests.steps.createRandomBodyProduct

@Tag("WEB_API")
@DisplayName("Tests API method POST $PRODUCT_URL -> Добавление товара ")
class AddNewProductTest : BaseTest() {

    private var id: String? = ""

    @Test
    @DisplayName("Базовый позитивный кейс создания продукта")
    @Description("Создаём видимый продукт со всеми полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun visibleBodyPositiveTest() {
        val product = createRandomBodyProduct()
        val response = productService.addProduct(product).execute()
        id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)

    }

    @Test
    @DisplayName("Кейс создания продукта с таким же боди")
    @Description("Создаём  продукт с таким же боди")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun doubleCreateTests() {
        val product = createRandomBodyProduct()
        val response = productService.addProduct(product).execute()
        id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)
        val response2 = productService.addProduct(product).execute()
        assertThat(response2.code()).isEqualTo(500)

    }

    @Test
    @DisplayName("Базовый позитивный кейс создания продукта с пустым body")
    @Description("Создаём видимый продукт с пустым body")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun emptyBodyPositiveTest() {
        val product = createEmptyBodyProduct()
        val response = productService.addProduct(product).execute()
        id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)

    }

    @AfterEach
    fun deleteCategory() {
        id.let {
            val response = productService.deleteProduct(it).execute()
            assertThat(response.code()).isEqualTo(200)
        }

    }


}