package itacademy.spring_hibernate.service;

import itacademy.spring_hibernate.dao.EmployeeDao;
import itacademy.spring_hibernate.dao.IDao;
import itacademy.spring_hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class EmployeeServiceImpl extends BaseTransactionService<Employee> implements EmployeeService {

    // второй вариант: если в BaseTransactionService убрали @Autowired над baseDao
    /*@Autowired
    public EmployeeServiceImpl(EmployeeDao baseDao) {
        super(baseDao);
    }*/
}
