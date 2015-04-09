
public class Driver {

	public static void main(String[] args) 
	{
		BinaryTree bt = new BinaryTree();
		bt.add(5);
		bt.add(4);
		bt.add(2);
		bt.add(1);
		bt.rotateLeft(bt);
		System.out.println(bt.isBalanced());
		
		//System.out.println(bt.search(11));
		//bt.displayPreOrder();
		//bt.displayInOrder();
		//bt.displayPostOrder();
	}
}
