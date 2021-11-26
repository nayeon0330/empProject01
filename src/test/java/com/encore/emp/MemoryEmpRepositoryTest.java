package com.encore.emp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MemoryEmpRepositoryTest {
    MemoryEmpRepository repository = new MemoryEmpRepository();
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Emp employees = new Emp();
        /**
         *
         * @param eno 사원 번호
         * @param ename 이름
         * @param job 업무
         * @param hiredate 입사일
         * @param dept 부서명
         * @param grade 등급 (관리자,직원,퇴사자)
         */


        employees.setEname("박보검");

        employees.setHiredate("2020-01-01");

        employees.setGrade(Grade.NORMAL);

        repository.save(employees);

        Emp result= repository.findById(employees.getEno()).get();
        assertThat(employees).isEqualTo(result);



        Emp employees1 = new Emp();
        employees1.setEname("박보검1");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);

        repository.save(employees1);

        Emp result1 = repository.findById(employees1.getEno()).get();
        assertThat(employees1).isEqualTo(result1);
        // Assertions.assertThat static import

    }
    @Test
    public void findById(){
        Emp employees1 = new Emp();
        employees1.setEname("박보검1");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);
        repository.save(employees1);

        Emp employees2 = new Emp();
        employees2.setEname("조인성");

        employees2.setHiredate("2020-01-01");

        employees2.setGrade(Grade.NORMAL);
        repository.save(employees2);

        Emp result = repository.findById(employees1.getEno()).get();
        assertThat(result).isEqualTo(employees1);

    }
    @Test
    public void findByName(){
        Emp employees1 = new Emp();
        employees1.setEname("박보검1");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);
        repository.save(employees1);

        Emp employees2 = new Emp();
        employees2.setEname("조인성");

        employees2.setHiredate("2020-01-01");

        employees2.setGrade(Grade.NORMAL);
        repository.save(employees2);

        Emp result = repository.findByName(employees1.getEname()).get();
        assertThat(result).isEqualTo(employees1);

    }

    @Test
    public void findAll(){

        Emp employees = new Emp();
        employees.setEname("조인성");

        employees.setHiredate("2020-01-01");

        employees.setGrade(Grade.NORMAL);

        repository.save(employees);


        Emp employees1 = new Emp();
        employees1.setEname("박서준");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);

        repository.save(employees1);

        List<Emp> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

    @Test
    public void update(){
        //given
        Emp employees1 = new Emp();
        employees1.setEname("박서준");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);

        repository.save(employees1);

        //when

        Emp employees = repository.findById(employees1.getEno()).get();


        repository.update(employees);
        Emp result = repository.findById(employees1.getEno()).get();
        //then
        assertThat(employees).isEqualTo(result);

    }

    @Test
    public void updateRetiree(){
        //given
        Emp employees1 = new Emp();
        employees1.setEname("박서준");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);
        repository.save(employees1);

        //when
        repository.updateRetiree(employees1);

        //then
        Emp result = repository.findById(employees1.getEno()).get();
        assertThat(result.getGrade()).isEqualTo(Grade.RETIREE);
    }

    @Test
    void findByDeptNo(){

        //given
        Emp employees1 = new Emp();
        employees1.setEname("박서준");

        employees1.setHiredate("2020-01-01");

        employees1.setGrade(Grade.NORMAL);

        employees1.setDepno(1);
        repository.save(employees1);

        Emp employees2 = new Emp();
        employees2.setEname("송중기");

        employees2.setHiredate("2020-01-01");

        employees2.setGrade(Grade.NORMAL);

        employees2.setDepno(1);
        repository.save(employees2);


        Emp employees3 = new Emp();
        employees3.setEname("조인성");

        employees3.setHiredate("2020-01-01");

        employees3.setGrade(Grade.NORMAL);

        employees3.setDepno(2);
        repository.save(employees3);

        List<Emp> byDept = repository.findByDept(1);
        System.out.println("byDept = " + byDept);
    }
}