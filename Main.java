/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Movie
{
    // Instance Variables
   private String name;
   private String year;
   private String gener;
   private int rating=0;
   private int raters=0;
   
//   private List<User> userList=new ArrayList<User>();
   private Map<String, Integer> userList  = new HashMap<String, Integer>();
 
    // Constructor Declaration of Class
    public Movie(String name, String year,
                    String gener)
    {
        this.name = name;
        this.year = year;
        this.gener = gener;
    }
    public String getname()
    {
        return this.name;
    }
    public String getYear()
    {
        return this.year;
    }
    public void addUser(String user,int rating)
    {
        this.userList.put(user,rating);
        this.rating=(this.rating*raters+rating)/(raters+1);
        this.raters+=1;
    }
    public int getRating()
    {
        return this.rating;
    }
    public Boolean checkUser(String user)
    {
        if(userList.containsKey(user))
        {
            return true;
        }
        return false;
        // this.userList.stream().filter(s -> 
        // {
        //     if(s.name.equals(user))
        //     {
        //         return true;
        //     }
        //     return false;
        // });
        // return false;
    }
}
class User
{
    // Instance Variables
    private String name;
    private String category="";
    private int reviewCount;
    // Constructor Declaration of Class
    public User(String name)
    {
        this.name = name;
    }
    public String getname()
    {
        return this.name;
    }
    public String iscategory()
    {
        return this.category;
    }
    public int totalReview()
    {
        return this.reviewCount;
    }
    public void increaseReviewCount()
    {
         this.reviewCount+=1;
         if(reviewCount==3)
         this.category="critic";
    }
}
class ReviewSystem
{
    // Instance Variables
    List<Movie> movieList=new ArrayList<Movie>();
    List<User> users=new ArrayList<User>();
    public void addReview(String person,String movie, int rating)
    {
        //     Comparator<Movie> c = new Comparator<Movie>() {
        //   public int compare(Movie u1, Movie u2) {
        //     return u1.getname().compareTo(u2.getname());
        //   }
        // };
        int movieIndex = Collections.binarySearch(movieList, new Movie(movie,"",""), Comparator.comparing(Movie::getname));
        int userIndex = Collections.binarySearch(users, new User(person), Comparator.comparing(User::getname));
         
         if((movieIndex>=0 && movieIndex<movieList.size())  && (userIndex>=0 && userIndex<users.size()) )
         {
             if(!movieList.get(movieIndex).checkUser(person))
             {
                 users.get(userIndex).increaseReviewCount();
                 if(users.get(userIndex).iscategory().equals("critic"))
                 {
                     rating=rating*2;
                 }
                 movieList.get(movieIndex).addUser(person,rating);
                 
                //  System.out.println("Raja");
             }
             else
             {
                 System.out.println(person +" User already added rating for "+movie+" movie");
             }
         }
         else
         {
             System.out.println("Either Movie or User was not in list");
         }
    }
    // Constructor Declaration of Class
    
}

public class Main
{
  
	public static void main(String[] args) {
	    
// 		System.out.println("Hello World");
		Movie x=new Movie("RajaHinustani","2000","Romantic");
		Movie y=new Movie("Hinustani","2000","Romantic");
		Movie z=new Movie("Raa","2000","Romantic");
		Movie a=new Movie("Raa2","2000","Romantic");
		
		ReviewSystem system=new ReviewSystem();
		system.movieList.add(x);
		system.movieList.add(y);
		system.movieList.add(z);
		system.movieList.add(a);
        system.movieList.sort(Comparator.comparing(Movie::getname));  // sort for indexing on columns
        
        
// 		Collections.sort(system.movieList, new CompareObj());
// 		List<Movie> movieList=new ArrayList<Movie>();
        // TreeSet<String> movieList = new TreeSet<String>();
// 		 movieList.add(x);

		 User sharuk = new User("Sharuk Khan");
		 User salman = new User("Salman Khan");
		 User amir = new User("Amir Khan");
		 system.users.add(sharuk);
		 system.users.add(salman);
		 system.users.add(amir);
		 system.users.sort(Comparator.comparing(User::getname)); // sort for indexing on columns
		 

		 system.addReview("Sharuk Khan","Raa",2);
		 system.addReview("Sharuk Khan","Raa",5); // Same movie cannot be reviewed twice by same person
		 
		 system.addReview("Sharuk Khan","RajaHinustani",1);
		 system.addReview("Sharuk Khan","Hinustani",5);
		 system.addReview("Salman Khan","Hinustani",3);
		 system.addReview("Amir Khan","Hinustani",2);
		 
		 
		 system.addReview("Sharuk Khan","Raa2",3); //Sharuk becomes critic
		 
		  // System.out.println(system.users.get(2).totalReview());
		 for (int i = 0; i < system.movieList.size(); i++) 
            System.out.println(system.movieList.get(i).getname() + " "+system.movieList.get(i).getRating());
	}
}
