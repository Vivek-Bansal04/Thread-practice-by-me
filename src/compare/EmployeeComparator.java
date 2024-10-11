package compare;

import java.util.Comparator;
//sort a collection of Employee objects by salary using Comparator

//What happens if compareTo() or compare() returns a value other than -1, 0, or 1?
//Both compareTo() and compare() should return:
//
//A negative integer if the first object is "less than" the second.
//Zero if the objects are equal.
//A positive integer if the first object is "greater than" the second.
//If a value other than -1, 0, or 1 is returned (e.g., -10, 100), it still works for comparison but might
//not be as efficient because only the sign matters, not the exact value.

public class EmployeeComparator implements Comparator<Employee> {

    public int compare(Employee emp1, Employee emp2){
        return Double.compare(emp1.getSalary(), emp2.getSalary());
    }
}
