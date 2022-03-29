package com.elon_musk_portal.backend.tracks.tweets

import com.elon_musk_portal.backend.utils.Extensions.ifEmpty
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import twitter4j.Twitter

@Service
class TweetCronJob(
    private val tweetRepository: TweetRepository,
    private val twitter: Twitter,
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Scheduled(fixedDelay = REFRESH_TIME)
    fun updateTwitter() {
        logger.info("Start update twitter")
        val responseList = twitter.getUserTimeline(USERNAME)
        if (responseList.isNotEmpty()) {
            val lastTweetId = responseList.maxByOrNull { it.createdAt }!!.id
            logger.info("Last tweet from twitter with id $lastTweetId")
            tweetRepository.findTweetByTweetId(lastTweetId).ifEmpty {
                saveNewTweet(lastTweetId)
            }
        } else {
            logger.info("Response from twitter was empty")
        }
    }

    private fun saveNewTweet(lastId: Long) {
        val link = "https://twitter.com/$USERNAME/status/$lastId"
        val tweet = Tweet(
            tweetId = lastId,
            link = link
        )
        tweetRepository.save(tweet)
        logger.info("New tweet with id $lastId")
    }

    companion object {
        const val USERNAME = "elonmusk"
        const val REFRESH_TIME: Long = 2 * 60 * 1000
    }

}
