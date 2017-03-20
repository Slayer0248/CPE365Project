package project.view;

import java.util.*;
import javax.swing.table.*;

public GeneralTableModel extends AbstractTableModel {
   private Object[][] data;
   private String[] columns;
   

   public GeneralTableModel(Object[][] data, String[] columns) {
      this.data = data;
      this.columns = columns;
   }
   
   public void setData(Object[][] data) {
     this.data = data; 
   }
   
   public Object[][] getData() {
     return data; 
   }
   
   public void setColumnNames(String[] columns) {
     this.columns = columns;
   }
   
   public String[] ColumnNames() {
     return columns; 
   }
   
   public int getColumnCount() {
      return columns.length;
   }
 
   public int getRowCount() {
      return data.length;
   }
 
   public String getColumnName(int col) {
      return columns[col];
   }
 
   public Object getValueAt(int row, int col) {
      return data[row][col];
   }
   
   public Class getColumnClass(int c) {
      return getValueAt(0, c).getClass();
   }
   
   public boolean isCellEditable(int row, int col) {
      //Note that the data/cell address is constant,
      //no matter where the cell appears onscreen.
      /*if (col < 2) {
         return false;
      } else {
        return true;
      }*/
      return true;
   }
   
   public void setValueAt(Object value, int row, int col) {
            /*if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }*/
 
      data[row][col] = value;
      fireTableCellUpdated(row, col);
 
      /*if (DEBUG) {
         System.out.println("New value of data:");
                printDebugData();
            }*/
    }
}