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
    
    println("3.")
    println(stringRecursiveTail(days))
  }
  
  def stringRecursiveTail(days: List[String]): String = {
    @tailrec def tailRecur(days: List[String], str: String): String = {
      if(!days.isEmpty)
        tailRecur(days.tail, str + ", " + days.head)
      else 
        str
    }
    
    tailRecur(days.tail, days.head)
  }
}


