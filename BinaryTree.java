
public class BinaryTree 
{
	private boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;

	
	public BinaryTree()
	{
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
	}
	
	public boolean search(int value)
	{	
		if(isEmpty)
		{
			return false;
		}
		else
		{
			if(value == this.payload)
			{
				return true;
			}
			else if (value < this.payload)
			{
				if(this.leftTree == null)
				{
					return false;
				}
				else
				{
					return this.leftTree.search(value);
				}
			}
			else if (value > this.payload)
			{
				if(this.rightTree == null)
				{
					return false;
				}
				else
				{
					return this.rightTree.search(value);
				}
			}
		}
		return false;
	}
	

	public void displayInOrder()
	{
		System.out.println("*******In Order********");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			visitInOrder();
		}
	}
	
	private void visitInOrder()
	{
		if(this.leftTree != null)
		{   
			this.leftTree.visitInOrder();
		}
		System.out.println(this.payload);
		if(this.rightTree != null)
		{   
			this.rightTree.visitInOrder();
		}		
	}
	
	public void displayPostOrder()
	{
		System.out.println("*******Post Order********");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			visitPostOrder();
		}
	}
	
	private void visitPostOrder()
	{
		if(this.leftTree != null)
		{   
			this.leftTree.visitPostOrder();
		}
		if(this.rightTree != null)
		{   
			this.rightTree.visitPostOrder();
		}		
		System.out.println(this.payload);
	}
	
	public void displayPreOrder()
	{
		System.out.println("*******Pre Order********");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			visitPreOrder();
		}
	}
	
private void visitPreOrder()
	{
		System.out.println(this.payload);
		if(this.leftTree != null)
		{   
			this.leftTree.visitPreOrder();
		}
		if(this.rightTree != null)
		{   
			this.rightTree.visitPreOrder();
		}		
	}
	
	public void add(int value)
	{
		if (this.isEmpty)
		{
			this.payload = value;
			this.isEmpty = false;
		}
		else
		{
			if (value <= this.payload)
			{
				if (this.leftTree == null)
				{
					this.leftTree = new BinaryTree();
				}
				this.leftTree.add(value);
			}
			else
			{
				if (this.rightTree == null)
				{
					this.rightTree = new BinaryTree();
				}
				this.rightTree.add(value);
			}
		}
	}
}
