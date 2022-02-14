package ua.hurin.pancakes.service

import ua.hurin.pancakes.dto.ClientDto


interface ClientService {
    fun create(clientDto: ClientDto): ClientDto

    fun get(id: Long): ClientDto

    fun getAll(): List<ClientDto>

    fun update(id: Long, clientDto: ClientDto): ClientDto

    fun delete(id: Long)
}