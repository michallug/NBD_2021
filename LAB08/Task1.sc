object Main {
  def main(args: Array[String]) = {
    
    println("1.")
    println(typDnia("Poniedziałek"))
    println(typDnia("Sobota"))
    println(typDnia("Plecak"))
  }
  
  def typDnia(str: String): String = {
    var dniRobocze = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")
    var dniWeekend = List("Sobota", "Niedziela")

    str match {
      case a if (dniRobocze.contains(a)) => "Praca"
      case b if (dniWeekend.contains(b)) => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }  
}


