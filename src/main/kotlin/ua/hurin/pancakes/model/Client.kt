package ua.hurin.pancakes.model

import ua.hurin.pancakes.dto.ClientDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var name: String,
    val phoneNumber: String
) {
    companion object {
        fun Client.toClientDto() =
            ClientDto(id, name, phoneNumber)
    }
}
