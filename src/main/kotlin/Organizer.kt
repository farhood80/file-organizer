package com.example.fileorganizer

import java.io.File
import java.nio.file.*
import java.time.*

class Organizer(
    private val targetPath: Path,
    private val mode: String,
    private val dryRun: Boolean,
    private val configPath: String?

){
    fun organize(){
        val files = targetPath.toFile().listFiles() ?:return
        val rules = if(config != null)Rules.load(configPath)else Rules.default()

        files.filter {it.isFile}.forEach { file ->
            val dest = when(mode){
                "type" -> rules.resolveByType(file, targetPath)
                "data" -> resolveByDate(file)
                else -> null
            }
            dest?.let {moveFile(file, it)}
        }
    }

    private fun resolveByDate(file: File): Path{
        val date = Instant.ofEpochMilli(file.lastModified())
            .atZone(zoneId.systemDefault())
            .toLocalDate()
        val folderName = "${date.year}${"%02d".format(date.monthValue)}"
        return targetPath.resolve(folderName)
    }
    private fun moveFile(file:File,destDir:Path){
        if(!Files.exists(destDir)) File.createDirectories(destDir)
        val destFile =destDir.resolve(file.name)
        if(dryRun){
            println("[DRY RUN] ${file.name} -> $destDir")
        }else{
            Files.move(file.toPath(), destFile, StandardCopyOption.REPLACE_EXISTING)
            println("Moved ${file.name} -> $destDir")
        }
    }
}