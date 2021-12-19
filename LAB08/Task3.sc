object Main {
  def main(args: Array[String]) = {
    println("3.")
    val osoba1 = new Osoba("Kot", "Pejot")
    val osoba2 = new Osoba("Adam", "Lis")
    val osoba3 = new Osoba("Kamil", "Nowak")
    
    println(osoba1.powitaj())
    println(osoba2.powitaj())
    println(osoba3.powitaj())
  }
  
  case class Osoba(imie: String, nazwisko: String) {
    
    def powitaj(): String = {
      this.imie match {
        case "Kot" => "Dzień dobry, Kocie Pejocie"
        case "Adam" => "Dzień dobry, Adamie"
        case _ => "Witaj, nieznajomy!"
      }
    }
  }
}
