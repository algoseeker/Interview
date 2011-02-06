import java.io.Console;

public class Node{
	public Node parent;
	public Node left;
	public Node right;
	public char label;

	public Node(Node parent,Node left, Node rigth, char label){
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.label = label;
	}
	
	public static void main(String[] args){
		Console console = System.console();
		String preorder = console.readLine("Enter the preorder traversal string:");
		Node root = null;
		Node current = null;
	
		for(int i = 0; i<preorder.length();i++){
			if(preorder.charAt(i)=='N'){
				if(root==null){
					root = new Node(null,null,null,'N');
					current = root;
				} else {
					if(current.left==null){
						Node temp = new Node(current,null,null,'N');
						current.left = temp;
						current = temp;
					} else if(current.right==null){
						Node temp = new Node(current,null,null,'N');
						current.right=temp;
						current = temp;
					}
				}
			} else {
				 if(root==null){
					root = new Node(null,null,null,'L');
					current = root;
					break;
				} else {
					if(current.left==null){
						Node temp = new Node(current,null, null, 'L');
						current.left = temp;
					} else if(current.right==null){
						Node temp = new Node(current, null,null,'L');
						current.right=temp;
						while(current!=null && current.right!=null){
							current = current.parent;
						}
					}
				}
			}
	}
	System.out.println("==== Preorder traversal of tree constructed ======");
	inorderTraversal(root);
	System.out.println();
	System.out.println("==================================================");
   	}	
	
	public static void inorderTraversal(Node root){
		if(root!=null){
		System.out.print(root.label);
		inorderTraversal(root.left);
		inorderTraversal(root.right);
		}
	}
}

