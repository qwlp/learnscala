object Solution09 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 09: Misc (I/O and Imports) ===\n")
    
    // Exercise 1: Different import styles
    import scala.collection.mutable.ArrayBuffer
    import scala.collection.mutable.{Map => MutableMap}
    
    val buffer = ArrayBuffer(1, 2, 3)
    val mmap = MutableMap("key" -> "value")
    
    println(s"Imports demonstration:")
    println(s"  ArrayBuffer: $buffer")
    println(s"  MutableMap: $mmap")
    
    // Exercise 2 & 3: Writing to and reading from a file
    import java.io.PrintWriter
    import scala.io.Source
    
    val filename = "test_output.txt"
    
    // Write to file
    val writer = new PrintWriter(filename)
    try {
      writer.write("First line of text" + util.Properties.lineSeparator)
      writer.write("Second line of text" + util.Properties.lineSeparator)
      writer.write("Third line of text" + util.Properties.lineSeparator)
    } finally {
      writer.close()
    }
    
    println(s"\nWrote to $filename")
    
    // Read from file
    println("\nFile contents:")
    val source = Source.fromFile(filename)
    try {
      for (line <- source.getLines()) {
        println(s"  $line")
      }
    } finally {
      source.close()
    }
    
    // Exercise 4: Process file data
    val numbersFile = "numbers.txt"
    
    // Create file with numbers
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
    
    // Read and calculate sum
    val numSource = Source.fromFile(numbersFile)
    val sum = try {
      numSource.getLines().map(_.toInt).sum
    } finally {
      numSource.close()
    }
    
    println(s"\nSum of numbers in file: $sum")
    
    // Exercise 5: Command line arguments
    println(s"\nCommand line arguments:")
    println(s"  Number of arguments: ${args.length}")
    println("  Arguments:")
    args.zipWithIndex.foreach { case (arg, i) =>
      println(s"    [$i]: $arg")
    }
    
    // Clean up test files
    new java.io.File(filename).delete()
    new java.io.File(numbersFile).delete()
    println(s"\nCleaned up test files")
    
    println("\n=== Solution 09 complete! ===")
    println("\nTo test with arguments, run: scala solution.scala arg1 arg2 arg3")
  }
}
