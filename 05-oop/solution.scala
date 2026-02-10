object Solution05 {
  def main(args: Array[String]): Unit = {
    println("=== SOLUTION 05: Object-Oriented Programming ===\n")
    
    // Exercise 1: Implement a class
    class Rectangle(val width: Double, val height: Double) {
      def area: Double = width * height
      def perimeter: Double = 2 * (width + height)
      def isSquare: Boolean = width == height
    }
    
    val rect1 = new Rectangle(5.0, 3.0)
    val rect2 = new Rectangle(4.0, 4.0)
    
    println(s"Rectangle 1 (${rect1.width}x${rect1.height}):")
    println(s"  Area: ${rect1.area}, Perimeter: ${rect1.perimeter}, IsSquare: ${rect1.isSquare}")
    println(s"Rectangle 2 (${rect2.width}x${rect2.height}):")
    println(s"  Area: ${rect2.area}, Perimeter: ${rect2.perimeter}, IsSquare: ${rect2.isSquare}")
    
    // Exercise 2: Case class
    case class Book(title: String, author: String, year: Int)
    
    val book1 = Book("Scala for Beginners", "John Doe", 2023)
    val book2 = Book("Advanced Scala", "Jane Smith", 2022)
    
    println(s"\nCase classes:")
    println(s"  Book 1 title: ${book1.title}")
    println(s"  Book 1 author: ${book1.author}")
    
    // Test equality
    val book1Copy = Book("Scala for Beginners", "John Doe", 2023)
    println(s"  book1 == book1Copy: ${book1 == book1Copy}")
    
    // Use copy method
    val book1NewEdition = book1.copy(year = 2024)
    println(s"  Updated book: $book1NewEdition")
    
    // Exercise 3: Trait with implementation
    trait Shape {
      def area: Double
      def perimeter: Double
      def description: String = s"Shape with area=$area, perimeter=$perimeter"
    }
    
    class Circle(radius: Double) extends Shape {
      def area: Double = math.Pi * radius * radius
      def perimeter: Double = 2 * math.Pi * radius
    }
    
    val circle = new Circle(5.0)
    println(s"\nTrait implementation:")
    println(s"  ${circle.description}")
    
    // Exercise 4: Mixins
    trait Drawable {
      def draw(): String = "Drawing..."
    }
    
    trait Colorful {
      def color: String
      def paint(): String = s"Painting $color"
    }
    
    class ColoredRectangle(width: Double, height: Double, val color: String) 
      extends Rectangle(width, height) with Drawable with Colorful
    
    val coloredRect = new ColoredRectangle(3.0, 4.0, "blue")
    println(s"\nMixins:")
    println(s"  ${coloredRect.draw()}")
    println(s"  ${coloredRect.paint()}")
    println(s"  Area: ${coloredRect.area}")
    println(s"  Color: ${coloredRect.color}")
    
    println("\n=== Solution 05 complete! ===")
  }
}
