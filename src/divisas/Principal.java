package divisas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import temperatura.Temperatura;

public class Principal extends JFrame implements ActionListener{
	
	private JLabel mensaje;
	private JComboBox<Object> opciones;
	private JButton ingresar, salir;
	
	public Principal() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversor Alura");
		
		mensaje = new JLabel ("¿Que desea convertir? Seleccione una opcion.");
		mensaje.setBounds(15,10,300,30);
		add(mensaje);
		
		opciones = new JComboBox<>();
		opciones.setBounds(15,40,300,30);
		add(opciones);
		opciones.addItem("Moneda");
		opciones.addItem("Temperatura");
		
		ingresar = new JButton("Ingresar");
		ingresar.setBounds(15,80,100,30);
		add(ingresar);
		ingresar.addActionListener(this);
		
		salir = new JButton("Salir");
		salir.setBounds(125, 80, 100, 30);
		add(salir);
		salir.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ingresar) {
			String op = opciones.getSelectedItem().toString();
			if(op.equals("Moneda")) {
				Monedas interfaz = new Monedas();
				interfaz.setBounds(0, 0, 350, 270);
				interfaz.setVisible(true);
				interfaz.setResizable(false);
				interfaz.setLocationRelativeTo(null);
				this.setVisible(false);
			}
			if(op.equals("Temperatura")) {
				Temperatura interfaz = new Temperatura();
				interfaz.setBounds(0, 0, 350, 270);
				interfaz.setVisible(true);
				interfaz.setResizable(false);
				interfaz.setLocationRelativeTo(null);
				this.setVisible(false);
			}
			
		}
		if(e.getSource() == salir) {
			int i = JOptionPane.showConfirmDialog(this, "¿Desea salir del conversor?");
			if(i == 0) {
				System.exit(0);
			} else if (i == 1) {
				JOptionPane.showMessageDialog(this, "Gracias. Continuemos con el programa");
			}
		}
	}
	
	public static void main(String[] args) {
		Principal interfaz = new Principal();
		interfaz.setBounds(0,0,350,150);
		interfaz.setVisible(true);
		interfaz.setResizable(false);
		interfaz.setLocationRelativeTo(null);
		
	}
}
