package pcmania;
import pcmania.model.Computador;
import pcmania.model.HardwareBasico;
import pcmania.model.MemoriaUSB;
import pcmania.model.SistemaOperacional;
import pcmania.model.Cliente;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        int matricula = 670;
        Scanner scanner = new Scanner(System.in);

        Computador p1 = new Computador("Apple", matricula);
        p1.addHardware(new HardwareBasico("Processador Core i5", 2200));
        p1.addHardware(new HardwareBasico("Memória RAM", 8));
        p1.addHardware(new HardwareBasico("HD", 500));
        p1.setSistemaOperacional(new SistemaOperacional("macOS Sequoia", 64));
        p1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        Computador p2 = new Computador("Samsung", matricula + 1);
        p2.addHardware(new HardwareBasico("Processador Core i7", 3370));
        p2.addHardware(new HardwareBasico("Memória RAM", 16));
        p2.addHardware(new HardwareBasico("HD", 1000)); // 1Tb = 1000Gb
        p2.setSistemaOperacional(new SistemaOperacional("Windows 8", 64));
        p2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        Computador p3 = new Computador("Dell", matricula + 2);
        p3.addHardware(new HardwareBasico("Processador Core i7", 4500));
        p3.addHardware(new HardwareBasico("Memória RAM", 32));
        p3.addHardware(new HardwareBasico("HD", 2000)); // 2Tb = 2000Gb
        p3.setSistemaOperacional(new SistemaOperacional("Windows 10", 64));
        p3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));

        Computador[] promocoes = {p1, p2, p3};

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        int codigo;
        do {
            System.out.println("\n           PC Mania - Promoções           ");

            for (int i = 0; i < promocoes.length; i++) {
                System.out.println("\nPromoção " + (i + 1) + ":");
                promocoes[i].mostraPCConfigs();
            }

            System.out.println("\n0 - Finalizar compra");
            System.out.print("\nAdicione promoção ao carrinho (1 a 3) ou 0 para finaliza a compra: \n");
            codigo = scanner.nextInt();

            if (codigo >= 1 && codigo <= promocoes.length) {
                cliente.addComputador(promocoes[codigo - 1]);
                System.out.println("\nPC adicionado à sua compra!");
            } else if (codigo != 0) {
                System.out.println("\nCódigo inválido!");
            }

        } while (codigo != 0);

        System.out.println("\n      Resumo da Compra      ");
        System.out.println("pcmania.model.Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        for (Computador c : cliente.getComputadoresComprados()) {
            System.out.println("\n--- pcmania.model.Computador ---");
            c.mostraPCConfigs();
        }

        System.out.printf("%nTotal da compra: R$ %.2f%n", cliente.calculaTotalCompra());

    }
    }


