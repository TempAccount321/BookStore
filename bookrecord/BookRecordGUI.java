
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class BookRecordGUI extends JPanel
{
	static private final int BUTTON_INDEX = 8;

	//booksdb321
	//nimda321
	//admin1
	/*Database: booksdb321
	Username: nimda321
	*/
	
	
	static private JFrame 		frame;
	static private JTextField 	bookName, authorName, idNum, subject, price;
	static private JLabel		numRecord;
	static private JButton[] 	button = new JButton[BUTTON_INDEX];

	private JPanel 		mainPanel, iconPanel,txtLblPanel;
	private JPanel 		symPanel, comPanel;
	private JLabel 		label, lblIcon;
	private JDialog 	dialog;

	private JButton		btnCount;
	private Action 		add,delete,search,edit,first,last,prev,next,count;

	public BookRecordGUI(JFrame frame)
	{
		add 	= new Add("Add",frame);
		delete	= new Delete("Delete",frame);
		search  = new Search("Search",frame);
		edit	= new Edit("Edit",frame);

		first	= new First(null,new ImageIcon("image/first.gif"));
		last	= new Last(null, new ImageIcon("image/last.gif"));
		prev	= new Prev(null, new ImageIcon("image/prev.gif"));
		next	= new Next(null, new ImageIcon("image/next.gif"));

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		JToolBar toolBar = new JToolBar("ToolBar");
		toolBar.setFloatable(false);
        toolBar.setRollover(true);

		txtLblPanel = new JPanel();
		iconPanel	= new JPanel();
		symPanel	= new JPanel();
		comPanel	= new JPanel();

		toolBar.add(button[0] = new JButton(first));
		toolBar.add(button[1] = new JButton(prev));
		toolBar.add(button[2] = new JButton(next));
		toolBar.add(button[3] = new JButton(last));
		toolBar.addSeparator();
		toolBar.add(numRecord = new JLabel("Record #: 0"));

		button[4] = new JButton(add);
		button[5] = new JButton(edit);
		button[6] = new JButton(search);
		button[7] = new JButton(delete);

		button[5].setEnabled(false);
		button[6].setEnabled(false);
		button[7].setEnabled(false);

		button[4].setPreferredSize(new Dimension(80,26));
		button[5].setPreferredSize(new Dimension(80,26));
		button[6].setPreferredSize(new Dimension(80,26));
		button[7].setPreferredSize(new Dimension(80,26));

		button[0].setToolTipText("First");
		button[1].setToolTipText("Previous");
		button[2].setToolTipText("Next");
		button[3].setToolTipText("Last");
		
		button[5].setVisible(false);

		addLayout();

		mainPanel 	= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createTitledBorder("Book Information"),
							BorderFactory.createEmptyBorder(5,5,5,5)));

		mainPanel.add(txtLblPanel);

		JPanel layout = new JPanel();
			layout.setLayout(new BoxLayout(layout, BoxLayout.PAGE_AXIS));
			layout.add(Box.createRigidArea(new Dimension(5,5)));
			layout.add(iconPanel);
			layout.add(Box.createRigidArea(new Dimension(5,5)));
			layout.add(mainPanel);
			layout.add(Box.createRigidArea(new Dimension(5,5)));
			layout.add(comPanel);

		add(toolBar, BorderLayout.PAGE_START);
		add(layout,	 BorderLayout.PAGE_END);

	}

	public BookRecordGUI(boolean tF)
	{
		button[5].setEnabled(tF);
		button[6].setEnabled(tF);
		button[7].setEnabled(tF);
	}

	public BookRecordGUI(int n)
	{
		numRecord.setText("Record #: " + String.valueOf(n));
	}

	public BookRecordGUI(String bookName1, String authorName1, Integer num, String c, String price1)
	{
		idNum.setText(String.valueOf(num));
		bookName.setText(bookName1);
		authorName.setText(authorName1);
		subject.setText(c);
		price.setText(price1);
	}

	public void addLayout()
	{
		JPanel lblPanel = new JPanel();
		lblPanel.setLayout(new GridLayout(5,1,25,5));
			lblPanel.add(label = new JLabel("Book Id :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Book Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Author Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Subject :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Price :",JLabel.RIGHT));

		JPanel txtPanel = new JPanel();
		txtPanel.setLayout(new GridLayout(5,1,25,0));
			txtPanel.add(idNum 		= new JTextField(25));
			txtPanel.add(bookName	= new JTextField(25));
			txtPanel.add(authorName   = new JTextField(25));
			txtPanel.add(subject 	= new JTextField(25));
			txtPanel.add(price 	= new JTextField(25));

			idNum.setHorizontalAlignment(JTextField.CENTER);
			bookName.setHorizontalAlignment(JTextField.CENTER);
			authorName.setHorizontalAlignment(JTextField.CENTER);
			subject.setHorizontalAlignment(JTextField.CENTER);
			price.setHorizontalAlignment(JTextField.CENTER);

			idNum.setFocusable(false);
			bookName.setFocusable(false);
			authorName.setFocusable(false);
			subject.setFocusable(false);
			price.setFocusable(false);

		txtLblPanel.setLayout(new BoxLayout(txtLblPanel, BoxLayout.LINE_AXIS));
			txtLblPanel.add(lblPanel);
			txtLblPanel.add(Box.createRigidArea(new Dimension(5,5)));
			txtLblPanel.add(txtPanel);
			txtLblPanel.setPreferredSize(new Dimension(350,130));

		comPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
			for(int i = 4; i < button.length; i++){
				comPanel.add(button[i]);
				button[i].setFont(new Font("sans-serif",Font.PLAIN,10));
			}

		iconPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
			iconPanel.add(lblIcon = new JLabel(new ImageIcon("image/wi0054-32.gif")));
			iconPanel.setBorder(BorderFactory.createEtchedBorder());
	}

	public static void initcode()
	{
		JFrame frame = new JFrame("Book Record");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setContentPane(new BookRecordGUI(frame));

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
	}

	public static void main(String[] args)
	{
		
		try
		{
	/*		Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/cdcol","root", "");
			System.out.print("Database is connected !");
			conn.close();
		*/
			
			//databaseWork();
		
		}
		catch(Exception e)
		{
			System.out.print("Do not connect to DB - Error:"+e);
		}
		
		
		
		Runnable doRun = new Runnable(){
			public void run(){
				initcode();
			}
		};

        javax.swing.SwingUtilities.invokeLater(doRun);
	}
	
	 public static void databaseWork()
	    {

	        /**
	         * 3306 is the default port for MySQL in XAMPP. Note both the 
	         * MySQL server and Apache must be running. 
	         */
	        String url = "jdbc:mysql://localhost:3306/cdcol";

	        /**
	         * The MySQL user.
	         */
	        String user = "root";

	        /**
	         * Password for the above MySQL user. If no password has been 
	         * set (as is the default for the root user in XAMPP's MySQL),
	         * an empty string can be used.
	         */
	        String password = "";

	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            Connection con = DriverManager.getConnection(url, user, password);

	            java.sql.Statement stt = con.createStatement();

	            /**
	             * Create and select a database for use. 
	             */
	   /*         stt.execute("CREATE DATABASE IF NOT EXISTS test");
	            stt.execute("USE test");
*/
	            /**
	             * Create an example table
	             */
	        /*    stt.execute("DROP TABLE IF EXISTS people");
	            stt.execute("CREATE TABLE people (" +
	                    "id BIGINT NOT NULL AUTO_INCREMENT,"
	                    + "fname VARCHAR(25),"
	                    + "lname VARCHAR(25),"
	                    + "PRIMARY KEY(id)"
	                    + ")");
*/
	            /**
	             * Add entries to the example table
	             */
	            	            
	            
	            stt.execute("INSERT INTO booksinfo (bookid, bookname, authorname, subject, price) VALUES" + 
	                    "('14', 'UpHill', 'Tim cook', 'Geography', '$15')");

	            /**
	             * Query people entries with the lname 'Bloggs'
	             */
	            ResultSet res = stt.executeQuery("SELECT * FROM booksinfo WHERE id = 10");

	            /**
	             * Iterate over the result set from the above query
	             */
	            while (res.next())
	            {
	                System.out.println(res.getInt("id") + " " + res.getInt("bookid")+ " " + res.getString("bookname")+ " " + res.getString("authorname")+ " " + res.getString("subject")+ " " + res.getString("price"));
	            }
	            System.out.println("");

	            /**
	             * Same as the last query, but using a prepared statement. 
	             * Prepared statements should be used when building query strings
	             * from user input as they protect against SQL injections
	             */
	      /*      java.sql.PreparedStatement prep = con.prepareStatement("SELECT * FROM people WHERE lname = ?");
	            prep.setString(1, "Bloggs");

	            res = prep.executeQuery();
	            while (res.next())
	            {
	                System.out.println(res.getString("fname") + " " + res.getString("lname"));
	            }
*/
	            /**
	             * Free all opened resources
	             */
	            res.close();
	            stt.close();
	         //   prep.close();
	            con.close();

	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	
}