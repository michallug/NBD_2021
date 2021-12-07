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
    
    println("2.a.")
    println(stringRecursive(days))
    
    println("2.b.")
    println(stringRecursiveRev(days))
  }
  
  def stringRecursive(days: List[String]): String = {
    if (!days.tail.isEmpty)
      days.head + ", " + stringRecursive(days.tail)
    else 
      days.head
  }
  
  def stringRecursiveRev(days: List[String]): String = {
    if (!days.tail.isEmpty)
      stringRecursiveRev(days.tail) + ", " + days.head
    else 
      days.head
  }  
}


