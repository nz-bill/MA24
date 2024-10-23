public class Main {
    public static void main(String[] args) {


       Board board = new Board(10);
       board.printBoard();
    }
}

//Skapa ett text-baserat Tre-i-rad-spel i Java som spelas av två mänskliga spelare i terminalen/konsollen.
// Varje spelare turas om att ange var i ett 3x3-rutnät spelaren önskar placera X (eller O).
// När en spelare har tre X (eller O) i rad horisontellt, vertikalt eller diagonalt meddelar spelet vem som vann.
// Har ingen spelare tre i rad när inga tomma rutor längre kvarstår slutar spelet oavgjort.
// Efter att ett spel är klart börjar spelet om med ett nytt tomt rutnät.

//Game
//    -winner
// -wins
//  -draw
//  -turns
// -loop
// -currentPlayer

//Player
// -name

//InputOutput
//-errorHandling

//Board
//  -grid (squares)
// -size
//  -skriv ut grid

//square
// -player
// -print

//row
//column
//diagonal

//Menu
// -starta ett spel med två spelare
// * starta ett spel mot datorn
//  -avsluta

//AI

// skapa ett rutnät
// skriva ut rutnät
//TODO skapa en meny
//TODO starta ett nytt spel -1p
//TODO starta ett spel- 2p
//TODO spelare kan lägga ut markörer
//TODO kontrollera om man KAN lägga ut markör
//TODO kontrollera om spelare har vunnit

//TODO kontrollera om det blivit oavgjort
//TODO fråga om man vill spela igen




//TODO Spelet ska vara spelbart mellan två människor som turas om att ge indata till terminalen/kommandotolken där spelet visas med text-baserad grafik.
//TODO Spelet ska kontrollera och meddela vilken spelare som vunnit eller om spelet slutat oavgjort
//TODO Spelet ska vid varje drag kontrollera att indata motsvarar en tom ruta i rutnätet
//TODO När en spelare vunnit börjar spelet om från början.
//TODO Din kod skall vara skriven på engelska: variabelnamn, klassnamn, metodnamn och helst även kommentarer
//TODO Spelat skall vara skrivet Objektorienterat, så det skall innehålla olika klasser.
//TODO Projektet finns upplagt på GitHub.

//vg
//TODO Spelet ska fråga om spelarnas namn och vid varje drag skriva ut vems tur det är
//TODO Spelet ska räkna hur många vinster varje spelare har
//TODO Indata från användaren skall korrekt felhanteras så spelet varken kraschar eller att andra fel uppstår
//TODO Under projektet har Git använts kontinuerlig och versionshistorik finns tillgänglig i den slutgiltiga inlämningen

//minst en av följande
//TODO Spelet ska ha stöd för att spela mot datorspelare som slumpar fram sina drag
//TODO Spelet ska vara flexibelt så att det med indata går att välja hur många rutor spelplanen är