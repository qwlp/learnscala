// Lesson 12: Capstone Project - Student Grade Management System (Solution)
// Complete working implementation

import scala.io.Source
import java.io.PrintWriter
import scala.util.{Try, Success, Failure}

// ==================== DATA MODELS ====================

case class Student(id: String, name: String, email: String) {
  def displayInfo: String = s"[$id] $name ($email)"
}

case class Course(id: String, name: String, credits: Int) {
  require(credits >= 1 && credits <= 6, "Credits must be between 1 and 6")
}

case class Grade(studentId: String, courseId: String, score: Double) {
  require(score >= 0.0 && score <= 100.0, "Score must be between 0.0 and 100.0")
  
  def letterGrade: String = score match {
    case s if s >= 90 => "A"
    case s if s >= 80 => "B"
    case s if s >= 70 => "C"
    case s if s >= 60 => "D"
    case _ => "F"
  }
}

// ==================== DATA SERVICE ====================

object DataService {
  
  def loadStudents(filename: String): List[Student] = {
    Try {
      val source = Source.fromFile(filename)
      try {
        source.getLines()
          .drop(1) // Skip header
          .flatMap { line =>
            val parts = line.split(",")
            if (parts.length == 3) {
              Some(Student(parts(0).trim, parts(1).trim, parts(2).trim))
            } else None
          }
          .toList
      } finally {
        source.close()
      }
    } match {
      case Success(students) => students
      case Failure(e) => 
        println(s"Error loading students: ${e.getMessage}")
        Nil
    }
  }
  
  def loadCourses(filename: String): List[Course] = {
    Try {
      val source = Source.fromFile(filename)
      try {
        source.getLines()
          .drop(1)
          .flatMap { line =>
            val parts = line.split(",")
            if (parts.length == 3) {
              try {
                Some(Course(parts(0).trim, parts(1).trim, parts(2).trim.toInt))
              } catch {
                case _: NumberFormatException => None
              }
            } else None
          }
          .toList
      } finally {
        source.close()
      }
    } match {
      case Success(courses) => courses
      case Failure(e) => 
        println(s"Error loading courses: ${e.getMessage}")
        Nil
    }
  }
  
  def loadGrades(filename: String): List[Grade] = {
    Try {
      val source = Source.fromFile(filename)
      try {
        source.getLines()
          .drop(1)
          .flatMap { line =>
            val parts = line.split(",")
            if (parts.length == 3) {
              try {
                Some(Grade(parts(0).trim, parts(1).trim, parts(2).trim.toDouble))
              } catch {
                case _: NumberFormatException => None
              }
            } else None
          }
          .toList
      } finally {
        source.close()
      }
    } match {
      case Success(grades) => grades
      case Failure(e) => 
        println(s"Error loading grades: ${e.getMessage}")
        Nil
    }
  }
  
  def saveStudents(students: List[Student], filename: String): Unit = {
    val writer = new PrintWriter(filename)
    try {
      writer.println("id,name,email")
      students.foreach { s =>
        writer.println(s"${s.id},${s.name},${s.email}")
      }
    } finally {
      writer.close()
    }
  }
  
  def saveCourses(courses: List[Course], filename: String): Unit = {
    val writer = new PrintWriter(filename)
    try {
      writer.println("id,name,credits")
      courses.foreach { c =>
        writer.println(s"${c.id},${c.name},${c.credits}")
      }
    } finally {
      writer.close()
    }
  }
  
  def saveGrades(grades: List[Grade], filename: String): Unit = {
    val writer = new PrintWriter(filename)
    try {
      writer.println("studentId,courseId,score")
      grades.foreach { g =>
        writer.println(s"${g.studentId},${g.courseId},${g.score}")
      }
    } finally {
      writer.close()
    }
  }
}

// ==================== GRADE SERVICE ====================

class GradeService(
  var students: List[Student],
  var courses: List[Course],
  var grades: List[Grade]
) {
  
  def addStudent(student: Student): Unit = {
    if (!students.exists(_.id == student.id)) {
      students = students :+ student
    }
  }
  
  def removeStudent(studentId: String): Unit = {
    students = students.filterNot(_.id == studentId)
    grades = grades.filterNot(_.studentId == studentId)
  }
  
  def addGrade(grade: Grade): Boolean = {
    val studentExists = students.exists(_.id == grade.studentId)
    val courseExists = courses.exists(_.id == grade.courseId)
    
    if (studentExists && courseExists) {
      // Remove existing grade for this student-course combination
      grades = grades.filterNot(g => g.studentId == grade.studentId && g.courseId == grade.courseId)
      grades = grades :+ grade
      true
    } else {
      false
    }
  }
  
  def getStudentGrades(studentId: String): List[(Course, Grade)] = {
    grades.filter(_.studentId == studentId).flatMap { grade =>
      courses.find(_.id == grade.courseId).map(course => (course, grade))
    }
  }
  
  def calculateGPA(studentId: String): Option[Double] = {
    val studentGrades = getStudentGrades(studentId)
    if (studentGrades.isEmpty) None
    else {
      val totalPoints = studentGrades.map { case (course, grade) =>
        val points = grade.score match {
          case s if s >= 90 => 4.0
          case s if s >= 80 => 3.0
          case s if s >= 70 => 2.0
          case s if s >= 60 => 1.0
          case _ => 0.0
        }
        points * course.credits
      }.sum
      
      val totalCredits = studentGrades.map(_._1.credits).sum
      Some(totalPoints / totalCredits)
    }
  }
  
  def topStudents(n: Int): List[(Student, Double)] = {
    students.flatMap { student =>
      calculateGPA(student.id).map(gpa => (student, gpa))
    }.sortBy(-_._2) // Sort by GPA descending
     .take(n)
  }
  
  def studentsWithoutGrades: List[Student] = {
    students.filter(s => !grades.exists(_.studentId == s.id))
  }
  
  def courseAverage(courseId: String): Option[Double] = {
    val courseGrades = grades.filter(_.courseId == courseId).map(_.score)
    if (courseGrades.isEmpty) None
    else Some(courseGrades.sum / courseGrades.length)
  }
}

// ==================== REPORT SERVICE ====================

object ReportService {
  
  def generateStudentReport(student: Student, service: GradeService): String = {
    val grades = service.getStudentGrades(student.id)
    val gpa = service.calculateGPA(student.id)
    
    val gradesSection = grades.map { case (course, grade) =>
      f"  ${course.name}%-20s | ${grade.score}%.1f | ${grade.letterGrade}"
    }.mkString("\n")
    
    s"""
    |Student Report
    |================
    |Name: ${student.name}
    |ID: ${student.id}
    |Email: ${student.email}
    |
    |Course Grades:
    |  ${"Course"}%-20s | Score | Grade
    |  ${"-" * 40}
    |$gradesSection
    |
    |GPA: ${gpa.getOrElse("N/A")}
    """.stripMargin
  }
  
  def generateClassReport(service: GradeService): String = {
    val studentCount = service.students.length
    val courseCount = service.courses.length
    val gradeCount = service.grades.length
    
    val top3 = service.topStudents(3)
    val topSection = top3.zipWithIndex.map { case ((student, gpa), i) =>
      f"  ${i + 1}. ${student.name} (GPA: ${gpa}%.2f)"
    }.mkString("\n")
    
    s"""
    |Class Summary Report
    |====================
    |Total Students: $studentCount
    |Total Courses: $courseCount
    |Total Grades Recorded: $gradeCount
    |
    |Top 3 Students:
    |$topSection
    """.stripMargin
  }
  
  def generateCourseReport(service: GradeService): String = {
    val courseStats = service.courses.map { course =>
      val avg = service.courseAverage(course.id)
      val count = service.grades.count(_.courseId == course.id)
      (course, avg.getOrElse(0.0), count)
    }.sortBy(-_._2) // Sort by average score descending
    
    val statsSection = courseStats.map { case (course, avg, count) =>
      f"  ${course.name}%-20s | ${avg}%.1f | $count students"
    }.mkString("\n")
    
    s"""
    |Course Statistics
    |=================
    |  ${"Course"}%-20s | Avg Score | Enrolled
    |  ${"-" * 45}
    |$statsSection
    """.stripMargin
  }
}

// ==================== MAIN APPLICATION ====================

object StudentGradeSystem extends App {
  
  println("Student Grade Management System")
  println("=" * 40)
  
  // Create sample data files
  val studentsData = """id,name,email
                       |1,Alice Johnson,alice@school.edu
                       |2,Bob Smith,bob@school.edu
                       |3,Carol White,carol@school.edu""".stripMargin
  
  val coursesData = """id,name,credits
                      |MATH101,Calculus I,4
                      |ENG101,English Composition,3
                      |CS101,Introduction to Programming,4
                      |PHY101,Physics I,4""".stripMargin
  
  val gradesData = """studentId,courseId,score
                     |1,MATH101,92.5
                     |1,ENG101,88.0
                     |1,CS101,95.0
                     |2,MATH101,78.5
                     |2,PHY101,82.0
                     |3,CS101,91.0
                     |3,ENG101,87.5
                     |3,MATH101,85.0
                     |3,PHY101,90.0""".stripMargin
  
  // Write sample data to files
  val studentWriter = new PrintWriter("students.csv")
  try { studentWriter.write(studentsData) } finally { studentWriter.close() }
  
  val courseWriter = new PrintWriter("courses.csv")
  try { courseWriter.write(coursesData) } finally { courseWriter.close() }
  
  val gradeWriter = new PrintWriter("grades.csv")
  try { gradeWriter.write(gradesData) } finally { gradeWriter.close() }
  
  // Load data and create GradeService
  val students = DataService.loadStudents("students.csv")
  val courses = DataService.loadCourses("courses.csv")
  val grades = DataService.loadGrades("grades.csv")
  
  val service = new GradeService(students, courses, grades)
  
  // Display reports
  println("\n" + ReportService.generateClassReport(service))
  println("\n" + ReportService.generateCourseReport(service))
  
  // Display individual student reports
  service.students.foreach { student =>
    println("\n" + ReportService.generateStudentReport(student, service))
  }
  
  // Demonstrate adding a new grade
  println("\nAdding new grade for Bob in CS101...")
  val newGrade = Grade("2", "CS101", 89.5)
  if (service.addGrade(newGrade)) {
    println("Grade added successfully!")
    val updatedGPA = service.calculateGPA("2")
    println(s"Bob's updated GPA: ${updatedGPA.map(gpa => f"$gpa%.2f").getOrElse("N/A")}")
  }
  
  // Test top students after update
  println("\nUpdated Top Students:")
  service.topStudents(3).zipWithIndex.foreach { case ((student, gpa), i) =>
    println(f"  ${i + 1}. ${student.name}%-15s (GPA: ${gpa}%.2f)")
  }
  
  // Cleanup
  new java.io.File("students.csv").delete()
  new java.io.File("courses.csv").delete()
  new java.io.File("grades.csv").delete()
  
  println("\n" + "=" * 40)
  println("System completed successfully!")
  println("\nCongratulations on completing the Scala course!")
}
