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
    
    println("1.a.")
    println(stringFor(days))
    
    println("1.b.")
    println(stringForP(days))
    
    println("1.c.")
    println(stringForWhile(days))
  }
  
  def stringFor(days: List[String]) = {
    var str = ""
    for (i <- days) {
      if (str != "")
        str += ", " + i
      else
        str += i
    }
    
    str
  }
  
  def stringForP(days: List[String]) = {
    var str = ""
    for (i <- days.filter(_.toLowerCase().startsWith("p"))) {
      if (str != "")
        str += ", " + i
      else
        str += i
    }
    
    str
  }
  
  def stringForWhile(days: List[String]) = {
    var str = ""
    var i = 0;
    while (i < days.length) {
      if (str != "")
        str += ", " + days.get(i)
      else
        str += days.get(i)

      i += 1;
    }

    str
  }
  
}


