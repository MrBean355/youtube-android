package com.github.mrbean355.android.startup

object SimpleLogger {
    private var tag = ""

    fun initialise(tag: String) {
        this.tag = tag
    }

    fun log(message: String) {
        println("[$tag] $message")
    }
}