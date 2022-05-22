package tests.api.categoryTests

import api.constants.CATEGORY_URL
import api.constants.FEATURE_API
import api.dto.AddCategoryResponse
import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import org.assertj.core.api.Assertions
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
@DisplayName("Tests API method UPDATE $CATEGORY_URL -> Обновление категории")
class UpdateCategoryTest : BaseTest() {

    private var id: String? = ""

    @Test
    @DisplayName("Базовый позитивный кейс обновления категории")
    @Description("Обновляем предварительно созданную сущность Category")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateCategoryPositiveTest() {
        val category = createRandomVisibleBodyCategory()
        val response: Response<AddCategoryResponse> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateCategory = createRandomVisibleBodyCategory()
        val id2 = response.body()?.value?.id
        val updateResponse = categoryService.updateCategory(id = id2, updateCategory).execute()
        checkCategoryResponse(updateResponse, updateCategory)

    }

    @Test
    @DisplayName("Обновление категории такой же сущностью")
    @Description("Обновляем предварительно созданную сущность Category таким же body")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateCategoryTest() {
        val category = createRandomVisibleBodyCategory()
        val response = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateResponse = categoryService.updateCategory(id = id, category).execute()
        checkCategoryResponse(updateResponse, category)

    }

    @Test
    @DisplayName("Обновление категории не видимую на видимую")
    @Description("Обновляем предварительно созданную сущность Category не видимую на видимую")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateUnVisCategoryTest() {
        val category = createRandomUnvisibleBodyCategory()
        val response = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateCategory = createRandomVisibleBodyCategory()
        val id2 = response.body()?.value?.id
        val updateResponse = categoryService.updateCategory(id = id2, updateCategory).execute()
        checkCategoryResponse(updateResponse, updateCategory)

    }

    @Test
    @DisplayName("Обновление категории не видимую на не видимую")
    @Description("Обновляем предварительно созданную сущность Category не видимую на не видимую")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateUnVisCategoryTest2() {
        val category = createRandomUnvisibleBodyCategory()
        val response = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateCategory = createRandomUnvisibleBodyCategory()
        val id2 = response.body()?.value?.id
        val updateResponse = categoryService.updateCategory(id = id2, updateCategory).execute()
        checkCategoryResponse(updateResponse, updateCategory)

    }

    @Test
    @DisplayName("Обновление категории видимую на не видимую")
    @Description("Обновляем предварительно созданную сущность Category видимую на не видимую")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateUnVisCategoryTest3() {
        val category = createRandomVisibleBodyCategory()
        val response = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateCategory = createRandomUnvisibleBodyCategory()
        val id2 = response.body()?.value?.id
        val updateResponse = categoryService.updateCategory(id = id2, updateCategory).execute()
        checkCategoryResponse(updateResponse, updateCategory)

    }

    @Test
    @DisplayName("Обновление категории видимую на пустое body")
    @Description("Обновляем предварительно созданную сущность Category на пустое body")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateUnVisCategoryTest4() {
        val category = createRandomVisibleBodyCategory()
        val response = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateCategory = createAnyBody()
        val id2 = response.body()?.value?.id
        val updateResponse = categoryService.updateCategory(id = id2, updateCategory).execute()
        checkCategoryResponse(updateResponse, updateCategory)

    }

    @Test
    @DisplayName("Обновление категории видимую на заполненное body")
    @Description("Обновляем предварительно созданную сущность Category на заполненное body")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateUnVisCategoryTest5() {
        val category = createAnyBody()
        val response = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateCategory = createRandomUnvisibleBodyCategory()
        val id2 = response.body()?.value?.id
        val updateResponse = categoryService.updateCategory(id = id2, updateCategory).execute()
        checkCategoryResponse(updateResponse, updateCategory)

    }

    @Test
    @DisplayName("Обновление категории видимую на пустое body")
    @Description("Обновляем предварительно созданную пустую сущность Category на пустое body")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateUnVisCategoryTest6() {
        val category = createAnyBody()
        val response = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateCategory = createAnyBody()
        val id2 = response.body()?.value?.id
        val updateResponse = categoryService.updateCategory(id = id2, updateCategory).execute()
        checkCategoryResponse(updateResponse, updateCategory)

    }

    @Test
    @DisplayName("Обновление категории видимую на пустое body")
    @Description("Обновляем предварительно созданную null сущность Category на пустое body")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateUnVisCategoryTest7() {
        val category = createAnyBody(name = "null", brand = "null")
        val response = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateCategory = createAnyBody()
        val id2 = response.body()?.value?.id
        val updateResponse = categoryService.updateCategory(id = id2, updateCategory).execute()
        checkCategoryResponse(updateResponse, updateCategory)

    }

    @Test
    @DisplayName("Обновление категории видимую на пустое body")
    @Description("Обновляем предварительно созданную null сущность Category на пустое null")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.CRITICAL)
    fun updateUnVisCategoryTest8() {
        val category = createAnyBody(name = "null", brand = "null")
        val response = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id
        checkCategoryResponse(response, category)
        val updateCategory = createAnyBody(name = "null", brand = "null")
        val id2 = response.body()?.value?.id
        val updateResponse = categoryService.updateCategory(id = id2, updateCategory).execute()
        checkCategoryResponse(updateResponse, updateCategory)

    }


    @AfterEach
    fun deleteCategory() {
        id.let {
            val response = categoryService.deleteCategory(it).execute()
            Assertions.assertThat(response.code()).isEqualTo(201)
        }

    }
}