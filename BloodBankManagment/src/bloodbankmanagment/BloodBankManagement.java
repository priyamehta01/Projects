/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankmanagment;

import java.io.BufferedInputStream;                                             //Importing various libraries
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BloodBankManagement {                                              //Main Class
    
    
   private static LinkedList head = new LinkedList();                           //Objects of various classes
   public static LinkedListBST l = new LinkedListBST();
   //public static int donor_id = 1;
   
   public static void main(String[] args) throws IOException                    //Main Function
    {
        int choice, u_id;                                                       //Variable declaration                        
        int d_choice, e_choice, br1 , return_id;
        String br, u_bg, s_bg;
        Scanner input = new Scanner(System.in);
        BloodBankManagement b = new BloodBankManagement();                      //Object creation
       
        l.insert();                                                             //Making a predefined tree according to the blood groups
        l.bst.preorder();                                                       //Displaying the contents of the tree in preorder fashion    
        do
        {
            System.out.println("\nEnter choice");                               //Asking user for input regarding the way he wants to proceed with the program
            System.out.println("1. Donate");
            System.out.println("2. Need");
            System.out.println("3. Display");
            System.out.println("0. Exit");
            choice = input.nextInt();

            if(choice == 0)
            {
                return;
            }
            
            else if(choice < 1 || choice >3)                                    //Checking for validity of input
            {
                System.out.println("Invalid Input!");
            }

            else if(choice == 1)
            {
                System.out.println("Do you have an account? [1 for yes, 0 for no]");
                d_choice = input.nextInt();
                if(d_choice == 0)
                {
                    Donor newData = new Donor();
                    head.append(newData);                                       //Adding data to the linked list
                    l.update(newData.id, newData.bg);                           //Updating data in the blood group binary tree
                    
                }
                
                else if(d_choice==1)
                {
                    System.out.println("Enter choice");
                    System.out.println("1. Update personal details");
                    System.out.println("2. Donate Blood");
                    e_choice = input.nextInt();
                    System.out.println("Enter your donor id: ");                //Asking for ID from existing user
                    u_id = input.nextInt();
                    s_bg = head.search(u_id);                                   //Searching the ID in the linked list
                    head.update(e_choice, u_id);                                //Updating user details 
                   
                    if(e_choice == 2)
                    {
                        l.update(u_id, s_bg);                                   //Updating the user details in the binary tree of blood groups
                    }
                }
            }

            else if(choice == 2)
            {
                System.out.println("Enter the blood group you want :");         //Asking for blood group when user needs blood
                br = input.nextLine();
                br = input.nextLine();
                br1 = l.data(br);
                return_id = l.bst.delete(br1);                                  //Deleting data frok the binary tree i.e. lessening the blood bottles 
                head.delete(return_id);                                         //Deleting data from the linked list
            }
            
            else if(choice == 3)
            {
                head.display();                                                 //Displying personal details
                l.bst.preorder();                                               //Displaying blood group binary tree
            }
        }while(true);
    }
}

class Donor                                                                     //Class dealing with donations
{
    long contact_num;                                                           //Variable declaration
    String name, bg, str_contact_num;
    int id, cnt=1, age;
    int file_write = 0;
    
    InputStream inputstream;
    BloodBankManagement bm = new BloodBankManagement();                         //Objecct of class to access functions and variables
    
    LinkedList first=null;
    LinkedList curr=null;
    
    
    
    Donor() throws IOException                                                  //Constructor accepting donor details
    { 
        String file_id, toFileid;
        int id_int = 0;
        try
        {
            Scanner fileId = new Scanner(new File("id.txt"));                   //File which consists of the last donor ID which ensures that no two users get the same donor ID
            file_id = fileId.next();
            id_int = Integer.parseInt(file_id);  
            id_int++;
            BufferedWriter input = new BufferedWriter(new FileWriter("id.txt")); //Writing ID to file
            toFileid = Integer.toString(id_int);
            input.write(toFileid);
            input.close();                                                      //Closing the file
        }
        
        catch(Exception e){
        }
             
        String str_contact_num;
        
        //Asking for various donor details
        int len=0;
        id = id_int;    
        this.id = id;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your name : ");
        this.name=input.nextLine();
        System.out.println("Enter your contact number : ");
        //this.contact_num=input.nextLong();
        this.str_contact_num = input.next();
        len = this.str_contact_num.length();
        if(len == 10)
        {
            try
            {
                   contact_num = Integer.parseInt(this.str_contact_num);
            }
            catch(NumberFormatException ex)
            {
                   System.out.println("Enter a valid 10 digit number");
                   this.str_contact_num = input.next();
                   contact_num = Integer.parseInt(this.str_contact_num);
            }
                
        }
        else
        {
            System.out.println("Enter a valid 10 digit number");
            str_contact_num = input.next();
            contact_num = Integer.parseInt(this.str_contact_num);
        }
       
        System.out.println("Enter your age : ");
        this.age=input.nextInt();
        
        if(age<16 || age>67)
        {
            System.out.println("Sorry .... \nYou don't fit in to donate blood ");
            System.exit(0);
        }
        
        System.out.println("Enter your blood group : ");
        this.bg = input.nextLine();
        this.bg = input.nextLine();
        
        BufferedWriter output;                                                  //To write user's personal details to file
        try
        {
            output = new BufferedWriter(new FileWriter(bg+".txt", true));       
        
            output.newLine();                                                   //Writing data to the file
            output.append("ID : "+id);
            output.newLine();
            output.append("Name : "+name);
            output.newLine();
            output.append("Contact Number : "+contact_num);
            output.newLine();
            output.append("Age : "+age);
            output.newLine();
            output.append("Blood Group : "+bg);
            output.newLine();                                               
            output.append("Blood Donation Done : "+cnt);
                
            
            output.close();
        }
        
        catch (IOException e)                                                   //Catching thrown exception
        {
            System.out.println("Entry not successful in file!");
        }
       
        System.out.println(" ");                                                //Displying user details on console
        System.out.println("YOUR DETAILS");
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Contact number : "+contact_num);
        System.out.println("Age : "+age);
        System.out.println("Blood Group : "+bg);
        System.out.println("Blood Donations Done : "+cnt);
    }
    
    void display()
    {
        System.out.println(" ");                                                //Displaying user details
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Contact number : "+contact_num);
        System.out.println("Age : "+age);
        System.out.println("Blood Group : "+bg);
        System.out.println("Blood Donations Done : "+cnt);
        
    }
    
    public String getname()
    {
        return name;
    }
    
    void update() throws FileNotFoundException, IOException                     //Updating personal details of the user
    {
        String line;
        int i;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter donor name : ");                              //Asking for new data from the user
        this.name=input.nextLine();
        System.out.println("Enter donor contact number : ");
        this.contact_num=input.nextLong();
        System.out.println("Enter donor age");
        this.age=input.nextInt();
        
        
        Scanner fileIn = new Scanner(new File(bg+".txt"));                      //Updating the data in the file at the same ID
        File inputFile = new File(bg+".txt");                                   //Blood group file
        File tempFile = new File("myTempFile.txt");                             //Temporary file where updated data will be stored 

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));  //For reading from a file
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));   //For writing to a file
        
        String details[] = new String[6];                                       //Array stroring old data
        
        while(fileIn.hasNextLine())                                             //Reading the whole file
        {
            line = fileIn.nextLine();
            if(line.compareTo("ID : "+id) == 0)                                 //Searching for ID to be updated
            {
                for(i=0;i<4;i++)
                {
                    details[i] = line;
                    line = fileIn.nextLine();
                  
                }
                
                writer.newLine();                                               //Updating data at the ID location in the temporary file
                writer.append("ID : "+id);
                writer.newLine();
                writer.append("Name : "+name);
                writer.newLine();
                writer.append("Contact Number : "+contact_num);
                writer.newLine();
                writer.append("Age : "+age);
                writer.newLine();
                writer.append("Blood Group : "+bg);
                writer.newLine();                                               
                writer.append("Blood Donation Done : "+cnt);
                
            }
            
            else
            {
                writer.append(line);                                            //Writing non modified data to the temporary file as it is 
                writer.newLine();
            }
        }
        writer.close();                                                         //Closing all file
        reader.close();
        writer.close();
        fileIn.close();
        String file_name;
        
        try{                                                                    //Deleting the old, non updated file

                file_name = bg+".txt";
    		File file = new File(file_name);

    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}

    	}catch(Exception e){

    		e.printStackTrace();

    	}
        
        File oldName = new File("myTempFile.txt");                              //Renaming the temporary file to the blood group file name
        File newName = new File(bg+".txt");
        if(oldName.renameTo(newName)) {
 
        } else {
     
        }
        
        System.out.println("  ");                                               //Printing modified details to the console
        System.out.println("YOUR DETAILS");
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Contact number : "+contact_num);
        System.out.println("Age : "+age);
        System.out.println("Blood Group : "+bg);
        System.out.println("Blood Donations Done : "+cnt);
    
    }

}



class LinkedList                                                                //Linked list storing personal details of the user
{
    Donor data=null;                                                            //Variable and pointer declaration
    LinkedList next = null;
    LinkedList first=null;
    int cntnum, age; 
    String name;


	public void append(Donor newData)                                       //Function to append the list
	{ 
		LinkedList curr;
                if(data == null)
                {
			this.data = newData;                                    //Appending first node
                       
                }
		else
		{
			
			for(curr = this; curr.next!=null; curr = curr.next);    //Appending nodes to a list of nodes

			curr.next = new LinkedList();
			curr = curr.next;
			curr.data = newData;
			curr.next = null;
		}
	}
        public void display()                                                   //Function to display the entered list
	{
		if(this.data == null)
			System.out.println("\nList is Empty!");
		else
		{
			LinkedList curr;
			for(curr = this; curr!=null; curr = curr.next)          //Scanning the whole list and displaying data
			{
				curr.data.display();
				System.out.print("\t");
			}
		}
	} 
        
    void update(int choice, int id) throws FileNotFoundException, IOException   //Updating user details
    {
        int flag = 0;
        Scanner input=new Scanner(System.in);
        
        
        LinkedList curr;
        
        for(curr=this;curr!=null;curr=curr.next)                
        {
            if(id == curr.data.id)                                              //Searching for the user ID from the list
            {
                if(choice == 1)
                {
                    curr.data.update();                                         //Calling the update function
                    flag=1;
                }
                
                else if(choice == 2)
                {
                    curr.data.cnt++;                                            //Incrementing blood bottles
                    
                    System.out.println("   ");                                  //Displaying various user details
                    System.out.println("YOUR DETAILS");
                    System.out.println("ID : "+curr.data.id);
                    System.out.println("Name : "+curr.data.name);
                    System.out.println("Contact number : "+curr.data.contact_num);
                    System.out.println("Age : "+curr.data.age);
                    System.out.println("Blood Group : "+curr.data.bg);
                    System.out.println("Blood Bottles Left : "+curr.data.cnt);
                    flag=1;
                }
            }   
        }
        
         if(flag==0)
                System.out.println("Not Found!");  
    }
    
    String search(int id)                                                       //Searching for the ID in the lined list
    {
        int flag=0;
        LinkedList curr;
        
        for(curr=this;curr!=null;curr=curr.next)
        {
            if(id == curr.data.id)
            {
                  flag=1;
                  return curr.data.bg;                                          //Returns the number of blood bottles of the user
            }
        }   
        
        
         if(flag==0)
                System.out.println("Not Found!");
        
        return null;
    }
    
    void delete(int id)                                                         //Function to delete data from the personal details when a donation is made from that ID
    {
        int flag=0;
        LinkedList curr;
       
        for(curr=this;curr!=null;curr=curr.next)
        {
            if(id == curr.data.id)
            {
                  curr.data.cnt--;                                              //Decrementing the blood bottles
                  flag=1;
            }
        }   
        
        
         if(flag==0)
                System.out.println("Not Found!");
        
    }
   
     
}


class LinkedListBST                                                             //Binary tree implementation using linked list
{               
         Scanner scan = new Scanner(System.in);
         BST bst = new BST(); 
         int bloodGroup[] = {5, 4, 6, 2, 8, 1, 3, 7, 9};                        //Various Declarations
         int i, j;
    
         void insert()
         {
            for(i=0; i<9; i++)
            {
                bst.insert(bloodGroup[i]);                                      //Inserting nodes, i.e. blood groups to the binary tree
            }
         }
         
            void update(int id, String bg)                                      //Updating data in the binary tree using ID and blood group
         {
             j = data(bg);
             bst.search(j, id);
         }
         
        int data(String bg)                                                     //Allocating various blood groups node numbers so we can implement binary search tree concept
         {
             int k=0;
             if(bg.compareTo("A+") == 0 || bg.compareTo("a+") == 0){
                 k=1;
             }
             
             if(bg.compareTo("B+") == 0 || bg.compareTo("b+") == 0){
                 k=3;
             }
             
             if(bg.compareTo("AB+") == 0 || bg.compareTo("ab+") == 0){
                 k=2;
             }
             
             if(bg.compareTo("O+") == 0 || bg.compareTo("o+") == 0){
                 k=4;
             }
             
             if(bg.compareTo("A-") == 0 || bg.compareTo("a-") == 0){
                 k=7;
             }
             
             if(bg.compareTo("B-") == 0 || bg.compareTo("b-") == 0){
                 k=9;
             }
             
             if(bg.compareTo("AB-") == 0|| bg.compareTo("ab-") == 0){
                 k=8;
             }
             
             if(bg.compareTo("O-") == 0 || bg.compareTo("o-") == 0){
                 k=6;
             }
             
             return k;                                                          //Returns node number corresponding to the blood group
         }
       
}

class Node                                                                      //Representing a node in the binary seach tree 
 {
     Node left, right;
     int data;
     int i, count;
     int id_donor[] = new int [100];

     public Node(int n)                                                         //Allocating various feilds to the node
     {
         left = null;
         right = null;
         data = n;
         count = 0;
         for(i=0;i<100;i++)
         {
             id_donor[i] = 0;
         }
     }         
 }
 
 class BST                                                                      //Class performing various operations on the nodes of binary tree
 {
     private Node root;
     int top[] = new int [10];
     int id_delete;
     //LinkedListBST lb = new LinkedListBST();
 
     public BST()
     {
         root = null;
     }
     
         
        String string_return(int i)
        {
            String s=null;
            
            if(i==1)
            {
                s="A+";
            }
            else if(i==2)
            {
                s="AB+";
            }
            else if(i==3)
            {
                s="B+";
            }
            else if(i==4)
            {
                s="O+";
            }
            else if(i==6)
            {
                s="O-";
            }
            else if(i==7)
            {
                s="A-";
            }
            else if(i==8)
            {
                s="AB-";
            }
            else if(i==9)
            {
                s="B-";
            }
            return s;
        }
         
        
        
     
     public void insert(int data)                                               //Inserting data to the binary tree
     {
         root = insert(root, data);
     }
     
     public Node insert(Node node, int data)                                    //Insertion in binary search tree fashion
     {
         if (node == null)
             node = new Node(data);
         else
         {
             if (data <= node.data)                                             //Decision to make whether to insert in right node or the left one
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
     
    public void preorder()                                                      //Preoder traversal of the binary tree
    {
         preorder(root);
    }
     
    public void preorder(Node r)                                                //Displays binary tree in preorder fashion
    {
         String d;
         
         if (r != null)
         {
             System.out.println("   ");                                         //Displaying data of nodes
             d=string_return(r.data);
             if(r.data==5)
             {
                 preorder(r.left);             
                 preorder(r.right);
             
             }
            else
            {
             
             System.out.println("Data of blood group : "+d);
             System.out.println("Count of blood bottles : "+r.count);
             System.out.println("List of donor id : ");
             for(int v= 0; v<10 ; v++)                                          //Scanning the whole binary tree
             {
                 if(r.id_donor[v] != 0)
                 System.out.print(r.id_donor[v]+"\t");
             }
             System.out.println(" ");
             
             preorder(r.left);             
             preorder(r.right);
             }
                 
             
         }
    }
    
    public void search(int i, int j)                                            //Search operation on the binary tree
    {
        search(i, j, root);
    }
    
    public void search(int i, int id, Node current)                             //Searching on the basis of ID
    {
        
        while(current != null)
        {
            if(current.data == i)                                               //Binary search performed on the binary tree, comaring it to the node value, i, passed
                    
            {
                current.id_donor[top[i]++] = id;
                current.count++;
                return;
            }
            
            if(current.data > i)
            {
                current = current.left;
            }
            
            if(current.data < i)
            {
                current = current.right;
            }
        }
    }
   
    
    public Node find_parent(Node p, int bg)                                     //Function to find parent of the given node when blood bottles of a particular blood group are not available and blood has to be taken from the parent node
    {
        Node current = root;
        Node prev = null;
        
        
        while(current!=null)
        {

            if(current.data == p.data)                                          //prev represents the parent node which is non empty
            {
                return prev;
            }
              
            else if(current.data > p.data)                                      //Binary search operation performed and the node is found which has blood bottles
            {
              
                prev = current;
                current = current.left;
            }
            
            else if(current.data < p.data)
            {
                prev = current;
                current = current.right;
            }
       
        }
        
        return null;
    }
    
    
    public int delete(int bg)                                                   //Function to delete data from the binary tree
    {
        Node current = root;
        Node prev =null;
        Node prev_return= null;
        Node p = null;
        String s, s1;
        while(current != null)
        {
            if(current.data == bg)                                              //Checking for the node to be seached
            {
                
                id_delete = current.id_donor[0];
                
                if(id_delete == 0 && prev.id_donor[0] != 0)
                {
                    id_delete = prev.id_donor[0];                               //ID to be deleted stored in id_delete
                    prev.count--;
                    s=string_return(current.data);
                    s1=string_return(prev.data);
                    System.out.println("We do not have "+s+" blood group.\n Instead you are being donated "+s1+" blood group");
                    
                    for(int k=0; k<9; k++)
                    {
                        prev.id_donor[k] = prev.id_donor[k+1] ;                 //Data deleted
                    }
                    
                    
                    return id_delete;
                    
                }          
        
                else if(id_delete == 0 && prev.id_donor[0] == 0)                //When blood is to be fetched from the parent
                {
                    
                    p=current;
                    prev=find_parent(prev, prev.data);
                    prev.count--;
                    id_delete = prev.id_donor[0];
                    s=string_return(current.data);
                    s1=string_return(prev.data);
                    System.out.println("We do not have "+s+" blood group.\n Instead you are being donated "+s1+" blood group");
                    for(int k=0; k<9; k++)
                    {
                       prev.id_donor[k] = prev.id_donor[k+1] ;                  //Data deleted
                    }


                return id_delete;       
                }
                
                else
                {
                    s=string_return(current.data);
                    System.out.println("You are beind donated "+s+" blood group");
                    current.count--;                                            //Decrementing the blood bottles
                    for(int k=0; k<9; k++)
                    {
                        current.id_donor[k] = current.id_donor[k+1] ;
                    }
                }
                return id_delete;
            }
            
            if(current.data > bg)                                               //Traversing the binary tree in nbinary search fashion
            {
                prev = current;
                current = current.left;
            }
            
            if(current.data < bg)
            {
                prev = current;
                current = current.right;
            }
       
        }
         return 0; 
    }
 }
