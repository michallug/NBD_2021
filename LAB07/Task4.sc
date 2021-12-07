import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {
    val days = List(
      "Poniedziałek", 
      "Wtorek",
      "Środa",
      "Czwartek",
      "Piątek",
      "Sobota",
      "Niedziela")
    
    println("4.a.")
    println(stringFoldL(days))
    
    println("4.b.")
    println(stringFoldR(days))
    
    println("4.c.")
    println(stringFoldLP(days))
  }
  
  def stringFoldL(days: List[String]) = {
    days.tail.foldLeft(days.head)(_+", "+_)
  }
  
  def stringFoldR(days: List[String]) = {
    days.dropRight(1).foldRight(days.last)(_+", "+_)
  }
  
  def stringFoldLP(days: List[String]) = {
    days.filter(_.toLowerCase().startsWith("p")).tail.foldLeft(days.head)(_+", "+_)
  }
  
}
