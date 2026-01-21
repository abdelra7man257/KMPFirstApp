package models

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName



@Serializable
data class ProductsResponseItem(

    @SerialName("image")
    val image: String? = null,

    @SerialName("price")
    val price: Double? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("id")
    val id: Int? = null,

    @SerialName("title")
    val title: String? = null,

    @SerialName("category")
    val category: String? = null
)
