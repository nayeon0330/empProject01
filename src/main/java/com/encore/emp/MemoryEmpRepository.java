package com.encore.emp;

import org.springframework.stereotype.Repository;

import java.util.*;



public class MemoryEmpRepository implements EmpRepository{

    private static Map<Integer,Emp> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Emp save(Emp employees) {
        employees.setEno(++sequence);
        store.put(employees.getEno(),employees);

        return employees;
    }

    @Override
    public Optional<Emp> findById(int employeesId) {
        return Optional.ofNullable(store.get(employeesId));
    }

    @Override
    public Optional<Emp> findByName(String ename) {
        return store.values().stream()
                .filter(employees -> employees.getEname().equals(ename))
                .findAny();
    }

    @Override
    public List<Emp> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Emp> findByDept(int depno) {
        ArrayList<Emp> list = new ArrayList<>();
        for (Integer k  :store.keySet())
            if (store.get(k).getDepno() == depno) {
                list.add(store.get(k));
            }
        return list;
    }

    @Override
    public Emp update(Emp employees) {
        store.replace(employees.getEno(),employees);

        return employees;
    }

    @Override
    public Emp updateRetiree(Emp employees) {
        employees.setGrade(Grade.RETIREE); // 여기서 정해도 되는지...?
        store.replace(employees.getEno(),employees);

        return employees;
    }

    public void clearStore() {
        store.clear();
    }
}
