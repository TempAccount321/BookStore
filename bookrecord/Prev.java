
 
import java.awt.event.*;
import javax.swing.*;

public class Prev extends AbstractAction
{
	BookList bookList = new BookList();
	
	public Prev(String command,ImageIcon icon)
	{
		super(command,icon);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			prevbookRecord();
		}
		catch(Exception e)
		{}
	}
	
	public void prevbookRecord()
	{
		if(bookList.getRecord() != 0)
		{
			int i = bookList.getRecord();
			
				Book book = (Book)bookList.getList().get(i - 1);
				bookList.setRecord(--i);
			
				new BookRecordGUI(i + 1);			
				new BookRecordGUI(book.getbookname(),
							 		 book.getauthorname(),
							 		 book.getId(),
							 		 book.getsubject(),
					 				 book.getprice());
		}
	}
}