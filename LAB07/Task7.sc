import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {
    val products = Map("Pencil" -> 5, "Headphones" -> 35, "Keyboard" -> 80)
    println(products)
    
    println(getValue(products, "Pencil"))
    println(getValue(products, "Chair"))
  }
  
  def getValue(map : Map[String, Int], key : String): Any = {
    map.get(key).getOrElse("Produkt nie istnieje!")
  }
  
}


