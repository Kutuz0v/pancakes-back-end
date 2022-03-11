package ua.hurin.pancakes.exception

import org.springframework.http.HttpStatus

open class NotFoundException : BaseException(
        errorCode = "not.found",
        message = "Entity not found",
        status = HttpStatus.NOT_FOUND
)

class ClientNotFoundException(val id: Long) : NotFoundException() {
    override val errorCode: String
        get() = "client." + super.errorCode
    override val message: String
        get() = "Client with id = $id not found"
}

class PancakeNotFoundException(val id: Long) : NotFoundException() {
    override val errorCode: String
        get() = "pancake." + super.errorCode
    override val message: String
        get() = "Pancake with id = $id not found"
}


class IngredientNotFoundException(val id: Long) : NotFoundException() {
    override val errorCode: String
        get() = "ingredient." + super.errorCode
    override val message: String
        get() = "Ingredient with id = $id not found"
}