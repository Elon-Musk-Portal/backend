package com.elon_musk_portal.backend.tracks.tweets

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tweets")
class TweetController(
    private val tweetRepository: TweetRepository,
) {

    @GetMapping
    fun getTweets(): List<Tweet> {
        return tweetRepository.findAll()
    }
}
