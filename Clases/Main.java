package Clases;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.print.DocFlavor.URL;
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
				}
			}
		});
	}
}
