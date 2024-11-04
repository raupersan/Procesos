package asd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Ventanal {

	private JFrame frame;
	private JTextField txtNumero;
	private JTextField txtNumero_1;
	private JTextField txtOperacion;
	private JTextField textField;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanal window = new Ventanal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventanal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Calculadora");
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado:");
		frame.getContentPane().add(lblNewLabel_1);
		
		txtNumero = new JTextField();
		txtNumero.setText("numero1");
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtNumero_1 = new JTextField();
		txtNumero_1.setText("numero2");
		frame.getContentPane().add(txtNumero_1);
		txtNumero_1.setColumns(10);
		
		txtOperacion = new JTextField();
		txtOperacion.setText("operacion");
		frame.getContentPane().add(txtOperacion);
		txtOperacion.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char operacion;
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
	}
}
