package temperatura;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import divisas.Principal;

public class Temperatura extends JFrame implements ActionListener, KeyListener {

	private JLabel cantidad, grados, convertir, resultado, logo;
	private JTextField textCantidad, textResultado;
	private JButton calcular, reset, regresar;
	private JComboBox<Object> comboConvertir, comboGrados;
	private double operacion;

	public Temperatura() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversor Alura");
		
		ImageIcon imagen = new ImageIcon("Images/termometro.png");
	    logo = new JLabel(imagen);
	    logo.setBounds(225,80,120,110);
	    Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
	    logo.setIcon(icono);
	    add(logo);

		cantidad = new JLabel("Ingrese la cantidad");
		cantidad.setBounds(15, 10, 150, 30);
		add(cantidad);

		textCantidad = new JTextField();
		textCantidad.setBounds(15, 40, 150, 30);
		add(textCantidad);
		textCantidad.addKeyListener(this);

		grados = new JLabel("Tipo de grados");
		grados.setBounds(185, 10, 150, 30);
		add(grados);

		comboGrados = new JComboBox<>();
		comboGrados.setBounds(185, 40, 150, 30);
		comboGrados.setBackground(new java.awt.Color(224, 224, 224));
		add(comboGrados);
		comboGrados.addItem("");
		comboGrados.addItem("Celsius");
		comboGrados.addItem("Fahrenheit");
		comboGrados.addItem("Kelvin");

		convertir = new JLabel("¿A que grados desea convertir?");
		convertir.setBounds(15, 70, 200, 30);
		add(convertir);

		comboConvertir = new JComboBox<>();
		comboConvertir.setBounds(15, 100, 200, 30);
		comboConvertir.setBackground(new java.awt.Color(224, 224, 224));
		add(comboConvertir);
		comboConvertir.addItem("");
		comboConvertir.addItem("Celsius");
		comboConvertir.addItem("Fahrenheit");
		comboConvertir.addItem("Kelvin");

		resultado = new JLabel("El resultado de tu conversion es:");
		resultado.setBounds(15, 130, 200, 30);
		add(resultado);

		textResultado = new JTextField();
		textResultado.setBounds(15, 160, 200, 30);
		textResultado.setBackground(new java.awt.Color(255, 255, 255));
		textResultado.setEditable(false);
		add(textResultado);

		calcular = new JButton("Calcular");
		calcular.setBounds(15, 200, 100, 30);
		add(calcular);
		calcular.addActionListener(this);

		reset = new JButton("Resetear");
		reset.setBounds(125, 200, 100, 30);
		add(reset);
		reset.addActionListener(this);

		regresar = new JButton("Regresar");
		regresar.setBounds(235, 200, 100, 30);
		add(regresar);
		regresar.addActionListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Metodo1 con solo numeros enteros.
		/*float key = e.getKeyChar();
		boolean numero = key >= 48 && key <= 57;

		if (!numero) {
			e.consume();
		}*/
		//Metodo2 acepta numeros decimales
		char valor = e.getKeyChar();
		if((valor < '0' || valor > '9') && (valor < '.' || valor > '.')) {
			e.consume();
		}
		
		if (textCantidad.getText().trim().length() == 8) {
			e.consume();
			Toolkit.getDefaultToolkit().beep();
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
				
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == calcular) {
			String grado = comboGrados.getSelectedItem().toString();
			String convertidor = comboConvertir.getSelectedItem().toString();
			String valor = textCantidad.getText();
			
			if (valor.equals("") || grado.equals("") || convertidor.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe de llener todos los campos");
			}
			
			float cantidad = Float.parseFloat(textCantidad.getText());
			
			if (grado.equals("Fahrenheit")) {
				if(convertidor.equals("Celsius")) {
					operacion = (5 * (cantidad - 32) / 9);
					textResultado.setText((double)Math.round(operacion*100d)/100 + "° Celsius");
				}
				if(convertidor.equals("Kelvin")) {
					operacion = ((cantidad - 32) / 1.8 + 273.15);
					textResultado.setText((double)Math.round(operacion*100d)/100 + "° Kelvin");
				}
				if(convertidor.equals("Fahrenheit")) {
					operacion = (cantidad * 1);
					textResultado.setText((double)Math.round(operacion*100d)/100 + "° Fahrenheit");
				}

			} if (grado.equals("Celsius")) {
				if(convertidor.equals("Fahrenheit")) {
					operacion = (((9 * cantidad) / 5) + 32);
					textResultado.setText((double)Math.round(operacion*100d)/100 + "° Fahrenheit");
				}
				if(convertidor.equals("Kelvin")) {
					operacion = (cantidad - 273.15);
					textResultado.setText((double)Math.round(operacion*100d)/100 + "° Kelvin");
				}
				if(convertidor.equals("Celsius")) {
					operacion = (cantidad * 1);
					textResultado.setText((double)Math.round(operacion*100d)/100 + "° Celsius");
				}
				
			} if (grado.equals("Kelvin")) {
				if(convertidor.equals("Celsius")) {
					operacion = (273.15 + cantidad);
					textResultado.setText((double)Math.round(operacion*100d)/100 + "° Celsius");
				}
				if (convertidor.equals("Fahrenheit")) {
					operacion = ((9 * (cantidad - 273.15) / 5) + 32);
					textResultado.setText((double)Math.round(operacion*100d)/100 + "° Fahrenheit");
				}
				if(convertidor.equals("Kelvin")) {
					operacion = (cantidad * 1);
					textResultado.setText((double)Math.round(operacion*100d)/100 + "° Kelvin");
				}
			}		
		}
		if (e.getSource() == reset) {
			textCantidad.setText("");
			textResultado.setText("");
			comboGrados.setSelectedIndex(0);
			comboConvertir.setSelectedIndex(0);

		}
		if (e.getSource() == regresar) {
			
			Principal interfaz = new Principal();
			interfaz.setBounds(0, 0, 350, 150);
			interfaz.setVisible(true);
			interfaz.setResizable(false);
			interfaz.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		Temperatura interfaz = new Temperatura();
		interfaz.setBounds(0, 0, 350, 270);
		interfaz.setVisible(true);
		interfaz.setResizable(false);
		interfaz.setLocationRelativeTo(null);
	}
}
