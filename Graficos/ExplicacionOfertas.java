package Graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;

public class ExplicacionOfertas extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;

	public ExplicacionOfertas() {
		setVisible(true);
		setAlwaysOnTop(true);
		setBackground(Color.WHITE);		
		setBounds(800, 350, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTextPane jtext = new JTextPane();
			jtext.setEditable(false);
			jtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jtext.setText("-Usted puede elegir una categor\u00EDa o un aritulo espec\u00EDfico para asignar su oferta, pero la oferta se asigna siempre al art\u00EDculo. Es decir si elije la categor\u00EDa \"prueba\" la oferta se le asignara a los articulos que contengan la categor\u00EDa prueba. Pero si a\u00F1ade nuevos art\u00EDculos deber\u00E1 volver a reasignar dicha oferta a la categor\u00EDa para aplicarsela a \u00E9stos.\r\n-Debe tener en cuenta que puede elegir una categor\u00EDa y despues un art\u00EDculo espec\u00EDfico de esa categor\u00EDa para asignarle una oferta distinta. La oferta nueva siempre sobrescribe a la antigua.\r\n");
			contentPanel.add(jtext, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("Cerrar");
				btnOk.addActionListener(this);
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
		}
	}

	protected JButton getBtnOk() {
		return btnOk;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		if(evento.equals(btnOk)) {
			dispose();
		}
	}
}
