package ua.hurin.pancakes.service

import ua.hurin.pancakes.dto.PancakeDto

interface PancakeService {
    fun createPancake(pancakeDto: PancakeDto): PancakeDto

    fun getPancake(id: Long): PancakeDto

    fun getAllPancakes(): List<PancakeDto>

    fun updatePancake(id: Long, pancakeDto: PancakeDto): PancakeDto

    fun deletePancake(id: Long)
}