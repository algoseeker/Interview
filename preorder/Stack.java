public class Stack{
ListNode top=null;

public void push(Object o){
	ListNode temp = new ListNode(o,top);
	top = temp;
}

public Object pop(){
	if(isEmpty())
	   return null;
	ListNode temp = top;
	top = top.next;
	return temp.val;
}
public boolean isEmpty(){
	return top == null;
}
}
