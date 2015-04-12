public class BinaryTree 
{	
	//private Node root;
	private Boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private BinaryTree parent;
	private int depth;

	public BinaryTree()
	{
		this(0); //this is how we call our own local constructor		
	}

	private BinaryTree(int depth) //setting up the intial variables
	{
		//this.root = null;
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
		this.depth = depth;
		this.parent = null; //every ROOT node will not have a parent so we need to set it's parent to null
	}
	private void  updateDepths(int newDepth)
	{
		this.depth = newDepth;
		if(this.leftTree != null)
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
		//return true if value is in the tree
		//return false if value is not in the tree
		if(this.isEmpty)
		{
			return false;
		}
		else
		{
			if(this.payload == value)
			{
				return true;
			}
			else
			{
				if(value < payload)
				{
					//check the left
					if(this.leftTree == null)
					{
						return false;
					}
					else
					{
						return this.leftTree.search(value);
					}
				}
				else
				{
					//check the right
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

	public void visitPreOrder()
	{
		System.out.println(this.payload + " : " + this.depth);
		if(this.leftTree != null)
		{
			this.leftTree.visitPreOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPreOrder();
		}
	}

	public void visitPostOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitPostOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPostOrder();
		}
		System.out.println(this.payload + " : " + this.depth);
	}

	public void displayInOrder()
	{
		System.out.println("**** In Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitInOrder();
		}

	}

	public void displayPreOrder()
	{
		System.out.println("**** Pre Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPreOrder();
		}
		
	}

	public void displayPostOrder()
	{
		System.out.println("**** Post Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPostOrder();
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
			//get the depth of the left
			int currMaxLeftDepth = this.leftTree == null?0:this.leftTree.getMaxDepth(); //inline if statement see 54:15 in video csc 300 3/31/15 //boolean-expr?true-val:false-val
			int currMaxRightDepth = this.rightTree == null?0:this.rightTree.getMaxDepth();
			System.out.println("Max Left = " + currMaxLeftDepth);
			System.out.println("Max Right = " + currMaxRightDepth);
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) <= 1;
		}	
	}

	private void rotateRight(BinaryTree pivot)
	{
		//System.out.println("rotateRight");
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
			pivot.parent = pivGP;
		}
		else
		{
			//pivot is the new root tree of the entire tree
			pivot.parent = null;
		}
		//always remove pivot from his parent
		if(pivP == null)
		{
			System.err.println("I have no parent...should I be calling rotate right?");
			return;
		}
		else
		{
			//should always get into this else
			//always replace pivP's left tree with whatever pivRT points to
			pivP.leftTree = pivRT;
		}
		//finally connect pivP as the right child of pivot and notify pivP who his new parent is
		pivot.rightTree = pivP;
		pivP.parent = pivot;

		//update all of the depths under pivot
		pivot.updateDepths(pivot.depth-1);
	}

	private void rotateLeft(BinaryTree pivot)
	{
		//System.out.println("rotateLeft");
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
			pivot.parent = pivGP;
		}
		else
		{
			//pivot is the new root tree of the entire tree
			pivot.parent = null;
		}
		//always remove pivot from his parent
		if(pivP == null)
		{
			System.err.println("I have no parent...should I be calling rotate left?");
			return;
		}
		else
		{
			//should always get into this else
			//always replace pivP's right tree with whatever pivLT points to
			pivP.rightTree = pivLT;
		}
		//finally connect pivP as the left child of pivot and notify pivP who his new parent is
		pivot.leftTree = pivP;
		pivP.parent = pivot;		

		//update all of the depths under pivot
		pivot.updateDepths(pivot.depth-1);
	}

	public void add(int value)
	{
		if(this.isEmpty)
		{
			this.payload = value;
			this.isEmpty = false;
		}
		else
		{
			if(value <= this.payload)
			{
				if(this.leftTree == null)
				{
					this.leftTree = new BinaryTree(this.depth+1);
					this.leftTree.parent = this;
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree(this.depth+1);
					this.rightTree.parent = this;
				}
				this.rightTree.add(value);
			}
		}

		//am I the top level root tree?
		if(this.parent == null)
		{
			//do we need to rebalance?
			if(!this.isBalanced())
			{
				if(this.leftTree == null)
				{
					//the right tree is out of balance
					if (this.rightTree.leftTree == null)
					{
						this.rightTree.rotateLeft(this.rightTree);
					}
					else
					{
						this.rightTree.rotateRight(this.rightTree.leftTree);
						this.rightTree.rotateLeft(this.rightTree);
					}
				}
				else if(this.rightTree == null)
				{
					//the left tree is out of balance
					if (this.leftTree.rightTree == null)
					{
						this.rightTree.rotateLeft(this.leftTree);
					}
					else
					{
						this.leftTree.rotateLeft(this.leftTree.rightTree);
						this.leftTree.rotateRight(this.leftTree);
					}
				}
				else
				{
					//we know we have a left and a right tree
					if(this.leftTree.getMaxDepth() > this.rightTree.getMaxDepth())
					{
						if (this.leftTree.rightTree == null)
						{
							this.rightTree.rotateLeft(this.leftTree.leftTree);
						}
						else if(this.leftTree.rightTree != null && this.leftTree.leftTree != null)
						{
							this.leftTree.rotateRight(this.leftTree);
						}
						else
						{
							this.leftTree.rotateLeft(this.leftTree.rightTree);
							this.leftTree.rotateRight(this.leftTree);
						}
					}
					else
					{
						if (this.rightTree.leftTree == null)
						{
							this.rightTree.rotateLeft(this.rightTree.rightTree);
						}
						else if(this.rightTree.leftTree != null && this.rightTree.rightTree != null)
						{
							this.rightTree.rotateLeft(this.rightTree);
						}
						else
						{
							this.rightTree.rotateRight(this.rightTree.leftTree);
							this.rightTree.rotateLeft(this.rightTree);
						}
					}
				}
			}
		}
	}
}