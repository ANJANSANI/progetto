
abstract class Traccia {
    protected int durata; // Durata in minuti
    public abstract int getDurata();
    public abstract String getInfo();
}

// Classe TracciaAudio che estende Traccia
class TracciaAudio extends Traccia {
    private String titolo;
    private String copertina;

    public TracciaAudio(String titolo, int durata, String c) {
        this.titolo = titolo;
        this.durata = durata;
        this.copertina = c;
    }

    @Override
    public int getDurata() {
        return this.durata;
    }

    @Override
    public String getInfo() { //metodo per avere tutte le info sulla traccia audio
        return "Traccia Audio: " + titolo + ", durata: " + durata + " minuti.";
    }
}
// classe podcast che estende traccia
class Podcast extends Traccia {
    private String titolo;
    private String autore;

    public Podcast(String titolo, int durata, String autore) {
        this.titolo = titolo;
        this.durata = durata;
        this.autore =  autore;
    }

    @Override
    public int getDurata() {
        return this.durata;
    }

    @Override
    public String getInfo() {
        return "Podcast: " + titolo + ", durata: " + durata + " minuti."; //il metodo + mi permette di unire più stringhe  insieme
    }
}
//classe TracciaVideo che estende la classe traccia
class TracciaVideo extends Traccia {
    private String titolo;
    private String dimenisioni;

    public TracciaVideo(String titolo, int durata, String dim) {
        this.titolo = titolo;
        this.durata = durata;
        this.dimenisioni = dim;
    }

    @Override
    public int getDurata() {
        return this.durata;
    }

    @Override
    public String getInfo() {
        return "Traccia Video: " + titolo + ", durata: " + durata + " minuti.";
    }
}

// Classe Playlist per gestire la lista delle tracce
class Playlist {
    private Traccia[] tracce;  // array di tracce
    private int count; // Conta le tracce che sono attualmente nella playlist

    // Costruttore della Playlist
    public Playlist(int maxTracce) {
        tracce = new Traccia[maxTracce]; // impongo un limite massimo di tracce che possono stare nella traccia principale
        count = 0; // faccio partire la playlist vuota
    }

    // Metodo per aggiungere una traccia alla playlist
    public void aggiungiTraccia(Traccia traccia) {
        if (count < tracce.length) {
            tracce[count] = traccia; // aggiunge una nuova traccia nell'array
            count++; // Incrementa il numero delle tracce
            System.out.println("Traccia aggiunta");
        } else {
            System.out.println("Playlist piena non si può aggiungere altre tracce.");
        }
    }

    // Metodo per rimuovere una traccia dalla playlist
    public void rimuoviTraccia(int indice) {
        if (indice >= 0 && indice < count) {
            // metodo per spostare tutte le tracce successive di una posizione a sinistra (funz.array)
            for (int i = indice; i < count - 1; i++) {
                tracce[i] = tracce[i + 1]; // Sposta la traccia successiva al posto della traccia eliminata
            }
            tracce[count - 1] = null; // Imposta l'ultima posizione su null la traccia è "rimossa"
            count--; // decrementa il numero di tracce
            System.out.println("Traccia rimossa");
        } else {
            System.out.println("Indice non valido");
        }
    }

    // Metodo che uso  per calcolare la durata totale della playlist
    public int calcolaDurataTotale() {
        int durataTotale = 0;
        for (int i = 0; i < count; i++) {
            durataTotale += tracce[i].getDurata();  // Somma la durata di ogni traccia (sia audio che video)
        }
        return durataTotale;
    }

    // Metodo per visualizzare tutte le tracce nella playlist
    public void visualizzaPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < count; i++) {
            System.out.println(tracce[i].getInfo()); // Mostra le informazioni di ogni traccia
        }
    }
}

// Classe principale -> ANJAN RIFATTO
public class Main {
    public static void main(String[] arguments) {
        // Crea una playlist con spazio per 3 tracce -> 1 audio, 1 video, 1 podcat
        Playlist playlist = new Playlist(3);

        // Crea alcune tracce (audio, podcast, video)
        TracciaAudio traccia1 = new TracciaAudio("Canzone Tony Effe", 4, "sfondo colorato");//in ogni traccia esprimo una durata in minuti come detto prima
        Podcast traccia2 = new Podcast("Podcast sulle canzoni", 19, "Casanova");
        TracciaVideo traccia3 = new TracciaVideo("Video Pantellas", 15, "1280x1080");

        // Aggiungiamo le tracce alla playlist
        playlist.aggiungiTraccia(traccia1);
        playlist.aggiungiTraccia(traccia2);
        playlist.aggiungiTraccia(traccia3);
        // Visualizzo la playlist
        playlist.visualizzaPlaylist();
        // Calcoliamo e mostriamo la durata totale della playlist
        int durataTotale = playlist.calcolaDurataTotale();
        System.out.println("Durata totale della playlist: " + durataTotale + " minuti");

        // Rimuove la seconda traccia posta sull'indice 1
        playlist.rimuoviTraccia(1);
        // Visualizza la playlist dopo la rimozione di una traccia
        playlist.visualizzaPlaylist();
        // Ricalcolo la durata totale
        durataTotale = playlist.calcolaDurataTotale();
        System.out.println("Durata totale della playlist dopo la rimozione: " + durataTotale + " minuti.");
    }
}
