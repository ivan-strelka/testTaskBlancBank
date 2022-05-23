package api.dto

import com.fasterxml.jackson.annotation.JsonProperty


data class AddCategoryRequest(
    @field:JsonProperty("name")
    val name: String,

    @field:JsonProperty("isVisible")
    val isVisible: Boolean,

    @field:JsonProperty("brand")
    val brand: String
)

data class AddCategoryResponse(

    @field:JsonProperty("action")
    val action: String,

    @field:JsonProperty("value")
    val value: Value
)

data class Value(

    @field:JsonProperty("created")
    val created: String,

    @field:JsonProperty("name")
    val name: String,

    @field:JsonProperty("modified")
    val modified: String,

    @field:JsonProperty("id")
    val id: String,

    @field:JsonProperty("isVisible")
    val isVisible: Boolean,

    @field:JsonProperty("brand")
    val brand: String
)

data class ErrorResponse(

    @field:JsonProperty("path")
    val path: String,

    @field:JsonProperty("error")
    val error: String,

    @field:JsonProperty("timestamp")
    val timestamp: Long,

    @field:JsonProperty("status")
    val status: Int
)




