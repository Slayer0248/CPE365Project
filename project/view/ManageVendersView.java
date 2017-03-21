package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import project.model.DBAccess;
import project.model.Vender;
import project.model.Customer;

public class ManageVendersView extends JPanel {
   private int sessionID;
   private Customer customer;
   private DBAccess dbaccess;
   
   private JTable vendersTable;
   private JTextArea errorMsgLabel;
   private JPanel vendersPanel;
   private JScrollPane vendersScrollPane;
   //private String[] columnNames = {"Vender ID", "name", "offices", "member", "discount"};
   private String[] columnNames = {"Vender ID", "name", "offices"};
   private ArrayList<Vender> venders = new ArrayList<Vender>();
   private JButton btnAdd;
   private JButton btnDelete;
   private JButton btnUpdate;


   public ManageVendersView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      dbaccess = new DBAccess();
      setLayout(null);
	  setBounds(0, 0, 450, 300); 
	  
	  try {
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
			    try {
		   	      CreateVendersView createVendersView = new CreateVendersView(sessionID, customer, null);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(createVendersView);
				  //frame.pack();
				  frame.revalidate();
				  frame.repaint();
		   	   }
		   	   catch (Exception ex) {
                  ex.printStackTrace(System.out);
               }
			}
		});
		btnAdd.setBounds(48, 265, 94, 29);
		add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   if (vendersTable.getSelectedRow() == -1) {
			      //error case
			      errorMsgLabel.setText("Error: No row selected to delete");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				  
				  errorMsgLabel.repaint();
			   }
			   else {
			      //delete and refresh
			      Vender vender = venders.get(vendersTable.getSelectedRow());
			      
			       try {
			        dbaccess.open();
			        //dbaccess.runUpdate("delete from Ownership where customerID = " +customer.getID()+ "and cardNum = \"" +card.getCardNumber()+"\";");
			        dbaccess.runUpdate("delete from Venders where venderID = \"" +vender.getID()+"\";");
			        dbaccess.close();
			        
			        cardsTable = new JTable(getTableContent(), columnNames);
			        cardsTable.repaint();
			     }
		   	     catch (Exception ex) {
                    ex.printStackTrace(System.out);
                 }
			   }
			}
		});
		btnDelete.setBounds(178, 265, 94, 29);
		add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   if (vendersTable.getSelectedRow() == -1) {
			      //error case
			      errorMsgLabel.setText("Error: No row selected to update");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				  
				  errorMsgLabel.repaint();
			   }
			   else {
			      //update and refresh
			      
			      try {
			      Vender vender = venders.get(vendersTable.getSelectedRow());
		   	      CreateVendersView createVendersView = new CreateVendersView(sessionID, customer, vender);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(createVendersView);
				  //frame.pack();
				  frame.revalidate();
				  frame.repaint();
		   	   }
		   	   catch (Exception ex) {
                  ex.printStackTrace(System.out);
               }
			   }
			}
		});
		btnUpdate.setBounds(306, 265, 94, 29);
		add(btnUpdate);
		
		}
	    catch (Exception ex) {
           ex.printStackTrace(System.out);
        }
   }

	private Object[][] getTableContent() throws Exception {
	    dbaccess.open();
		venders = dbaccess.runVenderSelect("select * from Venders;");
		dbaccess.close();
		
		Object[][] result = new Object[venders.size()][columnNames.length];
		for (int i=0; i<venders.size(); i++) {
			Vender vender = venders.get(i);
			result[i][0] = "" + vender.getID();
			result[i][1] = vender.getName();
			result[i][2] = vender.getOffices();
		}
		return result;
	}
}