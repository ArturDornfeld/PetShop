package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    // Escreve uma linha no final do arquivo
    public static void escrever(String caminho, String linha) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + caminho);
            e.printStackTrace();
        }
    }

    // Lê todas as linhas do arquivo
    public static List<String> ler(String caminho) {
        List<String> linhas = new ArrayList<>();
        File file = new File(caminho);

        if (!file.exists()) return linhas;

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + caminho);
            e.printStackTrace();
        }

        return linhas;
    }

    // Sobrescreve o conteúdo do arquivo
    public static void sobrescrever(String caminho, List<String> linhas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao sobrescrever o arquivo: " + caminho);
            e.printStackTrace();
        }
    }

    // ➕ NOVO: método usado pelo ClienteController
    public static List<String> lerLinhas(String caminho) {
        return ler(caminho);
    }

    // ➕ NOVO: método para sobrescrever usando lista de strings
    public static void escreverLinhas(String caminho, List<String> linhas) {
        sobrescrever(caminho, linhas);
    }
}
