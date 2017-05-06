
 
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Add extends AbstractAction
{
	private JDialog 	dialog;
	private JFrame		frame;
	
	public Add(String commandAction,JFrame frame)
	{
		super(commandAction);
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		addNewStudent();
	}
	
	public void addNewStudent()
	{
		dialog = new JDialog(frame,"Add Book Record",true);
		
		dialog.setContentPane(new NewBook(dialog).getPanel());
		dialog.pack();
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
	}
}