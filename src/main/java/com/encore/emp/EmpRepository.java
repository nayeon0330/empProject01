package com.encore.emp;

import java.util.List;
import java.util.Optional;

public interface EmpRepository {
    //crud
    //create
    Emp save(Emp employee);
    //read (id, name, all)
    Optional<Emp> findById(int eno);
    Optional<Emp> findByName(String ename);
    List<Emp> findAll();

    List<Emp> findByDept(int depno);


    //update
    Emp update(Emp employees);

    //delete(update grade)
    Emp updateRetiree (Emp employees);

}
