
 
import java.awt.event.*;

import javax.swing.*;

public class Next extends AbstractAction
{
	BookList bookList = new BookList();
	private int size;
	

	public Next(String command,ImageIcon icon)
	{
		super(command,icon);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try{
			if(bookList.getRecord() < bookList.getSize())
				{
					int i = bookList.getRecord();
					Book book = (Book)bookList.getList().get(i + 1);
			
					bookList.setRecord(++i);
			
					new BookRecordGUI(1 + i);			
					new BookRecordGUI(book.getbookname(),
									 	 book.getauthorname(),
									 	 book.getId(),
										 book.getsubject(),
				 						 book.getprice());
			}
		}
		catch(Exception e)
		{}
	}
}