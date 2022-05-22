package api.service

import api.constants.*
import api.dto.AddCategoryRequest
import api.dto.ResponseAddCategory
import retrofit2.Call
import retrofit2.http.*


interface CategoryService {


    @PATCH("$CATEGORY_URL/{id}")
    fun updateCategory(
        @Path("id") id: Long?,
        @Body category: AddCategoryRequest
    ): Call<ResponseAddCategory>

    @DELETE("$CATEGORY_URL/{id}")
    fun deleteProduct(
        @Path("id") id: String?
    ): Call<ResponseAddCategory>


    @POST(CATEGORY_URL)
    fun addCategory(
        @Body category: AddCategoryRequest
    ): Call<CategoryResp2>
}