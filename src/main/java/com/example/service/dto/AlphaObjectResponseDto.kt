package com.example.service.dto

import org.springframework.stereotype.Component

/**
 *
 */
@Component
data class AlphaObjectResponseDto(var foo: String? = null, var bar: String? = null): IEppObjectResponseDto {

    companion object {
        const val TAG = "alpha"
    }

    init {
        foo = "$TAG Foo"
        bar = "$TAG Bar"
    }

    override fun getTag(): String {
        return TAG
    }
}
