package com.elon_musk_portal.backend.twitter

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

@Component
class TwitterComponent(
    private val twitterConfiguration: TwitterConfiguration,
) {

    @Bean
    fun twitterBean(): Twitter {
        val configurationBuilder = ConfigurationBuilder()
        configurationBuilder.apply {
            setDebugEnabled(true)
            setOAuthConsumerKey(twitterConfiguration.api_key)
            setOAuthConsumerSecret(twitterConfiguration.secret_key)
            setOAuthAccessToken(twitterConfiguration.access_token)
            setOAuthAccessTokenSecret(twitterConfiguration.secret_token)
        }
        val twitterFactory = TwitterFactory(configurationBuilder.build())
        return twitterFactory.instance
    }

}
