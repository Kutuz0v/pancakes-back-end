package ua.hurin.pancakes.controller

import org.springframework.web.bind.annotation.*
import ua.hurin.pancakes.dto.IngredientDto
import ua.hurin.pancakes.service.IngredientService

@RestController
@RequestMapping("/ingredients")
class IngredientController(
    val service: IngredientService
) {

    @PostMapping
    fun create(@RequestBody ingredientDto: IngredientDto): IngredientDto =
        service.create(ingredientDto)

    @GetMapping("/{id}")
    fun getIngredient(@PathVariable id: Long): IngredientDto =
        service.get(id)

    @GetMapping
    fun getAll(): List<IngredientDto> =
        service.getAll()

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody ingredientDto: IngredientDto
    ): IngredientDto =
        service.update(id, ingredientDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}