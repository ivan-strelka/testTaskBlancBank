package tests.api.categoryTests

import api.constants.CATEGORY_URL
import api.constants.FEATURE_API
import api.dto.AddCategoryResponse
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
import retrofit2.Response
import tests.api.BaseTest
import tests.api.categoryTests.steps.checkCategoryResponse
import tests.api.categoryTests.steps.createRandomVisibleBodyCategory

@Tag("WEB_API")
@DisplayName("Tests API method DELETE $CATEGORY_URL -> Удаление категории")
class DeleteCategoryTest : BaseTest() {

    @Test
    @DisplayName("Базовый позитивный кейс удаления категории")
    @Description("Удаляем предварительно созданную сущность Category")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun deleteCategoryPositiveTest() {
        val category = createRandomVisibleBodyCategory()
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        val id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
        val respDelete = categoryService.deleteCategory(id).execute()
        checkCategoryResponse(respDelete, category)

    }

    @Test
    @DisplayName("Базовый негативный кейс двойного удаления категории")
    @Description("Дважды удаляем предварительно созданную сущность Category")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun doubleDeleteCategoryTest() {
        val category = createRandomVisibleBodyCategory()
        val response = categoryService.addCategory(category).execute()
        val id = response.body()?.value?.id.toString()
        checkCategoryResponse(response, category)
        val respDelete = categoryService.deleteCategory(id).execute()
        checkCategoryResponse(respDelete, category)
        val respDelete2 = categoryService.deleteCategory(id).execute()
        assertThat(respDelete2.code()).isEqualTo(500)

    }

    @Test
    @DisplayName("Негативный кейс удаления не существующей категории")
    @Description("Удаляем не существующий объект Category path -> random Int")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun intDeleteCategoryTest() {
        val respDelete = categoryService.deleteCategory(generateRndInt()).execute()
        assertThat(respDelete.code()).isEqualTo(400)

    }

    @Test
    @DisplayName("Негативный кейс удаления не существующей категории UUID")
    @Description("Удаляем не существующий объект Category path -> random UUID")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun uuidDeleteCategoryTest() {
        val respDelete = categoryService.deleteCategory(generateRndInt()).execute()
        assertThat(respDelete.code()).isEqualTo(400)
    }

    @ParameterizedTest(name = "#{index} - Негативный тест удаления не существующего объект Category path  -> {0}")
    @DisplayName("Негативный кейс удаления не существующей категории с разными path parameters")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.NORMAL)
    @ArgumentsSource(TestData::class)
    fun diffDeleteCategoryTest(input: String) {
        val respDelete = categoryService.deleteCategory(input).execute()
        assertThat(respDelete.code()).isEqualTo(400)

    }


}