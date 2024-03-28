
import java.util.*;
class Node{
        Node next;
        int val;
        Node(int v){
            val=v;
        }
    }
public class MergeLinkedLists
{
    private static Node mergedLinkedList(Node l1,Node l2){
        Node temp=new Node(0);
        Node current=temp;
        while (l1 != null && l2 != null) {
 if (l1.val < l2.val) {
 current.next = l1;
 l1 = l1.next;
 } else {
 
 current.next = l2;
 l2 = l2.next;
 }
 current = current.next;
 }
   if (l1 != null) {
 current.next = l1;
 } 
 else {
 current.next = l2;
 }
        return temp.next;
    }
    private static Node createLL(Scanner in,int n){
        Node temp=new Node(0);
        Node current=temp;
        for(int i=0;i<n;i++){
            int val=in.nextInt();
            current.next=new Node(val);
            current=current.next;
        }
        return temp.next;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        Node l1=createLL(in,n);
        int n2=in.nextInt();
        Node l2=createLL(in,n2);
            
        Node merged=mergedLinkedList(l1,l2);
        
        while(merged!=null){
            System.out.print(merged.val+" ");
            merged=merged.next;
        }
        in.close();
    }
}
