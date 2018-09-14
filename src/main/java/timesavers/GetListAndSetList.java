package timesavers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetListAndSetList {

    public static void main(String[] args) {
        CreateEmployeeList createEmployeeList = new CreateEmployeeList();
        createEmployeeList.setEmployeeList(LamdaExamples.generateEmployees());

        TargetEmployeeList targetEmployeeList = new TargetEmployeeList();

        /**This is how you use it. */
        //targetEmployeeList.setTargetEmployeeList(dtoConverter(createEmployeeList, somenameConverter));

    }

    /**
     * Below 2 functions will help in getting each value from the list and set on to the target list.
     */
    /*static final Function<SourceDTO, TargetDTO> somenameConverter =
            sourceDTO -> {
                final TargetDTO targetDTO = new TargetDTO();
                targetDTO.setFirstField(sourceDTO.getFirstField());
                targetDTO.setSecondField(sourceDTO.getSecondField());
                return targetDTO;
            };

    private static <F, T> List<T> dtoConverter(List<F> input, Function<F, T> transform){
        return org.apache.commons.collections4.CollectionUtils.emptyIfNull(input).stream().map(transform).collect(Collectors.toList());
    }*/
}

 class CreateEmployeeList{
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
 }

 class TargetEmployeeList{
     private List<Employee> targetEmployeeList;

     public List<Employee> getTargetEmployeeList() {
         return targetEmployeeList;
     }

     public void setTargetEmployeeList(List<Employee> targetEmployeeList) {
         this.targetEmployeeList = targetEmployeeList;
     }
 }