package com.abusada.teachme.domain.common

data class ErrorResponse(
    val code: Int,
    val message: String,
    val data: Any
)