
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EditProfile extends JPanel
{	
	private BookList bookList = new BookList();
	private Book 	book;
	
	private JPanel 		panel,mainPanel,txtLblPanel,btnPanel,iconPanel;
	
	private JLabel 		label,lblIcon;
	private JTextField 	bookname, authorname, idNum;
	private JButton		btnSave,btnExt;
	
	private JComboBox 	subject,price;
	private JDialog		dialog;
	
	private String[] 	listofbooks = { 
										 "SELECT subject",
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
										 "$5",
										 "$10",
										 "$15",
										 "$20",
										 "$25"
										};	
	private int index;
	
	public EditProfile(Book book,JDialog dialog,int index)
	{
		this();
		this.dialog  = dialog;
		this.index   = index;
		
		bookname.setText(book.getbookname());
		authorname.setText(book.getauthorname());
		idNum.setText(String.valueOf(book.getId()));
		subject.setSelectedItem(book.getsubject());
		price.setSelectedItem(book.getprice());
	}
	
	public EditProfile()
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
	
	public JPanel getPanel()
	{
		return panel;
	}
		
	public void addLayout()
	{
		JPanel lblPanel = new JPanel();
		lblPanel.setLayout(new GridLayout(5,1,5,1));
			lblPanel.add(label = new JLabel("Book Id :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("First Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Last Name :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("subject :",JLabel.RIGHT));
			lblPanel.add(label = new JLabel("Year Level :",JLabel.RIGHT));
		
		JPanel txtPanel = new JPanel();
		txtPanel.setLayout(new GridLayout(5,1));	
			txtPanel.add(idNum 		= new JTextField(15));
			txtPanel.add(bookname	= new JTextField(15));
			txtPanel.add(authorname	= new JTextField(15));
			txtPanel.add(subject 	= new JComboBox(listofbooks));
			txtPanel.add(price 	= new JComboBox(pricelist));
			
			idNum.setHorizontalAlignment(JTextField.CENTER);
			bookname.setHorizontalAlignment(JTextField.CENTER);
			authorname.setHorizontalAlignment(JTextField.CENTER);
			
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
			btnPanel.add(btnSave = new JButton("Save"));
			btnPanel.add(btnExt  = new JButton("Close"));
			
		txtLblPanel.setLayout(new BoxLayout(txtLblPanel, BoxLayout.LINE_AXIS));			
			txtLblPanel.add(lblPanel);
			txtLblPanel.add(Box.createRigidArea(new Dimension(5,5)));
			txtLblPanel.add(txtPanel);
			
		iconPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
			iconPanel.add(lblIcon = new JLabel(new ImageIcon("image/wi0062-32.gif"),JLabel.LEFT));					
			iconPanel.setBorder(BorderFactory.createEtchedBorder());

		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int n = JOptionPane.showConfirmDialog(
									dialog,
									"Continue save?",
									"Confirm save",
									JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION)
				{
					save();
					message();
					dispose();
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
	
	public void save()
	{
		book = new Book(bookname.getText().trim(),
							  authorname.getText().trim(),
							  Integer.valueOf(idNum.getText().trim()),
							  String.valueOf(subject.getSelectedItem()),
							  String.valueOf(price.getSelectedItem()));
		
		bookList.getList().set(index,book);
		
		Book update = (Book)bookList.getList().get(index);
		new BookRecordGUI(update.getbookname(),
							 update.getauthorname(),
							 update.getId(),
							 update.getsubject(),
							 update.getprice());
	}
	
	public void message()
	{
		JOptionPane.showMessageDialog(
					dialog,
					"Successfull.",
					"Message",
					JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void dispose()
	{
		dialog.setVisible(false);
		dialog.dispose();
	}
}