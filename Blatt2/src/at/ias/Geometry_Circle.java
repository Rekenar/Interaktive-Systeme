package at.ias;

import java.awt.*;

import javax.swing.*;

import at.ias.model.Circle;
import at.ias.model.Rectangle;
import at.ias.model.Triangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Geometry_Circle extends JFrame {

	//Circle


	private JTextField textFieldRadius;
	private JLabel lblArea;
	private JLabel lblPerimeter;

	//Rectangle

	private JTextField textFieldLength;
	private JTextField textFieldWidth;
	private JLabel lblAreaRectangle;
	private JLabel lblPerimeterRectangle;

	//Triangle

	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldC;
	private JLabel lblAreaTriangle;
	private JLabel lblPerimeterTriangle;

	//Layout Panels

	private JPanel mainPane;
	private JPanel contentCirclePane;
	private JPanel contentRectanglePane;
	private JPanel contentTrianglePane;

	//Error Panels

	private JLabel lblErrorCircle;
	private JLabel lblErrorRectangle;
	private JLabel lblErrorTriangle;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Geometry_Circle frame = new Geometry_Circle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Geometry_Circle() {
		setTitle("GeometryGenius - Circle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);


		mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(3,1));
		setContentPane(mainPane);

		contentCirclePane = new JPanel();
		contentCirclePane.setBorder(BorderFactory.createTitledBorder("Circle"));
		contentCirclePane.setLayout(null);
		mainPane.add(contentCirclePane);

		contentRectanglePane = new JPanel();
		contentRectanglePane.setBorder(BorderFactory.createTitledBorder("Rectangle"));
		contentRectanglePane.setLayout(null);
		mainPane.add(contentRectanglePane);

		contentTrianglePane = new JPanel();
		contentTrianglePane.setBorder(BorderFactory.createTitledBorder("Triangle"));
		contentTrianglePane.setLayout(null);
		mainPane.add(contentTrianglePane);

		//NEW CIRCLE

		textFieldRadius = new JTextField();
		textFieldRadius.setBounds(66, 21, 86, 20);
		contentCirclePane.add(textFieldRadius);

		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRadius.setBounds(10, 24, 46, 14);
		contentCirclePane.add(lblRadius);

		lblArea = new JLabel("Area:");
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArea.setBounds(199, 24, 225, 14);
		contentCirclePane.add(lblArea);

		lblPerimeter = new JLabel("Perimeter:");
		lblPerimeter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPerimeter.setBounds(199, 49, 225, 14);
		contentCirclePane.add(lblPerimeter);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(335, 87, 89, 23);
		btnCalculate.addActionListener(new CalculateListener());
		contentCirclePane.add(btnCalculate);

		//NEW RECTANGLE

		textFieldLength = new JTextField();
		textFieldLength.setBounds(66,21,86,20);
		contentRectanglePane.add(textFieldLength);

		JLabel lblLength = new JLabel("Length:");
		lblLength.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLength.setBounds(10,24,46,14);
		contentRectanglePane.add(lblLength);

		textFieldWidth = new JTextField();
		textFieldWidth.setBounds(66,46,86,20);
		contentRectanglePane.add(textFieldWidth);


		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setFont(new Font("Tahoma", Font.BOLD,11));
		lblWidth.setBounds(10,49,46,14);
		contentRectanglePane.add(lblWidth);

		lblAreaRectangle = new JLabel("Area:");
		lblAreaRectangle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAreaRectangle.setBounds(199, 24, 225, 14);
		contentRectanglePane.add(lblAreaRectangle);

		lblPerimeterRectangle = new JLabel("Perimeter:");
		lblPerimeterRectangle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPerimeterRectangle.setBounds(199, 49, 225, 14);
		contentRectanglePane.add(lblPerimeterRectangle);

		JButton btnCalculateRectangle = new JButton("Calculate");
		btnCalculateRectangle.setBounds(335, 87, 89, 23);
		btnCalculateRectangle.addActionListener(new CalculateListenerRectangle());
		contentRectanglePane.add(btnCalculateRectangle);

		//NEW TRIANGLE

		textFieldA = new JTextField();
		textFieldA.setBounds(66,21,86,20);
		contentTrianglePane.add(textFieldA);


		JLabel lblA = new JLabel("Side A:");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblA.setBounds(10,24,46,14);
		contentTrianglePane.add(lblA);

		textFieldB = new JTextField();
		textFieldB.setBounds(66,46,86,20);
		contentTrianglePane.add(textFieldB);

		JLabel lblB = new JLabel("Side B:");
		lblB.setFont(new Font("Tahoma", Font.BOLD,11));
		lblB.setBounds(10,49,46,14);
		contentTrianglePane.add(lblB);

		textFieldC = new JTextField();
		textFieldC.setBounds(66,71,86,20);
		contentTrianglePane.add(textFieldC);

		JLabel lblC = new JLabel("Side C:");
		lblC.setFont(new Font("Tahoma", Font.BOLD,11));
		lblC.setBounds(10,76,46,14);
		contentTrianglePane.add(lblC);

		lblAreaTriangle = new JLabel("Area:");
		lblAreaTriangle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAreaTriangle.setBounds(199, 24, 225, 14);
		contentTrianglePane.add(lblAreaTriangle);

		lblPerimeterTriangle = new JLabel("Perimeter:");
		lblPerimeterTriangle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPerimeterTriangle.setBounds(199, 49, 225, 14);
		contentTrianglePane.add(lblPerimeterTriangle);

		JButton btnCalculateTriangle = new JButton("Calculate");
		btnCalculateTriangle.setBounds(335, 87, 89, 23);
		btnCalculateTriangle.addActionListener(new CalculateListenerTriangle());
		contentTrianglePane.add(btnCalculateTriangle);

	}

	private class CalculateListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			try{
				contentCirclePane.remove(lblErrorCircle);
			}
			catch(Exception ex){
			}

			try {
				double tempRadius = Double.parseDouble(textFieldRadius.getText());

				Circle circle = new Circle(tempRadius);

				lblArea.setText("Area: "+circle.getArea());
				lblPerimeter.setText("Perimeter: "+circle.getPerimeter());

			}
			catch(NumberFormatException nfe) {
				lblErrorCircle = new JLabel("Please enter a valid number!");
				lblErrorCircle.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrorCircle.setForeground(Color.red);
				lblErrorCircle.setBounds(10,107,225,14);
				contentCirclePane.add(lblErrorCircle);

			}

			mainPane.updateUI();
		}
	}

	private class CalculateListenerRectangle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){

			try{
				contentRectanglePane.remove(lblErrorRectangle);
			}
			catch(Exception ex){
			}

			try {
				double tempLength = Double.parseDouble(textFieldLength.getText());
				double tempWidth = Double.parseDouble(textFieldWidth.getText());

				Rectangle rectangle = new Rectangle(tempLength,tempWidth);

				lblAreaRectangle.setText("Area: "+rectangle.getArea());
				lblPerimeterRectangle.setText("Perimeter: "+rectangle.getPerimeter());
			}
			catch(NumberFormatException nfe) {
				lblErrorRectangle = new JLabel("Please enter a valid number!");
				lblErrorRectangle.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrorRectangle.setForeground(Color.red);
				lblErrorRectangle.setBounds(10,107,225,14);
				contentRectanglePane.add(lblErrorRectangle);

			}

			mainPane.updateUI();
		}
	}

	private class CalculateListenerTriangle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){

			try{
				contentTrianglePane.remove(lblErrorTriangle);
			}
			catch(Exception ex){
			}

			try {
				double tempA = Double.parseDouble(textFieldA.getText());
				double tempB = Double.parseDouble(textFieldB.getText());
				double tempC = Double.parseDouble(textFieldC.getText());

				Triangle triangle = new Triangle(tempA,tempB,tempC);

				lblAreaTriangle.setText("Area: "+triangle.getArea());
				lblPerimeterTriangle.setText("Perimeter: "+triangle.getPerimeter());
			}
			catch(NumberFormatException nfe) {
				lblErrorTriangle = new JLabel("Please enter a valid number!");
				lblErrorTriangle.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblErrorTriangle.setForeground(Color.red);
				lblErrorTriangle.setBounds(10,107,225,14);
				contentTrianglePane.add(lblErrorTriangle);

			}

			mainPane.updateUI();
		}
	}

}
