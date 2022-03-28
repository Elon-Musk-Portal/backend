package com.elon_musk_portal.backend.utils

import java.util.*

object Extensions {

    fun <T> Optional<T>.isEmpty(
        action: () -> Unit,
    ) {
        if (this.isEmpty) action.invoke()
    }
}
