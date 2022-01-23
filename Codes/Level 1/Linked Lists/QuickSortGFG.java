// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    
    class Node 
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    
    class SortLL
    {
        static Node head;
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0) 
            {
                int n = sc.nextInt();
                int a1 = sc.nextInt();
                Node head = new Node(a1);
                addToTheLast(head);
                
                for(int i = 1; i< n; i++)
                {
                    int a = sc.nextInt();
                    addToTheLast(new Node(a));
                }
                
                GfG gfg = new GfG();
                Node node = gfg.quickSort(head);
                
                printList(node);
                System.out.println();
            }
        }
        public static void printList(Node head)
        {
            while(head != null)
            {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }
        
        public static void addToTheLast(Node node) 
    {
      if (head == null) 
      {
        head = node;
      } else 
      {
       Node temp = head;
       while (temp.next != null)
              temp = temp.next;
             temp.next = node;
      }
    }
    }// } Driver Code Ends
    
    
    /*node class of the linked list
    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
        
    }*/
    // you have to complete this function
    class GfG
    {
        
        public static Node partition(Node head, int x) {
            Node rDummy = new Node(-1), lDummy = new Node(-1), rTail = rDummy, lTail = lDummy;
            while(head != null){
                if(head.data < x){
                    lTail.next = head;
                    lTail = head;
                    head = head.next;
                }else{
                    rTail.next = head;
                    rTail = head;
                    head = head.next;
                }
            }
            lTail.next = null;
            rTail.next = null;
            return lDummy.next;
        }
        
        public static Node getTail(Node curr){
            while(curr!=null && curr.next != null)
                curr = curr.next;
            return curr;
        }
        
        public static Node quickSort(Node head)
        {
            //Your code here
            if(head == null || head.next == null)
                return head;
            
            Node left = quickSort(partition(head, head.data));
            Node right = quickSort(head.next);
            head.next = right;
            
            if(left == null)
                return head;
            
            Node leftTail = getTail(left);
            leftTail.next = head;
            return left;
        }
        
        
    }