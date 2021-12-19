object Main {
  def main(args: Array[String]) = {
    println("1.")
    
    println("1. Cointaner")
    val con = new Container("s17190");
    println(con.getContent())
    println(con.applyFunction((v: String) => "PJATK no. " + v))
    
    println("2. Cointaner")
    val con2 = new Container("17190");
    println(con2.getContent())
    println(con2.applyFunction((v: String) => "Pow = " + Integer.parseInt(v) * Integer.parseInt(v)))
  }
  
  class Container[A](private val v: A){
    def getContent(): A = {
      v
    }
    
    def applyFunction[R](fun: A => R): R = {
      fun(v)
    }
  }
  
}
