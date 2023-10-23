import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: [-c | -l | -w | -m] <file_path>")
        return
    }

    val command: String
    val filePath: String

    if (args[0].startsWith("-")) {
        command = args[0]
        filePath = args[1]
    } else {
        command = ""
        filePath = args[0]
    }
    val file = File(filePath)

    when (command) {
        "-c" -> printNumberOfBytes(file, filePath)
        "-l" -> printNumberOfLines(file, filePath)
        "-w" -> printNumberOfWords(file, filePath)
        "-m" -> printNumberOfCharactersLocale(file, filePath)
        else -> printDefaultWcOption(file, filePath)
    }
}

// Step 1 - outputs the number of bytes in a file
fun printNumberOfBytes(file: File, filePath: String) {
    println("${file.readBytes().size} $filePath")
}

// Step 2 - outputs the number of lines in a file
fun printNumberOfLines(file: File, filePath: String) {
    println("${file.readLines().size} $filePath")
}

// Step 3 - outputs the number of words in a file
fun printNumberOfWords(file: File, filePath: String) {
    println("${file.readText().split("\\s+".toRegex()).filter { it.isNotEmpty() }.size} $filePath")
}

// Step 4 - outputs the number of characters in a file based on locale
fun printNumberOfCharactersLocale(file: File, filePath: String) {
    println("${file.readText().length} $filePath")
}

// Step 5 - outputs -l -c -w by default
fun printDefaultWcOption(file: File, filePath: String) {
    printNumberOfLines(file, filePath)
    printNumberOfBytes(file, filePath)
    printNumberOfWords(file, filePath)
    println(filePath)
}

// Step 6 - To be continued
