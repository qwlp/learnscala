object Exercise03 {
  def main(args: Array[String]): Unit = {
    // TODO: Complete the exercises below
    
    // Exercise 1: Range and foreach
    // Create a range from 1 to 10 and print each number
    val range1to10 = 1 to 10
    println("Numbers 1 to 10:")
    // Use foreach to print each number
    ???
    
    // Exercise 2: Convert while loop to recursion
    // This while loop prints even numbers from 2 to 20
    var i = 2
    println("\nEven numbers (while loop):")
    while (i <= 20) {
      println(i)
      i += 2
    }
    
    // Convert the above to a recursive function
    def printEvenRecursive(n: Int): Unit = {
      // TODO: Implement recursive version
      ???
    }
    
    println("\nEven numbers (recursive):")
    printEvenRecursive(2)
    
    // Exercise 3: Fix recursive function
    // This factorial function has bugs - fix them
    def factorial(n: Int): Int = {
      if (n == 0) 1
      else n * factorial(n)  // Bug here!
    }
    
    // Exercise 4: Conditional as expression
    // Rewrite these using if/else expressions
    val score = 75
    var grade = ""  // Don't use var!
    if (score >= 90) {
      grade = "A"
    } else if (score >= 80) {
      grade = "B"
    } else if (score >= 70) {
      grade = "C"
    } else if (score >= 60) {
      grade = "D"
    } else {
      grade = "F"
    }
    
    // Rewrite using val and if/else expression:
    // val gradeExpr = ???
    
    // Exercise 5: Range operations
    // Create different ranges and process them
    val descending = 10 to 1 by -1
    val oddNumbers = 1 to 20 by 2
    val everyThird = 0 to 30 by 3
    
    println("\nDescending range:")
    descending.foreach(print(_))
    println("\nOdd numbers:")
    oddNumbers.foreach(print(_))
    println("\nEvery third number:")
    everyThird.foreach(print(_))
    println()
    
    println(s"Grade: $grade")
    // println(s"Grade (expression): $gradeExpr")
    println(s"Factorial of 5: ${factorial(5)}")
    
    println("Exercise 03 complete!")
  }
}
