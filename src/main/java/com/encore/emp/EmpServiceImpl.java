package com.encore.emp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



public class EmpServiceImpl implements EmpService {

    private final EmpRepository repository;


    public EmpServiceImpl(EmpRepository empRepository) {
        this.repository = empRepository;
    }

    @Override
    public Integer join(Emp employees) {

        validateDuplicateName(employees);

        repository.save(employees);

        return employees.getEno();
    }

    // 이름 중복되있으면 가입 거절........일단... find 리스트 만들기 귀찮아서 ..
    @Override
    public void validateDuplicateName(Emp employees) {
        repository.findByName(employees.getEname())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 사원 입니다.");
                }); // null이 아니라 값이 있으면 동작
    }

    @Override
    public Optional<Emp> findEmpById(int employeesId) {
        return repository.findById(employeesId);
    }

    @Override
    public Optional<Emp> findEmpByName(String ename) {
        return repository.findByName(ename);
    }

    @Override
    public List<Emp> findAll() {
        return repository.findAll();
    }

    @Override
    public Emp update(Emp employees) {
        repository.update(employees);
        return employees;
    }

    @Override
    public Emp updateRetiree(Emp employees) {
        //관리자냐는 어디서 물어보지 ?
        repository.updateRetiree(employees);
        return null;
    }
}