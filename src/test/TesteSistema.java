package test;

import model.*;

import java.time.LocalDateTime;

public class TesteSistema {
    public static void main(String[] args) {
        // 1. Criar cliente
        Cliente cliente = new Cliente("Artur Dornfeld", "123.456.789-00", "artur@email.com", "11999999999");
        System.out.println(cliente);

        // 2. Criar pet
        Pet pet = new Pet("Lulu", "Cachorro", "Poodle", cliente);
        System.out.println(pet);

        // 3. Criar serviço
        Servico servico = new Servico("Banho", "Banho completo com shampoo especial", 49.90);
        System.out.println(servico);

        // 4. Criar agendamento
        LocalDateTime dataHora = LocalDateTime.of(2025, 7, 5, 10, 30);
        Agendamento agendamento = new Agendamento(pet, servico, dataHora);
        System.out.println(agendamento);

        // 5. Criar pagamento
        Pagamento pagamento = new Pagamento(servico.getPreco(), "Pix", true);
        System.out.println(pagamento);
    }
}
