
import java.util.*;
class Node{
    Node next;
    int val;
    Node(int v){
        val=v;
    }
}

public class PalindromeLL
{
static Node createLL(Scanner in, int n){
    Node temp=new Node(0);
    Node current=temp;
    for(int i=0;i<n;i++){
        int val=in.nextInt();
        current.next=new Node(val);
        current=current.next;
    }
    return temp.next;
}
static Node revList(Node temp){
    Node prevN=null,nextN=null;
    Node curN=temp;
    while(curN!=null){
        nextN=curN.next;
        curN.next=prevN;
        prevN=curN;
        curN=nextN;
    }
    return prevN;
}
static void isPalin(Node l1, int n){
        int mid=(n%2==0)?(n/2):((n+1)/2);
        Node temp=l1;
        for(int i=1;i<mid;i++){
            temp=temp.next;
        }
        Node rev=revList(temp.next);
        while(rev!=null){
            if(l1.val!=rev.val){
                System.out.print(false);
                return;
            }
            rev=rev.next;
            l1=l1.next;
        }
     System.out.print(true);
}
public static void main(String[] args){
    Scanner in= new Scanner(System.in);
    int n=in.nextInt();
    Node l1=createLL(in,n);
    isPalin(l1,n);
    
}
}