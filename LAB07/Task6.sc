import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {
    val tuple = ("Pencil", 5, 0.5)
    
    stringTuple(tuple)    
  }
  
  def stringTuple(tup: (Any, Any, Any)) = {
    println(tup._1)
    println(tup._2)
    println(tup._3)
  }  
}
