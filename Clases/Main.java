package Clases;

import java.awt.EventQueue;

import Graficos.panelPrincipal;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelPrincipal frame = new panelPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
