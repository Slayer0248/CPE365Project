package project.view;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.table.*;
import project.model.DBAccess;
import project.model.Customer;

public class ManageCardsView extends JPanel {
   private int sessionID;
   private Customer customer;
   
   private JTable cardsTable;
   private JTextArea errorMsgLabel;
   private JPanel cardsPanel;
   private JScrollPane cardsScrollPane;
   private String[] columnNames = {"Card #", "Type", "Credit limit", "Balance", "Active", "Current"};
   private ArrayList<Integer> editStates = new ArrayList<Integer>();
   private GeneralTableModel tModel;
   private JButton btnAdd;
   private JButton btnDelete;
   private JButton btnUpdate;

   public ManageCardsView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setBounds(0, 0, 450, 300); 
	  
	  JLabel nameLabel = new JLabel(customer.getName());
		nameLabel.setBounds(6, 6, 94, 16);
		add(nameLabel);
		
		cardsPanel = new JPanel();
		cardsPanel.setBounds(48, 90, 354, 160);
		add(cardsPanel);
		cardsPanel.setLayout(new BorderLayout(0, 0));
		
		tModel = new GeneralTableModel(getTableContent(), columnNames);
		cardsTable = new JTable(tModel);
		//TableColumn addColumn = cardsTable.getColumnModel().getColumn(0);
		//DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		/*cardsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
           public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
              System.out.println(cardsTable.getValueAt(cardsTable.getSelectedRow(), 0).toString());
           }
        });*/
		
		//cardsTable = new JTable();
		cardsTable.setFillsViewportHeight(true);
		
		cardsScrollPane = new JScrollPane(cardsTable);
		cardsScrollPane.setPreferredSize(new Dimension(354, 160));
		cardsPanel.add(cardsScrollPane, BorderLayout.CENTER);
		
		
		errorMsgLabel = new JTextArea("");
		errorMsgLabel.setOpaque(false);
		errorMsgLabel.setFocusable(false);
		errorMsgLabel.setEditable(false);
		errorMsgLabel.setBorder(null);
		errorMsgLabel.setVisible(false);
		errorMsgLabel.setForeground(Color.RED);
		errorMsgLabel.setLineWrap(true);
		errorMsgLabel.setBounds(48, 45, 354, 20);
		add(errorMsgLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(363, 6, 81, 29);
		btnHome.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   	   try {
		   	      HomeView homeView = new HomeView(sessionID, customer);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(homeView);
				  //frame.pack();
				  frame.revalidate();
				  frame.repaint();
		   	   }
		   	   catch (Exception ex) {
                  ex.printStackTrace(System.out);
               }
		   	}
		   });
		add(btnHome);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(48, 265, 94, 29);
		add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(178, 265, 94, 29);
		add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(306, 265, 94, 29);
		add(btnUpdate);
   }
   
	private Object[][] getTableContent() {
		int rowCount = 1;
		Object[][] result = new Object[rowCount][columnNames.length];
		for (int i=0; i<rowCount; i++) {
			if (i<rowCount-1) {
				
				
			}
			else {
				JButton btnAdd = new JButton("+");
				btnAdd.setBounds(0, 0, 20, 29);
				result[i][0] = btnAdd;
				
				for (int j=1; j<columnNames.length; j++) {
					result[i][j] = "";
				}
				
			}
		}
		return result;
	}
}