package com.tdd_test.sll.sll_assignment;

public class Sll {

	public Node head;

	public Sll() {
		this.head = null;
	}

	// add method => add node to the list
	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			this.head = newNode;
			System.out.println(value + " : is the first node in the list");
		} else {
			Node runner = this.head;
			while (runner != null) {
				runner = runner.next;
			}
			this.head.next = newNode;
			System.out.println(value + " : is the last node in the list");
		}
	}

	// remove front of the list
	public void removeFront() {
		if (this.head == null) {
			System.out.println("List is empty nothing to remove !!");
		}
		
		if(this.head!= null && this.head.next==null) {
			this.head=head.next;
		}
		else {
			Node runner = this.head;
			while (runner.next.next != null) {
				runner = runner.next;
			}
			runner.next = null;	
		}

	}

	// remove at
	public void removeAt(int n) {
		if (this.head == null) {
			System.out.println("List is empty nothing to remove !!");
		}
		Node runner = this.head;
		if(n == 0) {
			this.head=runner.next;
		}
		
		int counter = 0;
		while (runner.next != null) {
			if (counter == n-1) {
				runner.next = runner.next.next;
			}
			runner = runner.next;
			counter++;
		}
	}
}
