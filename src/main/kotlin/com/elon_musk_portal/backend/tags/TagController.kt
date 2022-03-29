package com.elon_musk_portal.backend.tags

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tags")
class TagController {

    @GetMapping
    fun getTags(): List<String> {
        return TagValue.values().map { it.name }
    }
}
