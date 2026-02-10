object Solution01 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 01: Basics ===\n")
    
    // Exercise 1: Fix variable declarations
    // Changed 'var' to 'val' since x is not reassigned
    val x = 10
    // x = 20  // This would cause an error now - x is immutable
    
    val y = 30
    // y = 40  // Correctly causes error - commented out
    
    println(s"x = $x (immutable val)")
    println(s"y = $y (immutable val)")
    
    // Exercise 2: Type declarations
    val a: Int = 10
    val b: Double = 3.14
    val c: Boolean = true
    val d: String = "Hello, Scala!"
    
    println(s"\nExplicit types:")
    println(s"  a: Int = $a")
    println(s"  b: Double = $b")
    println(s"  c: Boolean = $c")
    println(s"  d: String = $d")
    
    // Exercise 3: Type conversion
    val intValue: Int = 10
    val doubleFromInt: Double = intValue.toDouble  // Convert Int to Double
    
    val doubleValue: Double = 3.7
    val intFromDouble: Int = doubleValue.toInt     // Convert Double to Int (truncates)
    
    println(s"\nType conversions:")
    println(s"  Double from int $intValue: $doubleFromInt")
    println(s"  Int from double $doubleValue: $intFromDouble (truncated)")
    
    // Exercise 4: String interpolation
    val name = "Scala"
    val version = 3
    val pi = math.Pi
    
    val greeting = s"Welcome to $name version $version!"
    val formattedPi = f"Pi = $pi%1.4f"
    
    println(s"\nString interpolation:")
    println(s"  $greeting")
    println(s"  $formattedPi")
    
    // Exercise 5: String operations
    val text = "  Functional Programming with Scala  "
    
    val trimmed = text.trim
    val upperCase = text.toUpperCase
    val containsScala = text.contains("Scala")
    val length = trimmed.length
    
    println(s"\nString operations:")
    println(s"  Original: '$text'")
    println(s"  Trimmed: '$trimmed'")
    println(s"  Uppercase: '$upperCase'")
    println(s"  Contains 'Scala': $containsScala")
    println(s"  Length of trimmed: $length")
    
    println("\n=== Solution 01 complete! ===")
  }
}
