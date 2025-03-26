package org.example.artspaceapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform