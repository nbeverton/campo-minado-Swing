package br.com.nbeverton.cm.Visao;

import br.com.nbeverton.cm.Modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class PainelTabuleiro extends JPanel {

    public PainelTabuleiro(Tabuleiro tabuleiro) {

        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));

        tabuleiro.registrarObservador(e -> {

            SwingUtilities.invokeLater(() -> {
                if (e.isGanhou()) {
                    JOptionPane.showMessageDialog(this, "Ganhou ;)");
                } else {
                    JOptionPane.showMessageDialog(this, "Perdeu! Que tistreza! :(");
                }

                tabuleiro.reiniciar();
            });
        });
    }

}
