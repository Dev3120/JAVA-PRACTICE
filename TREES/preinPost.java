import java.util.LinkedList;
import java.util.Queue;

public class preinPost {
    public static void pip(int n){
        if(n==0) return;
        System.out.println("pre "+n);
        pip(n-1);
        System.out.println("In "+n);
        pip(n-1);
        System.out.println("Post "+n);
    }
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val=val;
        }
    }
    public static void inorder(Node root){
        //inorder is left root right
        if(root==null) return ;
        
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    public static void bfs(Node root){//Iterative 
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            Node temp =q.peek();
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            System.out.println(temp.val+" ");
            q.remove();
        }

    }
    public static int height(Node root){
        if(root==null) return 0;
        if(root.left==null&& root.right==null) return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }
    public static void preorder(Node root){
        //preorder is root left right
        if(root==null) return ;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node root){
        //prstorder is left rigth root
        if(root==null) return ;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);

    }

    public static void nthlevel(Node root,int n){
        if(root==null) return ;
        if(n==1) System.out.println(root.val+" ");
        
        nthlevel(root.left,n-1);
        nthlevel(root.right,n-1);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a=new Node(2);
        Node b=new Node(3);
        root.left=a;
        root.right=b; 
        Node c=new Node(4);
        Node d=new Node(5);
        a.left=c;
        a.right=d;
        Node e=new Node(6);
        Node f=new Node(7);
        b.right=e;
        e.left=f;
        // int level=height(root)+1;
        // for(int i=1;i<=level;i++){
        //     nthlevel(root,i);
        //     System.out.println();
        // }
        bfs(root);
        

        
    }
    
    
}
