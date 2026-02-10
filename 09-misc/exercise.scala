object Exercise09 {
  def main(args: Array[String]): Unit = {
    // TODO: Complete the I/O and imports exercises
    
    // Exercise 1: Different import styles
    // Import specific classes
    // import scala.collection.mutable.{ArrayBuffer, Map}
    
    // Import with renaming
    // import scala.collection.mutable.{Map => MutableMap}
    
    // Import everything except certain classes
    // import scala.collection.mutable.{Map => _, Set => _, _}
    
    // Exercise 2: Writing to a file
    import java.io.PrintWriter
    import scala.io.Source
    
    val filename = "test_output.txt"
    
    // TODO: Write multiple lines to the file using PrintWriter
    // Make sure to close the writer properly!
    val writer = new PrintWriter(filename)
    try {
      // writer.write(???)
      // writer.write(???)
      // writer.write(???)
    } finally {
      // Close the writer
    }
    
    println(s"Wrote to $filename")
    
    // Exercise 3: Reading from a file
    // TODO: Read the file back and print each line
    // Use Source.fromFile(filename).getLines()
    
    println("\nFile contents:")
    // for (line <- ???) {
    //   println(line)
    // }
    
    // Exercise 4: Process file data
    // Read numbers from a file and calculate their sum
    val numbersFile = "numbers.txt"
    
    // First, create a file with numbers
    val numWriter = new PrintWriter(numbersFile)
    try {
      numWriter.write("10\n")
      numWriter.write("20\n")
      numWriter.write("30\n")
      numWriter.write("40\n")
      numWriter.write("50\n")
    } finally {
      numWriter.close()
    }
    
    // TODO: Read the file and calculate sum
    // val sum = Source.fromFile(numbersFile)
    //   .getLines()
    //   .map(???)
    //   .sum
    
    // println(s"Sum of numbers: $sum")
    
    // Exercise 5: Command line arguments
    // Print the command line arguments
    println(s"\nNumber of arguments: ${args.length}")
    println("Arguments:")
    args.foreach(println)
    
    // Clean up test files
    new java.io.File(filename).delete()
    new java.io.File(numbersFile).delete()
    println(s"\nCleaned up test files")
    
    println("Exercise 09 complete!")
    println("\nNote: Run with arguments like: scala exercise.scala arg1 arg2 arg3")
  }
}
