object FileMatches {
    private def filesHere = (new java.io.File(".")).listFiles
    
    def filesEnding(query: String) = {
        for(file <- filesHere; if file.getName.endsWith(query))
            yield file
    }

    def filesContaining(query: String) = {
        for(file <- filesHere; if file.getName.contains(query))
            yield file
    }

    def filesRegex(query: String) = {
        for(file <- filesHere; if file.getName.matches(query))
            yield file
    }

    private def filesMatching(query: String, 
                              matcher: (String, String) => Boolean) = {
        for(file <- filesHere; if matcher(file.getName, query))
            yield file
    }

    def filesEndsWith(query: String) = {
        filesMatching(query, _.endsWith(_))
    }

    def filesContains(query: String) = {
        filesMatching(query, _.contains(_))
    }

    def filesRegexins(query: String) = {
        filesMatching(query, _.matches(_))
    }

    private def shortMatching(matcher: (String) => Boolean) = {
        for(file <- filesHere; if matcher(file.getName))
            yield file
    }

    def shortEndsWith(query: String) = {
        shortMatching(_.endsWith(query))
    }

    def shortContains(query: String) = {
        shortMatching(_.contains(query))
    }

    def shortMatches(query: String) = {
        shortMatching(_.matches(query))
    }
}

object Control {
    def printNames(file: java.io.File*) = {
        file.foreach(x => println(x.getName))
    }
    def main(args: Array[String]): Unit = {
        val fi0 = FileMatches.filesEnding(".scala")
        fi0.foreach(x => println(x.getName))

        val fi1 = FileMatches.filesContaining("sca")
        fi1.foreach(x => println(x.getName))

        val reg = ".*[0-9][a-z]*.*"
        val fi2 = FileMatches.filesRegex(reg)
        fi2.foreach(x => println(x.getName))

        val fo0 = FileMatches.filesEndsWith(".scala")
        printNames(fo0: _*)

        val fo1 = FileMatches.filesContains("sca")
        printNames(fo1: _*)

        val regx = ".*[0-9][a-z]*.*"
        val fo2 = FileMatches.filesRegexins(regx)
        printNames(fo2: _*)

        val fu0 = FileMatches.shortEndsWith(".scala")
        printNames(fu0: _*)

        val fu1 = FileMatches.shortContains("sca")
        printNames(fu1: _*)

        val regxs = ".*[0-9][a-z]*.*"
        val fu2 = FileMatches.shortMatches(regxs)
        printNames(fu2: _*)
    }
}