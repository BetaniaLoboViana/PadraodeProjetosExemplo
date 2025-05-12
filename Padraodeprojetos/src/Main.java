// Importa a classe Scanner para capturar entradas do usuário
import java.util.Scanner;


// Interface Estado define o método ou acao() que será implementado pelos estados concretos
interface Estado {
    void acao();
}


// EstadoLigado: Implementa o estado 'Ligado'
class EstadoLigado implements Estado {
    @Override
    public void acao() {
        System.out.println("A Máquina está Ligada!");
    }
}


// EstadoDesligado: Implementa o estado 'Desligado'
class EstadoDesligado implements Estado {
    @Override
    public void acao() {
        System.out.println("A Máquina está Desligada...");
    }
}


// Classe Pessoa que possui um estado atual
class Maquina {
    private Estado estadoAtual;


    // Define o estado atual da máquina
    public void definirEstado(Estado novoEstado) {
        this.estadoAtual = novoEstado;
    }


    // Executa a ação do estado atual
    public void expressar() {
        if (estadoAtual != null) {
            estadoAtual.acao();
        } else {
            System.out.println("A máquina está em standby.");
        }
    }
}


// Classe principal que executa o programa
public class Main {
    public static void main(String[] args) {
        // Cria o objeto Scanner para leitura do usuário
        Scanner entrada = new Scanner(System.in);
        Maquina maquina = new Maquina();
        String opcao;


        // Estado inicial da máquina
        System.out.println("Estado inicial:");
        maquina.expressar();


        // Loop para escolha do estado
        while (true) {
            System.out.println("\nEscolha um estado para a máquina:");
            System.out.println("1 - Ligado");
            System.out.println("2 - Desligado");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = entrada.nextLine();


            // Verifica a opção escolhida e define o estado
            switch (opcao) {
                case "1":
                    maquina.definirEstado(new EstadoLigado());
                    break;
                case "2":
                    maquina.definirEstado(new EstadoDesligado());
                    break;
                case "0":
                    System.out.println("Encerrando...");
                    entrada.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }


            // Mostra o estado atual da máquina
            System.out.println("Estado atual:");
           maquina.expressar();
        }
    }
}
