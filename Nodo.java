/*
AUTORE: NICOLO' MEZZANZANICA & GIORGIO JUSTIN FASULLO
DATA: 21/03/2023
OGGETTO: CLASSE NODO PER L'ALGORITMO DI DIJKSTRA
*/

import java.util.TreeMap;

public class Nodo {
    private String label;					// etichetta del nodo
    private int weight = Integer.MAX_VALUE;	// peso del nodo, viene aggiornato durante l'algoritmo
    private TreeMap<Nodo, Integer> links;		// mappa contenente i nodi raggiungibili dal nodo corrente 
    private Nodo prev = null;				// nodo precedente 
    
    // metodo costruttore della classe Nodo
    public Nodo(String label) {
        this.label = label;
        links = new TreeMap<>((a, b) -> a.label.compareTo(b.label));
    }

    // metodo per collegare il nodo corrente con un altro ottenendo un arco il cui peso e' specificato
    public void link(Nodo nodo2, Integer weight) {
        links.put(nodo2, weight);
        nodo2.links.put(this, weight);
    }
    
    // metodo per calcolare il peso a partire dal nodo corrente al nodo specificato
    public int weightTo(Nodo n) {
        return weight + links.get(n);
    }
    
    // metodo che restituisce una stringa la quale rappresenta il cammino minimo dal nodo iniziale a questo nodo
    public String getPath() {
        String weight = "";
        if (this.weight < Integer.MAX_VALUE) {
            weight += this.weight;
        } else {
            weight = "inf";
        }
	
        String path = "(" + label + "-" + weight + ")";
        if (prev != null) {
            path = prev.getPath() + "-" + prev.links.get(this) + "->" + path;
        }

        return path;
    } 
    
    /* --- Setter --- */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPrev(Nodo prev) {
        this.prev = prev;
    }

    /* --- Getter --- */
    public int getWeight() {
        return weight;
    }

    public TreeMap<Nodo, Integer> getLinks() {
        return links;
    }
}