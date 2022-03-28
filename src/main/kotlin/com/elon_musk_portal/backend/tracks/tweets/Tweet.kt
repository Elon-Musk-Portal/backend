package com.elon_musk_portal.backend.tracks.tweets

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tweets")
data class Tweet(
    @Id
    @Column(name = "id")
    val id: Long = 0,

    @Column(name = "link")
    val link: String = "",

    @Column(name = "created")
    @CreationTimestamp
    val created: LocalDateTime = LocalDateTime.now(),
)
