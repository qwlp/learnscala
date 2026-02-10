object Solution03 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 03: Flow Control ===\n")
    
    // Exercise 1: Range and foreach
    val range1to10 = 1 to 10
    println("Numbers 1 to 10:")
    range1to10.foreach(println)
    
    // Exercise 2: Convert while loop to recursion
    println("\nEven numbers (recursive):")
    
    def printEvenRecursive(n: Int): Unit = {
      if (n <= 20) {
        println(n)
        printEvenRecursive(n + 2)
      }
    }
    
    printEvenRecursive(2)
    
    // Exercise 3: Fix recursive function
    // Fixed factorial with proper base case and recursive step
    def factorial(n: Int): Int = {
      if (n <= 1) 1
      else n * factorial(n - 1)
    }
    
    // Test factorial
    println(s"\nFactorial of 5: ${factorial(5)}")
    println(s"Factorial of 0: ${factorial(0)}")
    println(s"Factorial of 10: ${factorial(10)}")
    
    // Exercise 4: Conditional as expression
    val score = 75
    
    // Using if/else expression with val
    val grade = if (score >= 90) {
      "A"
    } else if (score >= 80) {
      "B"
    } else if (score >= 70) {
      "C"
    } else if (score >= 60) {
      "D"
    } else {
      "F"
    }
    
    println(s"\nScore: $score, Grade: $grade")
    
    // Exercise 5: Range operations
    val descending = 10 to 1 by -1
    val oddNumbers = 1 to 20 by 2
    val everyThird = 0 to 30 by 3
    
    println("\nRange operations:")
    print("Descending range: ")
    descending.foreach(x => print(s"$x "))
    println()
    
    print("Odd numbers: ")
    oddNumbers.foreach(x => print(s"$x "))
    println()
    
    print("Every third number: ")
    everyThird.foreach(x => print(s"$x "))
    println()
    
    println("\n=== Solution 03 complete! ===")
  }
}
