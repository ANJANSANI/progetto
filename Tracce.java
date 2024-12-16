// Classe astratta Traccia
abstract class Traccia {
    protected int durata; // Durata in minuti
    public abstract int getDurata();
    public abstract String getInfo();
}

// Classe TracciaAudio che estende Traccia
class TracciaAudio extends Traccia {
    private String titolo;

    public TracciaAudio(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    @Override
    public int getDurata() {
        return this.durata;
    }

    @Override
    public String getInfo() {
        return "Traccia Audio: " + titolo + ", durata: " + durata + " minuti.";
    }
}

// Classe Podcast che estende Traccia
class Podcast extends Traccia {
    private String titolo;

    public Podcast(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    @Override
    public int getDurata() {
        return this.durata;
    }

    @Override
    public String getInfo() {
        return "Podcast: " + titolo + ", durata: " + durata + " minuti.";
    }
}

// Classe TracciaVideo che estende Traccia
class TracciaVideo extends Traccia {
    private String titolo;

    public TracciaVideo(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
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
        tracce = new Traccia[maxTracce]; // impongo un limite massimo di tracce
        count = 0; // faccio partire la playlist vuota
    }

    // Metodo per aggiungere una traccia alla playlist
    public void aggiungiTraccia(Traccia traccia) {
        if (count < tracce.length) {
            tracce[count] = traccia; // aggiunge una nuova traccia nell'array
            count++; // Incrementa il numero delle tracce
            System.out.println("Traccia aggiunta");
        } else {
            System.out.println("Playlist piena, non si possono aggiungere altre tracce.");
        }
    }

    // Metodo per rimuovere una traccia dalla playlist
    public void rimuoviTraccia(int indice) {
        if (indice >= 0 && indice < count) {
            for (int i = indice; i < count - 1; i++) {
                tracce[i] = tracce[i + 1]; // Sposta la traccia successiva al posto della traccia eliminata
            }
            tracce[count - 1] = null; // Imposta l'ultima posizione su null
            count--; // decrementa il numero di tracce
            System.out.println("Traccia rimossa");
        } else {
            System.out.println("Indice non valido");
        }
    }

    // Metodo per calcolare la durata totale della playlist
    public int calcolaDurataTotale() {
        int durataTotale = 0;
        for (int i = 0; i < count; i++) {
            durataTotale += tracce[i].getDurata();
        }
        return durataTotale;
    }

    // Metodo per visualizzare tutte le tracce nella playlist
    public void visualizzaPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < count; i++) {
            System.out.println(tracce[i].getInfo());
        }
    }
}