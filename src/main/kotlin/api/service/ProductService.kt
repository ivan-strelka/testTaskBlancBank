package api.service

import api.constants.PRODUCTS_URL
import api.constants.PRODUCT_URL
import api.dto.product.*
import retrofit2.Call
import retrofit2.http.*

interface ProductService {

    @POST(PRODUCT_URL)
    fun addProduct(
        @Body product: AddProductRequest
    ): Call<ResponseCreateProduct>

    @DELETE("$PRODUCT_URL/{id}")
    fun deleteProduct(
        @Path("id") id: String?
    ): Call<ResponseUpdate>

    @GET("$PRODUCT_URL/{id}")
    fun getProduct(
        @Path("id") id: String?
    ): Call<ResponseGetSingleProduct>

    @GET(PRODUCTS_URL)
    fun getAllProduct(): Call<ListProductResp>

    @PATCH("$PRODUCT_URL/{id}")
    fun updateCategory(
        @Path("id") id: String?,
        @Body product: AddProductRequest
    ): Call<ResponseUpdate>

}