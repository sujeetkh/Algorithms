package algorithms.stack;

public class Stack {
	int top;
	int[] data;

	public Stack(int maxSize) {
		top = -1;
		data = new int[maxSize];
	}

	public void push(int value) {
		if (top + 1 >= data.length) {
			System.out.println("Stack is Full.");
			return;
		}
		top = top + 1;
		data[top] = value;
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack is Empty.");
			return -1;
		}
		int value = data[top];
		top = top - 1;
		return value;
	}

	public void print() {
		if(top==-1)
		{
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("Stack values: ");
		for (int i = top; i>=0; i--)
			System.out.println(data[i]);
	}

	public static void main(String[] args) {
		Stack st=new Stack(5);
		st.push(10);
		st.push(25);
		st.push(43);
		st.print();
		st.push(25);
		st.push(25);
		st.push(463);
		st.print();
	}

}
