package ua.hurin.pancakes.controller

import org.springframework.web.bind.annotation.*
import ua.hurin.pancakes.dto.PancakeDto
import ua.hurin.pancakes.service.PancakeService

@RestController
@RequestMapping("/pancakes")
class PancakeController(
    val service: PancakeService
) {

    @PostMapping
    fun create(@RequestBody pancake: PancakeDto): PancakeDto =
        service.createPancake(pancake)

    @GetMapping("/{id}")
    fun getPancake(@PathVariable id: Long): PancakeDto =
        service.getPancake(id)

    @GetMapping
    fun getAll(): List<PancakeDto> {
        return service.getAllPancakes()
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody pancakeDto: PancakeDto): PancakeDto =
        service.updatePancake(id, pancakeDto)

    @DeleteMapping("/{id}")
    fun delete (@PathVariable id: Long) =
        service.deletePancake(id)
}