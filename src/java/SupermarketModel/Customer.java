package SupermarketModel;

public class Customer 
{
  public String name, address, gen,user,pass;      
  public int i, mt,sal;

    public Customer(String name, String address, String gen, 
                    String user, String pass, int i, int mt, int sal) 
    {
        this.name = name;
        this.address = address;
        this.gen = gen;
        this.user = user;
        this.pass = pass;
        this.i = i;
        this.mt = mt;
        this.sal = sal;
    }
  
}

class SortingLogic  implements java.util.Comparator<Customer>
{
  public int compare(Customer o1, Customer o2) 
  {
    return (o1.i - o2.i );
  }  
}
