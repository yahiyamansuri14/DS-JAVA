class LinkedList{
	public static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	Node head;
	LinkedList(){
		head = null;
	}
	public int length(){
		Node temp = head;
		int count = 0;
		while(temp != null){
			temp = temp.next;
			count++;
		}
		System.out.println("length is:-"+count);
		return count;
	}
	public void create(int arr[], int size){
		Node last, temp;
		head = new Node(arr[0]);
		last = head;
		for(int i = 1; i < arr.length; i++){
			temp = new Node(arr[i]);
			last.next = temp;
			last = temp;
		}
	}
	public void insert(int data, int index){
		if(index < 0 || index > length()){
			System.out.println("Invalid Index");
			return;
		}
		//first create the node
		Node newnode = new Node(data);
		Node temp = head;
		if(index == 0){
			newnode.next = head;
			head = newnode;
		}else{
			
			for(int i = 0; i < index - 1; i++){
				temp = temp.next;
			}
			newnode.next = temp.next;
			temp.next = newnode;
		}
	}
	public void print(){
		if(head == null){
			System.out.println("Linked List is empty");
			return;
		}
		Node temp = head;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
		
	}
	public static void main(String args[]){
		 System.out.println("Linked List using java");
		 LinkedList ll = new LinkedList();
		 int arr[] = {1,2,3,4,5};
		 ll.create(arr,arr.length);
		 ll.insert(6,2);
		 ll.print();
	}

}
