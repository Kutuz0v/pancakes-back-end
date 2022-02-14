package ua.hurin.pancakes.exception

import org.springframework.http.HttpStatus
import java.util.function.Supplier

abstract class BaseException(
    open val errorCode: String,
    override val message: String,
    var status: HttpStatus
) : RuntimeException(message), Supplier<BaseException> {

    override fun get(): BaseException = this
}