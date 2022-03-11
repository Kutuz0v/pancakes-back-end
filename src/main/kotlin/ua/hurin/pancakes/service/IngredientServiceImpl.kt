package ua.hurin.pancakes.service

import org.springframework.stereotype.Service
import ua.hurin.pancakes.dto.IngredientDto
import ua.hurin.pancakes.dto.IngredientDto.Companion.toIngredient
import ua.hurin.pancakes.exception.IngredientNotFoundException
import ua.hurin.pancakes.model.Ingredient.Companion.toIngredientDto
import ua.hurin.pancakes.repository.IngredientRepository

@Service
class IngredientServiceImpl(
        val repository: IngredientRepository
) : IngredientService {
    override fun create(ingredientDto: IngredientDto): IngredientDto =
            saveIngredient(ingredientDto)

    override fun get(id: Long): IngredientDto =
            repository
                    .findById(id).orElseThrow(IngredientNotFoundException(id))
                    .toIngredientDto()

    override fun getAll(): List<IngredientDto> =
            repository.findAll()
                    .map { it.toIngredientDto() }

    override fun update(id: Long, ingredientDto: IngredientDto): IngredientDto =
            if (repository.existsById(id))
                saveIngredient(id, ingredientDto)
            else throw IngredientNotFoundException(id)

    override fun delete(id: Long) =
            if (repository.existsById(id))
                repository.deleteById(id)
            else throw IngredientNotFoundException(id)

    private fun saveIngredient(id: Long, ingredientDto: IngredientDto): IngredientDto =
            repository
                    .save(ingredientDto.toIngredient(id))
                    .toIngredientDto()


    private fun saveIngredient(ingredientDto: IngredientDto): IngredientDto =
            saveIngredient(0, ingredientDto)
}