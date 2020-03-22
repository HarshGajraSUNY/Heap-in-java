package com.code.heaps;

public class HeapArray {

//Implementing a max heap in java
	
	private static int[] heap ;
	
	private static int size;
	
	
	public HeapArray(int capacity) {
		
		heap = new int[++capacity];
		heap[0] = Integer.MAX_VALUE-10;
		this.size =0;
	}
	public static void swap(int value,int parentIndex) {
		
		int temp = heap[parentIndex];
		heap[parentIndex] = heap[value];
		heap[value] = temp;
		
	}
	public static void heapifyUp(int value) {
		
		//int parentIndex = value/2;
		
		//int parent = heap[parentIndex];
		
		//int i = heap[value];
		while(heap[value]>heap[value/2]) {
			swap(value, value/2);
			value   = value/2;
		}
		
	}
	
	
	public static void heapifyDown(int value) {
	
		int largestIndex = value;
		int leftIndex = value*2;
		int rightIndex = value*2 +1;
		
		if( leftIndex<heap.length && heap[leftIndex] > heap[largestIndex])
		{
			largestIndex=leftIndex;
		}
		if(rightIndex<heap.length && heap[rightIndex]>heap[largestIndex]) {
			largestIndex=rightIndex;
		}
		
		if(largestIndex!=value) {
			
			swap(value, largestIndex);
			heapifyDown(largestIndex);
			
		}
		
		
	}
	
	public void insert(int value)
	{
		heap[++size] = value;
		heapifyUp(size);
		
		
	}
	public int peek() {
        return heap[1];
    }
	public int deleteMax() {
		
		int max = heap[1];
		heap[1] = heap[size--];
		heapifyDown(1);
		
		return max;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapArray maxHeap = new HeapArray(5);
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(2);
        maxHeap.insert(9);
        
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.deleteMax());
        System.out.println(maxHeap.peek());
	}

}
