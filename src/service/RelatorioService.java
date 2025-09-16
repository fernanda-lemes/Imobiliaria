package service;

import dao.ClienteDAO;
import dao.ContratoDAO;
import dao.ImovelDAO;
import model.Cliente;
import model.Contrato;
import model.Imovel;

import java.util.*;
import java.util.stream.Collectors;

public class RelatorioService {
    private ImovelDAO imovelDAO = new ImovelDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ContratoDAO contratoDAO = new ContratoDAO();

    // Lista os imóveis disponíveis
    public void listarImoveisDisponiveis() {
        List<Imovel> lista = imovelDAO.listarDisponiveis();
        System.out.println("=== Imóveis Disponíveis ===");
        lista.forEach(System.out::println);
    }

    // Lista os contratos ativos
    public void listarContratosAtivos() {
        List<Contrato> lista = contratoDAO.listarAtivos();
        System.out.println("=== Contratos Ativos ===");
        lista.forEach(System.out::println);
    }

    // Clientes com mais contratos no total
    public void clientesComMaisContratos() {
        List<Contrato> contratos = contratoDAO.listarTodos();
        Map<Integer, Long> contagem = contratos.stream()
                .collect(Collectors.groupingBy(Contrato::getIdCliente, Collectors.counting()));

        Optional<Map.Entry<Integer, Long>> max = contagem.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (max.isPresent()) {
            Cliente cliente = clienteDAO.buscarPorId(max.get().getKey());
            System.out.println("Cliente com mais contratos: " + cliente.getNome() + " (" + max.get().getValue() + " contratos)");
        } else {
            System.out.println("Nenhum contrato encontrado.");
        }
    }

    // Contratos expirando nos próximos 30 dias
    public void contratosExpirandoProximos30Dias() {
        List<Contrato> lista = contratoDAO.contratosExpirandoProximos30Dias();
        System.out.println("=== Contratos expirando nos próximos 30 dias ===");
        lista.forEach(System.out::println);
    }
}