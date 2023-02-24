package divisas;

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

public class Monedas extends JFrame implements ActionListener, KeyListener {
	private JLabel cantidad, moneda, convertir, resultado, logo;
	private JTextField textCantidad, textResultado;
	private JButton calcular, reset, regresar;
	private JComboBox<Object> comboConvertir, comboMoneda;
	private double operacion;

	public Monedas() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversor Alura");

		ImageIcon imagen = new ImageIcon("Images/moneda.png");
		logo = new JLabel(imagen);
		logo.setBounds(235, 80, 100, 115);
		Icon icono = new ImageIcon(
				imagen.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
		logo.setIcon(icono);
		add(logo);

		cantidad = new JLabel("Ingrese la cantidad");
		cantidad.setBounds(15, 10, 150, 30);
		add(cantidad);

		textCantidad = new JTextField();
		textCantidad.setBounds(15, 40, 150, 30);
		add(textCantidad);
		textCantidad.addKeyListener(this);

		moneda = new JLabel("Tipo de moneda");
		moneda.setBounds(175, 10, 150, 30);
		add(moneda);

		comboMoneda = new JComboBox<>();
		comboMoneda.setBounds(175, 40, 160, 30);
		comboMoneda.setBackground(new java.awt.Color(224, 224, 224));
		add(comboMoneda);
		comboMoneda.addItem("");
		comboMoneda.addItem("Pesos MXN");
		comboMoneda.addItem("Dolar USD");
		comboMoneda.addItem("Euros EUR");
		comboMoneda.addItem("Libras Esterlinas GBP");
		comboMoneda.addItem("Yen Japones CNY");
		comboMoneda.addItem("Won SurCoreano KRW");

		convertir = new JLabel("Moneda a convertir");
		convertir.setBounds(15, 70, 200, 30);
		add(convertir);

		comboConvertir = new JComboBox<>();
		comboConvertir.setBounds(15, 100, 200, 30);
		comboConvertir.setBackground(new java.awt.Color(224, 224, 224));
		add(comboConvertir);
		comboConvertir.addItem("");
		comboConvertir.addItem("Pesos MXN");
		comboConvertir.addItem("Dolar USD");
		comboConvertir.addItem("Euros EUR");
		comboConvertir.addItem("Libras Esterlinas GBP");
		comboConvertir.addItem("Yen Japones CNY");
		comboConvertir.addItem("Won SurCoreano KRW");

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
			String moneda = comboMoneda.getSelectedItem().toString();
			String convertidor = comboConvertir.getSelectedItem().toString();
			String valor = textCantidad.getText();

			if (valor.equals("") || moneda.equals("") || convertidor.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe de llener todos los campos");
			}

			float cantidad = Float.parseFloat(textCantidad.getText());

			if (moneda.equals("Libras Esterlinas GBP")) {
				if (convertidor.equals("Pesos MXN")) {
					operacion = 22.14 * cantidad;
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " MXN.");
				}
				if (convertidor.equals("Dolar USD")) {
					operacion = 1.21 * cantidad;
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " USD.");
				}
				if (convertidor.equals("Euros EUR")) {
					operacion = 1.14 * cantidad;
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " EUR.");
				}
				if (convertidor.equals("Yen Japones CNY")) {
					operacion = 162.52 * cantidad;
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " CNY.");
				}
				if (convertidor.equals("Won SurCoreano KRW")) {
					operacion = 1567.98 * cantidad;
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " KRW.");
				}
				if (convertidor.equals("Libras Esterlinas GBP")) {
					operacion = 1 * cantidad;
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " GBP.");
				}
			}
			if (moneda.equals("Pesos MXN")) {
				if (convertidor.equals("Dolar USD")) {
					operacion = (cantidad / 18.36);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " USD.");
				}
				if (convertidor.equals("Euros EUR")) {
					operacion = (cantidad / 19.50);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " EUR.");
				}
				if (convertidor.equals("Libras Esterlinas GBP")) {
					operacion = (cantidad / 22.14);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " GBP.");
				}
				if (convertidor.equals("Yen Japones CNY")) {
					operacion = (cantidad * 7.34);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " CNY.");
				}
				if (convertidor.equals("Won SurCoreano KRW")) {
					operacion = (cantidad * 70.57);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " KRW.");
				}
				if (convertidor.equals("Pesos MXN")) {
					operacion = (cantidad * 1);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " MXN.");
				}
			}
			if (moneda.equals("Dolar USD")) {
				if (convertidor.equals("Pesos MXN")) {
					operacion = (cantidad * 18.36);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " MXN.");
				}
				if (convertidor.equals("Euros EUR")) {
					operacion = (cantidad / 1.06);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " EUR.");
				}
				if (convertidor.equals("Libras Esterlinas GBP")) {
					operacion = (cantidad / 1.21);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " GBP.");
				}
				if (convertidor.equals("Yen Japones CNY")) {
					operacion = (cantidad * 134.78);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " CNY.");
				}
				if (convertidor.equals("Won SurCoreano KRW")) {
					operacion = (cantidad * 1295.87);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " KRW.");
				}
				if (convertidor.equals("Dolar USD")) {
					operacion = (cantidad * 1);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " USD.");
				}

			}
			if (moneda.equals("Euros EUR")) {
				if (convertidor.equals("Pesos MXN")) {
					operacion = (cantidad * 19.49);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " MXN.");
				}
				if (convertidor.equals("Dolar USD")) {
					operacion = (cantidad * 1.06);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " USD.");
				}
				if (convertidor.equals("Libras Esterlinas GBP")) {
					operacion = (cantidad / 1.14);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " GBP.");
				}
				if (convertidor.equals("Yen Japones CNY")) {
					operacion = (cantidad * 143.12);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " CNY.");
				}
				if (convertidor.equals("Won SurCoreano KRW")) {
					operacion = (cantidad * 1380.70);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " KRW.");
				}
				if (convertidor.equals("Euros EUR")) {
					operacion = (cantidad * 1);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " EUR.");
				}
			}
			if (moneda.equals("Yen Japones CNY")) {
				if (convertidor.equals("Pesos MXN")) {
					operacion = (cantidad / 7.34);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " MXN.");
				}
				if (convertidor.equals("Dolar USD")) {
					operacion = (cantidad / 134.78);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " USD.");
				}
				if (convertidor.equals("Euros EUR")) {
					operacion = (cantidad / 143.12);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " EUR.");
				}
				if (convertidor.equals("Libras Esterlinas GBP")) {
					operacion = (cantidad / 162.52);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " GBP.");
				}
				if (convertidor.equals("Won SurCoreano KRW")) {
					operacion = (cantidad * 9.61);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " KRW.");
				}
				if (convertidor.equals("Yen Japones CNY")) {
					operacion = (cantidad * 1);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " CNY.");
				}
			}
			if (moneda.equals("Won SurCoreano KRW")) {
				if (convertidor.equals("Pesos MXN")) {
					operacion = (cantidad / 70.57);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " MXN.");
				}
				if (convertidor.equals("Dolar USD")) {
					operacion = (cantidad / 1295.87);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " USD.");
				}
				if (convertidor.equals("Euros EUR")) {
					operacion = (cantidad / 1380.70);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " EUR.");
				}
				if (convertidor.equals("Libras Esterlinas GBP")) {
					operacion = (cantidad / 1567.98);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " GBP.");
				}
				if (convertidor.equals("Yen Japones CNY")) {
					operacion = (cantidad / 9.61);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " CNY");
				}
				if (convertidor.equals("Won SurCoreano KRW")) {
					operacion = (cantidad * 1);
					textResultado.setText((double) Math.round(operacion * 100d) / 100 + " KRW.");
				}
			}
		}
		if (e.getSource() == reset) {
			textCantidad.setText("");
			textResultado.setText("");
			comboMoneda.setSelectedIndex(0);
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
		Monedas interfaz = new Monedas();
		interfaz.setBounds(0, 0, 350, 270);
		interfaz.setVisible(true);
		interfaz.setResizable(false);
		interfaz.setLocationRelativeTo(null);

	}
}
