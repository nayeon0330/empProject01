package com.encore.emp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmpServiceImplTest {

    EmpServiceImpl empService;
    MemoryEmpRepository empRepository;

    @BeforeEach
    public void beforeEach(){
        empRepository = new MemoryEmpRepository();
        empService = new EmpServiceImpl(empRepository);
    }

    @AfterEach
    public void afterEach(){
        empRepository.clearStore();
    }
    @Test
    void join() {

        //given
        Emp employee = new Emp();
        employee.setEname("박보검");

        employee.setHiredate("2020-01-01");

        employee.setGrade(Grade.NORMAL);

        //when
        Integer id = empService.join(employee);

        //then
        Emp findEmployee = empService.findEmpById(id).get();
        assertThat(employee.getEname()).isEqualTo(findEmployee.getEname());


    }

    @Test
    void validateDuplicateName() {
        //given
        Emp employee1 = new Emp();
        employee1.setEname("박보검");

        Emp employee2 = new Emp();
        employee2.setEname("박보검");

        //when
        empService.join(employee1);

        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> empService.join(employee2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 사원 입니다.");


    }

    @Test
    void findEmpById() {

        Emp employees1 = new Emp();
        employees1.setEname("박보검1");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);
        empService.join(employees1);

        Emp employees2 = new Emp();
        employees2.setEname("조인성");

        employees2.setHiredate("2020-01-01");

        employees2.setGrade(Grade.NORMAL);
        empService.join(employees2);

        Emp result = empService.findEmpById(employees1.getEno()).get();
        assertThat(result).isEqualTo(employees1);
    }

    @Test
    void findEmpByName() {


        Emp employees1 = new Emp();
        employees1.setEname("박보검1");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);
        empService.join(employees1);

        Emp employees2 = new Emp();
        employees2.setEname("조인성");

        employees2.setHiredate("2020-01-01");

        employees2.setGrade(Grade.NORMAL);
        empService.join(employees2);

        Emp result = empService.findEmpByName(employees1.getEname()).get();
        assertThat(result).isEqualTo(employees1);
    }

    @Test
    void findAll() {

        Emp employees = new Emp();
        employees.setEname("조인성");

        employees.setHiredate("2020-01-01");

        employees.setGrade(Grade.NORMAL);

        empService.join(employees);


        Emp employees1 = new Emp();
        employees1.setEname("박서준");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);

        empService.join(employees1);

        List<Emp> result = empService.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void update() {

        //given
        Emp employees1 = new Emp();
        employees1.setEname("박서준");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);

        empService.join(employees1);

        //when

        Emp employees = empService.findEmpById(employees1.getEno()).get();


        empService.update(employees);
        Emp result = empService.findEmpById(employees1.getEno()).get();
        //then
        assertThat(employees).isEqualTo(result);
    }

    @Test
    void updateRetiree() {

        //given
        Emp employees1 = new Emp();
        employees1.setEname("박서준");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);
        empService.join(employees1);

        //when
        empService.updateRetiree(employees1);

        //then
        Emp result = empService.findEmpById(employees1.getEno()).get();
        assertThat(result.getGrade()).isEqualTo(Grade.RETIREE);
    }
}