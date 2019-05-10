package ui;

import model.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Node n = new Node(5);
		Node n1 = new Node(3);
		Node n2 = new Node(7);
		Node n3 = new Node(4);
		Node n4 = new Node(10);
		Node n5 = new Node(0);
		Node n6 = new Node(2);
		
		n.setNext(n1);
		n1.setPrevious(n);
		n1.setNext(n2);
		n2.setPrevious(n1);
		n2.setNext(n3);
		n3.setPrevious(n2);
		n3.setNext(n4);
		n4.setPrevious(n3);
		n4.setNext(n5);
		n5.setPrevious(n4);
		n5.setNext(n6);
		n6.setPrevious(n5);*/
		
		//DoublyLinkedList dll = new DoublyLinkedList(n);
		DoublyLinkedList dll = new DoublyLinkedList(50000);
		//System.out.println(dll);
		long now = System.currentTimeMillis();
		dll.selectionSort();
		long later = System.currentTimeMillis();
		System.out.println(later-now);
		System.out.println("\n" + dll);
	}

}
