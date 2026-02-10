object Exercise07 {
  def main(args: Array[String]): Unit = {
    // TODO: Complete the functional programming exercises
    
    // Exercise 1: map operations
    val numbers = List(1, 2, 3, 4, 5)
    
    // Use map to create a list of squares
    val squares = ???  // numbers.map(???)
    
    // Use map to create a list of doubled values
    val doubled = ???  // numbers.map(???)
    
    println(s"Original: $numbers")
    println(s"Squares: $squares")
    println(s"Doubled: $doubled")
    
    // Exercise 2: filter operations
    val moreNumbers = List(10, 15, 20, 25, 30, 35, 40)
    
    // Filter for even numbers
    val evens = ???  // moreNumbers.filter(???)
    
    // Filter for numbers greater than 20
    val greaterThan20 = ???  // moreNumbers.filter(???)
    
    // Filter for numbers divisible by 5
    val divisibleBy5 = ???  // moreNumbers.filter(???)
    
    println(s"Evens: $evens")
    println(s"Greater than 20: $greaterThan20")
    println(s"Divisible by 5: $divisibleBy5")
    
    // Exercise 3: Chaining operations
    // Get the sum of squares of even numbers
    val numbers2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    val sumOfEvenSquares = numbers2
      // .filter(???)  // Keep only even numbers
      // .map(???)     // Square them
      // .sum          // Sum them up
    
    println(s"Sum of squares of even numbers: $sumOfEvenSquares")
    
    // Exercise 4: reduce operations
    val nums = List(5, 10, 15, 20)
    
    // Calculate product using reduce
    val product = ???  // nums.reduce(???)
    
    // Find maximum using reduce
    val maximum = ???  // nums.reduce(???)
    
    // Find minimum using reduce
    val minimum = ???  // nums.reduce(???)
    
    println(s"Product: $product")
    println(s"Maximum: $maximum")
    println(s"Minimum: $minimum")
    
    // Exercise 5: Convert for-comprehension to map/filter
    // This for-comprehension:
    val result1 = for {
      n <- List(1, 2, 3, 4, 5)
      if n > 2
    } yield n * n
    
    // Rewrite using map and filter:
    val result2 = List(1, 2, 3, 4, 5)
      // .filter(???)
      // .map(???)
    
    println(s"For-comprehension result: $result1")
    println(s"Map/filter result: $result2")
    
    // Exercise 6: For-comprehension with multiple generators
    // Create all combinations of (letter, number) where letter is a,b,c and number is 1,2
    val letters = List('a', 'b', 'c')
    val nums2 = List(1, 2)
    
    val combinations = for {
      // TODO: Fill in generators
      ???
    } yield (letter, number)
    
    println(s"Combinations: $combinations")
    
    println("Exercise 07 complete!")
  }
}
