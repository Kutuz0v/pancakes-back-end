package ua.hurin.pancakes.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(exception: BaseException): ResponseEntity<ApiErrorBody> =
        ResponseEntity(
            ApiErrorBody(
                errorCode = exception.errorCode,
                message = exception.message
            ),
            exception.status
        )
}