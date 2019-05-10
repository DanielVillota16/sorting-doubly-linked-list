package model;

public class DoublyLinkedList {

	public Node first;
	
	public DoublyLinkedList(Node first) {
		this.first = first;
	}
	
	public DoublyLinkedList(int nNodes) {
		this.first = new Node((int)(Math.random()*nNodes));
		Node current = first;
		int counter = 0;
		while(counter < nNodes) {
			current.setNext(new Node((int)(Math.random()*nNodes)));
			current.getNext().setPrevious(current);
			current = current.getNext();
			counter++;
		}
	}
	
	public void selectionSort() {
		Node current = first;
		while(current != null) {
			Node temp = current.getNext();
			Node min = current;
			while(temp != null) {
				if(temp.getValue() <= min.getValue()) {
					min = temp;
				}
				temp = temp.getNext();
			}
			boolean firstIt = false;
			if(min != current) {
				Node next1 = current.getNext();
				Node previous1 = current.getPrevious();
				
				Node next2 = min.getNext();
				Node previous2 = min.getPrevious();
				
				if(min == current.getNext()	) {
					if(previous1 != null) previous1.setNext(min);
					else {
						first = min;
						firstIt = true;
					}
					current.setNext(next2);
					current.setPrevious(min);
					if(next2 != null) next2.setPrevious(current);
					min.setNext(current);
					min.setPrevious(previous1);
				} else {
					if(next1 != null) next1.setPrevious(min);
					if(previous1 != null) previous1.setNext(min);
					else {
						first = min;
						firstIt = true;
					}
					
					min.setNext(next1);
					min.setPrevious(previous1);
					
					if(next2 != null) next2.setPrevious(current);
					if(previous2 != null) previous2.setNext(current);
					
					current.setNext(next2);
					current.setPrevious(previous2);
				}
				current = min;
			}
			if(firstIt) {
				current = first.getNext();
			} else {
				current = current.getNext();
			}
		}
	}
	
	public void bubbleSort() {
		if(first != null) {
			Node temp = first;
			int counter = 0;
			int size = size();
			while(temp != null) {
				Node current = first;
				int counter2 = 0;
				while(current.getNext() != null && counter2 < size-counter) {
					if(current.getValue() > current.getNext().getValue()) {
						if(first == current) first = current.getNext();
						Node next = current.getNext().getNext();
						Node prev = current.getPrevious();
						if(next != null) next.setPrevious(current);
						if(prev != null) prev.setNext(current.getNext());
						current.getNext().setNext(current);
						current.getNext().setPrevious(prev);
						current.setPrevious(current.getNext());
						current.setNext(next);
					} else {
						current = current.getNext();
					}
					counter2++;
				}
				counter++;
				temp = temp.getNext();
			}
		}
	}
	
	
	public int size() {
		Node temp = first;
		int s = 0;
		while(temp != null) {
			s++;
			temp = temp.getNext();
		}
		return s;
	}
	
	
	public Node getFirst() {
		return first;
	}
	
	public String toString() {
		Node temp = first;
		String s = "";
		int counter = 1;
		while(temp != null) {
			String next = "";
			if(temp.getNext() != null) {
				next = ""+temp.getNext().getValue();
			} else {
				next = "null";
			}
			String prev = "";
			if(temp.getPrevious() != null) {
				prev = ""+temp.getPrevious().getValue();
			} else {
				prev = "null";
			}
			
			s+= counter + ". Value: " + temp.getValue() + " Next: " + next + " Prev: " + prev+"\n";
			temp = temp.getNext();
			counter++;
		}
		return s;
	}
	
	public void insertionSort() {
		if(first.getNext() != null) {
			Node current = first.getNext();
			while(current != null) {
				Node temp = current;
				while(temp.getPrevious() != null) {
					if(temp.getValue() < temp.getPrevious().getValue()) {
						if(temp.getPrevious() == first) first = temp;
						Node next = temp.getNext();
						Node prev = temp.getPrevious().getPrevious();
						if(next != null) next.setPrevious(temp.getPrevious());
						if(prev != null) prev.setNext(temp);
						temp.setNext(temp.getPrevious());
						temp.getPrevious().setPrevious(temp);
						temp.getPrevious().setNext(next);
						temp.setPrevious(prev);
					} else {
						temp = temp.getPrevious();
					}
				}
				current = current.getNext();
			}
		}
		
	}
	
	public void cocktailSort() {
		Node temp = first;
		int counter = 0;
		int size = size();
		while(temp != null) {
			Node current = first;
			int counter2 = 0;
			while(current.getNext() != null && counter2 < size - counter) {
				if(current.getValue() > current.getNext().getValue()) {
					if(current == first) first = current.getNext();
					Node next = current.getNext().getNext();
					Node prev = current.getPrevious();
					if(next != null) next.setPrevious(current);
					if(prev != null) prev.setNext(current.getNext());
					current.setPrevious(current.getNext());
					current.getNext().setNext(current);
					current.getNext().setPrevious(prev);
					current.setNext(next);
				} else {
					current = current.getNext();
				}
				counter2++;
			}
			while(current.getPrevious() != null && counter2 > counter) {
				if(current.getValue() < current.getPrevious().getValue()) {
					if(current.getPrevious() == first) first = current;
					Node next = current.getNext();
					Node prev = current.getPrevious().getPrevious();
					if(next != null) next.setPrevious(current.getPrevious());
					if(prev != null) prev.setNext(current);
					current.setNext(current.getPrevious());
					current.getPrevious().setPrevious(current);
					current.getPrevious().setNext(next);
					current.setPrevious(prev);					
				} else {
					current = current.getPrevious();
				}
				counter2--;
			}
			temp = temp.getNext();
			counter++;
		}
	}
	
}
