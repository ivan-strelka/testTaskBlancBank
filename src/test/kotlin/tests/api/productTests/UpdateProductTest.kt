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
import tests.api.productTests.steps.checkUpdateResp
import tests.api.productTests.steps.createEmptyBodyProduct
import tests.api.productTests.steps.createRandomBodyProduct

@Tag("WEB_API")
@DisplayName("Tests API method UPDATE $PRODUCT_URL -> Обновление товара")
class UpdateProductTest : BaseTest() {

    private var id: String? = ""

    @Test
    @DisplayName("Базовый позитивный кейс обновления продукта")
    @Description("Обновляем предварительно созданную сущность Product")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateProductPositiveTest() {
        val product = createRandomBodyProduct()
        val response = productService.addProduct(product).execute()
        id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)
        val updateProduct = createRandomBodyProduct()
        val updateResponse = productService.updateCategory(id, updateProduct).execute()
        checkUpdateResp(updateResponse, updateProduct, id)

    }

    @Test
    @DisplayName("Базовый позитивный кейс обновления продукта аналогичной сущностью")
    @Description("Обновляем предварительно созданную сущность Product на такую же сущность")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateProductPositiveTest2() {
        val product = createRandomBodyProduct()
        val response = productService.addProduct(product).execute()
        id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)
        val updateResponse = productService.updateCategory(id, product).execute()
        checkUpdateResp(updateResponse, product, id)

    }

    @Test
    @DisplayName("Обновление продукта на пустое body")
    @Description("Обновляем предварительно созданную сущность Product на пустое body")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateProductTest() {
        val product = createRandomBodyProduct()
        val response = productService.addProduct(product).execute()
        id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)
        val updateProduct = createEmptyBodyProduct()
        val updateResponse = productService.updateCategory(id, updateProduct).execute()
        checkUpdateResp(updateResponse, updateProduct, id)

    }

    @Test
    @DisplayName("Обновление продукта пустое body на пустое body")
    @Description("Обновляем предварительно созданную пустую сущность Product на пустое body")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateProductTest2() {
        val product = createEmptyBodyProduct()
        val response = productService.addProduct(product).execute()
        id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)
        val updateProduct = createEmptyBodyProduct()
        val updateResponse = productService.updateCategory(id, updateProduct).execute()
        checkUpdateResp(updateResponse, updateProduct, id)

    }

    @Test
    @DisplayName("Обновление продукта пустое body на заполненное body")
    @Description("Обновляем предварительно созданную сущность Product на пустое body")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateProductTest3() {
        val product = createEmptyBodyProduct()
        val response = productService.addProduct(product).execute()
        id = response.body()?.values?.get(0)?.id
        checkProductResp(response, product)
        val updateProduct = createRandomBodyProduct()
        val updateResponse = productService.updateCategory(id, updateProduct).execute()
        checkUpdateResp(updateResponse, updateProduct, id)

    }


    @AfterEach
    fun deleteCategory() {
        id.let {
            val response = productService.deleteProduct(it).execute()
            assertThat(response.code()).isEqualTo(200)
        }

    }

}