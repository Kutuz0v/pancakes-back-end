package ua.hurin.pancakes.service

import org.springframework.stereotype.Service
import ua.hurin.pancakes.dto.IngredientDto
import ua.hurin.pancakes.dto.PancakeDto
import ua.hurin.pancakes.model.Ingredient
import ua.hurin.pancakes.model.Pancake
import ua.hurin.pancakes.repository.IngredientRepository
import ua.hurin.pancakes.repository.PancakeRepository

@Service
class PancakeServiceImpl(
    private val pancakeRepository: PancakeRepository,
    private val ingredientRepository: IngredientRepository
) : PancakeService {

    override fun createPancake(pancakeDto: PancakeDto): PancakeDto =
        savePancake(0, pancakeDto)

    override fun getPancake(id: Long): PancakeDto =
        pancakeRepository.findById(id)
            .get()
            .toPancakeDto()

    override fun getAllPancakes(): List<PancakeDto> =
        pancakeRepository.findAll()
            .map {
                it.toPancakeDto()
            }

    override fun updatePancake(id: Long, pancakeDto: PancakeDto): PancakeDto =
        savePancake(id, pancakeDto)

    override fun deletePancake(id: Long) =
        pancakeRepository.deleteById(id)

    private fun savePancake(id: Long, pancakeDto: PancakeDto):PancakeDto {
        val pancakeToSave = pancakeDto.toPancake(id)
        val savedPancake = pancakeRepository.save(pancakeToSave)
        pancakeToSave.ingredients?.forEach {
            it.pancake = savedPancake
            ingredientRepository.save(it)
        }
        return savedPancake.toPancakeDto()
    }

    private fun Ingredient.toIngredientDto() =
        IngredientDto(
            value, weight, price
        )

    private fun IngredientDto.toIngredient(pancake: Pancake) =
        Ingredient(
            0, value, weight, price, pancake
        )

    private fun Pancake.toPancakeDto() =
        PancakeDto(
            price,
            weight,
            ingredients!!.map {
                it.toIngredientDto()
            }
        )

    @Deprecated(
        message = "Method marked us unused.",
        ReplaceWith("toPancake(id)"),
        level = DeprecationLevel.ERROR
    )
    private fun PancakeDto.toPancake() =
        toPancake(0)

    private fun PancakeDto.toPancake(id: Long): Pancake {
        val pancake = Pancake(
            id,
            price,
            weight,
            null
        )
        pancake.ingredients = this.ingredientsDto.map {
            it.toIngredient(pancake)
        }
        return pancake
    }
}