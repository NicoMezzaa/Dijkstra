/*
AUTORE: NICOLO' MEZZANZANICA & GIORGIO JUSTIN FASULLO
DATA: 21/03/2023
OGGETTO: CLASSE MAIN PER TESTARE L'ALGORITMO DI DIJKSTRA.
*/

public class Main {
    public static void main(String[] args) {
	
	// creazione dei nodi
        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");
        Nodo nodoD = new Nodo("D");
        Nodo nodoE = new Nodo("E");
	
	// aggiunta archi tra i nodi specificando il peso 
        nodoA.link(nodoB, 6);
        nodoA.link(nodoD, 8);
        nodoB.link(nodoC, 5);
        nodoB.link(nodoD, 3);
        nodoB.link(nodoE, 2);
        nodoC.link(nodoE, 5);
        nodoD.link(nodoE, 1);
	
        Graph.dijkstra(nodoA);
	
	// visualizzazione dei percorsi piu' brevi partendo da A per arrivare a tutti gli altri nodi
        System.out.println("Percorso piu corto partendo da A per arrivare a B:");
        System.out.println(nodoB.getPath());
	System.out.println("Percorso piu corto partendo da A per arrivare a C:");
        System.out.println(nodoC.getPath());
	System.out.println("Percorso piu corto partendo da A per arrivare a D:");
        System.out.println(nodoD.getPath());
	System.out.println("Percorso piu corto partendo da A per arrivare a E:");
        System.out.println(nodoE.getPath());
    }
}
