
public class Node 
{
	private int payload;
	private Node leftNode;
	private Node rightNode;
	
	public Node(int payload)
	{
		this.payload = payload;
		this.leftNode = null;
		this.rightNode = null;
	}

	public Node getLeftNode() 
	{
		return leftNode;
	}

	public void setLeftNode(Node leftNode) 
	{
		this.leftNode = leftNode;
	}

	public Node getRightNode() 
	{
		return rightNode;
	}

	public void setRightNode(Node rightNode) 
	{
		this.rightNode = rightNode;
	}

	public int getPayload() 
	{
		return payload;
	}
	
	public void addNode(Node n)
	{
		if (n.getPayload() <= this.getPayload())
		{
			if(this.leftNode == null)
			{
				this.leftNode = n;
			}
			else
			{
				this.leftNode.addNode(n);
			}
		}
		else 
		{
			if(this.rightNode == null)
			{
				this.rightNode = n;
			}
			else
			{
				this.rightNode.addNode(n);
			}
		}
	}
}
