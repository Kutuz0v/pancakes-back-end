package ua.hurin.pancakes.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ua.hurin.pancakes.model.Ingredient

@Repository
interface IngredientRepository: CrudRepository<Ingredient, Long> {
}