package Clases;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Graficos.VentanaPrincipal;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					VentanaPrincipal frame = new VentanaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "No se ha encontrado una conexión con la base de datos");
				}
			}
		});
	}
}
