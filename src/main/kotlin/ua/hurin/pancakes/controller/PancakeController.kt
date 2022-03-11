package ua.hurin.pancakes.controller

import org.springframework.web.bind.annotation.*
import ua.hurin.pancakes.dto.PancakeDto
import ua.hurin.pancakes.service.PancakeService

@CrossOrigin
@RestController
@RequestMapping("/pancakes")
class PancakeController(
        val service: PancakeService
) {

    @PostMapping
    fun create(@RequestBody pancake: PancakeDto): PancakeDto =
            service.create(pancake)

    @GetMapping("/{id}")
    fun getPancake(@PathVariable id: Long): PancakeDto =
            service.get(id)

    @GetMapping
    fun getAll(): List<PancakeDto> =
            service.getAll()

    @PutMapping("/{id}")
    fun update(
            @PathVariable id: Long,
            @RequestBody pancakeDto: PancakeDto
    ): PancakeDto =
            service.update(id, pancakeDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
            service.delete(id)
}