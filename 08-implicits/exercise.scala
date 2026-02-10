object Exercise08 {
  def main(args: Array[String]): Unit = {
    // TODO: Complete the implicits exercises
    
    // Exercise 1: Implicit parameters
    // Define an implicit value
    // implicit val defaultTimeout: Int = ???
    
    // Create a function with implicit parameter
    def fetchData(url: String)(implicit timeout: Int): String = {
      s"Fetching $url with timeout=${timeout}ms"
    }
    
    // Call without explicit timeout (should use implicit)
    // val result1 = fetchData("http://example.com")
    
    // Call with explicit timeout
    val result2 = fetchData("http://example.com")(5000)
    
    // println(s"With implicit: $result1")
    println(s"With explicit: $result2")
    
    // Exercise 2: Type class pattern
    // Define a trait for serialization
    trait Serializer[T] {
      def serialize(value: T): String
    }
    
    // Create implicit instances
    // implicit val intSerializer: Serializer[Int] = new Serializer[Int] {
    //   def serialize(value: Int): String = s"int:$value"
    // }
    
    // implicit val stringSerializer: Serializer[String] = new Serializer[String] {
    //   def serialize(value: String): String = s"string:$value"
    // }
    
    // Generic function using type class
    def serialize[T](value: T)(implicit serializer: Serializer[T]): String = {
      serializer.serialize(value)
    }
    
    // Test serialization
    // println(serialize(42))
    // println(serialize("hello"))
    
    // Exercise 3: Implicit conversions
    // Define a case class
    case class Temperature(celsius: Double) {
      def fahrenheit: Double = celsius * 9/5 + 32
      def isFreezing: Boolean = celsius <= 0
    }
    
    // Create an implicit conversion from Double to Temperature
    // implicit def doubleToTemp(celsius: Double): Temperature = ???
    
    // Now you can call Temperature methods on Doubles
    // val temp = 25.0
    // println(s"25°C = ${temp.fahrenheit}°F")
    // println(s"Is freezing? ${(-5.0).isFreezing}")
    
    // Exercise 4: Implicit class (extension methods)
    // Create an implicit class to add methods to String
    // implicit class StringExtensions(val s: String) {
    //   def isPalindrome: Boolean = ???
    //   def wordCount: Int = ???
    // }
    
    // Test the extensions
    // println("radar".isPalindrome)
    // println("hello world".wordCount)
    
    println("Exercise 08 complete!")
  }
}
