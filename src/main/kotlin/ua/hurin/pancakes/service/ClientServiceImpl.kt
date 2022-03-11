package ua.hurin.pancakes.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ua.hurin.pancakes.dto.ClientDto
import ua.hurin.pancakes.dto.ClientDto.Companion.toClient
import ua.hurin.pancakes.exception.ClientNotFoundException
import ua.hurin.pancakes.model.Client.Companion.toClientDto
import ua.hurin.pancakes.repository.ClientRepository

@Service
class ClientServiceImpl(
        private val repository: ClientRepository
) : ClientService {
    override fun create(clientDto: ClientDto): ClientDto =
            saveClient(clientDto)

    override fun get(id: Long): ClientDto =
            repository
                    .findById(id)
                    .orElseThrow(ClientNotFoundException(id))
                    .toClientDto()

    override fun getAll(): List<ClientDto> =
            repository
                    .findAll()
                    .map { it.toClientDto() }

    override fun update(id: Long, clientDto: ClientDto): ClientDto =
            if (repository.existsById(id))
                saveClient(id, clientDto)
            else throw ClientNotFoundException(id)

    @Transactional
    override fun delete(id: Long) =
            if (repository.existsById(id))
                repository.deleteById(id)
            else throw ClientNotFoundException(id)

    private fun saveClient(clientDto: ClientDto): ClientDto =
            saveClient(0, clientDto)

    private fun saveClient(id: Long, clientDto: ClientDto): ClientDto =
            repository
                    .save(clientDto.toClient(id))
                    .toClientDto()
}