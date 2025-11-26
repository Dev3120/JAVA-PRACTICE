public class implementation {
    public static class node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static class linkedlist{
        Node head=null;
        Node tail=null;

        void insertAtEnd(int val){
            Node temp=new Node(val);
            if(head=null){\
                head=temp;
                  
            }
            else{
                tail.next=temp
            }
            tail=temp;
        }
        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+' ');
                temp=temp.next;
            }
        }

        
    }

    public static void main(String[] args) {
        linkedlist ll=new linkedkist();
        ll.insertAtEnd(4);//4
        ll.insertAtEnd(5);//4 5
        ll.display(); 
    }
}
