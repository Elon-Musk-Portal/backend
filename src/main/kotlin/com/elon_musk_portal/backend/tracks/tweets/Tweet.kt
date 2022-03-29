package com.elon_musk_portal.backend.tracks.tweets

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tweets")
data class Tweet(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "tweet_id")
    val tweetId: Long = 0,

    @Column(name = "link")
    val link: String = "",

    @Column(name = "created")
    @CreationTimestamp
    val created: LocalDateTime = LocalDateTime.now(),

    @Column(name = "tags")
    val tags: String = "",
)
