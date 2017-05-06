
 
import java.awt.event.*;

import javax.swing.*;

public class Edit extends AbstractAction
{
	BookList	bookList = new BookList();
	Book 	book		= null;
	
	private JFrame  frame   = null;
	private JDialog dialog  = null;
	
	public Edit(String commandAction,JFrame frame)
	{
		super(commandAction);
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			if(bookList.getList().getFirst() != null)
			{
				editbookProfile();
			}
			else
			{
				JOptionPane.showMessageDialog(
						frame,
						"Empty book record.",
						"Edit",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(
						frame,
						"Empty book record.",
						"Edit",
						JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void editbookProfile()
	{
		int i = bookList.getRecord();
		book = (Book)bookList.getList().get(i);

		bookList.setRecord(i);
	
		dialog = new JDialog(frame,"Edit Book Profile",true);
		dialog.setContentPane(new EditProfile(book,dialog,i).getPanel());
		dialog.pack();
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
	}
}