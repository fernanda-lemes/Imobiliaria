package app;

import dao.ClienteDAO;
import dao.ContratoDAO;
import dao.ImovelDAO;
import model.Cliente;
import model.Contrato;
import model.Imovel;
import service.RelatorioService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ImovelDAO imovelDAO = new ImovelDAO();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static ContratoDAO contratoDAO = new ContratoDAO();
    private static RelatorioService relatorioService = new RelatorioService();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarImovel();
                case 2 -> cadastrarCliente();
                case 3 -> cadastrarContrato();
                case 4 -> relatorioService.listarImoveisDisponiveis();
                case 5 -> relatorioService.listarContratosAtivos();
                case 6 -> relatorioService.clientesComMaisContratos();
                case 7 -> relatorioService.contratosExpirandoProximos30Dias();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE IMOBILIÁRIA ===");
        System.out.println("1 - Cadastrar imóvel");
        System.out.println("2 - Cadastrar cliente");
        System.out.println("3 - Cadastrar contrato");
        System.out.println("4 - Listar imóveis disponíveis");
        System.out.println("5 - Listar contratos ativos");
        System.out.println("6 - Clientes com mais contratos");
        System.out.println("7 - Contratos expirando nos próximos 30 dias");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarImovel() {
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Valor do aluguel: ");
        double valor = Double.parseDouble(scanner.nextLine());

        Imovel imovel = new Imovel();
        imovel.setEndereco(endereco);
        imovel.setTipo(tipo);
        imovel.setValorAluguel(valor);
        imovel.setDisponivel(true);

        imovelDAO.inserir(imovel);
        System.out.println("Imóvel cadastrado com sucesso!");
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);

        clienteDAO.inserir(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarContrato() {
        System.out.print("ID do cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        System.out.print("ID do imóvel: ");
        int idImovel = Integer.parseInt(scanner.nextLine());
        System.out.print("Data início (yyyy-mm-dd): ");
        LocalDate inicio = LocalDate.parse(scanner.nextLine());
        System.out.print("Data fim (yyyy-mm-dd): ");
        LocalDate fim = LocalDate.parse(scanner.nextLine());
        System.out.print("Valor do aluguel: ");
        double valor = Double.parseDouble(scanner.nextLine());

        Contrato contrato = new Contrato();
        contrato.setIdCliente(idCliente);
        contrato.setIdImovel(idImovel);
        contrato.setDataInicio(inicio);
        contrato.setDataFim(fim);
        contrato.setValor(valor);

        contratoDAO.inserir(contrato);

        Imovel imovel = imovelDAO.buscarPorId(idImovel);
        if (imovel != null) {
            imovel.setDisponivel(false);
            imovelDAO.atualizar(imovel);
        }

        System.out.println("Contrato cadastrado com sucesso!");
    }
}