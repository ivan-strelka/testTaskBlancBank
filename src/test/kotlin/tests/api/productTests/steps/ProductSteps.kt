package tests.api.productTests.steps

import api.constants.*
import api.dto.product.AddProductRequest
import api.dto.product.ResponseCreateProduct
import api.dto.product.ResponseGetSingleProduct
import api.dto.product.ResponseUpdate
import api.utils.data.generateRndFirstName
import api.utils.data.generateRndInt
import api.utils.data.generateRndPercentDiscount
import io.qameta.allure.Step
import org.assertj.core.api.Assertions.assertThat
import retrofit2.Response
import tests.api.categoryTests.steps.createAnyBody
import tests.api.categoryTests.steps.createRandomVisibleBodyCategory

@Step("Создаём body для POST $API_URL$PRODUCT_URL со всеми полями")
fun createRandomBodyProduct(): AddProductRequest {
    return AddProductRequest(
        amount = generateRndInt().toInt(),
        name = generateRndFirstName(),
        discount = generateRndInt().toInt(),
        categories = listOf(createRandomVisibleBodyCategory()),
        isVisible = true,
        percentDiscount = generateRndPercentDiscount().toInt()
    )
}

@Step("Создаём пустое body для POST $PRODUCT_URL ")
fun createEmptyBodyProduct(): AddProductRequest {
    return AddProductRequest(
        amount = 0,
        name = "",
        discount = 0,
        categories = listOf(createAnyBody()),
        isVisible = true,
        percentDiscount = 0
    )
}

@Step("Проверяем всё body ответа {response} после создания продукта {product}")
fun checkProductResp(
    response: Response<ResponseCreateProduct>,
    product: AddProductRequest
) {
    assertThat(response.code()).isEqualTo(201)
    assertThat(response.body()?.action).isEqualTo(ADD)
    assertThat(response.body()?.values?.get(0)?.id).isNotNull
    assertThat(response.body()?.values?.get(0)?.categories?.get(0)?.id).isNotNull
    assertThat(response.body()?.values?.get(0)?.productName).isEqualTo(product.name)
    assertThat(response.body()?.values?.get(0)?.amount).isEqualTo(product.amount)
    assertThat(response.body()?.values?.get(0)?.discount).isEqualTo(product.discount)
    assertThat(response.body()?.values?.get(0)?.percentDiscount).isEqualTo(product.percentDiscount)
    assertThat(response.body()?.values?.get(0)?.isVisible).isEqualTo(product.isVisible)
    assertThat(response.body()?.values?.get(0)?.created).isNotNull
    assertThat(response.body()?.values?.get(0)?.created).isNotNull
    assertThat(response.body()?.values?.get(0)?.categories?.get(0)?.name).isEqualTo(product.categories[0].name)
    assertThat(response.body()?.values?.get(0)?.categories?.get(0)?.brand).isEqualTo(product.categories[0].brand)
    assertThat(response.body()?.values?.get(0)?.categories?.get(0)?.isVisible).isEqualTo(product.categories[0].isVisible)
    assertThat(response.body()?.values?.get(0)?.categories?.get(0)?.created).isNotNull
    assertThat(response.body()?.values?.get(0)?.categories?.get(0)?.modified).isNotNull
}

@Step("Проверяем всё body ответа {response} после создания продукта {product}")
fun checkGetProduct(
    responseGet: Response<ResponseGetSingleProduct>,
    product: AddProductRequest
) {
    assertThat(responseGet.code()).isEqualTo(200)
    assertThat(responseGet.body()?.value?.id).isNotNull
    assertThat(responseGet.body()?.value?.productName).isEqualTo(product.name)
    assertThat(responseGet.body()?.value?.amount).isEqualTo(product.amount)
    assertThat(responseGet.body()?.value?.discount).isEqualTo(product.discount)
    assertThat(responseGet.body()?.value?.percentDiscount).isEqualTo(product.percentDiscount)
    assertThat(responseGet.body()?.value?.isVisible).isEqualTo(product.isVisible)
    assertThat(responseGet.body()?.value?.created).isNotNull
    assertThat(responseGet.body()?.value?.modified).isNotNull
    assertThat(responseGet.body()?.value?.categories?.get(0)?.isVisible).isEqualTo(product.categories[0].isVisible)
    assertThat(responseGet.body()?.value?.categories?.get(0)?.name).isEqualTo(product.categories[0].name)
    assertThat(responseGet.body()?.value?.categories?.get(0)?.brand).isEqualTo(product.categories[0].brand)
    assertThat(responseGet.body()?.value?.categories?.get(0)?.created).isNotNull
    assertThat(responseGet.body()?.value?.categories?.get(0)?.modified).isNotNull
    assertThat(responseGet.body()?.value?.categories?.get(0)?.id).isNotNull
}

@Step("Проверяем всё body ответа {updateResponse} после обновления продукта {updateProduct}")
fun checkUpdateResp(
    updateResponse: Response<ResponseUpdate>,
    updateProduct: AddProductRequest,
    id: String?
) {
    assertThat(updateResponse.code()).isEqualTo(200)
    assertThat(updateResponse.body()?.action).isEqualTo(EDIT)
    assertThat(updateResponse.body()?.value?.id).isEqualTo(id)
    assertThat(updateResponse.body()?.value?.productName).isEqualTo(updateProduct.name)
    assertThat(updateResponse.body()?.value?.amount).isEqualTo(updateProduct.amount)
    assertThat(updateResponse.body()?.value?.discount).isEqualTo(updateProduct.discount)
    assertThat(updateResponse.body()?.value?.percentDiscount).isEqualTo(updateProduct.percentDiscount)
}

@Step("Проверяем всё body ответа {updateResponse} после обновления продукта {updateProduct}")
fun checkDeleteResp(
    updateResponse: Response<ResponseUpdate>,
    updateProduct: AddProductRequest,
    id: String?
) {
    assertThat(updateResponse.code()).isEqualTo(200)
    assertThat(updateResponse.body()?.action).isEqualTo(REMOVE)
    assertThat(updateResponse.body()?.value?.id).isEqualTo(id)
    assertThat(updateResponse.body()?.value?.productName).isEqualTo(updateProduct.name)
    assertThat(updateResponse.body()?.value?.amount).isEqualTo(updateProduct.amount)
    assertThat(updateResponse.body()?.value?.discount).isEqualTo(updateProduct.discount)
    assertThat(updateResponse.body()?.value?.percentDiscount).isEqualTo(updateProduct.percentDiscount)
}

