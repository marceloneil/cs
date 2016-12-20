package oneil.marcel;
import java.util.ArrayList;
import java.util.Iterator;

public class StringStack  {
	private ArrayList<String> stack;
	
	public StringStack(){
		stack = new ArrayList<>();
	}
	
	public void push(String node){
		stack.add(node);
	}
	
	public String peek(){
		return stack.get(stack.size()-1);
	}
	
	public String pop(){
		return stack.remove(stack.size()-1);
	}
	
	public boolean isEmpty(){
		return stack.size()==0;
	}
	
	public int size(){
		return stack.size();
	}

}
