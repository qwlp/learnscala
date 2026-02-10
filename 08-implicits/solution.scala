object Solution08 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 08: Implicits ===\n")
    
    // Exercise 1: Implicit parameters
    implicit val defaultTimeout: Int = 3000
    
    def fetchData(url: String)(implicit timeout: Int): String = {
      s"Fetching $url with timeout=${timeout}ms"
    }
    
    // Call without explicit timeout (uses implicit)
    val result1 = fetchData("http://example.com")
    
    // Call with explicit timeout
    val result2 = fetchData("http://example.com")(5000)
    
    println("Implicit parameters:")
    println(s"  With implicit: $result1")
    println(s"  With explicit: $result2")
    
    // Exercise 2: Type class pattern
    trait Serializer[T] {
      def serialize(value: T): String
    }
    
    implicit val intSerializer: Serializer[Int] = new Serializer[Int] {
      def serialize(value: Int): String = s"int:$value"
    }
    
    implicit val stringSerializer: Serializer[String] = new Serializer[String] {
      def serialize(value: String): String = s"string:$value"
    }
    
    implicit val doubleSerializer: Serializer[Double] = new Serializer[Double] {
      def serialize(value: Double): String = s"double:$value"
    }
    
    def serialize[T](value: T)(implicit serializer: Serializer[T]): String = {
      serializer.serialize(value)
    }
    
    println("\nType class pattern (Serializer):")
    println(s"  ${serialize(42)}")
    println(s"  ${serialize("hello")}")
    println(s"  ${serialize(3.14)}")
    
    // Exercise 3: Implicit conversions
    case class Temperature(celsius: Double) {
      def fahrenheit: Double = celsius * 9/5 + 32
      def isFreezing: Boolean = celsius <= 0
    }
    
    implicit def doubleToTemp(celsius: Double): Temperature = Temperature(celsius)
    
    val temp = 25.0
    println(s"\nImplicit conversions:")
    println(s"  25°C = ${temp.fahrenheit}°F")
    println(s"  Is -5°C freezing? ${(-5.0).isFreezing}")
    println(s"  Is 5°C freezing? ${(5.0).isFreezing}")
    
    // Exercise 4: Implicit class (extension methods)
    implicit class StringExtensions(val s: String) {
      def isPalindrome: Boolean = s == s.reverse
      def wordCount: Int = s.trim.split("\\s+").length
      def reversed: String = s.reverse
    }
    
    println("\nImplicit class (extension methods):")
    println(s"  'radar'.isPalindrome = ${"radar".isPalindrome}")
    println(s"  'hello'.isPalindrome = ${"hello".isPalindrome}")
    println(s"  'hello world'.wordCount = ${"hello world".wordCount}")
    println(s"  'Scala'.reversed = ${"Scala".reversed}")
    
    println("\n=== Solution 08 complete! ===")
  }
}
