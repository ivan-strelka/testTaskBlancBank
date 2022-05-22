package api.dto.product

import com.fasterxml.jackson.annotation.JsonProperty

data class AddProductRequest(

	@field:JsonProperty("amount")
	val amount: Int,

	@field:JsonProperty("name")
	val name: String,

	@field:JsonProperty("discount")
	val discount: Int,

	@field:JsonProperty("categories")
	val categories: List<CategoriesItem>,

	@field:JsonProperty("isVisible")
	val isVisible: String,

	@field:JsonProperty("percentDiscount")
	val percentDiscount: Int
)

data class CategoriesItem(

	@field:JsonProperty("name")
	val name: String,

	@field:JsonProperty("isVisible")
	val isVisible: Boolean,

	@field:JsonProperty("brand")
	val brand: String
)
