object Solution07 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 07: Functional Programming ===\n")
    
    // Exercise 1: map operations
    val numbers = List(1, 2, 3, 4, 5)
    
    val squares = numbers.map(x => x * x)
    val doubled = numbers.map(_ * 2)
    
    println("Map operations:")
    println(s"  Original: $numbers")
    println(s"  Squares: $squares")
    println(s"  Doubled: $doubled")
    
    // Exercise 2: filter operations
    val moreNumbers = List(10, 15, 20, 25, 30, 35, 40)
    
    val evens = moreNumbers.filter(_ % 2 == 0)
    val greaterThan20 = moreNumbers.filter(_ > 20)
    val divisibleBy5 = moreNumbers.filter(_ % 5 == 0)
    
    println("\nFilter operations:")
    println(s"  Original: $moreNumbers")
    println(s"  Evens: $evens")
    println(s"  Greater than 20: $greaterThan20")
    println(s"  Divisible by 5: $divisibleBy5")
    
    // Exercise 3: Chaining operations
    val numbers2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    val sumOfEvenSquares = numbers2
      .filter(_ % 2 == 0)
      .map(x => x * x)
      .sum
    
    println(s"\nChaining operations:")
    println(s"  Numbers: $numbers2")
    println(s"  Sum of squares of even numbers: $sumOfEvenSquares")
    
    // Exercise 4: reduce operations
    val nums = List(5, 10, 15, 20)
    
    val product = nums.reduce(_ * _)
    val maximum = nums.reduce((a, b) => if (a > b) a else b)
    val minimum = nums.reduce((a, b) => if (a < b) a else b)
    
    println(s"\nReduce operations:")
    println(s"  Numbers: $nums")
    println(s"  Product: $product")
    println(s"  Maximum: $maximum")
    println(s"  Minimum: $minimum")
    
    // Exercise 5: Convert for-comprehension to map/filter
    val result1 = for {
      n <- List(1, 2, 3, 4, 5)
      if n > 2
    } yield n * n
    
    // Equivalent using map and filter
    val result2 = List(1, 2, 3, 4, 5)
      .filter(_ > 2)
      .map(x => x * x)
    
    println(s"\nFor-comprehension vs map/filter:")
    println(s"  For-comprehension result: $result1")
    println(s"  Map/filter result: $result2")
    
    // Exercise 6: For-comprehension with multiple generators
    val letters = List('a', 'b', 'c')
    val nums2 = List(1, 2)
    
    val combinations = for {
      letter <- letters
      number <- nums2
    } yield (letter, number)
    
    println(s"\nMultiple generators:")
    println(s"  Letters: $letters")
    println(s"  Numbers: $nums2")
    println(s"  Combinations: $combinations")
    
    println("\n=== Solution 07 complete! ===")
  }
}
