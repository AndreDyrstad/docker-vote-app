package com.api.api

import org.springframework.context.annotation.Configuration

@Configuration
class Dao(private val voteRepository: VoteRepository) {

    fun getVotes(): List<VoteExtended> {
        val votes = voteRepository.findAllActiveUsers() ?: listOf()
        val colors: List<String> = listOf("#F2F230", "#C2F261", "#91F291", "#61F2C2", "#30F2F2")
        var i = 0
        val amount = votes.groupingBy { it?.value }.eachCount()
        println(votes.size)
        return amount.map { (key, value) -> VoteExtended(key ?: "", ((value.toDouble()/votes.size)*1000).toInt(), colors[i++], value) }
    }

    fun setVote(vote: Vote) = voteRepository.save(vote)

}