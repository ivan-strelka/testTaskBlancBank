package tests.api.categoryTests

import api.constants.CATEGORY_URL
import api.constants.FEATURE_API
import api.dto.AddCategoryResponse
import api.utils.data.generateRndInt
import api.utils.data.getRandomUUID
import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import retrofit2.Response
import tests.api.BaseTest
import tests.api.categoryTests.steps.checkCategoryResponse
import tests.api.categoryTests.steps.createAnyBody
import tests.api.categoryTests.steps.createRandomUnvisibleBodyCategory
import tests.api.categoryTests.steps.createRandomVisibleBodyCategory

@Tag("WEB_API")
@DisplayName("Tests API method POST $CATEGORY_URL -> Добавление категории ")
class AddNewCategoryTest : BaseTest() {

    private lateinit var id: String

    @Test
    @DisplayName("Базовый позитивный кейс с видимой категорией")
    @Description("Создаём видимую категорию со всеми полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun visibleBodyPositiveTest() {
        val category = createRandomVisibleBodyCategory()
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
    }

    @Test
    @DisplayName("Базовый позитивный кейс с не видимой категорией")
    @Description("Создаём не видимую категорию со всеми полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun invisibleBodyPositiveTest() {
        val category = createRandomUnvisibleBodyCategory()
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
    }

    @Test
    @DisplayName("Базовый негативный кейс с пустыми полями")
    @Description("Создаём body категории с пустыми полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun emptyBodyNegativeTest() {
        val category = createAnyBody()
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
    }

    @Test
    @DisplayName("Базовый негативный кейс c int полями")
    @Description("Создаём body категории с цифровыми полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun intBodyNegativeTest() {
        val category = createAnyBody(name = "123", brand = "123")
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
    }

    @Test
    @DisplayName("Базовый негативный кейс с случайными int")
    @Description("Создаём body категории с случайными цифровыми полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun intBodyNegativeTest2() {
        val category = createAnyBody(name = generateRndInt(), brand = generateRndInt())
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
    }

    @Test
    @DisplayName("Базовый негативный кейс с null")
    @Description("Создаём body категории с null полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun nullBodyNegativeTest() {
        val category = createAnyBody(name = "null", brand = "null")
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
    }

    @Test
    @DisplayName("Базовый негативный кейс с UUID name")
    @Description("Создаём body категории с UUID полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun UUIDBodyNegativeTest() {
        val category = createAnyBody(name = getRandomUUID().toString())
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
    }

    @Test
    @DisplayName("Базовый негативный кейс с UUID всеми полями")
    @Description("Создаём body категории с UUID полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun UUIDBodyNegativeTest2() {
        val category = createAnyBody(name = getRandomUUID().toString(), brand = getRandomUUID().toString())
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
    }

    @AfterEach
    fun deleteCategory() {
        id.let {
            val response = categoryService.deleteProduct(it).execute()
            assertThat(response.code()).isEqualTo(201)
        }

    }


}