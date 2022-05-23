package tests.api.productTests

import api.constants.FEATURE_API
import api.constants.PRODUCT_URL
import api.utils.data.TestData
import api.utils.data.generateRndInt
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
import tests.api.productTests.steps.checkDeleteResp
import tests.api.productTests.steps.checkProductResp
import tests.api.productTests.steps.createRandomBodyProduct


@Tag("WEB_API")
@DisplayName("Tests API method DELETE $PRODUCT_URL -> Удаление товара ")
class DeleteProductTest : BaseTest() {


    @Test
    @DisplayName("Базовый позитивный кейс удаления товара")
    @Description("Удаляем предварительно созданную сущность Product")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun deleteProductPositiveTest() {
        val product = createRandomBodyProduct()
        val response = productService.addProduct(product).execute()
        val id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)
        val responseDelete = productService.deleteProduct(id).execute()
        checkDeleteResp(responseDelete, product, id)

    }

    @Test
    @DisplayName("Базовый негативный кейс двойного удаления товара")
    @Description("Дважды удаляем предварительно созданную сущность Product")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun doubleDeleteProductTest() {
        val product = createRandomBodyProduct()
        val response = productService.addProduct(product).execute()
        val id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)
        val responseDelete = productService.deleteProduct(id).execute()
        checkDeleteResp(responseDelete, product, id)
        val responseDelete2 = productService.deleteProduct(id).execute()
        assertThat(responseDelete2.code()).isEqualTo(500)
    }


    @Test
    @DisplayName("Негативный кейс удаления не существующего товара")
    @Description("Удаляем не существующий объект Product path -> random Int")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun intDeleteProductTest() {
        val responseDelete = productService.deleteProduct(generateRndInt()).execute()
        assertThat(responseDelete.code()).isEqualTo(400)
    }

    @Test
    @DisplayName("Негативный кейс удаления не существующего товара UUID")
    @Description("Удаляем не существующий объект Product path -> random UUID")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun uuidDeleteProductTest() {
        val responseDelete = productService.deleteProduct(generateRndInt()).execute()
        assertThat(responseDelete.code()).isEqualTo(400)
    }

    @ParameterizedTest(name = "#{index} - Негативный тест удаления не существующего объект Product path  -> {0}")
    @DisplayName("Негативный кейс удаления не существующего товара с разными path parameters")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.NORMAL)
    @ArgumentsSource(TestData::class)
    fun diffDeletProductTest(input: String) {
        val responseDelete = productService.deleteProduct(generateRndInt()).execute()
        assertThat(responseDelete.code()).isEqualTo(400)

    }


}