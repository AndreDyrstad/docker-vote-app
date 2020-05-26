package com.api.api

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/vote")
@CrossOrigin(maxAge = 3600)
class Controller(private val dao: Dao) {

    @GetMapping
    fun printHello() = dao.getVotes()

    @PostMapping("/add")
    fun addVote(@RequestBody body: Map<String, String>): Map<String, String> {
        val vote = Vote(value = body["vote"] ?: "")
        dao.setVote(vote)
        return mapOf(Pair("message", "Success!"))
    }
}