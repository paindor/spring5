package com.hanrabong.web.lambda;

public class GenericTest {
	static class Box<T>{
		T item;
		void setItem(T item) {
			this.item = item;
			
		}
		T getItem() {
			return this.item;
			
		}
		
	}
	public static void main(String[] args) {
		GenericTest.Box<String> s = new GenericTest.Box<>();
		
	}
}
