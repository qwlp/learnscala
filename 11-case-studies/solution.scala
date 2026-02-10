// Lesson 11: Case Studies - Solution
// Complete working implementations

import scala.io.Source
import java.io.PrintWriter
import scala.collection.mutable

// ==================== CASE STUDY 1: CSV Data Processing ====================

case class Product(id: String, name: String, category: String, price: Double, stock: Int)

object DataProcessor {
  
  def parseProduct(line: String): Option[Product] = {
    val parts = line.split(",")
    if (parts.length == 5) {
      try {
        Some(Product(
          parts(0).trim,
          parts(1).trim,
          parts(2).trim,                     // category
          parts(3).trim.toDouble,            // price
          parts(4).trim.toInt                // stock
        ))
      } catch {
        case _: NumberFormatException => None
      }
    } else None
  }
  
  def loadProducts(filename: String): List[Product] = {
    val source = Source.fromFile(filename)
    try {
      source.getLines()
        .drop(1) // Skip header
        .flatMap(parseProduct)
        .toList
    } finally {
      source.close()
    }
  }
  
  def filterByCategory(products: List[Product], category: String): List[Product] = {
    products.filter(_.category == category)
  }
  
  def totalInventoryValue(products: List[Product]): Double = {
    products.map(p => p.price * p.stock).sum
  }
  
  def averagePriceByCategory(products: List[Product]): Map[String, Double] = {
    products.groupBy(_.category)
            .view.mapValues { prods => 
              prods.map(_.price).sum / prods.length
            }
            .toMap
  }
  
  def lowStockProducts(products: List[Product], threshold: Int): List[Product] = {
    products.filter(_.stock < threshold)
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
    books(book.id) = book
    status(book.id) = Available
  }
  
  def registerMember(member: Member): Unit = {
    members(member.id) = member
  }
  
  def borrow(bookId: String, memberId: String, dueDate: String): Boolean = {
    (books.get(bookId), members.get(memberId), status.get(bookId)) match {
      case (Some(_), Some(member), Some(Available)) =>
        status(bookId) = Borrowed(member, dueDate)
        true
      case _ => false
    }
  }
  
  def returnBook(bookId: String): Boolean = {
    status.get(bookId) match {
      case Some(Borrowed(_, _)) =>
        status(bookId) = Available
        true
      case _ => false
    }
  }
  
  def searchByAuthor(author: String): List[Book] = {
    books.values.filter(_.author.toLowerCase.contains(author.toLowerCase)).toList
  }
  
  def availableBooks: List[Book] = {
    status.collect {
      case (id, Available) if books.contains(id) => books(id)
    }.toList
  }
  
  def memberBorrows(memberId: String): List[Book] = {
    status.collect {
      case (bookId, Borrowed(member, _)) if member.id == memberId => 
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
    case Leaf(value) => value
    case Branch(children) => children.map(sumAll).sum
  }
  
  def countLeaves(node: TreeNode): Int = node match {
    case Leaf(_) => 1
    case Branch(children) => children.map(countLeaves).sum
  }
  
  def findMax(node: TreeNode): Option[Int] = node match {
    case Leaf(value) => Some(value)
    case Branch(children) =>
      val maxValues = children.flatMap(findMax)
      if (maxValues.isEmpty) None else Some(maxValues.max)
  }
  
  def mapTree(node: TreeNode, f: Int => Int): TreeNode = node match {
    case Leaf(value) => Leaf(f(value))
    case Branch(children) => Branch(children.map(mapTree(_, f)))
  }
  
  def filterTree(node: TreeNode, predicate: Int => Boolean): List[Int] = node match {
    case Leaf(value) => if (predicate(value)) List(value) else Nil
    case Branch(children) => children.flatMap(filterTree(_, predicate))
  }
}

// ==================== DEMONSTRATION ====================

object CaseStudiesSolution extends App {
  
  println("=== Case Study 1: Data Processing ===")
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
  println(s"Low stock (< 20): ${DataProcessor.lowStockProducts(products, 20).map(_.name)}")
  println(s"Avg price by category: ${DataProcessor.averagePriceByCategory(products)}")
  
  println("\n=== Case Study 2: Library System ===")
  val library = new Library()
  library.addBook(Book("1", "Scala Programming", "Martin", 2023))
  library.addBook(Book("2", "Java Basics", "James", 2020))
  library.registerMember(Member("1", "Alice"))
  
  println(s"Available books: ${library.availableBooks.map(_.title)}")
  println(s"Borrow book 1: ${library.borrow("1", "1", "2024-12-31")}")
  println(s"Available after borrow: ${library.availableBooks.map(_.title)}")
  println(s"Alice's books: ${library.memberBorrows("1").map(_.title)}")
  println(s"Return book 1: ${library.returnBook("1")}")
  println(s"Available after return: ${library.availableBooks.map(_.title)}")
  
  println("\n=== Case Study 3: Tree Operations ===")
  val tree = Branch(List(
    Leaf(10),
    Branch(List(Leaf(5), Leaf(15))),
    Leaf(20)
  ))
  
  println(s"Sum: ${TreeOperations.sumAll(tree)}") // 50
  println(s"Leaf count: ${TreeOperations.countLeaves(tree)}") // 4
  println(s"Max value: ${TreeOperations.findMax(tree)}") // Some(20)
  println(s"Doubled tree: ${TreeOperations.mapTree(tree, _ * 2)}")
  println(s"Values > 10: ${TreeOperations.filterTree(tree, _ > 10)}") // List(15, 20)
  
  new java.io.File("test_products.csv").delete()
  println("\nAll case studies completed successfully!")
}
