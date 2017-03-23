package project.view;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.table.*;
import project.model.DBAccess;
import project.model.CreditCard;
import project.model.Customer;
import project.model.Ownership;

public class ManageCardsView extends JPanel {
   private int sessionID;
   private Customer customer;
   private DBAccess dbaccess;
   
   private JTable cardsTable;
   private JTextArea errorMsgLabel;
   private JPanel cardsPanel;
   private JScrollPane cardsScrollPane;
   private String[] columnNames = {"Card #", "Type", "Limit", "Balance", "Active", "Current", "Primary"};
   //private ArrayList<Integer> editStates = new ArrayList<Integer>();
   private ArrayList<CreditCard> cardsOwned = new ArrayList<CreditCard>();
   private ArrayList<Ownership> ownerships = new ArrayList<Ownership>();
   private GeneralTableModel tModel;
   private JButton btnAdd;
   private JButton btnDelete;
   private JButton btnUpdate;

   public ManageCardsView(int id, Customer cust) {
      sessionID = id;
      customer = cust;
      setLayout(null);
      dbaccess = new DBAccess();
	  setBounds(0, 0, 450, 300); 
	  
	  try {
	  JLabel nameLabel = new JLabel(customer.getName());
		nameLabel.setBounds(6, 6, 94, 16);
		add(nameLabel);
		
		cardsPanel = new JPanel();
		cardsPanel.setBounds(18, 90, 475, 160);
		add(cardsPanel);
		cardsPanel.setLayout(new BorderLayout(0, 0));
		
		//tModel = new GeneralTableModel(getTableContent(), columnNames);
		//TableColumn addColumn = cardsTable.getColumnModel().getColumn(0);
		//DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		/*cardsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
           public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
              System.out.println(cardsTable.getValueAt(cardsTable.getSelectedRow(), 0).toString());
           }
        });*/
		cardsTable = new JTable(getTableContent(), columnNames);
		cardsTable.setFillsViewportHeight(true);
		cardsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		cardsTable.getColumnModel().getColumn(0).setPreferredWidth(60);
		cardsTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		cardsTable.getColumnModel().getColumn(2).setPreferredWidth(70);
		cardsTable.getColumnModel().getColumn(3).setPreferredWidth(60);
		cardsTable.getColumnModel().getColumn(4).setPreferredWidth(45);
		cardsTable.getColumnModel().getColumn(5).setPreferredWidth(50);
		cardsTable.getColumnModel().getColumn(6).setPreferredWidth(50);

		cardsScrollPane = new JScrollPane(cardsTable);
		cardsScrollPane.setPreferredSize(new Dimension(475, 160));
		cardsPanel.add(cardsScrollPane, BorderLayout.CENTER);
		
		errorMsgLabel = new JTextArea("");
		errorMsgLabel.setOpaque(false);
		errorMsgLabel.setFocusable(false);
		errorMsgLabel.setEditable(false);
		errorMsgLabel.setBorder(null);
		errorMsgLabel.setVisible(false);
		errorMsgLabel.setForeground(Color.RED);
		errorMsgLabel.setLineWrap(true);
		errorMsgLabel.setBounds(48, 45, 400, 20);
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
		   	      CreateCardsView createCardsView = new CreateCardsView(sessionID, customer);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(createCardsView);
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
			   if (cardsTable.getSelectedRow() == -1) {
			     errorMsgLabel.setText("Error: No row selected to delete");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				  
				  errorMsgLabel.repaint();
			   }
			   else {
			     //String cardNum = cardsTable.getValueAt(cardsTable.getSelectedRow(), 0).toString();
			     CreditCard card = cardsOwned.get(cardsTable.getSelectedRow());
			     Ownership owner = ownerships.get(cardsTable.getSelectedRow());
			     
			     try {
			        dbaccess.open();
			        //dbaccess.runUpdate("delete from Ownership where customerID = " +customer.getID()+ "and cardNum = \"" +card.getCardNumber()+"\";");
			        dbaccess.runUpdate("delete from CreditCards where cardNum = \"" +card.getCardNumber()+"\";");
			        dbaccess.close();

			        ManageCardsView manageCardsView = new ManageCardsView(sessionID, customer);
				  	JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  	JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  	frame.remove(current);
				  	frame.invalidate();
				  	frame.add(manageCardsView);
				  	//frame.pack();
				  	frame.revalidate();
				  	frame.repaint();
			        // cardsTable = new JTable(getTableContent(), columnNames);
			        // cardsTable.repaint();
			     }
		   	     catch (Exception ex) {
                    ex.printStackTrace(System.out);
                 }
                 
                 
			   }
			}
		});
		btnDelete.setBounds(178, 265, 94, 29);
		add(btnDelete);
		
		/*btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   if (cardsTable.getSelectedRow() == -1) {
			      errorMsgLabel.setText("Error: No row selected to delete");
					errorMsgLabel.setForeground(Color.RED);
					errorMsgLabel.setVisible(true);
				  
				  errorMsgLabel.repaint();
			   }
			   else {
			      //String cardNum = cardsTable.getValueAt(cardsTable.getSelectedRow(), 0).toString();
			      CreditCard card = cardsOwned.get(cardsTable.getSelectedRow());
			      Ownership owner = ownerships.get(cardsTable.getSelectedRow());
			      
			      try {
		   	      CreateCardsView createCardsView = new CreateCardsView(sessionID, customer);
				  JPanel current = (JPanel)(((JButton)e.getSource()).getParent());
				  JFrame frame = (JFrame) SwingUtilities.windowForComponent(current);
				  frame.remove(current);
				  frame.invalidate();
				  frame.add(createCardsView);
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
		add(btnUpdate);*/
		
	    }
		catch (Exception ex) {
           ex.printStackTrace(System.out);
        }
   }
   
	private Object[][] getTableContent() throws Exception {
	    cardsOwned = new ArrayList<CreditCard>();
	    //ownerships = new ArrayList<Ownership>();
	    dbaccess.open();
	    ownerships = dbaccess.runOwnershipSelect("select * from Ownership where customerID="+customer.getID()+";");
	    for (int i=0; i<ownerships.size(); i++) {
			CreditCard card = dbaccess.runCreditCardSelect("select * from CreditCards where cardNum=\""+ownerships.get(i).getCardNumber() +"\";").get(0);
			cardsOwned.add(card);
		}
		dbaccess.close();
	    
		//int rowCount = 1;
		Object[][] result = new Object[cardsOwned.size()][columnNames.length];
		for (int i=0; i<cardsOwned.size(); i++) {
			CreditCard card = cardsOwned.get(i);
			Ownership owner = ownerships.get(i);
			result[i][0] = card.getCardNumber();
			result[i][1] = dbaccess.convertTypeToDB(card.getType());
			result[i][2] = "" + card.getCreditLimit();
			result[i][3] = "" + card.getBalance();
			result[i][4] = (card.isActive() ? "Yes":"No");
			result[i][5] = (owner.isCurrent() ? "Yes":"No");
			result[i][6] = (owner.isPrimary() ? "Yes":"No");
		}
		return result;
	}

}