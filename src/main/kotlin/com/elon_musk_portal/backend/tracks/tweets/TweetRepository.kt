package com.elon_musk_portal.backend.tracks.tweets

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface TweetRepository: JpaRepository<Tweet, Long>{
    fun findTweetByTweetId(tweetId: String): Optional<Tweet>
}
