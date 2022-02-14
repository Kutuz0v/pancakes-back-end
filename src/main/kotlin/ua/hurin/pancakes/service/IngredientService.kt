package ua.hurin.pancakes.service

import ua.hurin.pancakes.dto.IngredientDto

interface IngredientService {

    fun create(ingredientDto: IngredientDto): IngredientDto

    fun get(id: Long): IngredientDto

    fun getAll(): List<IngredientDto>

    fun update(id: Long, ingredientDto: IngredientDto): IngredientDto

    fun delete(id: Long)
}