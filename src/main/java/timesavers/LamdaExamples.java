package timesavers;

import java.util.*;
import java.util.stream.Collectors;

public class LamdaExamples {

    public static void main(String[] args) {

        List<Employee> employeeList = generateEmployees();
        normalPrint(employeeList);
        //sortCollection(employeeList);
        //sortListByDate(employeeList);
        sortBasedOnEmpID(employeeList);


        /*****Other examples******/
        //Filtering a list and collecting back to list
        List<String> lines = Arrays.asList("coffee beans", "tea leaves", "sugar");

        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"tea leaves".equals(line))     // we dont want tea leaves
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println); //Prints coffee beans, sugar.
        //End of Filtering a list and collecting back to list

        /** The equivalent example in Java 8, use stream.filter() to filter a List, and .findAny().orElse (null) to return an object conditional */
        Employee foundEmp = employeeList.stream()
                .filter(i -> "Alex".equals(i.getEmployeeName()))
                .findAny()
                .orElse(null);
        System.out.println(foundEmp.getEmployeeName() + "\n");

        /** Similarly for multiple conditions */
        Employee foundEmpMultipleConditions = employeeList.stream()
                .filter((e) -> "Alex".equals(e.getEmployeeName()) && 47 == e.getEmployeeId())
                .findAny()
                .orElse(null);
        System.out.println(foundEmpMultipleConditions.getEmployeeName() + "\n");

        /** Multiple conditions another way */
        Employee foundEmpMultipleConditions1 = employeeList.stream()
                .filter((e) -> {
                    if ("Alex".equals(e.getEmployeeName()) && 47 == e.getEmployeeId()){
                        return true;
                    }
                    return false;
                })
                .findAny()
                .orElse(null);
        System.out.println(foundEmpMultipleConditions1.getEmployeeName() + "\n");

        /** More refined way of getting result using filter() and map()*/
        String empName = employeeList.stream()
                .filter((e) -> "James".equals(e.getEmployeeName()) && 27 == e.getEmployeeId())
                .map(Employee::getEmployeeName)
                .findAny()
                .orElse(null);
        System.out.println(empName + "\n");



        /**
         * If you have a Collection<byte[]> and want to allocate a ByteArrayOutputStream of specific size equal to total bytes length from collection.
         * filesCollection.stream().mapToInt(a -> a.length).sum();
         */

    }

    private static List<Employee> generateEmployees() {
        Employee e1 = new Employee("James", 27, 45000, new Date(1535544887000l));
        Employee e2 = new Employee("Roger", 29, 55000, new Date(1504008887000l));
        Employee e3 = new Employee("Alex", 47, 65000, new Date(1501330487000l));
        Employee e4 = new Employee("Douglas", 57, 75000, new Date(1500639287000l));

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        return employeeList;
    }

    /**
     * Prints
     * Employee{employeeName='James', employeeId=27, salary=45000, employeeStartDate=Wed Aug 29 07:14:47 CDT 2018}
     * Employee{employeeName='Roger', employeeId=29, salary=55000, employeeStartDate=Tue Aug 29 07:14:47 CDT 2017}
     * Employee{employeeName='Alex', employeeId=47, salary=65000, employeeStartDate=Sat Jul 29 07:14:47 CDT 2017}
     * Employee{employeeName='Douglas', employeeId=57, salary=75000, employeeStartDate=Fri Jul 21 07:14:47 CDT 2017}
     */
    private static void normalPrint(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
        System.out.println();
    }


    /**
     * Produces
     * Employee{employeeName='James', employeeId=27, salary=45000, employeeStartDate=Wed Aug 29 07:14:47 CDT 2018}
     * Employee{employeeName='Roger', employeeId=29, salary=55000, employeeStartDate=Tue Aug 29 07:14:47 CDT 2017}
     * Employee{employeeName='Alex', employeeId=47, salary=65000, employeeStartDate=Sat Jul 29 07:14:47 CDT 2017}
     * Employee{employeeName='Douglas', employeeId=57, salary=75000, employeeStartDate=Fri Jul 21 07:14:47 CDT 2017}
     * @param employeeList
     */
    private static void sortBasedOnEmpID(List<Employee> employeeList) {
        employeeList.sort(Comparator.comparing(Employee::getEmployeeId));
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    /**
     * Produces same output as sortCollection method.
     * @param employeeList
     */
    private static void sortListByDate(List<Employee> employeeList) {
        employeeList.sort((o1, o2) -> o1.getEmployeeStartDate().compareTo(o2.getEmployeeStartDate()));
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    /**Lamda expression to sort a list */
    /**
     * Prints
     * Employee{employeeName='Douglas', employeeId=57, salary=75000, employeeStartDate=Fri Jul 21 07:14:47 CDT 2017}
     * Employee{employeeName='Alex', employeeId=47, salary=65000, employeeStartDate=Sat Jul 29 07:14:47 CDT 2017}
     * Employee{employeeName='Roger', employeeId=29, salary=55000, employeeStartDate=Tue Aug 29 07:14:47 CDT 2017}
     * Employee{employeeName='James', employeeId=27, salary=45000, employeeStartDate=Wed Aug 29 07:14:47 CDT 2018}
     */
    private static void sortCollection(List<Employee> employeeList) {
        Collections.sort(employeeList, (o1, o2) -> o1.getEmployeeStartDate().compareTo(o2.getEmployeeStartDate()));

        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
}
