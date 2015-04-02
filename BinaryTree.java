
public class BinaryTree 
{
	private boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private int depth;


	public BinaryTree()
	{
		this(0);
	}

	private BinaryTree(int depth)
	{
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
		this.depth = depth;
		this.depth = depth;
	}

	public boolean search(int value)
	{	
		if(this.isEmpty)
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
		System.out.println(this.payload + " : " + this.depth);
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

	private int getMaxDepth()
	{
		if(this.leftTree == null && this.rightTree == null)
		{
			return this.depth;
		}
		else if(this.leftTree == null)
		{
			return this.rightTree.getMaxDepth();
		}
		else if(this.rightTree == null)
		{
			return this.leftTree.getMaxDepth();
		}
		else
		{
			return Math.max(this.leftTree.getMaxDepth(), this.rightTree.getMaxDepth());
		}
	}

	public boolean isBalanced()
	{
		if(this.isEmpty)
		{
			return true;
		}
		else
		{
			//boolean-expr?true-val:false-val
			int currMaxLeftDepth = this.leftTree == null?0:this.leftTree.getMaxDepth();
			int currMaxRightDepth = this.rightTree == null?0:this.rightTree.getMaxDepth();
			//System.out.println("Max Left = " + currMaxLeftDepth);
			//System.out.println("Max Right = " + currMaxRightDepth);
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) <= 1;
		}
	}
	
	public BinaryTree rotateRight(BinaryTree parent)
	{
		BinaryTree child = parent.leftTree;
		child.rightTree = parent;
		parent.leftTree = null;
		this.leftTree = child;
		return child;
	}
	
	public BinaryTree rotateLeft(BinaryTree parent)
	{
		BinaryTree child = parent.rightTree.rightTree;
		parent.rightTree = child;
		child.leftTree = parent;
		parent.rightTree = null;
		return child;
	}
	
	public void rebalance()
	{
		if (this.leftTree.getMaxDepth() >= this.rightTree.getMaxDepth())
		{
			if(this.leftTree.getMaxDepth() == this.getMaxDepth()- 2)
			{
				if(this.rightTree == null)
				{
					rotateRight(this);
				}
				else
				{
					rotateRight(this);
					rotateLeft(rotateRight(this));
				}
			}
			else
			{
				this.leftTree.rebalance();
			}
		}
		else
		{
			if(this.rightTree.getMaxDepth() == this.getMaxDepth() - 1)
			{
				if(this.leftTree == null)
				{
					rotateLeft(this);
				}
				else
				{
					rotateLeft(this);
					rotateRight(rotateLeft(this));
				}
			}
			else 
			{
				this.rightTree.rebalance();
				
			}
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
					this.leftTree = new BinaryTree(this.depth + 1);
				}
				this.leftTree.add(value);
			}
			else
			{
				if (this.rightTree == null)
				{
					this.rightTree = new BinaryTree(this.depth + 1);
				}
				this.rightTree.add(value);
			}
		}
		while (!this.isBalanced())
		{
			rebalance();
		}
	}
}
