package com.example.fileorganizer

import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class CustomRule(val extension: String, val folder: String)

object Rules {
    fun load(configPath: String): List<CustomRule> {
        val json = File(configPath).readText()
        return Json.decodeFromString(json)
    }

    fun default(): List<CustomRule> = listOf(
        CustomRule("jpg", "Images"),
        CustomRule("png", "Images"),
        CustomRule("pdf", "Documents"),
        CustomRule("docx", "Documents"),
        CustomRule("mp3", "Music")
    )

    fun resolveByType(file: File, targetPath: Path): Path {
        val ext = file.extension.lowercase()
        val rule = default().find { it.extension == ext }
        return targetPath.resolve(rule?.folder ?: "Other")
    }
}
