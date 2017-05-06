

public class Book extends BookBasic
{
	private Integer id;
	private String subject;
	private String price;
	
	public Book(String bookname, String authorname, Integer id, String subject, String price)
	{
		super(bookname,authorname);
		this.id 	= id;
		this.subject = subject;
		this.price 	= price;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public void Setsubject(String subject)
	{
		this.subject = subject;
	}
	
	public void setprice(String price)
	{
		this.price = price;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public String getsubject()
	{
		return subject;
	}
	
	public String getprice()
	{
		return price;
	}
}