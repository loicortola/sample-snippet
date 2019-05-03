package com.example.service.dto

import org.springframework.stereotype.Component

/**
 *
 */
@Component
data class BetaObjectResponseDto(var foo: String? = null, var bar: String? = null): IEppObjectResponseDto {

    companion object {
        const val TAG = "beta"
    }

    init {
        foo = "$TAG Foo"
        bar = "$TAG Bar"
    }

    override fun getTag(): String {
        return TAG
    }
}
