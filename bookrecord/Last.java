
 
import java.awt.event.*;

import javax.swing.*;

public class Last extends AbstractAction
{
	BookList bookList = new BookList();
	
	public Last(String command,ImageIcon icon)
	{
		super(command,icon);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			Book book = (Book)bookList.getList().getLast();
		
			bookList.setRecord(bookList.getList().size() - 1);
		
			new BookRecordGUI(bookList.getSize());
			new BookRecordGUI(book.getbookname(),
						 	     book.getauthorname(),
					 	    	 book.getId(),
						 	     book.getsubject(),
					 			 book.getprice());
		}
		catch(Exception e)
		{}
	}
}