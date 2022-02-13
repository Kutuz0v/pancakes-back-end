package ua.hurin.pancakes.service

import ua.hurin.pancakes.dto.ClientDto


interface ClientService {
    fun createClient(clientDto: ClientDto): ClientDto

    fun getClient(phoneNumber: String): ClientDto

    fun getAllClients(): List<ClientDto>

    fun updateClient(phoneNumber: String, clientDto: ClientDto): ClientDto

    fun deleteClient(phoneNumber: String)
}