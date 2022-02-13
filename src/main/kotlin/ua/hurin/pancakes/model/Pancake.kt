package ua.hurin.pancakes.model

import javax.persistence.*

@Entity
data class Pancake(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val price: Int,     // in UAH
    val weight: Int,     // in grams

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pancake", cascade = [CascadeType.ALL])
    var ingredients: List<Ingredient>? = emptyList()
)
