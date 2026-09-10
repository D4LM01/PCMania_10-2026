package pcmania.model;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;


    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[0];
    }

    public void addComputador(Computador c) {
        Computador[] novoArray = new Computador[computadores.length + 1];
        for (int i = 0; i < computadores.length; i++) {
            novoArray[i] = computadores[i];
        }
        novoArray[computadores.length] = c;
        this.computadores = novoArray;
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (Computador c : computadores) {
            if (c != null) {
                total += c.getPreco();
            }
        }
        return total;
    }

    public Computador[] getComputadoresComprados() {
        return computadores;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
