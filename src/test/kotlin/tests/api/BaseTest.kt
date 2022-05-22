package tests.api

import api.service.CategoryService
import api.service.ProductService
import api.utils.RetrofitUtils

open class BaseTest {

    val retrofitUtils = RetrofitUtils()
    val retrofit = retrofitUtils.getRetrofit()
    val categoryService = retrofit!!.create(CategoryService::class.java)
    val productService = retrofit!!.create(ProductService::class.java)

}