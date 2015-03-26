
public class BinaryTree 
{
	private Node root;
	private Node parent;
	
	public BinaryTree()
	{
		this.root = null;
		this.parent = null;
	}

	public void displayInOrder()
	{
		System.out.println("*******In Order********");
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			inOrder(this.root);
		}
	}
	
	public void inOrder(Node n)
	{
		if(n != null)
		{   
			System.out.println(n.getPayload() + " ");
			inOrder(n.getLeftNode());
			inOrder(n.getRightNode());
		}	
	}
	
	public void displayPostOrder()
	{
		System.out.println("*******Post Order********");
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			postOrder(this.root);
		}
	}
	public void postOrder(Node n)
	{
		if(n != null)
		{   
			postOrder(n.getLeftNode());
			System.out.println(n.getPayload() + " ");
			postOrder(n.getRightNode());
		}
	}
	
	public void add(int value)
	{
		Node theNode = new Node(value);
		if (this.root == null)
		{
			this.root = theNode;
		}
		else
		{
			this.root.addNode(theNode);
		}
	}
}
