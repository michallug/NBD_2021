import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {
    val products = Map("Pencil" -> 5, "Headphones" -> 35, "Keyboard" -> 80)
    println(products)
    
    val productsSales = products.map{ 
      case (k, v) => k -> v*0.9 
    }
    println(productsSales)
  }
  
}


