# Lesson 11: Case Studies and Practical Applications

## Overview

This lesson brings together concepts from all previous lessons through three comprehensive case studies. Each case study demonstrates real-world Scala programming scenarios.

## Case Study 1: Data Processing Pipeline

Combines: File I/O + Collections + Functions + Pattern Matching

### Scenario
Build a system that reads sales data from a CSV file, processes it (filtering, transformation, aggregation), and outputs a summary report.

```scala
import scala.io.Source
import java.io.PrintWriter

// Data model
case class Sale(date: String, product: String, quantity: Int, price: Double) {
  def total: Double = quantity * price
}

// Processing pipeline
object SalesProcessor {
  
  def parseLine(line: String): Option[Sale] = {
    val parts = line.split(",")
    if (parts.length == 4) {
      try {
        Some(Sale(
          parts(0).trim,
          parts(1).trim,
          parts(2).trim.toInt,
          parts(3).trim.toDouble
        ))
      } catch {
        case _: NumberFormatException => None
      }
    } else None
  }
  
  def loadSales(filename: String): List[Sale] = {
    val source = Source.fromFile(filename)
    try {
      source.getLines()
        .drop(1) // Skip header
        .flatMap(parseLine)
        .toList
    } finally {
      source.close()
    }
  }
  
  def filterByProduct(sales: List[Sale], product: String): List[Sale] =
    sales.filter(_.product == product)
  
  def totalRevenue(sales: List[Sale]): Double =
    sales.map(_.total).sum
  
  def salesByProduct(sales: List[Sale]): Map[String, Double] =
    sales.groupBy(_.product)
         .view.mapValues(_.map(_.total).sum)
         .toMap
  
  def generateReport(sales: List[Sale]): String = {
    val totalRevenue = sales.map(_.total).sum
    val totalItems = sales.map(_.quantity).sum
    val avgOrderValue = if (sales.nonEmpty) totalRevenue / sales.length else 0.0
    
    val byProduct = salesByProduct(sales).toList.sortBy(-_._2)
    
    s"""Sales Report
       |================
       |Total Sales: $$${totalRevenue}%.2f
       |Total Items Sold: $totalItems
       |Average Order Value: $$${avgOrderValue}%.2f
       |Number of Orders: ${sales.length}
       |
       |Revenue by Product:
       |${byProduct.map { case (prod, rev) => s"  $prod: $$${rev}%.2f" }.mkString("\n")}
       |""".stripMargin
  }
  
  def process(inputFile: String, outputFile: String): Unit = {
    val sales = loadSales(inputFile)
    val report = generateReport(sales)
    
    val writer = new PrintWriter(outputFile)
    try {
      writer.write(report)
    } finally {
      writer.close()
    }
    println(s"Report written to $outputFile")
  }
}
```

## Case Study 2: Library Management System

Combines: OOP + Pattern Matching + Collections + State Management

### Scenario
Design a library system to manage books, patrons, and checkouts.

```scala
import scala.collection.mutable

// Domain models
case class Book(id: String, title: String, author: String, year: Int)
case class Patron(id: String, name: String)

sealed trait LoanStatus
case object Available extends LoanStatus
case class CheckedOut(by: Patron, dueDate: String) extends LoanStatus

// Library service
class Library {
  private val books = mutable.Map[String, Book]()
  private val loans = mutable.Map[String, LoanStatus]()
  private val patrons = mutable.Map[String, Patron]()
  
  def addBook(book: Book): Unit = {
    books(book.id) = book
    loans(book.id) = Available
  }
  
  def registerPatron(patron: Patron): Unit = {
    patrons(patron.id) = patron
  }
  
  def checkout(bookId: String, patronId: String, dueDate: String): Boolean = {
    (books.get(bookId), patrons.get(patronId), loans.get(bookId)) match {
      case (Some(_), Some(patron), Some(Available)) =>
        loans(bookId) = CheckedOut(patron, dueDate)
        true
      case _ => false
    }
  }
  
  def returnBook(bookId: String): Boolean = {
    loans.get(bookId) match {
      case Some(CheckedOut(_, _)) =>
        loans(bookId) = Available
        true
      case _ => false
    }
  }
  
  def searchByTitle(query: String): List[Book] =
    books.values.filter(_.title.toLowerCase.contains(query.toLowerCase)).toList
  
  def availableBooks: List[Book] =
    loans.collect { case (id, Available) if books.contains(id) => books(id) }.toList
  
  def overdueBooks(today: String): List[(Book, Patron)] = {
    loans.collect {
      case (id, CheckedOut(patron, dueDate)) if dueDate < today && books.contains(id) =>
        (books(id), patron)
    }.toList
  }
}

// Usage
val library = new Library()
library.addBook(Book("1", "Scala Programming", "John Doe", 2023))
library.registerPatron(Patron("1", "Alice"))
library.checkout("1", "1", "2024-12-31")
```

## Case Study 3: Functional Data Processing

Combines: Functional Programming + Recursion + Higher-Order Functions

### Scenario
Process nested data structures using pure functional techniques.

```scala
// Tree data structure for organization hierarchy
sealed trait OrgNode
case class Employee(name: String, role: String, salary: Double) extends OrgNode
case class Department(name: String, members: List[OrgNode]) extends OrgNode

object OrgProcessing {
  
  // Recursive function to count all employees
  def countEmployees(node: OrgNode): Int = node match {
    case Employee(_, _, _) => 1
    case Department(_, members) => members.map(countEmployees).sum
  }
  
  // Recursive function to calculate total salary
  def totalSalary(node: OrgNode): Double = node match {
    case Employee(_, _, salary) => salary
    case Department(_, members) => members.map(totalSalary).sum
  }
  
  // Find all employees matching a predicate
  def findEmployees(node: OrgNode, predicate: Employee => Boolean): List[Employee] = node match {
    case e: Employee if predicate(e) => List(e)
    case _: Employee => Nil
    case Department(_, members) => members.flatMap(findEmployees(_, predicate))
  }
  
  // Map over all employees (pure functional transformation)
  def mapEmployees(node: OrgNode, f: Employee => Employee): OrgNode = node match {
    case e: Employee => f(e)
    case Department(name, members) => 
      Department(name, members.map(mapEmployees(_, f)))
  }
  
  // Flatten organization to list of employees
  def flatten(node: OrgNode): List[Employee] = node match {
    case e: Employee => List(e)
    case Department(_, members) => members.flatMap(flatten)
  }
  
  // Higher-order function: fold over organization
  def foldOrg[A](node: OrgNode, empty: A)(combine: (A, Employee) => A): A = node match {
    case e: Employee => combine(empty, e)
    case Department(_, members) => 
      members.foldLeft(empty)((acc, m) => foldOrg(m, acc)(combine))
  }
}

// Example usage
val engineering = Department("Engineering", List(
  Employee("Alice", "Manager", 120000),
  Department("Frontend", List(
    Employee("Bob", "Developer", 90000),
    Employee("Carol", "Developer", 95000)
  )),
  Department("Backend", List(
    Employee("David", "Developer", 100000)
  ))
))

OrgProcessing.countEmployees(engineering)  // 4
OrgProcessing.totalSalary(engineering)     // 405000.0
OrgProcessing.findEmployees(engineering, _.salary > 95000).map(_.name)  // List("Alice", "David")
```

## Best Practices Demonstrated

1. **Pure Functions**: Data processing without side effects
2. **Immutable Data**: Using case classes and val
3. **Pattern Matching**: Exhaustive and type-safe
4. **Higher-Order Functions**: Flexible, reusable code
5. **Resource Management**: Properly closing files with try-finally
6. **Error Handling**: Using Option for potentially failing operations
7. **Separation of Concerns**: Each class/object has a single responsibility

## Assignment

Complete the exercises in `exercise.scala`. Your tasks:

1. **Task 1**: Implement CSV data processing functions (filter, transform, aggregate)
2. **Task 2**: Complete the Library class methods (checkouts, returns, searching)
3. **Task 3**: Process organization tree using functional programming techniques

Each task builds on the previous lessons and combines multiple concepts.

Run with: `scala exercise.scala`

Check your answer against `solution.scala`
