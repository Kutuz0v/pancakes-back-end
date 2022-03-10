package ua.hurin.pancakes.model

import ua.hurin.pancakes.dto.IngredientDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class Ingredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    /** at Ukrainian */
    val value: String,

    /** in grams */
    val weight: Int,

    /** in UAH */
    val price: Int,

    /*@ManyToMany(mappedBy = "ingredients")
    @JsonIgnore
    var pancakes: Set<Pancake> = mutableSetOf()*/
) {

    companion object {
        fun Ingredient.toIngredientDto() =
            IngredientDto(id, value, weight, price)
    }
}
