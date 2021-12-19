object Main {
  def main(args: Array[String]) = {
    println("3.")
    
    print("No class: ")
    val no = new No()
    println(no.applyFunction((v: String) => "PJATK no. " + v))
    
    print("Yes class: ")
    val yes = new Yes("Pencil")
    println(yes.applyFunction((v: String) => "PJATK no. " + v))
  }
  
  trait Maybe[A]
  
  class No extends Maybe[Nothing] {
    def applyFunction[A,R](fun: A => R): No = {
      new No()
    }
  }
  
  class Yes[A](val v: A) extends Maybe[A] {
    def applyFunction[R](fun: A => R): R = {
      fun(v)
    }
  }
  
  
}
