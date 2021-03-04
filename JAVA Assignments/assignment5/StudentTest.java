
import java.util.Scanner;
class  Student {
	int sid,age;
	String sname; 
	int marks[]=new int[4];
	int m1,m2,m3,m4;
	float total=0;
	 Scanner sc = new Scanner(System.in);
	char grade;
	
void read(){
		 System.out.println("enter id ");
		 	sid=sc.nextInt();
			sc.nextLine();
			
			System.out.println("enter name");
			 sname=sc.nextLine();
			
			System.out.println("enter age");
			age=sc.nextInt();
			
			System.out.println("enter marks");
			for(int i=0;i<marks.length;i++) {
				marks[i]=sc.nextInt();
				total=total+marks[i];
				
			}
		
	}

void calculategrade() {
	float totalavg;
	totalavg=(total/4);
   if(totalavg>=90) {
	      grade='A';
	}
   else if(totalavg>=80) {
		grade='B';
		
	}
	else if(totalavg>=70) {
		grade='C';
		
	}
	else if(totalavg>=55) {
		grade='D';
		
	}
	else {
		grade='E';
		
	}
   System.out.println(grade);


}

void display() {

	 System.out.println("\n " );
	 System.out.println("sid="+sid);
	 System.out.println("sname="+sname);
	 System.out.println("age="+age);
	 System.out.println("grade"+grade);
	
}

}
 class StudentTest{
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("how many students you want to store");
	     int n = sc.nextInt();
		Student std[]=new Student[n];
		for(int i=0;i<n;i++) {
			std[i]=new Student();
			std[i].read();
			
		}
		for(int i=0;i<n;i++) {
			std[i].calculategrade();
		}
		for(int i=0;i<n;i++) {
			
			std[i].display();
		
		}
		
	}

}

