package api.dto.product

import api.dto.Value
import com.fasterxml.jackson.annotation.JsonProperty

data class Response(

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

