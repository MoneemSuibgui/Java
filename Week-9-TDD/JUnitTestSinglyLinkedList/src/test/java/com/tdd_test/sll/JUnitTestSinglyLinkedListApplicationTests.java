package com.tdd_test.sll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tdd_test.sll.sll_assignment.Sll;

@SpringBootTest
class JUnitTestSinglyLinkedListApplicationTests {

	//------- using JUnit test to test our singly linked list ------
	
	public Sll sll;
	
	@BeforeEach
	public void setUp() throws Exception {
		// instantiate sll object from Sll class
		sll=new Sll();
	}
	
	// test head is null at first 
	@Test
	public void testHeadForNull() {
		// test sll.head : first node in th list it should be null because our list is empty at first
		assertNull(sll.head);
	}
	

	// test sll head not null after adding new node
	@Test
	public void TestHeadForNode() {
		sll.add(8);
		// test sll.head it should be not null when we add node to the list
		assertNotNull(sll.head);
	}
	
	// test head.next value is not null after adding 2 nodes in the list
	@Test
	public void testHeadNextValue() {
		sll.add(22);
		sll.add(15);
		// check if the second node in the list it should be of value of 15
		assertTrue(this.sll.head.next.value ==15);
	}
	
	// test the head of the list is null using assertions methods after adding node and remove from front of the list  
	@Test
	public void testHeadAfterAddTowNodeAndRemove() {
		sll.add(99);
		sll.removeFront();
		// assertNull() it should be return true because we remove the first node
		assertNull(sll.head);
	}
	
	// test head value using assertions methods
	@Test
	public void testHeadAfterRemove() {
		sll.add(99);
		sll.removeFront();
		sll.add(88);
		int expect=88;
		assertEquals(sll.head.value,expect);
	}
	
	// test list after adding nodes and removing at index 
	@Test
	public void TestRemoveAt() {
		sll.add(5);
		sll.add(22);
		sll.add(12); 
		sll.removeAt(2);
		// assertNull()  should return true to pass the test in TestRemoveAt method and that means we remove at index 2 of the list = node of value 12 removed and node will be point it to null
		assertNull(sll.head.next.next);
	}
	

}
