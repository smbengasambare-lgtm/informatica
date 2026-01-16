import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Pubblicazione> archivio = new ArrayList<>();

    // Aggiungere una pubblicazione
    public void aggiungi(Pubblicazione p) {
        archivio.add(p);
        System.out.println("Aggiunta pubblicazione: " + p.getTitolo());
    }

    // Rimuovere tramite numero progressivo
    public void rimuovi(int numeroProgressivo) {
        boolean rimossa = archivio.removeIf(p -> p.getNumeroProgressivo() == numeroProgressivo);

        if (rimossa) {
            System.out.println("Pubblicazione rimossa.");
        } else {
            System.out.println("Nessuna pubblicazione trovata con quel numero.");
        }
    }

    // Cercare una pubblicazione
    public Pubblicazione cerca(int numeroProgressivo) {
        for (Pubblicazione p : archivio) {
            if (p.getNumeroProgressivo() == numeroProgressivo) {
                return p;
            }
        }
        return null;
    }

    // Prestito
    public void presta(int numeroProgressivo) {
        Pubblicazione p = cerca(numeroProgressivo);

        if (p == null) {
            System.out.println("Pubblicazione non trovata.");
            return;
        }

        if (p.isInPrestito()) {
            System.out.println("La pubblicazione è già in prestito.");
        } else {
            p.presta();
            System.out.println("Hai preso in prestito: " + p.getTitolo());
        }
    }

    // Restituzione
    public void restituisci(int numeroProgressivo) {
        Pubblicazione p = cerca(numeroProgressivo);

        if (p == null) {
            System.out.println("Pubblicazione non trovata.");
            return;
        }

        if (!p.isInPrestito()) {
            System.out.println("La pubblicazione non era in prestito.");
        } else {
            p.restituisci();
            System.out.println("Hai restituito: " + p.getTitolo());
        }
    }

    // Stampa catalogo
    public void stampaCatalogo() {
        System.out.println("\n--- Catalogo Biblioteca ---");

        if (archivio.isEmpty()) {
            System.out.println("Nessuna pubblicazione in archivio.");
            return;
        }

        for (Pubblicazione p : archivio) {
            System.out.println(p);
        }
    }
}
