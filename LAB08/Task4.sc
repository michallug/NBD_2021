object Main {
  def main(args: Array[String]) = {
    println("4." + fun2(100, fun1))
  }
  
  def fun1(par: Int): Int = {
    par + 1
  }
  
  def fun2(par: Int, fun: Int => Int): Int = {
    fun1(fun1(fun1(par)))
  }
  
}
