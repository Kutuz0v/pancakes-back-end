package ua.hurin.pancakes.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonNaming
import ua.hurin.pancakes.model.Ingredient

data class PancakeDto(
    val price: Int,     // in UAH
    val weight: Int,     // in grams
    @JsonProperty(value = "ingredients")
    val ingredientsDto: List<IngredientDto> = emptyList()
)
