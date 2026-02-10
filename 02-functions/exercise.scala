object Exercise02 {
  def main(args: Array[String]): Unit = {
    // TODO: Implement the missing function bodies
    
    // Exercise 1: Basic function implementation
    // Implement a function that calculates the area of a rectangle
    def rectangleArea(width: Int, height: Int): Int = {
      ???
    }
    
    // Exercise 2: Functions with default parameters
    // Add a default parameter for tax rate (default 0.08)
    def calculateTotal(price: Double, taxRate: Double): Double = {
      price * (1 + taxRate)
    }
    
    // Exercise 3: Convert anonymous to named function
    // Convert this anonymous function to a named 'def' function
    val multiply = (a: Int, b: Int) => a * b
    
    // Create a named version:
    // def multiplyNamed(a: Int, b: Int): Int = ???
    
    // Exercise 4: Named parameters
    // Call this function using named parameters in reverse order
    def greet(firstName: String, lastName: String): String = {
      s"Hello, $firstName $lastName!"
    }
    
    val greeting = ???  // Use named parameters: lastName="Doe", firstName="John"
    
    // Exercise 5: Underscore syntax
    // Rewrite these anonymous functions using underscore shorthand
    val addFive: Int => Int = x => x + 5
    val multiplyByTwo: Int => Int = x => x * 2
    val combine: (Int, Int) => Int = (a, b) => a + b * 2
    
    // Rewrite using _:
    // val addFiveShort: Int => Int = ???
    // val multiplyByTwoShort: Int => Int = ???
    // val combineShort: (Int, Int) => Int = ???
    
    // Test your implementations
    println(s"Rectangle area (5x3): ${rectangleArea(5, 3)}")
    println(s"Total with default tax: ${calculateTotal(100.0, 0.08)}")
    println(s"Total with custom tax: ${calculateTotal(100.0, 0.10)}")
    println(s"Greeting: $greeting")
    println(s"Add five: ${addFive(10)}")
    println(s"Multiply by two: ${multiplyByTwo(7)}")
    println(s"Combine: ${combine(3, 4)}")
    
    println("Exercise 02 complete!")
  }
}
