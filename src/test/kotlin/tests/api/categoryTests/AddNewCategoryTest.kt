package tests.api.categoryTests

import api.constants.*
import api.constants.CATEGORY_URL
import api.constants.FEATURE_API
import api.utils.data.*
import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import retrofit2.Response
import tests.api.BaseTest

@Tag("WEB_API")
@DisplayName("Tests method POST $CATEGORY_URL -> `Добавление категории` ")
class AddNewCategoryTest : BaseTest() {

    private lateinit var id: String

    @Test
    @DisplayName("Базовый позитивный кейс")
    @Description("Создаём видимую категорию со всеми полями")
    @Feature(FEATURE_API)
    @Severity(SeverityLevel.NORMAL)
    fun name2() {
        val category = createRandomCategory2()
        val response: Response<CategoryResp2> = categoryService.addCategory(category).execute()
        id = response.body()?.value?.id.toString()
        assertThat(response.code()).isEqualTo(201)
        assertThat(response.body()?.value?.name).isEqualTo(category.name)
        assertThat(response.body()?.value?.brand).isEqualTo(category.brand)
        assertThat(response.body()?.value?.isVisible).isEqualTo(category.isVisible)
        assertThat(response.body()?.action).isEqualTo(ADD)
        assertThat(response.body()?.value?.id).isNotNull()
        assertThat(response.body()?.value?.modified).isNotNull()
        assertThat(response.body()?.value?.created).isNotNull()

    }

    @AfterEach
    fun deleteCategory() {
        id.let {
            val response = categoryService.deleteProduct(it).execute()
            assertThat(response.code()).isEqualTo(201)
        }

    }


}