package ua.hurin.pancakes.dto

import ua.hurin.pancakes.model.Client

data class ClientDto(
        val id: Long = 0,
        val name: String,
        val phoneNumber: String
) {
    companion object {
        fun ClientDto.toClient(id: Long) =
                Client(
                        id = id,
                        name = this.name,
                        phoneNumber = this.phoneNumber
                )
    }
}
