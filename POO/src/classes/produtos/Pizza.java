package classes.produtos;

import classes.ConsoleHelper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pizza extends MiniPizza{
    private ETamanho tamanho;

    public Pizza() {
        this.setTipo(ETipoProduto.PIZZA);
    }

    public void setTamanho(ETamanho tamanho) {
        this.tamanho = tamanho;
    }

    public ETamanho getTamanho() {
        return this.tamanho;
    }

    @Override
    public void mostrarDetalhesComanda() {
        super.mostrarDetalhesComanda();
        System.out.println("Tamanho: " + this.getTamanho());
    }

    @Override
    public void montarDetalhesProduto(Scanner in) {
        super.montarDetalhesProduto(in);
        while (true) {
            System.out.println("Tamanho da pizza: ");
            for (ETamanho tam : ETamanho.values()) {
                System.out.printf("(%d) %s\n", tam.getOpcao(), tam.getNomeApresentavel());
            }
            try {
                ETamanho tam = ETamanho.getByOpcaoMenu(in.nextInt());
                if (tam == null) {
                    ConsoleHelper.showError("Selecione um tamanho válido");
                    continue;
                }
                this.setTamanho(tam);
                break;
            } catch (InputMismatchException e) {
                ConsoleHelper.showError("Selecione um tamanho válido");
            } finally {
                in.nextLine();
            }
        }
    }
}
