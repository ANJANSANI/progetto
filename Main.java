import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist(10); // Playlist con massimo 10 tracce
        
        int scelta;
        do {
            System.out.println("Menu Playlist:");
            System.out.println("1. Aggiungi traccia audio");
            System.out.println("2. Aggiungi podcast");
            System.out.println("3. Aggiungi traccia video");
            System.out.println("4. Rimuovi traccia");
            System.out.println("5. Visualizza playlist");
            System.out.println("6. Calcola durata totale");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci titolo traccia audio: ");
                    scanner.nextLine();
                    String titoloAudio = scanner.nextLine();
                    System.out.print("Inserisci durata traccia audio (minuti): ");
                    int durataAudio = scanner.nextInt();
                    playlist.aggiungiTraccia(new TracciaAudio(titoloAudio, durataAudio));
                    break;
                case 2:
                    System.out.print("Inserisci titolo podcast: ");
                    scanner.nextLine();
                    String titoloPodcast = scanner.nextLine();
                    System.out.print("Inserisci durata podcast (minuti): ");
                    int durataPodcast = scanner.nextInt();
                    playlist.aggiungiTraccia(new Podcast(titoloPodcast, durataPodcast));
                    break;
                case 3:
                    System.out.print("Inserisci titolo traccia video: ");
                    scanner.nextLine();
                    String titoloVideo = scanner.nextLine();
                    System.out.print("Inserisci durata traccia video (minuti): ");
                    int durataVideo = scanner.nextInt();
                    playlist.aggiungiTraccia(new TracciaVideo(titoloVideo, durataVideo));
                    break;
                case 4:
                    System.out.print("Inserisci indice della traccia da rimuovere: ");
                    int indice = scanner.nextInt();
                    playlist.rimuoviTraccia(indice);
                    break;
                case 5:
                    playlist.visualizzaPlaylist();
                    break;
                case 6:
                    System.out.println("Durata totale della playlist: " + playlist.calcolaDurataTotale() + " minuti");
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        scanner.close();
    }
}