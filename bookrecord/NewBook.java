
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;

public class NewBook extends JFrame
{	
//	static private LinkedList list = new LinkedList();
	static private Book newbook;
		   
	private JPanel 		panel,mainPanel,txtLblPanel,btnPanel,iconPanel;
	
	private JLabel 		label,lblIcon;
	private JTextField 	bookname, authorname, idNum;
	private JButton		btnAdd,btnExt;
	
	private JComboBox 	subject,price;
	private JDialog		dialog;
	
	private String[] 	listOfsubject = { 
										 "[ SELECT SUBJECT ]",
										 "Arts",
										 "Literature",
										 "History",
										 "Management",
										 "Economics",
										 "INFORMATION TECHNOLOGY",
										 "Biology",
										 "ENGINEERING",
										 "Nature",
										 "Computer Science"
										};
										
	private String[]	pricelist 	 = {
										 "[ SELECT PRICE ]",
										 "$5",
										 "$10",
										 "$15",
										 "$20",
										 "$25"
										};
	
	public NewBook(JDialog dialog)
	{
		this();
		this.dialog = dialog;
	}
	
	public NewBook()
	{
		panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		txtLblPanel = new JPanel();
		iconPanel	= new JPanel();
		btnPanel	= new JPanel();
		
		addLayout();
						
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		mainPanel.add(txtLblPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(5,5)));
		mainPanel.add(btnPanel);
		
		panel.add(iconPanel);
		panel.add(mainPanel);		
	}
		
	public void addLayout()
	{
		JPanel lblPanel = new JPanel();
		lblPanel.setLayout(new GridLayout(5,1,5,1));
			lblPanel.add(label = new JLabel("Book Id :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Book Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Author Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Subject :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Price :",JLabel.RIGHT));
		
		JPanel txtPanel = new JPanel();
		txtPanel.setLayout(new GridLayout(5,1));	
			txtPanel.add(idNum 		= new JTextField(15));
			txtPanel.add(bookname	= new JTextField(15));
			txtPanel.add(authorname	= new JTextField(15));
			txtPanel.add(subject 	= new JComboBox(listOfsubject));
			txtPanel.add(price 	= new JComboBox(pricelist));
			
			idNum.setHorizontalAlignment(JTextField.CENTER);
			bookname.setHorizontalAlignment(JTextField.CENTER);
			authorname.setHorizontalAlignment(JTextField.CENTER);
			
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
			btnPanel.add(btnAdd = new JButton("Add"));
			btnPanel.add(btnExt = new JButton("Close"));
			
		txtLblPanel.setLayout(new BoxLayout(txtLblPanel, BoxLayout.LINE_AXIS));			
			txtLblPanel.add(lblPanel);
			txtLblPanel.add(Box.createRigidArea(new Dimension(5,5)));
			txtLblPanel.add(txtPanel);
			
		iconPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
			iconPanel.add(lblIcon = new JLabel(new ImageIcon("image/wi0062-32.gif"),JLabel.LEFT));					
			iconPanel.setBorder(BorderFactory.createEtchedBorder());

		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(!isEmptyTextBox()){
				//	if(!existIdNum(idNum.getText())){
						addNewbook();
						message();
						dispose();	
			/*		}else{
						JOptionPane.showMessageDialog(dialog,"ID number has already exist.","Message",JOptionPane.ERROR_MESSAGE);
					}
				*/}	
				else{
					JOptionPane.showMessageDialog(dialog,"Please fill up the textbox complete.","Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnExt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}
	
	public JPanel getPanel()
	{
		return panel;
	}

	public boolean isEmptyTextBox()
	{
		return(bookname.getText().length() == 0 ||
			   authorname.getText().length()  == 0 ||
			   idNum.getText().length() 	== 0 ||
			   subject.getSelectedIndex()    == 0 ||
			   price.getSelectedIndex() == 0);
	}
	
	public void message()
	{
		JOptionPane.showMessageDialog(dialog,"Successfull","Message",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void addNewbook()
	{
		newbook = new Book(bookname.getText().trim(),
							     authorname.getText().trim(),
							     Integer.valueOf(idNum.getText().trim()),
							     String.valueOf(subject.getSelectedItem()),
							     String.valueOf(price.getSelectedItem()));
		
		databaseWork(newbook);
		
/*		list.addLast(newbook);
		
		BookList sl = new BookList(newbook,list);
		System.out.println(list.size() - 1);
		sl.setRecord(list.size() - 1);
	*/	
	//	Book book = (Book)list.getLast();
		
		new BookRecordGUI(true);
		new BookRecordGUI(1);//list.size());
		new BookRecordGUI(newbook.getbookname(),
				newbook.getauthorname(),
				newbook.getId(),
				newbook.getsubject(),
				newbook.getprice());
	}
	
	public static void databaseWork(Book tempBook)
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
            	
            
    /*        book.getbookname(),
			 book.getauthorname(),
			 book.getId(),
			 book.getsubject(),
			 book.getprice()
      */      
            
            stt.execute("INSERT INTO booksinfo (bookid, bookname, authorname, subject, price) VALUES" + 
                    "( '"+tempBook.getId()+"' , '"+tempBook.getbookname()+"', '"+tempBook.getauthorname()+"', '"+tempBook.getsubject()+"', '"+tempBook.getprice()+"')");

            /**
             * Query people entries with the lname 'Bloggs'
             */
   /*         ResultSet res = stt.executeQuery("SELECT * FROM booksinfo WHERE id = 10");


            while (res.next())
            {
                System.out.println(res.getInt("id") + " " + res.getInt("bookid")+ " " + res.getString("bookname")+ " " + res.getString("authorname")+ " " + res.getString("subject")+ " " + res.getString("price"));
            }
            System.out.println("");
*/
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
    //        res.close();
            stt.close();
         //   prep.close();
            con.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	
	
	
/*	public boolean existIdNum(String idNumber)
	{
		boolean found = false;
		
		BookList s = new BookList();
		
		for(int i = 0; i < list.size(); i++)
		{
			Book id = (Book)s.getList().get(i);
			if(Integer.valueOf(idNumber).equals(id.getId()))
			{
				found = true;
				break;
			}
		}
		return found;	
	}
	*/	
	public void dispose()
	{
		dialog.setVisible(false);
		dialog.dispose();
	}
}