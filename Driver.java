
public class Driver 
{

	public static void main(String[] args) 
	{
		BinaryTree bt = new BinaryTree();
		bt.add(6);
		bt.add(5);
		bt.add(7);
		bt.displayInOrder();
		bt.add(8);
		bt.displayInOrder();
		bt.add(9);
		bt.displayInOrder();
		bt.add(10);

		bt.displayInOrder();
		
		System.out.println(bt.isBalanced());
	}
}


