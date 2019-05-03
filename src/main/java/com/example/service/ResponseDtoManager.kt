package com.example.service

import com.example.service.dto.IEppObjectResponseDto
import org.springframework.stereotype.Service

/**
 */
@Service
class ResponseDtoManager(responseDtos: List<IEppObjectResponseDto>) {

    private val responseDtoMap: MutableMap<String, Class<out IEppObjectResponseDto>>

    init {
        responseDtoMap = HashMap()
        responseDtos.forEach { d ->
            responseDtoMap.computeIfPresent(d.getTag()) { _, _ -> throw IllegalStateException("Response Dtos must have unique tags!")}
            responseDtoMap.put(d.getTag(), d.javaClass)
        }
        print(responseDtoMap)
    }

    fun getResponseDto(tag: String): Class<out IEppObjectResponseDto>? {
        return responseDtoMap[tag]
    }
}
