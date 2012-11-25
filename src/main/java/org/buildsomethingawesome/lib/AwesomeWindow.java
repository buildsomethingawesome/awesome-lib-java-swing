package org.buildsomethingawesome.lib;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class AwesomeWindow extends JFrame {

    public AwesomeWindow() {
        super();
    }

    public AwesomeWindow(String windowTitle) {
        super(windowTitle);
    }

    public void startGame(JComponent game) {
        this.add(game);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        if (game instanceof ActionListener) {
            Timer t = new Timer(30, (ActionListener) game);
            t.start();
        }

        if (game instanceof MouseListener) {
            game.addMouseListener((MouseListener) game);
        }

        if (game instanceof MouseMotionListener) {
            game.addMouseMotionListener((MouseMotionListener) game);
        }

        if (game instanceof KeyListener) {
            this.addKeyListener((KeyListener) game);
        }
    }
}
