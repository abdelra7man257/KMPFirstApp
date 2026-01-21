package com.example.kmpfirstapp.common

import kotlinx.serialization.json.Json

inline fun <reified T> T.toJson(): String {
    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        prettyPrint = false
    }
    return json.encodeToString(this)
}

inline fun<reified T> String.fromJsonToOriginal() : T {
    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        prettyPrint = false
    }
return json.decodeFromString(this)
}
