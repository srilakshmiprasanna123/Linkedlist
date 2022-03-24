package com.bridgelabz;

public class MyLinkedList {
    class Node {
        int data;
         Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    // Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;


    // addNode() will add a new node to the list

    public void addNode(int data) {
        // Create a new node
        Node newNode = new Node(data); // IDNode

        // Checks if the list is empty
        if (head == null) {
            // If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        }
        else
        {
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode will become new tail of the list
            tail = newNode;
        }
    }



    public void append(int new_data) {
        /*
         * 1. Allocate the Node & 2. Put in the data 3. Set next as null
         */
        Node new_node = new Node(new_data);

        /*
         * 4. If the Linked List is empty, then make the new node as head
         */
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        /*
         * 4. This new node is going to be the last node, so make next of it as null
         */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data)
    {
        /* 1. Check if the given Node is null */
        if (prev_node == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }

        /* 2 & 3: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;

        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    /* Given a reference (pointer to pointer) to the head of a list
    and a position, deletes the node at the given position */
    void pop(int position)
    {
        // If linked list is empty
        if (head == null)
            return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list
    }

    // display() will display all the nodes present in the list
    public void display() {
        // Node current will point to head
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of linked list: ");
        while (current != null) {
            // Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    //searchNode() will search for a given node in the list
    public int searchNode(int data) {
        Node current = head;
        int i = 1;
        boolean flag = false;
        //Checks whether list is empty
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            while(current != null) {
                //Compares node to be found with each node present in the list
                if(current.data == data) {
                    flag = true;
                    break;
                }
                i++;
                current = current.next;
            }
        }
        if(flag)
            System.out.println(current.data+" Element is present in the list at the position : " + i);
        else
            System.out.println("Element is not present in the list");
        return data;
    }


    // sortList() will sort nodes of the list in ascending
    // order
    public void sortList()
    {

        // Node current will point to head
        Node current = head, index = null;

        int temp;

        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }

    }

    public int size( )
    {
        int count = 0;
        Node position = head;

        while (position != null)
        {
            count++;
            position = position.next;
        }
        return count;
    }


    public static void main(String[] args) {

        MyLinkedList sList = new MyLinkedList();

        // Add nodes to the list
        sList.addNode(56);
        sList.append(70);
        sList.insertAfter(sList.head, 30);
        sList.insertAfter(sList.head.next, 40);

        // Displays the nodes present in the list
        System.out.println("\nCreated Linked list is: ");
        sList.display();

        //Search the Node
        System.out.println();
        sList.searchNode(30);

        //Sorting Linked List
        System.out.println();
        sList.sortList();
        System.out.println("Sorted list is : ");
        sList.display();

        //Delete the Node
        sList.pop(0);
        System.out.println("\nLinked List after Deletion : ");
        sList.display();

        //Display the size of linked list
        System.out.println();
        System.out.println("The size of the linked list is " + sList.size());
    }
}