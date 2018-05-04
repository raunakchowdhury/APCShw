//Raunak Chowdhury
//APCS2 pd2
//HW44 --   Prune Your Tree
//2018-05-02

/*****************************************************
* class BST - v1:partial
* Implementation of the BINARY SEARCH TREE abstract data type (ADT)
*
* A BST maintains the invariant that, for any node N with value V,
* L<V && V<R, where L and R are node values in N's left and right
* subtrees, respectively.
* (Any value in a node's left subtree must be less than its value,
*  and any value in its right subtree must be greater.)
* This BST only holds ints (its nodes have int cargo)
*****************************************************/

public class BST
{

//instance variables / attributes of a BST:
TreeNode _root;

/*****************************************************
* default constructor
*****************************************************/
BST( )
{
        _root = null;
}


/*****************************************************
* void insert( int )
* Adds a new data element to tree.
*****************************************************/
public void insert( int newVal )
{
        TreeNode newNode = new TreeNode( newVal );

        if ( _root == null ) {
                _root = newNode;
                return;
        }
        insert( _root, newNode );
}
//recursive helper for insert(int)
public void insert( TreeNode stRoot, TreeNode newNode )
{
        if ( newNode.getValue() < stRoot.getValue() ) {
                //if no left child, make newNode the left child
                if ( stRoot.getLeft() == null )
                        stRoot.setLeft( newNode );
                else //recurse down left subtree
                        insert( stRoot.getLeft(), newNode );
                return;
        }
        else { // new val >= curr, so look down right subtree
                //if no right child, make newNode the right child
                if ( stRoot.getRight() == null )
                        stRoot.setRight( newNode );
                else //recurse down right subtree
                        insert( stRoot.getRight(), newNode );
                return;
        }
}  //end insert()




//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

// each traversal should simply print to standard out
// the nodes visited, in order

//process root, recurse left, recurse right
public void preOrderTrav()
{
        preOrderTrav( _root );
}
public void preOrderTrav( TreeNode currNode )
{
        if ( currNode == null ) //stepped beyond leaf
                return;
        System.out.print( currNode.getValue() + " " );
        preOrderTrav( currNode.getLeft() );
        preOrderTrav( currNode.getRight() );
}

//recurse left, process root, recurse right
public void inOrderTrav()
{
        inOrderTrav( _root );
}
public void inOrderTrav( TreeNode currNode )
{
        if ( currNode == null ) //stepped beyond leaf
                return;
        inOrderTrav( currNode.getLeft() );
        System.out.print( currNode.getValue() + " " );
        inOrderTrav( currNode.getRight() );
}

//recurse left, recurse right, process root
public void postOrderTrav()
{
        postOrderTrav( _root );
}
public void postOrderTrav( TreeNode currNode )
{
        if ( currNode == null ) //stepped beyond leaf
                return;
        postOrderTrav( currNode.getLeft() );
        postOrderTrav( currNode.getRight() );
        System.out.print( currNode.getValue() + " "  );
}

//~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


/*****************************************************
* TreeNode search(int)
* returns pointer to node containing target,
* or null if target not found
*****************************************************/
TreeNode search( int target )
{
        /*** YOUR IMPLEMENTATION HERE ***/
        return search(target, _root);
}
//recursive helper method
private TreeNode search( int target, TreeNode currNode ){
        if (currNode == null)
                return null;
        int value = currNode.getValue();
        //do a binary search
        if (value == target) {
                return currNode;
        }
        //target less than currNode
        else if (target < value) {
                return search(target, currNode.getLeft());
        }
        else{
                return search(target,currNode.getRight());
        }
        //does not match and is a leaf
}

/*****************************************************
* int height()
* returns height of this tree (length of longest leaf-to-root path)
* eg: a 1-node tree has height 0
*****************************************************/
public int height()
{
        /*** YOUR IMPLEMENTATION HERE ***/
        return height(_root);
}
//recursive helper method
private int height(TreeNode currNode){
        //check to see if it's a leaf
        if (currNode == null)
                return 0;
        if (currNode.getLeft() == null && currNode.getRight() == null)
                return 0;

        int hLeft = 0; //height of left subtree
        int hRight = 0; //height of right subtree

        hLeft += 1 + height(currNode.getLeft());
        hRight += 1 + height(currNode.getRight());
        //compare the two heights
        if (hLeft >= hRight)
                return hLeft;
        else
                return hRight;
}

/*****************************************************
* int numLeaves()
* returns number of leaves in tree
*****************************************************/
public int numLeaves()
{
        /*** YOUR IMPLEMENTATION HERE ***/
        return numLeaves(_root);
}
//recursive helper method
private int numLeaves(TreeNode currNode){
        int total = 0;
        if (currNode.getLeft() != null && currNode.getRight() != null) {
                if (currNode.getLeft() != null) {
                        total += numLeaves(currNode.getLeft());
                }
                if (currNode.getRight() != null) {
                        total += numLeaves(currNode.getRight());
                }
        }
        else{
                total = 1;
        }
        return total;
}

public void remove(int target){
        TreeNode leader = _root;
        TreeNode follower = _root;
        //if the root has one subtree and is the target
        if (_root.getLeft() == null && target == _root.getValue()) {
                _root = _root.getRight();
        }
        else if (_root.getRight() == null && target == _root.getValue()) {
                _root = _root.getLeft();
        }
        //go down the tree to look for the target
        while (leader.getValue() != target) {
                //standard binary search
                if (leader == null)
                        return;
                else if (leader.getValue() > target) {
                        follower = leader;
                        leader = leader.getLeft();
                }
                else{
                        follower = leader;
                        leader = leader.getRight();
                }
        }
        // Case I: The leader is a leaf
        if (leader.getLeft() == null && leader.getRight() == null) {
                //check to see if the leaf is on the left or right
                if (follower.getLeft().getValue() == target) {
                        follower.setLeft(null);
                }
                else {
                        follower.setRight(null);
                }
                return;
        }
        //Case II: target has one subtree
        /* four different combos:
         * 1. L subtree with a L subtree
         * 2. R subtree with a R subtree
         * 3. L subtree with a R subtree
         * 4. R subtree with a L subtree
         */
        if (follower.getLeft().getValue() == target && leader.getLeft() == null) {
                follower.setLeft(leader.getRight());
        }
        else if (follower.getRight().getValue() == target && leader.getRight() == null) {
                follower.setRight(leader.getLeft());
        }
        else if(follower.getLeft().getValue() == target && leader.getRight() == null) {
                follower.setLeft(leader.getLeft());
        }
        else if(follower.getRight().getValue() == target && leader.getLeft() == null) {
                follower.setRight(leader.getRight());
        }
        // Case III: target has two subtrees
        else{
                TreeNode other = max(leader.getLeft());
                int temp = other.getValue();
                this.remove(other.getValue());
                leader.setValue(temp);
        }
}
//helper method
private TreeNode max(TreeNode currNode){
        while(currNode.getRight() != null) {
                currNode = currNode.getRight();
        }
        return currNode;
}

//main method for testing
public static void main( String[] args )
{
        BST arbol = new BST();

        //PROTIP: sketch state of tree after each insertion
        //        ...BEFORE executing these.
        arbol.insert( 4 );
        System.out.println("height of tree: " + arbol.height());
        arbol.insert( 2 );
        System.out.println("height of tree: " + arbol.height());
        arbol.insert( 5 );
        System.out.println("height of tree: " + arbol.height());
        arbol.insert( 6 );
        System.out.println("height of tree: " + arbol.height());
        arbol.insert( 1 );
        System.out.println("height of tree: " + arbol.height());
        arbol.insert( 3 );
        System.out.println("height of tree: " + arbol.height());

        System.out.println( "\n-----------------------------");
        System.out.println( "pre-order traversal:" );
        arbol.preOrderTrav();

        System.out.println( "\n-----------------------------");
        System.out.println( "in-order traversal:" );
        arbol.inOrderTrav();

        System.out.println( "\n-----------------------------");
        System.out.println( "post-order traversal:" );
        arbol.postOrderTrav();

        System.out.println( "\n-----------------------------");
        //<<< YOUR NEW TEST CALLS HERE >>>
        /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~

           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        System.out.println("Number of leaves in arbol: " + arbol.numLeaves());
        System.out.println( "\n-----------------------------");

        System.out.println("Finding 4: " + arbol.search(4).getValue());
        System.out.println("Finding 1: " + arbol.search(1).getValue());
        System.out.println("Finding 10: " + arbol.search(10));
        System.out.println( "\n-----------------------------");
        System.out.println("Testing remove...");
        arbol.inOrderTrav();
        arbol.remove(3);
        System.out.println();
        arbol.inOrderTrav();
        System.out.println();
        arbol.remove(5);
        System.out.println();
        arbol.inOrderTrav();
}

}//end class
