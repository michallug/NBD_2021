import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {
    val nums = List[Double](-7, -4.5, -3, 0, 1, 2, 5.5, 8, 12, 12.5, 20)
    
    println(listFilter(nums))
  }
  
  def listFilter(list: List[Double]): List[Double] = {
    list.filter(_ >= -5).filter(_ <= 12).map(_.abs)
  }
  
}

