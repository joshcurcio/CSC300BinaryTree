
public class Driver {

	public static void main(String[] args) 
	{
		BinaryTree bt = new BinaryTree();
		bt.add(10);
		bt.add(13);
		bt.add(8);
		bt.add(9);
		bt.add(6);
		bt.add(12);
		bt.add(15);
		bt.add(14);
		bt.add(16);
		bt.displayInOrder();
		bt.displayPostOrder();
	}

}
