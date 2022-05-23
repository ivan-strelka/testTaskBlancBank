package tests.api.categoryTests.steps

import api.constants.ADD
import api.constants.API_URL
import api.constants.CATEGORY_URL
import api.dto.AddCategoryRequest
import api.dto.AddCategoryResponse
import api.utils.data.generateRndCompanyName
import api.utils.data.generateRndFirstName
import io.qameta.allure.Step
import org.assertj.core.api.Assertions.assertThat
import retrofit2.Response

@Step("Проверяем всё body ответа {response} после создания категории {category}")
fun checkCategoryResponse(
    response: Response<AddCategoryResponse>,
    category: AddCategoryRequest,
    code: Int = 201
) {
    assertThat(response.code()).isEqualTo(code)
    assertThat(response.body()?.value?.name).isEqualTo(category.name)
    assertThat(response.body()?.value?.brand).isEqualTo(category.brand)
    assertThat(response.body()?.value?.isVisible).isEqualTo(category.isVisible)
    assertThat(response.body()?.action).isEqualTo(ADD)
    assertThat(response.body()?.value?.id).isNotNull
    assertThat(response.body()?.value?.modified).isNotNull
    assertThat(response.body()?.value?.created).isNotNull
}

@Step("Создаём body для POST $API_URL$CATEGORY_URL со всеми полями с isVisible = true")
fun createRandomVisibleBodyCategory(): AddCategoryRequest {
    return AddCategoryRequest(generateRndFirstName(), true, generateRndCompanyName())
}

@Step("Создаём body для POST $API_URL$CATEGORY_URL со всеми полями с isVisible = false")
fun createRandomUnvisibleBodyCategory(): AddCategoryRequest {
    return AddCategoryRequest(generateRndFirstName(), false, generateRndCompanyName())
}


@Step("Создаём body с параметрами для POST $API_URL$CATEGORY_URL со всеми полями с isVisible = false")
fun createAnyBody(name: String = "", isVisible: Boolean = true, brand: String = ""): AddCategoryRequest {
    return AddCategoryRequest(name, isVisible, brand)
}
