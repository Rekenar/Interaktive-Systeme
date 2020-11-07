package at.ias.example.table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable warehouseTable;
	private WarehouseTableModel warehouseTableModel;
	private int currentSelectedRow;
	private JTextField itemTextField;
	private JTextField descriptionTextField;
	private JTextField amountTextField;

	/**
	 * Launch the application.
	 */
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
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		warehouseTableModel = new WarehouseTableModel();


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 693, 157);
		contentPane.add(scrollPane);


		// Create table, pass table model
		warehouseTable = new JTable(warehouseTableModel);

		// Put table on a scroll pan
		scrollPane.setViewportView(warehouseTable);

		// Registrister listener to select rows
		warehouseTable.getSelectionModel().addListSelectionListener(new RowListener());
		warehouseTable.setRowSelectionAllowed(true);

		JLabel lblItem = new JLabel("Item:");
		lblItem.setBounds(10, 233, 46, 14);
		contentPane.add(lblItem);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(10, 258, 83, 14);
		contentPane.add(lblDescription);

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(10, 283, 83, 14);
		contentPane.add(lblAmount);

		itemTextField = new JTextField();
		itemTextField.setBounds(102, 230, 193, 20);
		contentPane.add(itemTextField);
		itemTextField.setColumns(10);

		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(103, 255, 192, 20);
		contentPane.add(descriptionTextField);
		descriptionTextField.setColumns(10);

		amountTextField = new JTextField();
		amountTextField.setBounds(103, 280, 192, 20);
		contentPane.add(amountTextField);
		amountTextField.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(102, 334, 118, 23);
		contentPane.add(btnSave);
		btnSave.addActionListener(new SaveListener());




	}

	// Listener for row selectioon
	private class RowListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {

			
			// Index of the currently selected row
			currentSelectedRow = warehouseTable.getSelectedRow();

			System.out.println("Selected row index: "+currentSelectedRow);

			if(currentSelectedRow >= 0 && currentSelectedRow < warehouseTableModel.getRowCount() ){
				// Get values from table model an write them into the text fields
				itemTextField.setText(""+warehouseTableModel.getValueAt(currentSelectedRow, 0));
				descriptionTextField.setText(""+warehouseTableModel.getValueAt(currentSelectedRow, 1));
				amountTextField.setText(""+warehouseTableModel.getValueAt(currentSelectedRow, 2));
			}


		}
	}

	// Listener to save values to the table model
	private class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			warehouseTableModel.setValueAt(itemTextField.getText(), currentSelectedRow, 0);
			warehouseTableModel.setValueAt(descriptionTextField.getText(), currentSelectedRow, 1);
			warehouseTableModel.setValueAt(amountTextField.getText(), currentSelectedRow, 2);

		}

	}
}
