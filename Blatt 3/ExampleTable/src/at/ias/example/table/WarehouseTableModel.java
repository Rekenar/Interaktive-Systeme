package at.ias.example.table;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

public class WarehouseTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6019769604081663816L;


	private int numberOfColumns = 3;

	
	ArrayList<ArrayList> warehouseData = new ArrayList<ArrayList>();

	private String[] labels = {"Item", "Description", "Amount"};

	public WarehouseTableModel(){
		initLager();
	}
	
	
	/*
	 * Set the number of columns in the table
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return numberOfColumns;
	}

	/*
	 * Set the number of rows in the table
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return warehouseData.size();
	}


	/*
	 * Set labels for columns
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int indexSpalte){
		return this.labels[indexSpalte];
	}
	
	
	/*
	 * Get value for every table cell from the warehouse data
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int indexZeile, int indexSpalte) {
		// TODO Auto-generated method stub
		return warehouseData.get(indexZeile).get(indexSpalte);
	}
	
	@Override
	public void setValueAt(Object wert, int indexZeile, int indexSpalte){
		
		warehouseData.get(indexZeile).set(indexSpalte, wert);
        // Active model - inform the view (JTable)
		fireTableCellUpdated(indexZeile, indexSpalte);
	}
		
	private void initLager(){
		warehouseData.add(new ArrayList<Object>(Arrays.asList("Item 1", "Description 1", new Integer(19))));
		warehouseData.add(new ArrayList<Object>(Arrays.asList("Item 2", "Description 2", new Integer(13))));
		warehouseData.add(new ArrayList<Object>(Arrays.asList("Item 3", "Description 3", new Integer(34))));
		warehouseData.add(new ArrayList<Object>(Arrays.asList("Item 4", "Description 4", new Integer(45))));
		warehouseData.add(new ArrayList<Object>(Arrays.asList("Item 5", "Description 5", new Integer(19))));
	}


}
