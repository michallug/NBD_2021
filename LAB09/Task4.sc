object Main {
  def main(args: Array[String]) = {
    println("4.")
    
    print("No class: ")
    val no = new No()
    println(no.getOrElse("PJATK no. "))
    
    print("Yes class: ")
    val yes = new Yes("Pencil")
    println(yes.getOrElse("PJATK no. "))
  }
  
  trait Maybe[A]
  
  class No extends Maybe[Nothing] {
    def applyFunction[A,R](fun: A => R): No = {
      new No()
    }
    
    def getOrElse(par: Any) = {
      par
    }
  }
  
  class Yes[A](val v: A) extends Maybe[A] {
    def applyFunction[R](fun: A => R): R = {
      fun(v)
    }
    
    def getOrElse(par: A) = {
      v
    }
  }  
  
}
