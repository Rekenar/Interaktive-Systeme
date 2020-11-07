package at.ias.example.table;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

public class AddressBook extends AbstractTableModel{

	private int numberOfColumns = 5;

	
	ArrayList<ArrayList> addressBook = new ArrayList<ArrayList>();

	private String[] labels = {"First Name", "Second Name", "Address", "Phone Number", "E-Mail"};

	public AddressBook(){
		initLager();
	}


	@Override
	public int getColumnCount() {
		return numberOfColumns;
	}


	@Override
	public int getRowCount() {
		return addressBook.size();
	}


	@Override
	public String getColumnName(int indexSpalte){
		return this.labels[indexSpalte];
	}


	@Override
	public Object getValueAt(int indexZeile, int indexSpalte) {
		return addressBook.get(indexZeile).get(indexSpalte);
	}
	
	@Override
	public void setValueAt(Object wert, int indexZeile, int indexSpalte){
		
		addressBook.get(indexZeile).set(indexSpalte, wert);
        // Active model - inform the view (JTable)
		fireTableCellUpdated(indexZeile, indexSpalte);
	}
	public void addRow(String name1, String name2, String address, String phone, String email){
		addressBook.add(new ArrayList<Object>(Arrays.asList(name1,name2,address,phone,email)));
		fireTableDataChanged();
	}
	public void removeRow(int indexZeile){
		addressBook.remove(indexZeile);
		fireTableDataChanged();
	}
	public int searchForEmail(String email){
		for (int i = 0; i < addressBook.size();i++){
			if(addressBook.get(i).get(4).equals(email)){
				return i;
			}
		}
		return 0;
	}
	private void initLager(){
		addressBook.add(new ArrayList<Object>(Arrays.asList("Lukas", "Stein", "Adolf-Dietel-Weg", "06651651541","a@idwai.at")));
		addressBook.add(new ArrayList<Object>(Arrays.asList("Konstantin", "Ball", "Badergasse", "0665453453","b@idwai.at")));
		addressBook.add(new ArrayList<Object>(Arrays.asList("Ben", "Bett", "Freistädter Straße", "0665125834","c@idwai.at")));
		addressBook.add(new ArrayList<Object>(Arrays.asList("Jonas", "Wand", "Gatterlechnerweg", "0665112345","d@idwai.at")));
		addressBook.add(new ArrayList<Object>(Arrays.asList("Noah", "Auto", "Hagenstraße", "0665114581","e@idwai.at")));
	}


}
