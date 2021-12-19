object Main {
  def main(args: Array[String]) = {
    println("2.")
    
    print("No class: ")
    val no = new No
    println(no.isInstanceOf[Maybe[_]])
    
    print("Yes class: ")
    val yes = new Yes("Pencil")
    println(yes.isInstanceOf[Maybe[_]])
  }
  
  trait Maybe[A]
  
  class No extends Maybe[Nothing] {
    
  }
  
  class Yes[A](val v: A) extends Maybe[A] {
    
  }
  
  
}
