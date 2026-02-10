object Exercise01 {
  def main(args: Array[String]): Unit = {
    // TODO: Fix the variable declaration errors below
    
    // Exercise 1: Fix variable declarations
    // Change 'var' to 'val' where appropriate (immutable values)
    var x = 10
    x = 20  // This line should cause an error - fix the declaration above
    
    val y = 30
    // y = 40  // This line correctly causes an error - leave it commented
    
    // Exercise 2: Type declarations
    // Add explicit type annotations to these variables
    val a = 10
    val b = 3.14
    val c = true
    val d = "Hello, Scala!"
    
    // Exercise 3: Type conversion
    // Convert these values to the specified types
    val intValue: Int = 10
    val doubleFromInt: Double = ???  // Convert intValue to Double
    
    val doubleValue: Double = 3.7
    val intFromDouble: Int = ???  // Convert doubleValue to Int (truncates)
    
    println(s"Double from int: $doubleFromInt")
    println(s"Int from double: $intFromDouble")
    
    // Exercise 4: String interpolation
    // Create strings using s-interpolator and f-interpolator
    val name = "Scala"
    val version = 3
    val pi = math.Pi
    
    val greeting = ???  // Use s-interpolator: "Welcome to Scala version 3!"
    val formattedPi = ???  // Use f-interpolator: "Pi = 3.1416" (4 decimal places)
    
    println(greeting)
    println(formattedPi)
    
    // Exercise 5: String operations
    // Use string methods to complete the following
    val text = "  Functional Programming with Scala  "
    
    val trimmed = ???  // Remove leading and trailing whitespace
    val upperCase = ???  // Convert to uppercase
    val containsScala = ???  // Check if text contains "Scala"
    val length = ???  // Get the length of the trimmed text
    
    println(s"Trimmed: '$trimmed'")
    println(s"Uppercase: '$upperCase'")
    println(s"Contains 'Scala': $containsScala")
    println(s"Length: $length")
    
    println("Exercise 01 complete!")
  }
}
