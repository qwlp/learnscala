object Exercise05 {
  def main(args: Array[String]): Unit = {
    // TODO: Complete the OOP exercises below
    
    // Exercise 1: Implement a class
    // Create a Rectangle class with width, height, and methods for area and perimeter
    class Rectangle(val width: Double, val height: Double) {
      // TODO: Implement area method
      def area: Double = ???
      
      // TODO: Implement perimeter method  
      def perimeter: Double = ???
      
      // TODO: Implement isSquare method (returns true if width == height)
      def isSquare: Boolean = ???
    }
    
    val rect1 = new Rectangle(5.0, 3.0)
    val rect2 = new Rectangle(4.0, 4.0)
    
    println(s"Rectangle 1: area=${rect1.area}, perimeter=${rect1.perimeter}, isSquare=${rect1.isSquare}")
    println(s"Rectangle 2: area=${rect2.area}, perimeter=${rect2.perimeter}, isSquare=${rect2.isSquare}")
    
    // Exercise 2: Case class
    // Define a case class for Book with title, author, and year
    // TODO: case class Book(???)
    
    // Create instances and use auto-generated methods
    // val book1 = Book("Scala for Beginners", "John Doe", 2023)
    // val book2 = Book("Advanced Scala", "Jane Smith", 2022)
    
    // Access fields
    // println(s"Book 1 title: ${book1.title}")
    
    // Test equality
    // val book1Copy = Book("Scala for Beginners", "John Doe", 2023)
    // println(s"book1 == book1Copy: ${book1 == book1Copy}")
    
    // Use copy method
    // val book1NewEdition = book1.copy(year = 2024)
    // println(s"Updated book: $book1NewEdition")
    
    // Exercise 3: Trait with implementation
    trait Shape {
      def area: Double
      def perimeter: Double
      def description: String = s"Shape with area=$area, perimeter=$perimeter"
    }
    
    // Create a Circle class that extends Shape
    // TODO: class Circle(radius: Double) extends Shape {
    //   def area: Double = ???
    //   def perimeter: Double = ???
    // }
    
    // val circle = new Circle(5.0)
    // println(circle.description)
    
    // Exercise 4: Mixins
    trait Drawable {
      def draw(): String = "Drawing..."
    }
    
    trait Colorful {
      def color: String
      def paint(): String = s"Painting $color"
    }
    
    // Create a class that extends Shape and mixes in Drawable and Colorful
    // TODO: class ColoredRectangle(width: Double, height: Double, val color: String) 
    //   extends Rectangle(width, height) with Drawable with Colorful
    
    // val coloredRect = new ColoredRectangle(3.0, 4.0, "blue")
    // println(coloredRect.draw())
    // println(coloredRect.paint())
    // println(s"Area: ${coloredRect.area}")
    
    println("Exercise 05 complete!")
  }
}
