package ua.hurin.pancakes.dto

import ua.hurin.pancakes.model.Ingredient

data class IngredientDto(
    val id: Long,
    val value: String,
    /** at Ukrainian */
    val weight: Int,
    /** in grams */
    val price: Int,
    /** in UAH */
) {
    companion object {
        fun IngredientDto.toIngredient(id: Long) =
            Ingredient(
                id, value, weight, price
            )
    }
}
