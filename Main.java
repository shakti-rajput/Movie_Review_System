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
   private int rating;
   private int raters;
   
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
    private String category;
    private int reviewCount;
    // Constructor Declaration of Class
    public User(String name)
    {
        this.name = name;
    }
    public String iscategory(String name)
    {
        return this.category;
    }
    public int totalReview(String name)
    {
        return this.reviewCount;
    }
    public void increaseReviewCount(String name)
    {
         this.reviewCount++;
         if(reviewCount==3)
         this.category="critic";
    }
}
class ReviewSystem
{
    // Instance Variables
    List<Movie> movieList=new ArrayList<Movie>();
    List<User> UserList=new ArrayList<User>();
    public void addReview(String person,String movie, int rating)
    {
         if(Collections.binarySearch(movieList))
    }
    // Constructor Declaration of Class
    
}

public class Main
{
  
	public static void main(String[] args) {
	    
		System.out.println("Hello World");
		Movie x=new Movie("RajaHinustani","2000","Romantic");
		Movie y=new Movie("Hinustani","2000","Romantic");
		Movie z=new Movie("Raa","2000","Romantic");
		
		ReviewSystem review=new ReviewSystem();
		review.movieList.add(x);
		review.movieList.add(y);
		review.movieList.add(z);
        review.movieList.sort(Comparator.comparing(Movie::getname));
// 		Collections.sort(review.movieList, new CompareObj());
// 		List<Movie> movieList=new ArrayList<Movie>();
        // TreeSet<String> movieList = new TreeSet<String>();
// 		 movieList.add(x);
		 User sharuk = new User("Sharuk Khan");
		 for (int i = 0; i < review.movieList.size(); i++) 
            System.out.print(review.movieList.get(i).getname() + " ");
	}
}
