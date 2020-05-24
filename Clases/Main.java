package Clases;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
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
					BufferedImage bImage = null;
					try {
						File initialImage = new File("C:\\Users\\Jorge\\eclipse-workspace\\PROYECTO 3EVALUACION\\src\\Imagenes\\btnFinalizar.png");
			             bImage = ImageIO.read(initialImage);
			             ImageIO.write(bImage, "jpg", new File("C:\\Users\\Jorge\\eclipse-workspace\\PROYECTO 3EVALUACION\\src\\lauritacallateya.jpg"));
					} catch (IOException e) {
						   System.out.println("Error de escritura");
						   e.printStackTrace();
					}
					
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					VentanaPrincipal frame = new VentanaPrincipal();
				} catch (Exception e) {
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "No se ha encontrado una conexión con la base de datos");
				}
			}
		});
	}
}
