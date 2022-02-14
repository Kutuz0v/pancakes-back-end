package ua.hurin.pancakes.service

import ua.hurin.pancakes.dto.PancakeDto

interface PancakeService {
    fun create(pancakeDto: PancakeDto): PancakeDto

    fun get(id: Long): PancakeDto

    fun getAll(): List<PancakeDto>

    fun update(id: Long, pancakeDto: PancakeDto): PancakeDto

    fun delete(id: Long)
}