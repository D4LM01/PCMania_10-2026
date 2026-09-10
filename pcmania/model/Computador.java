package pcmania.model;

public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hardwares;
    private MemoriaUSB memoriaUSB;
    private SistemaOperacional so;

    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;
        this.hardwares = new HardwareBasico[0];
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);

        for (HardwareBasico h : hardwares) {
            System.out.println(h.getNome() + ": " + h.getCapacidade());
        }

        if (this.so != null) {
            System.out.println("Sistema Operacional: " + this.so.getNome()
                    + " (" + this.so.getTipo() + " bits)");
        }

        if (memoriaUSB != null) {
            System.out.println(memoriaUSB.getNome() + ": " + memoriaUSB.getCapacidade() + "Gb");
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public float getPreco() {
        return preco;
    }

    public void addHardware(HardwareBasico hb) {
        HardwareBasico[] novoArray = new HardwareBasico[hardwares.length + 1];
        for (int i = 0; i < hardwares.length; i++) {
            novoArray[i] = hardwares[i];
        }
        novoArray[hardwares.length] = hb;
        this.hardwares = novoArray;
    }

    public void setSistemaOperacional(SistemaOperacional so) {
        this.so = so;
    }
}
