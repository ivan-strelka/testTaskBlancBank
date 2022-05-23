package api.dto.product

import api.dto.AddCategoryRequest
import api.dto.Value
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class AddProductRequest(

    @field:JsonProperty("amount")
    val amount: Int,

    @field:JsonProperty("name")
    val name: String,

    @field:JsonProperty("discount")
    val discount: Int,

    @field:JsonProperty("categories")
    val categories: List<AddCategoryRequest>,

    @field:JsonProperty("isVisible")
    val isVisible: Boolean,

    @field:JsonProperty("percentDiscount")
    val percentDiscount: Int
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseCreateProduct(

    @field:JsonProperty("values")
    val values: List<ValuesItem>,

    @field:JsonProperty("action")
    val action: String
)

data class ValuesItem(

    @field:JsonProperty("amount")
    val amount: Int,

    @field:JsonProperty("created")
    val created: String,

    @field:JsonProperty("discount")
    val discount: Int,

    @field:JsonProperty("modified")
    val modified: String,

    @field:JsonProperty("id")
    val id: String,

    @field:JsonProperty("categories")
    val categories: List<Value>,

    @field:JsonProperty("isVisible")
    val isVisible: Boolean,

    @field:JsonProperty("productName")
    val productName: String,

    @field:JsonProperty("percentDiscount")
    val percentDiscount: Int
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ListProductResp(

    @field:JsonProperty("values")
    val values: List<ValuesItem>
)

data class ResponseGetSingleProduct(

    @field:JsonProperty("value")
    val value: ValueThings
)

data class ValueThings(

    @field:JsonProperty("amount")
    val amount: Int,

    @field:JsonProperty("created")
    val created: String,

    @field:JsonProperty("discount")
    val discount: Int,

    @field:JsonProperty("modified")
    val modified: String,

    @field:JsonProperty("id")
    val id: String,

    @field:JsonProperty("categories")
    val categories: List<Value>,

    @field:JsonProperty("isVisible")
    val isVisible: Boolean,

    @field:JsonProperty("productName")
    val productName: String,

    @field:JsonProperty("percentDiscount")
    val percentDiscount: Int
)

data class ResponseUpdate(

    @field:JsonProperty("action")
    val action: String,

    @field:JsonProperty("value")
    val value: ValueItem
)

data class ValueItem(

    @field:JsonProperty("amount")
    val amount: Int,

    @field:JsonProperty("created")
    val created: String,

    @field:JsonProperty("discount")
    val discount: Int,

    @field:JsonProperty("modified")
    val modified: String,

    @field:JsonProperty("id")
    val id: String,

    @field:JsonProperty("categories")
    val categories: List<Any>,

    @field:JsonProperty("isVisible")
    val isVisible: Boolean,

    @field:JsonProperty("productName")
    val productName: String,

    @field:JsonProperty("percentDiscount")
    val percentDiscount: Int
)

