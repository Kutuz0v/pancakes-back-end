package ua.hurin.pancakes.model

import ua.hurin.pancakes.dto.PancakeDto
import ua.hurin.pancakes.model.Ingredient.Companion.toIngredientDto
import javax.persistence.*

@Entity
data class Pancake(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val price: Int,     /** in UAH */
    val weight: Int,    /** in grams */


    @ManyToMany()
    @JoinTable(
        name = "related_ingredients",
        joinColumns = [JoinColumn(name = "pancake_id")],
        inverseJoinColumns = [JoinColumn(name = "ingredient_id")]
    )
    var ingredients: Set<Ingredient>? = mutableSetOf()
) {
    companion object {
        fun Pancake.toPancakeDto() =
            PancakeDto(
                id,
                price,
                weight,
                ingredients!!.map {
                    it.toIngredientDto()
                }.toSet()
            )
    }
}
