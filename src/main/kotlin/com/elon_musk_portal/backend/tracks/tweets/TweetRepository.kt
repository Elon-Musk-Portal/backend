package com.elon_musk_portal.backend.tracks.tweets

import org.springframework.data.jpa.repository.JpaRepository

interface TweetRepository: JpaRepository<Tweet, Long>
