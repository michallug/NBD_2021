object Main {
  def main(args: Array[String]) = {
    println("5.")
    
    val student = new Osoba("Michał", "Kowalski") with Student
    println("Student pensja: brak")
    println("Student podatek: " + student.podatek + "\n")
    
    val nauczyciel = new Osoba("Jan", "Piątek") with Nauczyciel
    nauczyciel.pensja = 5000
    println("Nauczyciel pensja: " + nauczyciel.pensja)
    println("Nauczyciel podatek: " + nauczyciel.podatek + "\n")
    
    val pracownik = new Osoba("Adam", "Lipiec") with Pracownik
    pracownik.pensja = 4000
    println("Pracownik pensja: " + pracownik.pensja)
    println("Pracownik podatek: " + pracownik.podatek + "\n")
    
    val studentPracownik = new Osoba("Filip", "Prosty") with Student with Pracownik
    studentPracownik.pensja = 3000
    println("Student-pracownik pensja: " + studentPracownik.pensja)
    println("Student-pracownik  podatek: " + studentPracownik.podatek + "\n")
    
    val pracownikStudent = new Osoba("Dariusz", "Gryz") with Pracownik with Student
    pracownikStudent.pensja = 3000
    println("Pracownik-student pensja: " + pracownikStudent.pensja)
    println("Pracownik-student podatek: " + pracownikStudent.podatek + "\n")
    
    println("Drugi dodany trait, decyduje o wartości podatku.")
  }
  
  class Osoba(val imie: String, val nazwisko: String, private var _podatek: Double = 0) {
    def podatek: Double = _podatek
  }
  
  trait Pracownik extends Osoba {
    var pensja: Double = 0
    override def podatek: Double = 0.2 * pensja
  }
  
  trait Student extends Osoba {
    override def podatek: Double = 0
  }
  
  trait Nauczyciel extends Pracownik {
    override def podatek: Double = 0.1 * pensja
  }
  
}
