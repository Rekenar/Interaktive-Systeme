
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

public class WarehouseTableModel extends AbstractTableModel{

	/**
	 *
	 */
	private static final long serialVersionUID = 6019769604081663816L;

	private int numberOfColumns = 4;

	ArrayList<ArrayList> warehouseData = new ArrayList<ArrayList>();

	private String[] labels = {"Laden", "Preis", "Einkäufe","Datum"};

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

	public void addRow(){
		warehouseData.add(new ArrayList<Object>(Arrays.asList("","","","")));
	}

	public void subRow(int temp){
		warehouseData.remove(temp);
	}

	private void initLager(){
		warehouseData.add(new ArrayList<Object>(Arrays.asList("Hofer", "25€", "Ei, Käse, Thunfisch","26.10.2020")));
		warehouseData.add(new ArrayList<Object>(Arrays.asList("Spar", "110€", "Steak, Pizza, Zahnpasta, Brot","13.11.2020")));
		warehouseData.add(new ArrayList<Object>(Arrays.asList("Lidl", "15€", "Fleisch","16.11.2020")));
	}


}
