package ua.hurin.pancakes.repository

import org.springframework.data.repository.CrudRepository
import ua.hurin.pancakes.model.Pancake

interface PancakeRepository: CrudRepository<Pancake, Long>