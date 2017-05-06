

import java.util.*;
import java.awt.event.*;

import javax.swing.*;

public class First extends AbstractAction
{	
	private BookList bookList = new BookList();
	
	public First(String command, ImageIcon icon)
	{
		super(command,icon);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			Book book = (Book)bookList.getList().getFirst();
		
			bookList.setRecord(0);
					
			new BookRecordGUI(1);			
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