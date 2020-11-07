package at.ias.mvc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

public class Controller extends JFrame {

	private JPanel contentPane;
	
	private Model model;

	/**
	 * Create the frame.
	 */
	public Controller(Model model) {
		setTitle("Controller");
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 500, 450, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSlider slider = new JSlider(0, 50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.addChangeListener(new SliderListener());
		contentPane.add(slider, BorderLayout.CENTER);
		
		JLabel lblVerbrauchPro = new JLabel("Consumption per 100 kilometers");
		lblVerbrauchPro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVerbrauchPro.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblVerbrauchPro, BorderLayout.NORTH);
		model.setConsumption(slider.getValue());
		
	}
	
	private class SliderListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider slider = (JSlider)e.getSource();
			model.setConsumption(slider.getValue());
		}
		
	}

}
