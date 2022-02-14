package ua.hurin.pancakes.dto

import com.fasterxml.jackson.annotation.JsonProperty
import ua.hurin.pancakes.dto.IngredientDto.Companion.toIngredient
import ua.hurin.pancakes.model.Pancake

data class PancakeDto(
    val id: Long,
    val price: Int,
    /** in UAH */
    val weight: Int,
    /** in grams */
    @JsonProperty(value = "ingredients")
    val ingredientsDto: Set<IngredientDto> = mutableSetOf()
) {
    companion object {
        fun PancakeDto.toPancake(id: Long): Pancake =
            Pancake(
                id,
                price,
                weight,
                ingredientsDto
                    .map { it.toIngredient(id) }
                    .toSet()
            )
    }
}
