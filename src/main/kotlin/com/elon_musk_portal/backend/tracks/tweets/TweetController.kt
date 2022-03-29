package com.elon_musk_portal.backend.tracks.tweets

import com.elon_musk_portal.backend.tags.TagValue
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tweets")
class TweetController(
    private val tweetRepository: TweetRepository,
) {

    @GetMapping
    fun getTweets(): List<Tweet> {
        return tweetRepository.findAll()
    }

    @PutMapping("/{id}/tags")
    fun addTagsToTweet(
        @PathVariable
        id: Long,
        @RequestBody
        tags: List<String>,
    ): Tweet {
        val tweet = tweetRepository.findById(id)
        if (tweet.isEmpty) throw IndexOutOfBoundsException("Tweet with id $id not found")
        else {
            tags.forEach { tagValue ->
                val allTags = TagValue.values().map { it.name }
                if(!allTags.contains(tagValue)) {
                    throw IndexOutOfBoundsException("Tag with name $tagValue didnt exist")
                }
            }
            val updateTweet = tweet.get().copy(
                tags = tags.joinToString(", ")
            )
            return tweetRepository.save(updateTweet)
        }
    }
}
