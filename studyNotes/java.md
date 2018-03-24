# Java

### Useful methods
- Append to front of StringBuffer 
		- sb.insert(0, 'a');
- Character to Integer
		- int i = Character.getNumericValue('1');
- Get a single character from string
		- char c = "123".charAt(0);
- Int to String
		- String.valueOf(5);

- Comparator & Comparable (https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/).
Java provides two interfaces to sort objects using data members of the class:
	- Comparable is capable of comparing itself with another object. Suppose we wish 
	to sort a list of Movies based on year of release. We can implement the Comparable 
	interface with the Movie class, and we override the method `compareTo()` of Comparable interface.
	```java
	public class Movie implements Comparable<Movie> {
		public int compareTo(Movie m) {
			return this.year - m.year;
		}
	}
	```
	- Comparator is used to order user defined objects. Unlike Comparable, Comparator is 
	external to the element type we are comparing. It’s a separate class. The sort method takes 
	in comparator class `public void sort(List list, ComparatorClass c)`. The comparator interface defines 
	two methods `int compare(Obj o1, Obj o2)` & `boolean equals(Obj o2)`. The compare method return 
	`-1`,`0` or `1` to say if it is less than, equal to or greater than.
	Example:
	```java
	Class SortByRollNo implements Comparator<Student> {
		public int compare(Student s1, Student s2) {
			return s1.rollno - s2.rollno;
		}
	}
	Collections.sort(list, new SortByRollNo())
	
	Arrays.sort(list, new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			return s1.rollno - s2.rollno;
		}
	});
	```




