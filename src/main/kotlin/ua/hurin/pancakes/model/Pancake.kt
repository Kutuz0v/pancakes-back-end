package ua.hurin.pancakes.model

import ua.hurin.pancakes.dto.PancakeDto
import ua.hurin.pancakes.model.Ingredient.Companion.toIngredientDto
import javax.persistence.*

@Entity
data class Pancake(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val price: Int,
    /** in UAH */
    val weight: Int,
    /** in grams */


    //@ManyToMany(cascade = [CascadeType.PERSIST])  // create new items all time
    //@ManyToMany(cascade = [CascadeType.REFRESH])  // save before flushing
    //@ManyToMany(cascade = [CascadeType.ALL])      // create new items all time
    //@ManyToMany(cascade = [CascadeType.DETACH])   // save before flushing
    //@ManyToMany(cascade = [CascadeType.MERGE])    // save before flushing
    //@ManyToMany(cascade = [CascadeType.REMOVE])   // save before flushing
    //@ManyToMany()                                 // save before flushing
    @ManyToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH])
    @JoinTable(
        name = "related_ingredients",
        joinColumns = [JoinColumn(name = "pancake_id")],
        inverseJoinColumns = [JoinColumn(name = "ingredient_id")]
    )
    //@JsonIgnore(value = true)
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
