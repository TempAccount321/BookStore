

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Delete extends AbstractAction
{
	private BookList booklist = new BookList();
	private JFrame 		frame =	null;
	
	public Delete(String commandAction,JFrame frame)
	{
		super(commandAction);
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(booklist.getList().size() != 0)
		{
			int n = JOptionPane.showConfirmDialog(
								frame,
								"Are you sure? you want to  delete this record 'book'",
            	                "Confirm delete",
                	            JOptionPane.YES_NO_OPTION);
        
        	if(n == JOptionPane.YES_OPTION)
        	{
        		deletebookRecord();
        	}
    	}
	}

	public void deletebookRecord()
	{		
		booklist.getList().remove(booklist.getRecord());
		
		if(booklist.getList().size() != 0)
		{
			Book book = (Book)booklist.getList().getLast();
	
			booklist.setRecord(booklist.getList().size() - 1);
			
			new BookRecordGUI(booklist.getRecord() + 1);
			new BookRecordGUI(book.getbookname(),
							 	 book.getauthorname(),
							 	 book.getId(),
							 	 book.getsubject(),
							 	 book.getprice());
		}
		else
		{
			new BookRecordGUI(false);
			new BookRecordGUI(0);
			new BookRecordGUI("","",0,"","");
		}
	
	}
}