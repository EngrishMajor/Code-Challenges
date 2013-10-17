package data.structures;

public class LinkedList 
{
	public Node head;
	public Node tail;
	public int size;
	
	/**
	 * Creates an empty linked list.
	 */
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Creates a copy of the given Linked List
	 * @param other, the LinkedList to be copied.
	 */
	public LinkedList(LinkedList other)
	{
		this.copy(other);
	}
	
	/**
	 * Creates a new node with the given value and inserts
	 * it at the end of the linked list.
	 * @param value, value of the node to be inserted.
	 */
	public void insert(int value)
	{
		Node temp = new Node(value);
		
		if (head == null)
			head = temp;
		else
			tail.next = temp;
		
		tail = temp;
		size++;
	}
	
	/**
	 * Removes the first node in the linked list with 
	 * the given value
	 * @param val, value of the node to be removed.
	 */
	public void remove(int val)
	{
		Node current = head;
		while (current.next != null)
		{
			Node tempNext = current.next;
			if (tempNext.value == val)
			{
				if (tempNext.next == null)
					current.next = null;
				else
					current.next = tempNext.next;
				
				return;
			}
		}
	}
	
	/**
	 * Finds the first node in the list with the 
	 * given value.
	 * @param val, the value of the node to be found.
	 * @return the pointer of the node with the given value or null.
	 */
	public Node find(int val)
	{
		Node current = head;
		while (current.next != null)
		{
			if (current.value == val)
				return current;
		}
		return null;
	}
	
	/**
	 * Copies the given LinkedList object. This performs a deep copy.
	 */
	public void copy(LinkedList other)
	{
		Node thiscurr = this.head;
		for(Node othercurr = other.head; othercurr != null;
				othercurr = othercurr.next, thiscurr = thiscurr.next)
			thiscurr = new Node(othercurr.value, othercurr.next);
		
		this.tail = other.tail;
		this.size = other.size;
	}
	
	private class Node
	{
		Node next;
		int value;
		
		/**
		 * Default constructor for the node.
		 * Creates a node that has a value of 0, and points to NULL
		 */
		public Node()
		{
			next = null;
			value = 0;
		}
		
		/**
		 * Constructor for the node that initializes its value.
		 * @param val, the value of the node.
		 */
		public Node(int val)
		{
			next = null;
			value = val;
		}
		
		/**
		 * Constructor for the node that initializes its value and the
		 * next node in the linked list.
		 * @param val
		 * @param other
		 */
		public Node(int val, Node other)
		{
			next = other;
			value = val;
		}
	}
}
