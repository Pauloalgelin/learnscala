object Control extends App {
    // Imperative
    var filename1 = "default.txt"
    if (!args.isEmpty)
        filename1 = args(0)

    // Functional
    val filename2 = if (!args.isEmpty) args(0)
                    else "default.txt"

    println("filename1 = " + filename1)
    println("filename2 = " + filename2)

    // While vs Recursion

    def gcd1(x: Long, y: Long): Long = {
        var a = x
        var b = y
        while (a != 0){
            val temp = a
            a = b % a
            b = temp
        }
        b
    }

    def gcd2(x: Long, y: Long): Long = {
        if (y == 0) x else gcd2(y, x % y)
    }

    val d1 = gcd1(4, 6)
    val d2 = gcd2(4, 6)

    println("gcd1(4, 6) = " + d1)
    println("gcd2(4, 6) = " + d2)

    // For
    println("Print files' names")
    val FilesHere = (new java.io.File(".")).listFiles
    for (file <- FilesHere)
        println(file)

    println("Print scala file names only.")
    for(file <- FilesHere if file.getName.endsWith(".scala"))
        println(file)

    println("Print grep '.*gcd.*' of scala files.")
    def fileLines(file: java.io.File) =
        scala.io.Source.fromFile(file).getLines().toList

    def grep(pattern: String) =
        for {
            file <- FilesHere
            if file.getName.endsWith(".scala")
            line <- fileLines(file)
            trimmed = line.trim
            if trimmed.matches(pattern)
        } println(file + ": " + trimmed)

    grep(".*gcd.*")

    println("scalaFiles: ")
    val scalaFiles =
        for {
            file <- FilesHere
            if file.getName.endsWith(".scala")
        } yield file.getName

    scalaFiles.foreach(println)
}