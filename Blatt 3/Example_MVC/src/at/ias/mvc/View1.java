package at.ias.mvc;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import at.ias.mvc.interfaces.Observer;

import java.awt.Font;

public class View1 extends JFrame implements Observer  {

	private JPanel contentPane;
	private Model model;
	private JComboBox comboBox;
	private JLabel lblConsumption;


	/**
	 * Create the frame.
	 */
	public View1(Model model) {
		setTitle("View 1");
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblConsumption = new JLabel("Consumption");
		lblConsumption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsumption.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblConsumption, BorderLayout.CENTER);
	}

	@Override
	public void notifyUpdate() {
		lblConsumption.setText("Consumption: "+model.getConsumption()+" liters per 100 kilometers");
		
	}

}
