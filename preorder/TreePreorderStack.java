public class TreePreorderStack{

public static void main(String[] args){
	Stack s = new Stack();
	String t = args[0];
	
	for(int i = t.length()-1; i>=0;i--){
		if(t.charAt(i)=='N'){
			TreeNode left = (TreeNode) s.pop();
			TreeNode right = (TreeNode) s.pop();
			TreeNode root = new TreeNode(left,right,'N');
			s.push(root);
		} else if(t.charAt(i)=='L'){
			TreeNode leaf = new TreeNode(null,null,'L');
			s.push(leaf);
		}
	}
	TreeNode root = (TreeNode) s.pop();
	if(root!=null){
		String traversal = preorder(root);
		if(traversal.equals(args[0]))
		  System.out.println("Success");
	}	
}

public static String preorder(TreeNode t){
	if(t==null)
	 	return "";
	else
		return new StringBuilder().append(t.label).append(preorder(t.left)).append(preorder(t.right)).toString();
}	
}
