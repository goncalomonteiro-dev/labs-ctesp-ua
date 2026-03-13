// Classe que representa um nadador
// Implementa Comparable para permitir ordenar nadadores
public class nadador implements Comparable<nadador> {

    private String nome;
    private int tempo;

    // Construtor
    public nadador(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getTempo() {
        return tempo;
    }

    // Método que define como os nadadores são ordenados
    @Override
    public int compareTo(nadador outro) {

        // Primeiro critério: tempo (menor é melhor)
        if (this.tempo != outro.tempo) {
            return this.tempo - outro.tempo;
        }

        // Segundo critério: nome (ordem alfabética)
        return this.nome.compareToIgnoreCase(outro.nome);
    }
}
