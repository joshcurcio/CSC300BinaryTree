
public class BinaryTree 
{
	private boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private BinaryTree parent;
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
	}

	private void updateDepths(int newDepth)
	{
		this.depth = newDepth;
		if (this.leftTree != null)
		{
			this.leftTree.updateDepths(this.depth+1);
		}
		if(this.rightTree != null)
		{
			this.rightTree.updateDepths(this.depth+1);
		}
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
	
	public void rotateRight(BinaryTree pivot)
	{
		BinaryTree pivRT = null;
		BinaryTree pivP = null;
		BinaryTree pivGP = null;
		
		if(pivot.rightTree != null)
		{
			pivRT = pivot.rightTree;
			pivot.rightTree = null;
		}
		pivP = pivot.parent;
		pivGP = (pivP == null?null:pivP.parent);
		//conditionally remove pivP from his parent if he had a parent
		if(pivGP != null)
		{
			if(pivGP.leftTree == pivP)
			{
				pivGP.leftTree = pivot;
			}
			else
			{
				pivGP.rightTree = pivot;
			}
		}
		else
		{
			//pivot is the new root node of the entire tree
			pivot.parent = null;
		}
		
		//always remove pivot from his parent
		if(pivP == null)
		{
			System.err.println("I have no parent..should I be calling rotate right?");
			return;
		}
		else
		{
			//should always get to this else
			//always replace pivP's left tree with whatever pivRT points to
			pivP.leftTree = pivRT;
		}
		
		//finally connect pivP as the right child of pivot and notify pivP who his new parent is
		
		pivot.rightTree = pivP;
		pivP.parent = pivot;
		
		pivot.updateDepths(pivot.depth-1);
	}
	
	public void rotateLeft(BinaryTree pivot)
	{
		BinaryTree pivLT = null;
		BinaryTree pivP = null;
		BinaryTree pivGP = null;
		
		if(pivot.leftTree != null)
		{
			pivLT = pivot.leftTree;
			pivot.leftTree = null;
		}
		pivP = pivot.parent;
		pivGP = (pivP == null?null:pivP.parent);
		//conditionally remove pivP from his parent if he had a parent
		if(pivGP != null)
		{
			if(pivGP.leftTree == pivP)
			{
				pivGP.leftTree = pivot;
			}
			else
			{
				pivGP.rightTree = pivot;
			}
		}
		else
		{
			//pivot is the new root node of the entire tree
			pivot.parent = null;
		}
		
		//always remove pivot from his parent
		if(pivP == null)
		{
			System.err.println("I have no parent..should I be calling rotate left?");
			return;
		}
		else
		{
			//should always get to this else
			//always replace pivP's right tree with whatever pivRT points to
			pivP.rightTree = pivLT;
		}
		
		//finally connect pivP as the left child of pivot and notify pivP who his new parent is
		
		pivot.leftTree = pivP;
		pivP.parent = pivot;
		
		pivot.updateDepths(pivot.depth-1);
	}
	
	public void rebalance()
	{
		
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
					this.leftTree.parent = this;
				}
				this.leftTree.add(value);
			}
			else
			{
				if (this.rightTree == null)
				{
					this.rightTree = new BinaryTree(this.depth + 1);
					this.rightTree.parent = this;
				}
				this.rightTree.add(value);
			}
		}
		while (!this.isBalanced())
		{
			//rebalance();
		}
	}
}
