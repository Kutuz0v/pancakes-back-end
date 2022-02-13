package ua.hurin.pancakes.controller

import org.springframework.web.bind.annotation.*
import ua.hurin.pancakes.dto.ClientDto
import ua.hurin.pancakes.service.ClientService

@RestController
@RequestMapping("/clients")
class ClientController(
    val service: ClientService
) {
    @PostMapping
    fun create(@RequestBody clientDto: ClientDto): ClientDto =
        service.createClient(clientDto)

    @GetMapping("/{phoneNumber}")
    fun getClient(@PathVariable phoneNumber: String) =
        service.getClient(phoneNumber)

    @GetMapping
    fun getAll(): List<ClientDto> =
        service.getAllClients()

    @PutMapping("/{phoneNumber}")
    fun update(@PathVariable phoneNumber: String, @RequestBody clientDto: ClientDto): ClientDto =
        service.updateClient(phoneNumber, clientDto)

    @DeleteMapping("/{phoneNumber}")
    fun delete(@PathVariable phoneNumber: String) =
        service.deleteClient(phoneNumber)
}