package tree;

import list.List;
import stack.Stack;
import stack.StackException;

public class LinkedTree<E> {
	private TreeNode<E> root;
	
	public LinkedTree() {
	}
	
	public LinkedTree( E data ) {
		root = new TreeNode<E>( data );
	}
	
	public TreeNode<E> getRoot() {
		return root;
	}
	
	public TreeNode<E> insertLeft( TreeNode<E> parent, E data) {
		final TreeNode<E> node = new TreeNode<E>( data );
		parent.left = node;
		return node;
	}

	public TreeNode<E> insertRight( TreeNode<E> parent, E data) {
		final TreeNode<E> node = new TreeNode<E>( data );
		parent.right = node;
		return node;
	}

	public void traversalPostorder( List<E> list ){
		traversalPostorder( root, list );
	}

	public void traversalPreorder( List<E> list ){
		traversalPreorder( root, list );
	}
	
	public void traversalInorder( List<E> list ){
		traversalInorder( root, list );
	}
	
	public void traversalPostorder( TreeNode<E> node, List<E> list ){
		if( node.left != null ) {
			traversalPostorder( node.left, list );
		}
		
		if( node.right != null ) {
			traversalPostorder( node.right, list );
		}
		
		list.add( node.data );
	}

	public void traversalPreorder( TreeNode<E> node, List<E> list ){
		list.add( node.data );

		if( node.left != null ) {
			traversalPreorder( node.left, list );
		}
		
		if( node.right != null ) {
			traversalPreorder( node.right, list );
		}
	}
	
	public void traversalInorder( TreeNode<E> node, List<E> list ){
		if( node.left != null ) {
			traversalInorder( node.left, list );
		}

		list.add( node.data );
		
		if( node.right != null ) {
			traversalInorder( node.right, list );
		}
	}	
	
	public static double evaluteExpression( TreeNode<String> treeNode ){
		double result = 0.;
		double lValue = 0.;
		double rValue = 0.;
		
		if( treeNode.left != null ) {
			lValue = evaluteExpression( treeNode.left );
		}

		if( treeNode.right != null ) {
			rValue = evaluteExpression( treeNode.right );
		}
		
		switch ( treeNode.data ){
			case "+" : 
				result = lValue + rValue;
				break;
			case "-" : 
				result = lValue - rValue;
				break;
			case "*" : 
				result = lValue * rValue;
				break;
			case "/" : 
				result = lValue / rValue;
				break;
			default	 :  
				result = Double.parseDouble( treeNode.data );
		}
		
		return result;
	}
	
	public static LinkedTree<String> toExpressionTree( 
		List<String> tokens ) 
		throws StackException {
		LinkedTree<String> tree = new LinkedTree<String>();

		int index = 0;
		Stack<TreeNode<String>> stack = new Stack<TreeNode<String>>();
		
		while( true ) {
			String token = tokens.get( index );
			TreeNode<String> treeNode = new TreeNode<String>( token );
			
			if( token.matches("-?\\d+(\\.\\d+)?") ) {
				stack.push( treeNode );
			} else {
				treeNode.right = stack.pop();
				treeNode.left = stack.pop();
				stack.push( treeNode );
			}
			
			if( ++index == tokens.size() ) {
				tree.root = stack.pop();
				break;
			}
		}
		
		return tree;
	}
	
	public static class TreeNode<E>{
		private E data;
		private TreeNode<E> left;
		private TreeNode<E> right;
		
		public TreeNode( E data ) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
