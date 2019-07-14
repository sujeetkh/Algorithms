package algorithms.contest;

import algorithms.linkedlist.SList;
import algorithms.linkedlist.SList.Node;

public class AddTwoNumberAsLinkedList {
	public static SList add(SList num1, SList num2) {
		num1.reverse();
		num2.reverse();
		Node list1 = num1.getHead();
		Node list2 = num2.getHead();
		int carry = 0, curSum;
		SList res = new SList();
		while (list1 != null && list2 != null) {
			curSum = list1.value + list2.value + carry;
			carry = curSum / 10;
			res.insertAtFront(curSum % 10);
			list1 = list1.next;
			list2 = list2.next;
		}
		while (list1 != null) {
			curSum = list1.value + carry;
			carry = curSum / 10;
			res.insertAtFront(curSum % 10);
			list1 = list1.next;
		}
		while (list2 != null) {
			curSum = list2.value + carry;
			carry = curSum / 10;
			res.insertAtFront(curSum % 10);
			list2 = list2.next;
		}
		while (carry != 0) {
			res.insertAtFront(carry % 10);
			carry = carry / 10;
		}
		return res;
	}

	public static void main(String[] args) {
		SList num1 = new SList();
		SList num2 = new SList();

		int num11 = 234562345, num22 = 38904523;
		while (num11 > 0) {
			num1.insertAtFront(num11 % 10);
			num11 /= 10;
		}

		while (num22 > 0) {
			num2.insertAtFront(num22 % 10);
			num22 /= 10;
		}
		
		SList res=add(num1,num2);
		res.print();
	}

}
