import java.util.Scanner;
class Employee{
int id;
String name;
double salary;
Scanner sc=new Scanner(System.in);
Address add=new Address();
void read(){
 System.out.println("enter id");
id=sc.nextInt();
sc.nextLine();
System.out.println("enter name");
name=sc.nextLine();
System.out.println("enter salary");
salary=sc.nextDouble();
}

void calSalary()
{
double DA,HRA,PF;
HRA= 0.10*salary;
DA= 0.07*salary;
PF=0.05*salary;
salary= salary+HRA+DA-PF;
}

void display()
{
System.out.println("Employee Details");
System.out.println("\n---------------------------");
System.out.println("ID of the Employee: "+id);
System.out.println("Name of the Employee: "+name);
System.out.println("Salary of the Employee: "+salary);

}
}



class Manager extends Employee{
int number;
void readmgr()
{
System.out.println("enter no. of employees ");
number=sc.nextInt();
add.readadd();
}
void dismgr(){
System.out.println("enter no. of employees "+number);
add.disadd();
}
}


class Programmer extends Employee{
String projectname;
void readprg()
{
sc.nextLine();
System.out.println("enter name of the project ");
projectname=sc.nextLine();
add.readadd();
}
void disprg(){
System.out.println("project is"+projectname);
add.disadd();
}
}

class Address
{
String city,state;
int pincode;
Scanner obj=new Scanner(System.in);
void readadd()
{
System.out.println("enter city ");
city=obj.nextLine();
System.out.println("enter states ");
state=obj.nextLine();
System.out.println("enter pincode ");
pincode=obj.nextInt();
}
void disadd()
{
System.out.println("city"+city);
System.out.println("state"+state);
System.out.println("pincode "+pincode);
}
}


class EmpTest{
public static void main(String args[])
{
System.out.println("Manager details ");
Manager mgr=new Manager();
mgr.read();
mgr.readmgr();
System.out.println("programmer details ");
Programmer prg=new Programmer();
prg.read();
prg.readprg();
mgr.calSalary();
prg.calSalary();
mgr.display();
mgr.dismgr();
prg.display();
prg.disprg();
}
}