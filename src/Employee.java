import java.io.IOException;
import java.util.Scanner;

public class Employee {
    String Level;
    Integer Job_number;
    Double Gross,Basic,HRA,Perks, Net, IncomeTax;


    Employee(){

    }

    public static void main(String[] args) throws IOException {
        Integer CA1=1000,CA2=750,CA3=500,CA4=250,EA1=500,EA2=200,EA3=100,EA4=0;
        Employee emp = new Employee();

        //Getting user inputs
        Scanner sc= new Scanner(System.in);

        System.out.println("Please enter Job Number : ");
        emp.Job_number = sc.nextInt();

        System.out.println("Please enter level from one of this ('Manager','Project Leader','Software Engineer','Consultant'): ");
        emp.Level = sc.next();

        System.out.println("Please enter Basic pay : ");
        emp.Basic = sc.nextDouble();

        switch (emp.Level) {
            case "Manager":
                emp.Perks = (double) EA1+CA1;
                break;
            case "Project Leader":
                emp.Perks = (double) EA2+CA2;
                break;
            case "Software Engineer":
                emp.Perks = (double) EA3+CA3;
                break;
            case "Consultant":
                emp.Perks = (double) EA4+CA4;
                break;
            default:
                throw new IOException("Employee level value doesn't matched");
        }

        emp.HRA = (25/100) * emp.Basic;

        emp.Gross = emp.Basic + emp.HRA + emp.Perks;

        if (emp.Gross<=2000)
            emp.IncomeTax = 0.0d;
        else if (emp.Gross>2000 && emp.Gross<=4000)
            emp.IncomeTax = (0.03) * emp.Gross;
        else if (emp.Gross>4000 && emp.Gross<=5000)
            emp.IncomeTax = (0.05) * emp.Gross;
        else
            emp.IncomeTax = (0.08) * emp.Gross;

        emp.Net = emp.Gross - emp.IncomeTax;

        System.out.println("Values ");
        System.out.println("Level : "+emp.Level);
        System.out.println("JOB Number : "+emp.Job_number);
        System.out.println("Gross Pay : "+emp.Gross);
        System.out.println("Income Tax : "+emp.IncomeTax);
        System.out.println("Net Salary : "+emp.Net);
    }

}