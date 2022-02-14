package ua.hurin.pancakes.service

import org.springframework.stereotype.Service
import ua.hurin.pancakes.dto.PancakeDto
import ua.hurin.pancakes.dto.PancakeDto.Companion.toPancake
import ua.hurin.pancakes.exception.PancakeNotFoundException
import ua.hurin.pancakes.model.Pancake.Companion.toPancakeDto
import ua.hurin.pancakes.repository.PancakeRepository

@Service
class PancakeServiceImpl(
    private val repository: PancakeRepository
) : PancakeService {

    override fun create(pancakeDto: PancakeDto): PancakeDto =
        savePancake(pancakeDto)

    override fun get(id: Long): PancakeDto =
        repository
            .findById(id)
            .orElseThrow(PancakeNotFoundException(id))
            .toPancakeDto()

    override fun getAll(): List<PancakeDto> =
        repository.findAll()
            .map {
                it.toPancakeDto()
            }

    override fun update(id: Long, pancakeDto: PancakeDto): PancakeDto =
        if (repository.existsById(id))
            savePancake(id, pancakeDto)
        else throw PancakeNotFoundException(id)

    override fun delete(id: Long) =
        repository.deleteById(id)

    private fun savePancake(pancakeDto: PancakeDto): PancakeDto =
        savePancake(0, pancakeDto)

    private fun savePancake(id: Long, pancakeDto: PancakeDto): PancakeDto =
        repository
            .save(pancakeDto.toPancake(id))
            .toPancakeDto()

}