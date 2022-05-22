package api.service

import api.constants.CATEGORY_URL
import api.dto.AddCategoryRequest
import api.dto.AddCategoryResponse
import retrofit2.Call
import retrofit2.http.*


interface CategoryService {

    @PATCH("$CATEGORY_URL/{id}")
    fun updateCategory(
        @Path("id") id: String?,
        @Body category: AddCategoryRequest
    ): Call<AddCategoryResponse>

    @DELETE("$CATEGORY_URL/{id}")
    fun deleteCategory(
        @Path("id") id: String?
    ): Call<AddCategoryResponse>


    @POST(CATEGORY_URL)
    fun addCategory(
        @Body category: AddCategoryRequest
    ): Call<AddCategoryResponse>
}