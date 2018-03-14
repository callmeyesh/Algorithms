# Java

### Useful methods
- Append to front of StringBuffer 
		- `sb.insert(0, 'a');`
- Character to Integer
		- `int i = Character.getNumericValue('1');`
- Get a single character from string
		- `char c = "123".charAt(0);`
		
- Comparator is used to order user defined objects. The sort method takes in comparator class
`public void sort(List list, ComparatorClass c)`. The comparator interface defines two methods `int compare(Obj o1, Obj o2)` & `boolean equals(Obj o2)`.
The compare method return `-1`,`0` or `1` to say if it is less than, equal to or greater than.
Example:
```java
Class SortByRollNo implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.rollno - s2.rollno;
	}
}
Collections.sort(list, new SortByRollNo())

Arrays.sort(list, new Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.rollno - s2.rollno;
	}
});
```




