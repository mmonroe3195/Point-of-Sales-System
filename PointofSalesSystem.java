

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
public class PointofSalesSystem 
{

	String [] prices = new String [12];
	String [] names= new String [12];
	String [] description = new String [12];
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	private static int i = 0;

	JFrame frame = new JFrame("Point of Sales System");
	JPanel panel1 = new JPanel();
	JPanel Main = new JPanel();
	JPanel Menu = new JPanel();
	JPanel orderHistory = new JPanel();

	double subtotal = 0.00, tax =0.00, total = 0.00;
	JButton btnQuit = new JButton("Quit"),btnQuit2 = new JButton("Quit"),btnQuit3 = new JButton("Quit");

	JButton btnDeleteOrder = new JButton("Delete Order");
	JButton btnViewOrderHistory = new JButton("View Orders");
	JButton btnViewOrderHistory2 = new JButton("View Order History");
	JButton btnViewMenu = new JButton("View Menu");
	JButton btnViewMenu2 = new JButton("View Menu");
	JButton btnAddOrder2 = new JButton("Add Order");
	JButton btnNewOrder = new JButton("New Order");
	JButton btnAddOrder = new JButton("Add Order");

	JButton btnOption1 = new JButton("Option 1");
	JButton btnOption2 = new JButton("Option 2");
	JButton btnOption3 = new JButton("Option 3");
	JButton btnOption4 = new JButton("Option 4");

	JButton btnCancelOrder = new JButton("Cancel Order");
	JButton btnPlaceOrder = new JButton("Place Order");



	ButtonGroup radiogroup = new ButtonGroup();
	ButtonGroup radiogroup2 = new ButtonGroup();

	JRadioButton rdbtnAppetizers;
	JRadioButton rdbtnEntrees;
	JRadioButton rdbtnDesserts;

	JRadioButton rdbtnAppetizers2;
	JRadioButton rdbtnEntrees2;
	JRadioButton rdbtnDesserts2;

	ButtonListener listener = new ButtonListener();
	String customerName;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JEditorPane orderView = new JEditorPane();

	boolean changeScreens = true;
	String currentOrder = "";
	String currentOrderFormated = "";
	JButton displayOrder = new JButton("Display Order");
	static int orderNumber = 1;
	JComboBox<String> comboBoxNames = new JComboBox<String>();
	ArrayList<String> customerNamesArrayList = new ArrayList<String>();
	ArrayList<String> customerOrdersArrayList = new ArrayList<String>();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JEditorPane editorPane = new JEditorPane();
	JTextArea editorPane_1 = new JTextArea();
	JEditorPane dtrpnSubtotal = new JEditorPane();
	JEditorPane dtrpnTax = new JEditorPane();
	JEditorPane dtrpnTotal = new JEditorPane();
	ArrayList <Order> orders = new ArrayList <Order> ();
	public PointofSalesSystem()
	{
		frame.getContentPane().setLayout(new CardLayout(0, 0));


		frame.getContentPane().add(Main, "name_2599945390745");
		Main.setLayout(null);

		rdbtnAppetizers = new JRadioButton("Appetizers");
		rdbtnAppetizers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnAppetizers.setSelected(true);
		rdbtnAppetizers.setBounds(585, 112, 141, 23);
		Main.add(rdbtnAppetizers);

		rdbtnEntrees = new JRadioButton("Entrees");
		rdbtnEntrees.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnEntrees.setBounds(585, 138, 141, 23);
		Main.add(rdbtnEntrees);

		rdbtnDesserts = new JRadioButton("Desserts");
		rdbtnDesserts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDesserts.setBounds(585, 164, 141, 23);
		Main.add(rdbtnDesserts);

		//adding to button group
		radiogroup.add(rdbtnAppetizers);
		radiogroup.add(rdbtnEntrees);
		radiogroup.add(rdbtnDesserts);

		rdbtnAppetizers.setEnabled(false);
		rdbtnEntrees.setEnabled(false);
		rdbtnDesserts.setEnabled(false);

		JLabel lblLifeOfPie = new JLabel("Life of Pie Pizzeria Point of Sales System");
		lblLifeOfPie.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLifeOfPie.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifeOfPie.setBounds(181, 19, 421, 23);
		Main.add(lblLifeOfPie);

		JLabel lblMenuOptions = new JLabel("Menu Options:");
		lblMenuOptions.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMenuOptions.setBackground(Color.WHITE);
		lblMenuOptions.setBounds(591, 78, 122, 37);
		Main.add(lblMenuOptions);


		btnOption1.setForeground(new Color(255, 255, 255));
		btnOption1.setBackground(new Color(65, 105, 225));
		btnOption1.setOpaque(true);
		btnOption1.setBorderPainted(false);
		btnOption1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOption1.setBounds(590, 274, 166, 57);
		Main.add(btnOption1);
		btnOption1.setEnabled(false);

		btnOption2.setForeground(new Color(255, 255, 255));
		btnOption2.setBackground(new Color(65, 105, 225));
		btnOption2.setOpaque(true);
		btnOption2.setBorderPainted(false);
		btnOption2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOption2.setBounds(590, 342, 166, 57);
		Main.add(btnOption2);
		btnOption2.setEnabled(false);


		btnOption3.setForeground(new Color(255, 255, 255));
		btnOption3.setBackground(new Color(65, 105, 225));
		btnOption3.setOpaque(true);
		btnOption3.setBorderPainted(false);
		btnOption3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOption3.setBounds(590, 410, 166, 57);
		Main.add(btnOption3);
		btnOption3.setEnabled(false);


		btnOption4.setForeground(new Color(255, 255, 255));
		btnOption4.setBackground(new Color(65, 105, 225));
		btnOption4.setOpaque(true);
		btnOption4.setBorderPainted(false);
		btnOption4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOption4.setBounds(590, 478, 166, 57);
		Main.add(btnOption4);
		btnOption4.setEnabled(false);

		JLabel lblOrderOptions = new JLabel("Order Options:");
		lblOrderOptions.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderOptions.setBounds(592, 240, 134, 23);
		Main.add(lblOrderOptions);

		JLabel lblOrderHistory = new JLabel("Order History:");
		lblOrderHistory.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderHistory.setBounds(10, 51, 122, 29);
		Main.add(lblOrderHistory);
		btnNewOrder.setForeground(new Color(255, 255, 255));
		btnNewOrder.setBackground(new Color(0, 0, 0));


		btnNewOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewOrder.setBounds(358, 358, 147, 53);
		btnNewOrder.setOpaque(true);
		btnNewOrder.setBorderPainted(false);
		Main.add(btnNewOrder);
		btnViewOrderHistory.setForeground(Color.BLACK);
		btnViewOrderHistory.setBackground(new Color(255, 255, 255));


		btnViewOrderHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewOrderHistory.setBounds(358, 112, 147, 53);
		Main.add(btnViewOrderHistory);
		btnViewMenu.setForeground(Color.BLACK);
		btnViewMenu.setBackground(new Color(255, 255, 255));


		btnViewMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewMenu.setBounds(358, 176, 147, 52);
		Main.add(btnViewMenu);
		btnQuit.setForeground(new Color(255, 255, 255));
		btnQuit.setBackground(new Color(0, 0, 0));


		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuit.setBounds(358, 480, 147, 52);
		btnQuit.setOpaque(true);
		btnQuit.setBorderPainted(false);
		Main.add(btnQuit);

		btnPlaceOrder.setBackground(new Color(255, 255, 255));
		btnPlaceOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPlaceOrder.setBounds(434, 420, 116, 53);
		btnPlaceOrder.setEnabled(false);
		Main.add(btnPlaceOrder);

		btnCancelOrder.setBackground(new Color(255, 255, 255));
		btnCancelOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelOrder.setBounds(308, 420, 116, 53);
		btnCancelOrder.setEnabled(false);
		Main.add(btnCancelOrder);


		dtrpnSubtotal.setForeground(new Color(255, 255, 255));
		dtrpnSubtotal.setBackground(new Color(65, 105, 225));
		dtrpnSubtotal.setEditable(false);
		dtrpnSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dtrpnSubtotal.setText("Subtotal:        \r\n       " + formatter.format(subtotal));
		dtrpnSubtotal.setBorder(BorderFactory.createLineBorder(Color.black));
		dtrpnSubtotal.setBounds(10, 409, 259, 46);
		Main.add(dtrpnSubtotal);


		dtrpnTax.setEditable(false);
		dtrpnTax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dtrpnTax.setText("Tax: \r\n       " + formatter.format(tax));
		dtrpnTax.setBorder(BorderFactory.createLineBorder(Color.black));
		dtrpnTax.setBounds(10, 455, 259, 46);
		Main.add(dtrpnTax);


		dtrpnTotal.setForeground(new Color(255, 255, 255));
		dtrpnTotal.setBackground(new Color(65, 105, 225));
		dtrpnTotal.setEditable(false);
		dtrpnTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dtrpnTotal.setText("Total: \r\n       " + formatter.format(total));
		dtrpnTotal.setBorder(BorderFactory.createLineBorder(Color.black));
		dtrpnTotal.setBounds(10, 501, 259, 46);
		Main.add(dtrpnTotal);

		JLabel lblAlternateViews = new JLabel("Alternate Views:");
		lblAlternateViews.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAlternateViews.setBounds(364, 84, 154, 25);
		Main.add(lblAlternateViews);
		scrollPane_1.setBounds(10, 78, 259, 331);

		Main.add(scrollPane_1);
		editorPane.setForeground(Color.WHITE);
		editorPane.setBackground(Color.BLACK);
		editorPane.setEditable(false);

		scrollPane_1.setViewportView(editorPane);


		frame.getContentPane().add(orderHistory, "name_2609319311691");
		orderHistory.setLayout(null);

		JLabel lblOrderHistory_1 = new JLabel("Order History");
		lblOrderHistory_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOrderHistory_1.setBounds(324, 30, 136, 27);
		orderHistory.add(lblOrderHistory_1);



		btnDeleteOrder.setForeground(new Color(255, 255, 255));
		btnDeleteOrder.setBackground(new Color(65, 105, 225));
		//btnDeleteOrder.setEnabled(false);
		btnDeleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteOrder.setOpaque(true);
		btnDeleteOrder.setBorderPainted(false);
		btnDeleteOrder.setBounds(304, 258, 147, 53);
		orderHistory.add(btnDeleteOrder);
		btnViewMenu2.setForeground(new Color(255, 255, 255));
		btnViewMenu2.setBackground(new Color(0, 0, 0));


		btnViewMenu2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewMenu2.setOpaque(true);
		btnViewMenu2.setBorderPainted(false);
		btnViewMenu2.setBounds(304, 322, 147, 53);
		orderHistory.add(btnViewMenu2);
		btnAddOrder.setForeground(new Color(255, 255, 255));
		btnAddOrder.setBackground(new Color(65, 105, 225));

		btnAddOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddOrder.setOpaque(true);
		btnAddOrder.setBorderPainted(false);
		btnAddOrder.setBounds(304, 386, 147, 53);
		orderHistory.add(btnAddOrder);
		btnQuit3.setBackground(new Color(0, 0, 0));
		btnQuit3.setForeground(new Color(255, 255, 255));

		btnQuit3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuit3.setOpaque(true);
		btnQuit3.setBorderPainted(false);
		btnQuit3.setBounds(304, 450, 147, 53);
		orderHistory.add(btnQuit3);
		scrollPane.setBounds(501, 103, 259, 400);


		orderHistory.add(scrollPane);
		orderView.setEditable(false);

		scrollPane.setViewportView(orderView);


		comboBoxNames.setBounds(44, 248, 183, 27);
		orderHistory.add(comboBoxNames);

		JLabel lblPreviousOrders = new JLabel("Previous Orders:");
		lblPreviousOrders.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreviousOrders.setBounds(51, 220, 119, 27);
		orderHistory.add(lblPreviousOrders);



		displayOrder.setForeground(Color.WHITE);
		displayOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		displayOrder.setOpaque(true);
		displayOrder.setBorderPainted(false);
		displayOrder.setBackground(Color.BLACK);
		displayOrder.setBounds(44, 286, 147, 27);
		orderHistory.add(displayOrder);


		frame.getContentPane().add(Menu, "name_2625303045653");
		Menu.setLayout(null);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenu.setBounds(361, 36, 61, 25);
		Menu.add(lblMenu);

		JLabel menuOptions2 = new JLabel("Menu Options:");
		menuOptions2.setFont(new Font("Tahoma", Font.BOLD, 16));
		menuOptions2.setBackground(Color.WHITE);
		menuOptions2.setBounds(53, 101, 122, 16);
		Menu.add(menuOptions2);

		rdbtnAppetizers2 = new JRadioButton("Appetizers");
		rdbtnAppetizers2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnAppetizers2.setSelected(true);
		rdbtnAppetizers2.setBounds(53, 124, 109, 23);
		rdbtnAppetizers2.addActionListener(listener);
		Menu.add(rdbtnAppetizers2);

		rdbtnEntrees2 = new JRadioButton("Entrees");
		rdbtnEntrees2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnEntrees2.setBounds(53, 150, 109, 23);
		rdbtnEntrees2.addActionListener(listener);
		Menu.add(rdbtnEntrees2);

		rdbtnDesserts2 = new JRadioButton("Desserts");
		rdbtnDesserts2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDesserts2.setBounds(53, 176, 109, 23);
		rdbtnDesserts2.addActionListener(listener);
		Menu.add(rdbtnDesserts2);


		radiogroup2.add(rdbtnAppetizers2);
		radiogroup2.add(rdbtnEntrees2);
		radiogroup2.add(rdbtnDesserts2);
		radiogroup2.clearSelection();


		editorPane_1.setEditable(false);
		editorPane_1.setLineWrap(true);
		editorPane_1.setWrapStyleWord(true);
		editorPane_1.setBounds(288, 90, 457, 442);
		editorPane_1.setBorder(BorderFactory.createLineBorder(Color.black));
		Menu.add(editorPane_1);
		btnAddOrder2.setForeground(new Color(255, 255, 255));
		btnAddOrder2.setBackground(new Color(0, 0, 0));


		btnAddOrder2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddOrder2.setOpaque(true);
		btnAddOrder2.setBorderPainted(false);
		btnAddOrder2.setBounds(53, 345, 159, 53);
		Menu.add(btnAddOrder2);
		btnViewOrderHistory2.setBackground(new Color(65, 105, 225));
		btnViewOrderHistory2.setForeground(new Color(255, 255, 255));


		btnViewOrderHistory2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewOrderHistory2.setOpaque(true);
		btnViewOrderHistory2.setBorderPainted(false);
		btnViewOrderHistory2.setBounds(53, 408, 159, 53);
		Menu.add(btnViewOrderHistory2);
		btnQuit2.setForeground(new Color(255, 255, 255));
		btnQuit2.setBackground(new Color(0, 0, 0));


		btnQuit2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuit2.setOpaque(true);
		btnQuit2.setBorderPainted(false);
		btnQuit2.setBounds(53, 473, 159, 53);
		Menu.add(btnQuit2);

	}
	public void display()
	{

		bufferReader();
		btnOption1.setText(names[0]);
		btnOption2.setText(names[1]);
		btnOption3.setText(names[2]);
		btnOption4.setText(names[3]);

		// Panel size
		frame.setPreferredSize(new Dimension(800, 600));

		// Allows putting objects at specific coordinates
		panel1.setLayout(null);
		
		//Button characteristics/ button listeners
		btnQuit.addActionListener(listener);
		btnQuit2.addActionListener(listener);
		btnQuit3.addActionListener(listener);


		btnViewOrderHistory.addActionListener(listener);
		btnViewOrderHistory2.addActionListener(listener);
		btnViewMenu.addActionListener(listener);
		btnAddOrder2.addActionListener(listener);
		btnViewMenu2.addActionListener(listener);
		rdbtnEntrees.addActionListener(listener);
		rdbtnAppetizers.addActionListener(listener);
		rdbtnDesserts.addActionListener(listener);
		btnNewOrder.addActionListener(listener);
		btnAddOrder.addActionListener(listener);
		btnCancelOrder.addActionListener(listener);
		btnPlaceOrder.addActionListener(listener);

		btnOption1.addActionListener(listener);
		btnOption2.addActionListener(listener);
		btnOption3.addActionListener(listener);
		btnOption4.addActionListener(listener);
		btnDeleteOrder.addActionListener(listener);
		displayOrder.addActionListener(listener);
		rdbtnEntrees2.addActionListener(listener);
		rdbtnAppetizers2.addActionListener(listener);
		rdbtnDesserts2.addActionListener(listener);

		
		
		frame.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent we) {
			   
				  FileWriter write = null;
					try {
						write = new FileWriter ("src/Orders.csv", true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for(Order toAdd: orders)
						Order.addToCSV(toAdd,write);
					
				  System.exit(0);
			  }
			});

		//ALWAYS include this to display the program
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		frame.getContentPane().add(panel1);
		frame.pack();
		frame.setVisible(true);

	}
//	private void addWindowListener(WindowAdapter windowAdapter) {
//		// TODO Auto-generated method stub
//		
//	}
	public class ButtonListener implements ActionListener  
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == rdbtnAppetizers||rdbtnAppetizers.isSelected())
			{
				btnOption1.setText(names[0]);
				btnOption2.setText(names[1]);
				btnOption3.setText(names[2]);
				btnOption4.setText(names[3]);
			}

			if(e.getSource()==rdbtnEntrees)
			{
				btnOption1.setText(names[4]);
				btnOption2.setText(names[5]);
				btnOption3.setText(names[6]);
				btnOption4.setText(names[7]);
			}

			if(e.getSource()==rdbtnDesserts)
			{
				btnOption1.setText(names[8]);
				btnOption2.setText(names[9]);
				btnOption3.setText(names[10]);
				btnOption4.setText(names[11]);
			}

			if(e.getSource() == btnQuit||e.getSource() == btnQuit2||e.getSource() == btnQuit3)
			{
				//Order.closeCSV("Orders.csv");
				FileWriter write = null;
				try {
					write = new FileWriter ("src/Orders.csv", true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(Order toAdd: orders)
					Order.addToCSV(toAdd,write);
				
				System.exit(0);
			}

			if(e.getSource() == btnNewOrder)
			{
				currentOrder = "Order Number " + orderNumber + "-";
				setOrderText();
				changeScreens = false;
				rdbtnAppetizers.setEnabled(true);
				rdbtnEntrees.setEnabled(true);
				rdbtnDesserts.setEnabled(true);
				btnOption1.setEnabled(true);
				btnOption2.setEnabled(true);
				btnOption3.setEnabled(true);
				btnOption4.setEnabled(true);
				btnCancelOrder.setEnabled(true);
				btnNewOrder.setEnabled(false);
			}

			if(e.getSource() == btnCancelOrder)
			{
				changeScreens= true;
				rdbtnAppetizers.setEnabled(false);
				rdbtnEntrees.setEnabled(false);
				rdbtnDesserts.setEnabled(false);
				btnOption1.setEnabled(false);
				btnOption2.setEnabled(false);
				btnOption3.setEnabled(false);
				btnOption4.setEnabled(false);
				btnCancelOrder.setEnabled(false);
				btnPlaceOrder.setEnabled(false);
				btnNewOrder.setEnabled(true);
				editorPane.setText("");
				total = 0;
				tax = 0;
				subtotal = 0;
				pricing();
			}

			if(e.getSource() == btnPlaceOrder)
			{
				customerName= JOptionPane.showInputDialog("What is the Customer's Name?");
				

				if(customerName != null)
				{
					String formatedSubtotal = formatter.format(subtotal);
					String formatedTax = formatter.format(tax);
					String formatedTotal = formatter.format(total);
					Order customerOrder = new Order(orderNumber,currentOrderFormated,customerName,formatedSubtotal,formatedTax,formatedTotal);
					orders.add(customerOrder);

					changeScreens = true;
					btnPlaceOrder.setEnabled(false);
					btnCancelOrder.setEnabled(false);
					rdbtnAppetizers.setEnabled(false);
					rdbtnEntrees.setEnabled(false);
					rdbtnDesserts.setEnabled(false);
					btnOption1.setEnabled(false);
					btnOption2.setEnabled(false);
					btnOption3.setEnabled(false);
					btnOption4.setEnabled(false);
					btnNewOrder.setEnabled(true);
					customerNamesArrayList.add(customerName);
					customerOrdersArrayList.add(customerName+ "- " +currentOrder + "\n\nSubtotal: " + formatedSubtotal + "\nTax: " + formatedTax + "\nTotal: " +formatedTotal);
					comboBoxNames.addItem(customerName);
					orderNumber++;
					currentOrderFormated = "";
					total = 0;
					tax = 0;
					subtotal = 0;
					pricing();
				}
			}

			if(e.getSource() == btnViewOrderHistory && btnCancelOrder.isEnabled())
			{
				JOptionPane.showMessageDialog(new JFrame(), "Before changing to an alternate view please save or cancel the current order.", "Dialog",
						JOptionPane.ERROR_MESSAGE);	
			}

			if(e.getSource() == btnViewMenu && btnCancelOrder.isEnabled())
			{
				JOptionPane.showMessageDialog(new JFrame(), "Before changing to an alternate view please save or cancel the current order.", "Dialog",
						JOptionPane.ERROR_MESSAGE);	
			}

			if((e.getSource() == btnViewOrderHistory||e.getSource() == btnViewOrderHistory2) && changeScreens)
			{
				editorPane.setText("");
				orderView.setText("");
				Menu.setVisible(false);
				Main.setVisible(false);
				orderHistory.setVisible(true);
			}

			if((e.getSource() == btnViewMenu||e.getSource() == btnViewMenu2) && changeScreens)
			{
				editorPane.setText("");
				orderView.setText("");
				orderHistory.setVisible(false);
				Main.setVisible(false);
				Menu.setVisible(true);
			}

			if((e.getSource() == btnAddOrder||e.getSource() == btnAddOrder2) && changeScreens)
			{
				Menu.setVisible(false);
				orderHistory.setVisible(false);
				Main.setVisible(true);
			}

			if(e.getSource() == btnOption1)
			{
				String itemPrice="";
				if(rdbtnAppetizers.isSelected())
				{
					subtotal += Double.parseDouble(prices[0]);
					tax += Double.parseDouble(prices[0])*0.0635;
					itemPrice = prices[0];
				}

				if(rdbtnEntrees.isSelected())
				{
					subtotal += Double.parseDouble(prices[4]);
					tax += Double.parseDouble(prices[4])*0.0635;
					itemPrice = prices[4];
				}

				if(rdbtnDesserts.isSelected())
				{
					subtotal += Double.parseDouble(prices[8]);
					tax += Double.parseDouble(prices[8])*0.0635;
					itemPrice = prices[8];
				}


				total = subtotal + tax;
				btnPlaceOrder.setEnabled(true);
				currentOrder = currentOrder + "\n" + btnOption1.getText() + "----" + formatter.format(Double.parseDouble(itemPrice));
				currentOrderFormated = currentOrderFormated + btnOption1.getText();
				setOrderText();
				pricing();
			}

			if(e.getSource() == btnOption2)
			{
				String itemPrice="";
				if(rdbtnAppetizers.isSelected())
				{
					subtotal += Double.parseDouble(prices[1]);
					tax += Double.parseDouble(prices[1]) * 0.0635;
					itemPrice = prices[1];
				}

				if(rdbtnEntrees.isSelected())
				{
					subtotal += Double.parseDouble(prices[5]);
					tax += Double.parseDouble(prices[5]) * 0.0635;
					itemPrice = prices[5];
				}

				if(rdbtnDesserts.isSelected())
				{
					subtotal += Double.parseDouble(prices[9]);
					tax += Double.parseDouble(prices[9]) * 0.0635;
					itemPrice = prices[9];
				}


				total = subtotal + tax;
				btnPlaceOrder.setEnabled(true);
				currentOrder = currentOrder + "\n" + btnOption2.getText() + "----" + formatter.format(Double.parseDouble(itemPrice));

				currentOrderFormated = currentOrderFormated+ btnOption2.getText();

				setOrderText();
				pricing();
			}

			if(e.getSource() == btnOption3)
			{
				String itemPrice="";
				if(rdbtnAppetizers.isSelected())
				{
					subtotal += Double.parseDouble(prices[2]);
					tax += Double.parseDouble(prices[2])*0.0635;
					itemPrice = prices[2];
				}

				if(rdbtnEntrees.isSelected())
				{
					subtotal += Double.parseDouble(prices[6]);
					tax += Double.parseDouble(prices[6])*0.0635;
					itemPrice = prices[6];
				}

				if(rdbtnDesserts.isSelected())
				{
					subtotal += Double.parseDouble(prices[10]);
					tax += Double.parseDouble(prices[10])*0.0635;
					itemPrice = prices[10];
				}


				total = subtotal + tax;
				btnPlaceOrder.setEnabled(true);
				currentOrder = currentOrder + "\n" + btnOption3.getText() + "----" + formatter.format(Double.parseDouble(itemPrice));

				currentOrderFormated = currentOrderFormated+ btnOption3.getText();
				setOrderText();
				pricing();
			}

			if(e.getSource() == btnOption4)
			{
				String itemPrice="";
				if(rdbtnAppetizers.isSelected())
				{
					subtotal += Double.parseDouble(prices[3]);
					tax += Double.parseDouble(prices[3]) * 0.0635;
					itemPrice = prices[3];
				}

				if(rdbtnEntrees.isSelected())
				{
					subtotal += Double.parseDouble(prices[7]);
					tax += Double.parseDouble(prices[7]) * 0.0635;
					itemPrice = prices[7];
				}

				if(rdbtnDesserts.isSelected())
				{
					subtotal += Double.parseDouble(prices[11]);
					tax += Double.parseDouble(prices[11]) * 0.0635;
					itemPrice = prices[11];
				}


				total = subtotal + tax;
				btnPlaceOrder.setEnabled(true);
				currentOrder = currentOrder + "\n" + btnOption4.getText() + "----" + formatter.format(Double.parseDouble(itemPrice));

				currentOrderFormated = currentOrderFormated+ btnOption4.getText();
				setOrderText();
				pricing();
			}



			if(e.getSource() == btnDeleteOrder && comboBoxNames.getSelectedItem()!= null)
			{
				String a = comboBoxNames.getSelectedItem().toString();
				for(int i = 0; i < customerNamesArrayList.size(); i++)
				{
					if(a == customerNamesArrayList.get(i))
					{
						customerNamesArrayList.remove(i);
						orders.remove(i);

						if(orderView.getText().equals(customerOrdersArrayList.get(i)))
							orderView.setText("");
						customerOrdersArrayList.remove(i);

					}
				}

				comboBoxNames.removeItem(comboBoxNames.getSelectedItem());
			}

			if(e.getSource() == displayOrder && comboBoxNames.getSelectedIndex() != -1)
			{
				String a = comboBoxNames.getSelectedItem().toString();
				for(int i = 0; i<customerNamesArrayList.size(); i++)
					if(a == customerNamesArrayList.get(i))
						orderView.setText(customerOrdersArrayList.get(i));
					
			}

			if(e.getSource() == rdbtnAppetizers2)
			{
				editorPane_1.setText(GetDifferentFoods.callAps());
			}

			if(e.getSource() == rdbtnEntrees2)
			{
				editorPane_1.setText(GetDifferentFoods.callEntre());
			}

			if(e.getSource() == rdbtnDesserts2)
			{
				editorPane_1.setText(GetDifferentFoods.callDessert());
			}
		}
	}

	public void setOrderText()
	{
		editorPane.setText(currentOrder);
	}



	public void bufferReader()
	{

		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/menu.csv"));


			String line = br.readLine();

			while(line != null)
			{
		
				String [] lineArray = line.split(",");
					
				line = br.readLine();
				if(lineArray.length > 1)
				{
					names [i]=lineArray[0];
					prices [i] = lineArray[1];
					description [i] = lineArray [2];
					i++;	
				}
				else
				{
				
					continue;
				}
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void pricing()
	{
		dtrpnSubtotal.setText("Subtotal:        \r\n       " + formatter.format(subtotal));
		dtrpnTax.setText("Tax: \r\n       " + formatter.format(tax));
		dtrpnTotal.setText("Total: \r\n       " + formatter.format(total));
	}
}





