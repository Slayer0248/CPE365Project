package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import project.model.DBAccess;
import project.model.Customer;

public class ManageVendersView extends JPanel {
   private int sessionID;
   private Customer customer;
   
   private JTable vendersTable;
   private JTextArea errorMsgLabel;
   private JPanel vendersPanel;
   private JScrollPane vendersScrollPane;
   private String[] columnNames = {"Vender ID", "name", "offices", "member", "discount"};
   private ArrayList<Integer> editStates = new ArrayList<Integer>();
   private JButton btnAdd;
   private JButton btnDelete;
   private JButton btnUpdate;


   public ManageVendersView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
	  setBounds(0, 0, 450, 300); 
	  
	  JLabel nameLabel = new JLabel(customer.getName());
		nameLabel.setBounds(6, 6, 94, 16);
		add(nameLabel);
		
		vendersPanel = new JPanel();
		vendersPanel.setBounds(48, 90, 354, 160);
		add(vendersPanel);
		vendersPanel.setLayout(new BorderLayout(0, 0));
		
		vendersTable = new JTable(getTableContent(), columnNames);
		//vendersTable = new JTable();
		vendersTable.setFillsViewportHeight(true);
		
		vendersScrollPane = new JScrollPane(vendersTable);
		vendersScrollPane.setPreferredSize(new Dimension(354, 160));
		vendersPanel.add(vendersScrollPane, BorderLayout.CENTER);
		
		
		//vendersScrollPane.
		//vendersPanel.add(vendersTable, BorderLayout.SOUTH);
		
		errorMsgLabel = new JTextArea("");
		errorMsgLabel.setOpaque(false);
		errorMsgLabel.setFocusable(false);
		errorMsgLabel.setEditable(false);
		errorMsgLabel.setBorder(null);
		errorMsgLabel.setVisible(false);
		errorMsgLabel.setForeground(Color.RED);
		errorMsgLabel.setLineWrap(true);
		errorMsgLabel.setBounds(48, 45, 354, 35);
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