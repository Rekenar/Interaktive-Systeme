import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Main extends JFrame {

	private JPanel contentPane;
	private JTable warehouseTable;
	private WarehouseTableModel warehouseTableModel;
	private int currentSelectedRow;
	private JTextField firstnameTextField;
	private JTextField secondnameTextField;
	private JTextField phonenumberTextField;
	private JTextField emailTextField;
	private JScrollPane scrollPane;
	private JTextField searchTextField;
	private JPanel leftPane;
	private JPanel leftPaneControl;
	private JPanel rightPane;
	private JLabel image;
	private JPanel rightPaneControl;

	/**
	 * Launch the App
	 **/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the Frame
	 **/
	public Main() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		leftPane = new JPanel();
		leftPane.setBounds(10,10,600,500);
		leftPane.setLayout(null);
		leftPane.setBorder(new BevelBorder(BevelBorder.LOWERED));
		contentPane.add(leftPane);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 2, 596, 190);
		scrollPane.setBorder(new EmptyBorder(0,0,0,0));
		leftPane.add(scrollPane);

		leftPaneControl = new JPanel();
		leftPaneControl.setBounds(10,30,580,400);
		//leftPaneControll.setBorder(new BevelBorder(BevelBorder.LOWERED));
		leftPaneControl.setLayout(null);
		leftPane.add(leftPaneControl);

		rightPane = new JPanel();
		rightPane.setBounds(610,10, 300,500);
		rightPane.setBorder(new BevelBorder(BevelBorder.LOWERED));
		rightPane.setLayout(null);
		contentPane.add(rightPane);

		rightPaneControl = new JPanel();
		rightPaneControl.setBounds(910,10,70,500);
		rightPaneControl.setBorder(new BevelBorder(BevelBorder.LOWERED));
		rightPaneControl.setLayout(null);
		contentPane.add(rightPaneControl);

		/** Left Panel **/

		warehouseTableModel = new WarehouseTableModel();

		warehouseTable = new JTable(warehouseTableModel);

		// Put table on a scroll pan
		scrollPane.setViewportView(warehouseTable);

		// Register listener to select rows
		warehouseTable.getSelectionModel().addListSelectionListener(new RowListener());
		warehouseTable.setRowSelectionAllowed(true);

		JLabel lblLaden = new JLabel("Laden:");
		lblLaden.setBounds(10, 233, 100, 14);
		leftPaneControl.add(lblLaden);

		JLabel lblPreis = new JLabel("Preis:");
		lblPreis.setBounds(10, 258, 100, 14);
		leftPaneControl.add(lblPreis);

		JLabel lblEinkäufe = new JLabel("Einkäufe:");
		lblEinkäufe.setBounds(10, 283, 100, 14);
		leftPaneControl.add(lblEinkäufe);

		JLabel lblDatum = new JLabel(("Datum:"));
		lblDatum.setBounds(10, 308, 100, 14);
		leftPaneControl.add(lblDatum);

		firstnameTextField = new JTextField();
		firstnameTextField.setBounds(103, 230, 193, 20);
		leftPaneControl.add(firstnameTextField);
		firstnameTextField.setColumns(10);

		secondnameTextField = new JTextField();
		secondnameTextField.setBounds(103, 255, 192, 20);
		leftPaneControl.add(secondnameTextField);
		secondnameTextField.setColumns(10);

		phonenumberTextField = new JTextField();
		phonenumberTextField.setBounds(103, 280, 192, 20);
		leftPaneControl.add(phonenumberTextField);
		phonenumberTextField.setColumns(10);

		emailTextField = new JTextField();
		emailTextField.setBounds(103, 305,192,20);
		leftPaneControl.add(emailTextField);
		emailTextField.setColumns(10);

		JButton btnSave = new JButton("Überschreiben");
		btnSave.setBounds(102, 334, 118, 23);
		leftPaneControl.add(btnSave);
		btnSave.addActionListener(new SaveListener());

		JButton btnAddRow = new JButton("+");
		btnAddRow.setBounds(400, 180, 60, 23);
		leftPaneControl.add(btnAddRow);
		btnAddRow.addActionListener(new addRowListener());

		JButton btnSubRow = new JButton("-");
		btnSubRow.setBounds(400, 210, 60, 23);
		leftPaneControl.add(btnSubRow);
		btnSubRow.addActionListener(new subRowListener());

		searchTextField = new JTextField();
		searchTextField.setBounds(103,180,192,23);
		leftPaneControl.add(searchTextField);

		JButton btnSearch = new JButton("Search €");
		btnSearch.setBounds(10,180,80,23);
		leftPaneControl.add(btnSearch);
		btnSearch.addActionListener(new searchListener());

		JButton btnUp = new JButton("Up");
		btnUp.setBounds(500,180,60,23);
		leftPaneControl.add(btnUp);
		btnUp.addActionListener(new upRowListener());

		JButton btnDown = new JButton("Down");
		btnDown.setBounds(500,210,60,23);
		leftPaneControl.add(btnDown);
		btnDown.addActionListener(new downRowListener());


		/** Right Panel **/

		JLabel locationLabel = new JLabel("Location",SwingConstants.CENTER);
		locationLabel.setBounds(120,180,60,20);
		locationLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		rightPane.add(locationLabel);

		JPanel imageFrame = new JPanel();
		imageFrame.setBounds(2,200,296,298);
		rightPane.add(imageFrame);

		JLabel image = new JLabel();
		image.setIcon(new ImageIcon("D:\\Dokumente\\GitHub\\Interaktive-Systeme\\Project\\src\\Bild.png"));
		imageFrame.add(image);

		/** Right Control Panel **/

		JPanel capturePic = new JPanel();
		capturePic.setBounds(2,2,50,50);
		capturePic.setBorder(new BevelBorder(BevelBorder.RAISED));
		rightPaneControl.add(capturePic);

		JLabel image2 = new JLabel();
		image2.setIcon(new ImageIcon("D:\\Dokumente\\GitHub\\Interaktive-Systeme\\Project\\src\\Cam.png"));
		capturePic.add(image2);

		/** Rechnung **/

		JPanel Receipt = new JPanel();
		Receipt.setBounds(2,2,150,150);
		rightPane.add(Receipt);

		JLabel ReceiptImage = new JLabel();
		ReceiptImage.setIcon(new ImageIcon("D:\\Dokumente\\GitHub\\Interaktive-Systeme\\Project\\src\\Receipt.png"));
		Receipt.add(ReceiptImage);

		/** Navigation **/

		JPanel navi = new JPanel();
		navi.setBounds(2,60,50,50);
		navi.setBorder(new BevelBorder(BevelBorder.RAISED));
		rightPaneControl.add(navi);

		JLabel naviImage = new JLabel();
		naviImage.setIcon(new ImageIcon("D:\\Dokumente\\GitHub\\Interaktive-Systeme\\Project\\src\\navi50.png"));
		navi.add(naviImage);

	}

	private class searchListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){

			for (int i = 0; i < warehouseTableModel.getRowCount(); i++) {
				if(warehouseTableModel.getValueAt(i, 1).equals(searchTextField.getText())){
					firstnameTextField.setText(""+warehouseTableModel.getValueAt(i, 0));
					secondnameTextField.setText(""+warehouseTableModel.getValueAt(i, 1));
					phonenumberTextField.setText(""+warehouseTableModel.getValueAt(i, 2));
					emailTextField.setText(""+warehouseTableModel.getValueAt(i,3));
					break; //Damit das erste Ergebnis angezeigt wird.
				}
			}
		}
	}

	private class addRowListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			warehouseTableModel.addRow();
			scrollPane.updateUI();
			scrollPane.setViewportView(warehouseTable);
		}
	}

	private class subRowListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			int temp = currentSelectedRow;

			warehouseTableModel.subRow(temp);
			scrollPane.updateUI();
			scrollPane.setViewportView(warehouseTable);
		}
	}

	private class upRowListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			Object first = warehouseTableModel.getValueAt(currentSelectedRow-1,0);
			Object second = warehouseTableModel.getValueAt(currentSelectedRow-1,1);
			Object third = warehouseTableModel.getValueAt(currentSelectedRow-1,2);
			Object fourth = warehouseTableModel.getValueAt(currentSelectedRow-1,3);

			warehouseTableModel.setValueAt(warehouseTableModel.getValueAt(currentSelectedRow,0),currentSelectedRow-1,0);
			warehouseTableModel.setValueAt(warehouseTableModel.getValueAt(currentSelectedRow,1),currentSelectedRow-1,1);
			warehouseTableModel.setValueAt(warehouseTableModel.getValueAt(currentSelectedRow,2),currentSelectedRow-1,2);
			warehouseTableModel.setValueAt(warehouseTableModel.getValueAt(currentSelectedRow,3),currentSelectedRow-1,3);

			warehouseTableModel.setValueAt(first, currentSelectedRow,0);
			warehouseTableModel.setValueAt(second, currentSelectedRow,1);
			warehouseTableModel.setValueAt(third, currentSelectedRow,2);
			warehouseTableModel.setValueAt(fourth, currentSelectedRow,3);
		}
	}

	private class downRowListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			Object first = warehouseTableModel.getValueAt(currentSelectedRow+1,0);
			Object second = warehouseTableModel.getValueAt(currentSelectedRow+1,1);
			Object third = warehouseTableModel.getValueAt(currentSelectedRow+1,2);
			Object fourth = warehouseTableModel.getValueAt(currentSelectedRow+1,3);

			warehouseTableModel.setValueAt(warehouseTableModel.getValueAt(currentSelectedRow,0),currentSelectedRow+1,0);
			warehouseTableModel.setValueAt(warehouseTableModel.getValueAt(currentSelectedRow,1),currentSelectedRow+1,1);
			warehouseTableModel.setValueAt(warehouseTableModel.getValueAt(currentSelectedRow,2),currentSelectedRow+1,2);
			warehouseTableModel.setValueAt(warehouseTableModel.getValueAt(currentSelectedRow,3),currentSelectedRow+1,3);

			warehouseTableModel.setValueAt(first, currentSelectedRow,0);
			warehouseTableModel.setValueAt(second, currentSelectedRow,1);
			warehouseTableModel.setValueAt(third, currentSelectedRow,2);
			warehouseTableModel.setValueAt(fourth, currentSelectedRow,3);
		}
	}

	// Listener for row selection
	private class RowListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {

			// Index of the currently selected row
			currentSelectedRow = warehouseTable.getSelectedRow();

			System.out.println("Selected row index: "+currentSelectedRow);

			if(currentSelectedRow >= 0 && currentSelectedRow < warehouseTableModel.getRowCount() ){
				// Get values from table model an write them into the text fields
				firstnameTextField.setText(""+warehouseTableModel.getValueAt(currentSelectedRow, 0));
				secondnameTextField.setText(""+warehouseTableModel.getValueAt(currentSelectedRow, 1));
				phonenumberTextField.setText(""+warehouseTableModel.getValueAt(currentSelectedRow, 2));
				emailTextField.setText(""+warehouseTableModel.getValueAt(currentSelectedRow,3));
			}
		}
	}

	// Listener to save values to the table model
	private class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try{
				warehouseTableModel.setValueAt(firstnameTextField.getText(), currentSelectedRow, 0);
				warehouseTableModel.setValueAt(containsEuro(secondnameTextField.getText()), currentSelectedRow, 1);
				warehouseTableModel.setValueAt(phonenumberTextField.getText(), currentSelectedRow, 2);
				warehouseTableModel.setValueAt(emailTextField.getText(), currentSelectedRow, 3);
			}
			catch(IndexOutOfBoundsException e){
				warehouseTableModel.addRow();
				scrollPane.updateUI();
				scrollPane.setViewportView(warehouseTable);

				warehouseTableModel.setValueAt(firstnameTextField.getText(), warehouseTable.getRowCount()-1, 0);
				warehouseTableModel.setValueAt(containsEuro(secondnameTextField.getText()), warehouseTable.getRowCount()-1, 1);
				warehouseTableModel.setValueAt(phonenumberTextField.getText(), warehouseTable.getRowCount()-1, 2);
				warehouseTableModel.setValueAt(emailTextField.getText(), warehouseTable.getRowCount()-1, 3);

			}

		}

		private String containsEuro(String value){
			//char[] chars = new char[value.length()];
			for (int i = 0; i < value.length() ; i++) {
				String c = Character.toString(value.charAt(i));
				if(c.equals("€")){
					return value;
				}
			}
			return value+"€";
		}
	}
}

