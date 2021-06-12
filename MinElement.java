//program to get minimum element from stack in O(1) time
class Stack{
	int size = 10;
	int stk[];
	int top;
	Stack(){
		top = -1;
		stk = new int[size];
	}
	boolean isEmpty(){
		return (top == -1? true: false);
	}
	boolean isFull(){
		return (top == (size - 1) ? true : false);
	}
	void push(int x){
		if( isFull() ){
			System.out.println("Stack is full");
			return;
		}
		top++;
		stk[top] = x;
	}
	void pop(){
		if( isEmpty() ){
			System.out.println("Stack is empty");
			return;
		}
		int x = stk[top];
		top--;
	}
	void print(){
		for(int i = 0; i <= top; i++){
			System.out.println(stk[i]);
		}
	}
	int getTop(){
		return stk[top];
	}
	
}
public class MinElement{
	void push(Stack stk_main, Stack stk_aux, int x){
		 if( stk_main.isEmpty() && stk_aux.isEmpty()){
			 stk_main.push(x);
			 stk_aux.push(x);
		 }else{
			 int y = stk_aux.getTop();
			 if(x <= y){
				 stk_main.push(x);
				 stk_aux.push(x);
			 }else{
				 stk_main.push(x);
				 stk_aux.push(y);
			 }
		 }
	}
	void pop(Stack stk_main, Stack stk_aux){
		 stk_main.pop();
		 stk_aux.pop();
	}
	int getMinimumElement(Stack stk_main, Stack stk_aux){
		 return stk_aux.getTop();
	}
	
	public static void main(String args[]){
		Stack stk_main = new Stack();
		Stack stk_aux = new Stack();
		MinElement me = new MinElement();
		me.push(stk_main, stk_aux, 10);
		me.push(stk_main, stk_aux, 20);
		me.push(stk_main, stk_aux, 30);
		System.out.println("minimum element is:-"+stk_aux.getTop());
	}
}
