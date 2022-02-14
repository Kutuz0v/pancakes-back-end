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
        service.create(clientDto)

    @GetMapping("/{id}")
    fun getClient(@PathVariable id: Long) =
        service.get(id)

    @GetMapping
    fun getAll(): List<ClientDto> =
        service.getAll()

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody clientDto: ClientDto): ClientDto =
        service.update(id, clientDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}