// Lesson 11: Case Studies - Exercise
// Complete the implementations below by filling in the ??? sections

import scala.io.Source
import java.io.PrintWriter
import scala.collection.mutable

// ==================== CASE STUDY 1: CSV Data Processing ====================

case class Product(id: String, name: String, category: String, price: Double, stock: Int)

object DataProcessor {
  
  def parseProduct(line: String): Option[Product] = {
    val parts = line.split(",")
    // TODO 1: Parse a CSV line into a Product
    // Format: id,name,category,price,stock
    // Return None if parsing fails
    if (parts.length == 5) {
      try {
        Some(Product(
          parts(0).trim,
          parts(1).trim,
          ???,  // category
          ???,  // price - convert to Double
          ???   // stock - convert to Int
        ))
      } catch {
        case _: NumberFormatException => ???
      }
    } else ???
  }
  
  def loadProducts(filename: String): List[Product] = {
    // TODO 2: Load products from file
    // Read all lines, skip header (first line), parse each line
    val source = Source.fromFile(filename)
    try {
      source.getLines()
        .???  // Skip header
        .???  // Parse each line to Product
        .toList
    } finally {
      source.close()
    }
  }
  
  def filterByCategory(products: List[Product], category: String): List[Product] = {
    // TODO 3: Return only products matching the category
    products.???
  }
  
  def totalInventoryValue(products: List[Product]): Double = {
    // TODO 4: Calculate total value (price * stock for all products)
    products.???
  }
  
  def averagePriceByCategory(products: List[Product]): Map[String, Double] = {
    // TODO 5: Group by category and calculate average price
    products.groupBy(???)
            .view.mapValues { prods => 
              prods.map(???).sum / prods.length
            }
            .toMap
  }
  
  def lowStockProducts(products: List[Product], threshold: Int): List[Product] = {
    // TODO 6: Find products with stock below threshold
    ???
  }
}

// ==================== CASE STUDY 2: Library Management ====================

case class Book(id: String, title: String, author: String, year: Int)
case class Member(id: String, name: String)

sealed trait BookStatus
case object Available extends BookStatus
case class Borrowed(by: Member, dueDate: String) extends BookStatus

class Library {
  private val books = mutable.Map[String, Book]()
  private val status = mutable.Map[String, BookStatus]()
  private val members = mutable.Map[String, Member]()
  
  def addBook(book: Book): Unit = {
    // TODO 7: Add book to library with Available status
    ???
    ???
  }
  
  def registerMember(member: Member): Unit = {
    // TODO 8: Register a new member
    ???
  }
  
  def borrow(bookId: String, memberId: String, dueDate: String): Boolean = {
    // TODO 9: Check out a book to a member
    // Use pattern matching to verify book exists, member exists, and book is Available
    (books.get(bookId), members.get(memberId), status.get(bookId)) match {
      case (Some(_), Some(member), Some(Available)) =>
        ???
        true
      case _ => ???
    }
  }
  
  def returnBook(bookId: String): Boolean = {
    // TODO 10: Return a borrowed book
    status.get(bookId) match {
      case Some(Borrowed(_, _)) =>
        ???
        ???
      case _ => false
    }
  }
  
  def searchByAuthor(author: String): List[Book] = {
    // TODO 11: Find books by author (case-insensitive partial match)
    books.values.filter(???).toList
  }
  
  def availableBooks: List[Book] = {
    // TODO 12: Return all books currently available
    status.collect {
      case (id, Available) if books.contains(id) => ???
    }.toList
  }
  
  def memberBorrows(memberId: String): List[Book] = {
    // TODO 13: Return all books borrowed by a specific member
    status.collect {
      case (bookId, Borrowed(member, _)) if member.id == ??? => 
        books(bookId)
    }.toList
  }
}

// ==================== CASE STUDY 3: Organization Tree ====================

sealed trait TreeNode
case class Leaf(value: Int) extends TreeNode
case class Branch(children: List[TreeNode]) extends TreeNode

object TreeOperations {
  
  def sumAll(node: TreeNode): Int = node match {
    // TODO 14: Calculate sum of all values in tree
    case Leaf(value) => ???
    case Branch(children) => children.???
  }
  
  def countLeaves(node: TreeNode): Int = node match {
    // TODO 15: Count number of Leaf nodes
    case Leaf(_) => ???
    case Branch(children) => children.???
  }
  
  def findMax(node: TreeNode): Option[Int] = node match {
    // TODO 16: Find maximum value in tree (if any)
    case Leaf(value) => Some(value)
    case Branch(children) =>
      val maxValues = children.flatMap(???)
      if (maxValues.isEmpty) ??? else Some(maxValues.???)
  }
  
  def mapTree(node: TreeNode, f: Int => Int): TreeNode = node match {
    // TODO 17: Apply function f to all values in tree
    case Leaf(value) => ???
    case Branch(children) => ???
  }
  
  def filterTree(node: TreeNode, predicate: Int => Boolean): List[Int] = node match {
    // TODO 18: Return all values that satisfy predicate
    case Leaf(value) => if (???) List(value) else Nil
    case Branch(children) => children.flatMap(???)
  }
}

// ==================== TESTING YOUR SOLUTION ====================

object CaseStudiesExercise extends App {
  
  println("=== Case Study 1: Data Processing ===")
  // Create a test file for products
  val testProducts = """id,name,category,price,stock
                       |1,Laptop,Electronics,999.99,50
                       |2,Mouse,Electronics,29.99,200
                       |3,Chair,Furniture,199.99,30
                       |4,Desk,Furniture,399.99,15""".stripMargin
  
  val writer = new PrintWriter("test_products.csv")
  try {
    writer.write(testProducts)
  } finally {
    writer.close()
  }
  
  val products = DataProcessor.loadProducts("test_products.csv")
  println(s"Loaded ${products.length} products")
  println(s"Total inventory value: $${DataProcessor.totalInventoryValue(products)}")
  println(s"Electronics: ${DataProcessor.filterByCategory(products, "Electronics").map(_.name)}")
  
  println("\n=== Case Study 2: Library System ===")
  val library = new Library()
  library.addBook(Book("1", "Scala Programming", "Martin", 2023))
  library.addBook(Book("2", "Java Basics", "James", 2020))
  library.registerMember(Member("1", "Alice"))
  
  println(s"Available books: ${library.availableBooks.map(_.title)}")
  println(s"Borrow book 1: ${library.borrow("1", "1", "2024-12-31")}")
  println(s"Available after borrow: ${library.availableBooks.map(_.title)}")
  println(s"Alice's books: ${library.memberBorrows("1").map(_.title)}")
  
  println("\n=== Case Study 3: Tree Operations ===")
  val tree = Branch(List(
    Leaf(10),
    Branch(List(Leaf(5), Leaf(15))),
    Leaf(20)
  ))
  
  println(s"Sum: ${TreeOperations.sumAll(tree)}")
  println(s"Leaf count: ${TreeOperations.countLeaves(tree)}")
  println(s"Max value: ${TreeOperations.findMax(tree)}")
  println(s"Values > 10: ${TreeOperations.filterTree(tree, _ > 10)}")
  
  // Cleanup
  new java.io.File("test_products.csv").delete()
  println("\nAll exercises completed!")
}
