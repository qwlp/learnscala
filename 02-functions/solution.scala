object Solution02 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 02: Functions ===\n")
    
    // Exercise 1: Basic function implementation
    def rectangleArea(width: Int, height: Int): Int = {
      width * height
    }
    
    // Exercise 2: Functions with default parameters
    def calculateTotal(price: Double, taxRate: Double = 0.08): Double = {
      price * (1 + taxRate)
    }
    
    // Exercise 3: Convert anonymous to named function
    val multiply = (a: Int, b: Int) => a * b
    
    // Named version:
    def multiplyNamed(a: Int, b: Int): Int = a * b
    
    // Exercise 4: Named parameters
    def greet(firstName: String, lastName: String): String = {
      s"Hello, $firstName $lastName!"
    }
    
    val greeting = greet(lastName = "Doe", firstName = "John")
    
    // Exercise 5: Underscore syntax
    val addFive: Int => Int = x => x + 5
    val multiplyByTwo: Int => Int = x => x * 2
    val combine: (Int, Int) => Int = (a, b) => a + b * 2
    
    // Rewrite using _:
    val addFiveShort: Int => Int = _ + 5
    val multiplyByTwoShort: Int => Int = _ * 2
    val combineShort: (Int, Int) => Int = _ + _ * 2
    
    // Test implementations
    println(s"Rectangle area (5x3): ${rectangleArea(5, 3)}")
    println(s"Total with default tax (8%): ${calculateTotal(100.0)}")
    println(s"Total with custom tax (10%): ${calculateTotal(100.0, 0.10)}")
    println(s"Greeting: $greeting")
    println(s"\nOriginal functions:")
    println(s"  Add five: ${addFive(10)}")
    println(s"  Multiply by two: ${multiplyByTwo(7)}")
    println(s"  Combine: ${combine(3, 4)}")
    println(s"\nUsing underscore shorthand:")
    println(s"  Add five: ${addFiveShort(10)}")
    println(s"  Multiply by two: ${multiplyByTwoShort(7)}")
    println(s"  Combine: ${combineShort(3, 4)}")
    println(s"\nNamed function (multiply): ${multiplyNamed(6, 7)}")
    
    println("\n=== Solution 02 complete! ===")
  }
}
