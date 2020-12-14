package com.miscellaneous;

import java.util.Stack;

import org.junit.Test;

public class Trees {

	public class Tree {

		public Tree(int val, Tree left, Tree right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public int getVal() {
			return val;
		}

		public Tree getLeft() {
			return left;
		}

		public Tree getRight() {
			return right;
		}

		private int val;
		private Tree left;
		private Tree right;
	}

	public void preorderPrint(Tree t) {

		if (t == null)
			return;
		System.out.println(t.getVal());
		preorderPrint(t.getLeft());
		preorderPrint(t.getRight());
	}

	@SuppressWarnings("unchecked")
	public void preorderNoRecursionPrint(Tree t) {

		@SuppressWarnings("rawtypes")
		Stack stack = new Stack();
		if (t == null)
			return;
		stack.push(t);
		while (!stack.isEmpty()) {
			Tree miniT = (Tree) stack.pop();
			System.out.println(miniT.getVal());
			Tree aux;
			aux = miniT.getRight();
			if (aux != null)
				stack.push(aux);
			aux = miniT.getLeft();
			if (aux != null)
				stack.push(aux);
		}

	}

	public void printlowestCommonAncestor(int x, int y, Tree bt) {

		int deepx = 0, deepy = 0;
		int fatherx = 0, fathery = 0;
		Boolean xFound = true, yFound = false;
		Tree root;

		root = bt;
		while (root != null) {
			if (root.getVal() == x) {
				if (deepx == 0) {
					System.out.println(
							"One of the nodes is the root of the three, therefore there is no common lower ancestor");
					return;
				} else
					xFound = true;
				break;
			} else if (x > root.getVal()) {
				fatherx = root.getVal();
				root = root.getRight();
			} else {
				fatherx = root.getVal();
				root = root.getLeft();
			}
			deepx++;
		}

		root = bt;
		while (root != null) {
			if (root.getVal() == y) {
				if (deepy == 0) {
					System.out.println(
							"One of the nodes is the root of the three, therefore there is no common lower ancestor");
					return;
				} else
					yFound = true;
				break;
			} else if (y > root.getVal()) {
				fathery = root.getVal();
				root = root.getRight();
			} else {
				fathery = root.getVal();
				root = root.getLeft();
			}
			deepy++;
		}

		if (!xFound || !yFound) {
			System.out.println(
					"At least one of the passed nodes is not on the three therefore there won't be any lower common ancestor");
			return;
		}

		if (deepx > deepy)
			System.out.println("Common lower ancestor = " + fathery);
		else
			System.out.println("Common lower ancestor = " + fatherx);

	}

	public Tree getlowestCommonAncestor(int x, int y, Tree bt) {

		int val;
		Tree node = bt;

		while (node != null) {

			val = node.getVal();
			if (x > val && y > val)
				node = bt.getRight();
			else if (x < val && y < val)
				node = bt.getLeft();
			else
				return node;
		}

		return null;

	}

	@Test
	public void test() {

		// @formatter:off
		Tree t = new Tree(110,  
				 		  new Tree(34,
				 		           new Tree(2,null, null), 
				 		           new Tree(1,null, null)), 
				 new Tree(8,null,null));
		
		Tree bt = new Tree(20,  
		 		  new Tree(8,
		 		           new Tree(4,null, null), 
		 		           new Tree(12,
		 		        		    new Tree(10,null, null), 
				 		            new Tree(14,null, null))), 
		 new Tree(22,null,null));
		// @formatter:on

		System.out.println("PreOrderPrint:\n");

		preorderPrint(t);

		System.out.println("\nPreOrderPrintNoRecursion:\n");

		preorderNoRecursionPrint(t);

		System.out.println("\nLowerCommonAncestor:\n");

		printlowestCommonAncestor(4, 14, bt);

		System.out.println("\nProperLowerCommonAncestor:\n");

		System.out.println("Common lower ancestor = " + getlowestCommonAncestor(4, 14, bt).getVal());

	}

}
