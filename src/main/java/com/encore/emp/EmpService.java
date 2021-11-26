package com.encore.emp;

import java.util.List;
import java.util.Optional;

public interface EmpService {

    Integer join(Emp employees);
    void validateDuplicateName(Emp employees);

    Optional<Emp> findEmpById(int employeesId);
    Optional<Emp> findEmpByName(String ename);
    List<Emp> findAll();
    //update
    Emp update(Emp employees);

    //delete(update grade)
    Emp updateRetiree (Emp employees);


}