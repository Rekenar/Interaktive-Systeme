package at.ias.example.table;

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
	private JTable addressBookTable;
	private AddressBook addressBookTableModel;
	private int currentSelectedRow;
	private JTextField firstNameTextField;
	private JTextField secondNameTextField;
	private JTextField addressTextField;
	private JTextField phoneNumberTextField;
	private JTextField eMailTextField;
	private JTextField searchTextField;
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

		addressBookTableModel = new AddressBook();


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 693, 157);
		contentPane.add(scrollPane);


		// Create table, pass table model
		addressBookTable = new JTable(addressBookTableModel);

		// Put table on a scroll pan
		scrollPane.setViewportView(addressBookTable);

		// Registrister listener to select rows
		addressBookTable.getSelectionModel().addListSelectionListener(new RowListener());
		addressBookTable.setRowSelectionAllowed(true);

		JLabel lblfirstName = new JLabel("First Name:");
		lblfirstName.setBounds(10, 230, 80, 20);
		contentPane.add(lblfirstName);

		JLabel lblsecondName = new JLabel("Second Name:");
		lblsecondName.setBounds(10, 255, 100, 20);
		contentPane.add(lblsecondName);

		JLabel lbladdress = new JLabel("Address:");
		lbladdress.setBounds(10, 280, 80, 20);
		contentPane.add(lbladdress);

		JLabel lblphoneNumber = new JLabel("Phone number:");
		lblphoneNumber.setBounds(10, 305, 100, 20);
		contentPane.add(lblphoneNumber);

		JLabel lblemail = new JLabel("E-Mail:");
		lblemail.setBounds(10, 330, 80, 20);
		contentPane.add(lblemail);

		JLabel lblsearch = new JLabel("Search for email:");
		lblsearch.setBounds(300, 330, 100, 20);
		contentPane.add(lblsearch);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(100, 230, 190, 20);
		contentPane.add(firstNameTextField);
		firstNameTextField.setColumns(10);

		secondNameTextField = new JTextField();
		secondNameTextField.setBounds(100, 255, 190, 20);
		contentPane.add(secondNameTextField);
		secondNameTextField.setColumns(10);

		addressTextField = new JTextField();
		addressTextField.setBounds(100, 280, 190, 20);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);

		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(100, 305, 190, 20);
		contentPane.add(phoneNumberTextField);
		phoneNumberTextField.setColumns(10);

		eMailTextField = new JTextField();
		eMailTextField.setBounds(100, 330, 190, 20);
		contentPane.add(eMailTextField);
		eMailTextField.setColumns(10);

		searchTextField = new JTextField();
		searchTextField.setBounds(400, 330, 190, 20);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(50, 360, 100, 20);
		contentPane.add(btnSave);
		btnSave.addActionListener(new SaveListener());

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(160, 360, 100, 20);
		contentPane.add(btnRemove);
		btnRemove.addActionListener(new RemoveListener());

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(270, 360, 100, 20);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new AddListener());

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(380, 360, 100, 20);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new SearchListener());
	}

	// Listener for row selectioon
	private class RowListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			// Index of the currently selected row
			currentSelectedRow = addressBookTable.getSelectedRow();

			System.out.println("Selected row index: "+currentSelectedRow);

			if(currentSelectedRow >= 0 && currentSelectedRow < addressBookTableModel.getRowCount() ){
				// Get values from table model an write them into the text fields
				firstNameTextField.setText(""+ addressBookTableModel.getValueAt(currentSelectedRow, 0));
				secondNameTextField.setText(""+ addressBookTableModel.getValueAt(currentSelectedRow, 1));
				addressTextField.setText(""+ addressBookTableModel.getValueAt(currentSelectedRow, 2));
				phoneNumberTextField.setText(""+ addressBookTableModel.getValueAt(currentSelectedRow, 3));
				eMailTextField.setText(""+ addressBookTableModel.getValueAt(currentSelectedRow, 4));
			}


		}
	}

	// Listener to save values to the table model
	private class SaveListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			addressBookTableModel.setValueAt(firstNameTextField.getText(), currentSelectedRow, 0);
			addressBookTableModel.setValueAt(secondNameTextField.getText(), currentSelectedRow, 1);
			addressBookTableModel.setValueAt(addressTextField.getText(), currentSelectedRow, 2);
			addressBookTableModel.setValueAt(phoneNumberTextField.getText(), currentSelectedRow, 3);
			addressBookTableModel.setValueAt(eMailTextField.getText(), currentSelectedRow, 4);
		}
	}
	private class RemoveListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			addressBookTableModel.removeRow(currentSelectedRow);
		}
	}
	private class AddListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			addressBookTableModel.addRow(firstNameTextField.getText(),secondNameTextField.getText(),
					addressTextField.getText(),phoneNumberTextField.getText(),eMailTextField.getText());
		}
	}
	private class SearchListener implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent arg0) {
					addressBookTable.setRowSelectionInterval(addressBookTableModel.searchForEmail(searchTextField.getText()), addressBookTableModel.searchForEmail(searchTextField.getText()));
		}
	}
}
