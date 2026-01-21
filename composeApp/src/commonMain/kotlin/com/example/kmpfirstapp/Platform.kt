package com.example.kmpfirstapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform