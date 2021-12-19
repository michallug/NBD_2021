object Main {
  def main(args: Array[String]) = {
    println("2.")  
        
    val kontoPuste = new KontoBankowe()
    println("Nowe, puste konto: " + kontoPuste.stanKonta)
    
    
    val konto = new KontoBankowe(100)
    println("Nowe konto. Początkowy stan: " + konto.stanKonta)
    
    konto.wplata(1000)
    println("Wpłata 1000: " + konto.stanKonta)
    
    konto.wyplata(1005)
    println("Wpłata 1005: " + konto.stanKonta)
  }
  
  class KontoBankowe(private var _stanKonta: Double) {

    def this() = {
      this(0)
    }
    
    def stanKonta: Double = _stanKonta
    
    def wplata(wartosc: Double): Double = {
      this._stanKonta = this._stanKonta + wartosc
      this._stanKonta
    }

    def wyplata(wartosc: Double): Double = {
      this._stanKonta = this._stanKonta - wartosc
      this._stanKonta
    }
  }
}


