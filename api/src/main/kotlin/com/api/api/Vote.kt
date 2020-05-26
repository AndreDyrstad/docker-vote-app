package com.api.api

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Vote (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        val value: String = ""
)

data class VoteExtended(
        val label: String,
        val size: Int,
        val color: String,
        val numberOfVotes: Int
)

@Repository
interface VoteRepository: JpaRepository<Vote, Long> {
        @Query("SELECT v FROM Vote v")
        fun findAllActiveUsers(): Collection<Vote?>?
}
