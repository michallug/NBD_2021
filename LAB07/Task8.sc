import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {
    val nums = List[Int](0, 1, 2, 3, 0, 4, 0, 5, 6, 7, 0, 8, 9, 0, 10)
    
    println(zeroCut(nums))
  }
  
  @tailrec
  def zeroCut(list: List[Int], accumulator: List[Int] = List.empty): List[Int] = list match {
    case Nil => accumulator //if Empty
    case 0::tail => zeroCut(tail, accumulator)
    case head::tail => zeroCut(tail, accumulator:+head)
  }
  
}

