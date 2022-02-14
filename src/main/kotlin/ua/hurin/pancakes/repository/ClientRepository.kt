package ua.hurin.pancakes.repository

import org.springframework.data.repository.CrudRepository
import ua.hurin.pancakes.model.Client


interface ClientRepository : CrudRepository<Client, Long>