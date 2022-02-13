package ua.hurin.pancakes.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ua.hurin.pancakes.dto.ClientDto
import ua.hurin.pancakes.model.Client
import ua.hurin.pancakes.repository.ClientRepository

@Service
class ClientServiceImpl(
    private val repository: ClientRepository
) : ClientService {
    override fun getClient(phoneNumber: String): ClientDto =
        repository.getByPhoneNumber(phoneNumber).toClientDto()

    override fun createClient(clientDto: ClientDto): ClientDto {
        val savedClient = repository.save(
            clientDto.toClient()
        )
        return savedClient.toClientDto()
    }

    override fun getAllClients(): List<ClientDto> {
        return repository.findAll().map { it.toClientDto() }
    }

    override fun updateClient(phoneNumber: String, clientDto: ClientDto): ClientDto {
        val client = repository.getByPhoneNumber(phoneNumber)
        client.name = clientDto.name
        return repository.save(client)
            .toClientDto()
    }

    @Transactional
    override fun deleteClient(phoneNumber: String) {
        repository.deleteByPhoneNumber(phoneNumber)
    }

    private fun Client.toClientDto () =
        ClientDto(
            this.name,
            this.phoneNumber
        )

    private fun ClientDto.toClient () =
        Client(
            name = this.name,
            phoneNumber = this.phoneNumber
        )
}