

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.*;

public class Search extends AbstractAction
{
	private BookList bookList = new BookList();
	static private LinkedList list = new LinkedList();
	
	private JFrame 		frame;
	private JOptionPane dialog;
	
	public Search(String commandAction,JFrame frame)
	{
		super(commandAction);
		this.frame = frame;
		
		databaseWork();
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
            	
            
    /*        book.getbookname(),
			 book.getauthorname(),
			 book.getId(),
			 book.getsubject(),
			 book.getprice()
      */      
            
       /*     stt.execute("INSERT INTO booksinfo (bookid, bookname, authorname, subject, price) VALUES" + 
                    "( '"+tempBook.getId()+"' , '"+tempBook.getbookname()+"', '"+tempBook.getauthorname()+"', '"+tempBook.getsubject()+"', '"+tempBook.getprice()+"')");
*/
            /**
             * Query people entries with the lname 'Bloggs'
             */
            ResultSet res = stt.executeQuery("SELECT * FROM booksinfo");


            while (res.next())
            {
            	starter(res.getInt("bookid"), res.getString("bookname"), res.getString("authorname"), res.getString("subject"), res.getString("price"));
               // System.out.println(res.getInt("id") + " " + res.getInt("bookid")+ " " + res.getString("bookname")+ " " + res.getString("authorname")+ " " + res.getString("subject")+ " " + res.getString("price"));
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
	
	
	public static void starter(int id, String bookname, String authorname, String subject, String price){
		
		Book newbook = new Book(bookname,
			     authorname,
			     id,
			     subject,
			     price);
		
		list.addLast(newbook);
		
		BookList sl = new BookList(newbook,list);
		System.out.println(list.size() - 1);
		sl.setRecord(list.size() - 1);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Object[] search = {"ID #","BookName","AuthorName"};
		String s = (String)dialog.showInputDialog(
							  	  frame,
							  	  "Search By:",
							      "Search",
							      JOptionPane.PLAIN_MESSAGE,
							      null,
							      search,
							      "ID #");
		
		if(s == "ID #")
		{
			boolean foundID = false;
			String id = JOptionPane.showInputDialog(
									frame,
									"Search " + s +":",
									"Search",
									JOptionPane.PLAIN_MESSAGE);
			if(id != null && id.length() != 0){
				for(int i = 0; i < bookList.getSize(); i++){
					Book book = (Book)bookList.getList().get(i);										
					if(Integer.valueOf(id).equals(book.getId())){
						bookList(book,i);
						foundID = true;
					    break;
					}
				}
				if(foundID == false)
				{
					JOptionPane.showMessageDialog(frame,
												  "Searching,"+" " + id +" "+"does not exist.",
												  "Search",
												  JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(s == "BookName")
		{
			boolean foundBookName = false;
			String BookName = (String)JOptionPane.showInputDialog(
										   frame,
										   "Search " + s +":",
										   "Search",
										   JOptionPane.PLAIN_MESSAGE);
			if(BookName != null && BookName.length() != 0){
				for(int i = 0; i < bookList.getSize(); i++){
					Book book = (Book)bookList.getList().get(i);										
					if(BookName.equals(book.getbookname())){
						bookList(book,i);
						foundBookName = true;
					    break;
					}
				}
				if(foundBookName == false)
				{
					JOptionPane.showMessageDialog(frame,
												  "Searching,"+" " + BookName +" "+"does not exist.",
												  "Search",
												  JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(s == "AuthorName")
		{
			boolean foundAuthorName = false;
			String AuthorName = JOptionPane.showInputDialog(
										   frame,
										   "Search " + s +":",
										   "Search",
										   JOptionPane.PLAIN_MESSAGE);
			if(AuthorName != null && AuthorName.length() != 0){
				for(int i = 0; i < bookList.getSize(); i++){
					Book book = (Book)bookList.getList().get(i);										
					if(AuthorName.equals(book.getauthorname())){
						bookList(book,i);
						foundAuthorName = true;
					    break;
					}
				}
				if(foundAuthorName  == false)
				{
					JOptionPane.showMessageDialog(frame,
												  "Searching,"+" " + AuthorName +" "+"does not exist.",
												  "Search",
												  JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	public void bookList(Book book,int index)
	{
		book = (Book)bookList.getList().get(index);
		
		bookList.setRecord(index);

		new BookRecordGUI(bookList.getRecord() + 1);
		new BookRecordGUI(book.getbookname(),
			 		 		 book.getauthorname(),
			 		 		 book.getId(),
			 		 		 book.getsubject(),
			 		 		 book.getprice());
	}
}