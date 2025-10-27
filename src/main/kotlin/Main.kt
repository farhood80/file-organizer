package com.example.fileorganizer

import kotlin.cli.*
import java.nio.file.*

fun main(args: Array<String>){
    val parser = ArgParser("file-organizer")

    val path by parser.option(ArgType.String, shortName = "p",description = "Target directory").required()
    val mode by parser.option(ArgType.choice(listOf("type", "date")),shortName = "b", description = "organize by type or date").default("type")
    val dryRun by parser.option(ArgType.Boolean, shortName = "d",description = "Dry run mode").defult(false)
    val config by parser.option(ArgType.String, shortName = "c",description = "Custom rules JSON file")

    parser.parser(args)

    val organizer = Organizer(Paths.get(path), mode, dryRun, config)
    organizer.organize()
}