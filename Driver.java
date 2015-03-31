
public class Driver {

	public static void main(String[] args) 
	{
		BinaryTree bt = new BinaryTree();
		bt.add(10);
		bt.add(4);
		bt.add(16);
		bt.add(0);
		bt.add(8);
		bt.add(12);
		bt.add(81);
		bt.add(2);
		bt.add(5);
		bt.add(9);
		bt.add(11);
		bt.add(24);
		bt.add(1);
		bt.add(3);
		bt.add(38);
		System.out.println(bt.search(11));

		/*bt.displayPreOrder();
		bt.displayInOrder();
		bt.displayPostOrder();*/
	}

}
