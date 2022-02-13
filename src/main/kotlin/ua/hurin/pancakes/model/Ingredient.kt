package ua.hurin.pancakes.model

import javax.persistence.*


@Entity
data class Ingredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    /** at Ukrainian */
    val value: String,

    /** in grams */
    val weight: Int,

    /** in UAH */
    val price: Int,
    @ManyToOne
    @JoinColumn(name ="pancake_id")
    var pancake: Pancake
)
//{
    //CHEESE(null, "Сир твердий", 40, 14),
    //FRIED_MUSHROOMS(null, "Гриби смажені", 50, 14),
//    CHICKEN_MEAT("М'ясо куряче", 50, 14),
//    HUNTING_SAUSAGES("Ковбаски мисливські", 50, 13),
//    HAM("Шинка", 50, 13),
//    CRAB_STICKS("Крабові палички", 50, 15),
//    MILK_SAUSAGE("Сосиска молочна", 50, 13),
//    CANNED_PINEAPPLE("Ананас консерв.", 50, 15),
//    FRIED_ONIONS("Цибуля смажена", 50, 9 ),
//    CABBAGE_STEWED("Капуста тушкована", 80, 10),
//    MASHED_POTATOES("Картопля (пюре)", 80, 9 ),
//    BOILED_EGG("Яйце відварне", 50, 8 ),
//    CANNED_CORN("Кукурудза консерв.", 50, 8 ),
//    FRESH_TOMATO("Помідор свіжий", 50, 7 ),
//    FRESH_CUCUMBER("Огірок свіжий", 50, 7 ),
//    PICKLED_CUCUMBER("Огірок солоний", 40, 7 ),
//    CARROTS_IN_KOREAN("Морква по-корейськи", 80, 7 ),
//    FRESH_CABBAGE("Капуста свіжа", 80, 7 );
//}