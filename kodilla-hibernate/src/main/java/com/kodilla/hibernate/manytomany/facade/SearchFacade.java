package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompanyWithAnyStr (String str){
        return companyDao.retrieveCompaniesWithAnyStr(str);
    }
    public List<Employee> findEmployeeWithAnyStr (String str){
        return employeeDao.retrieveEmployeeWithAnyStr(str);
    }
    public void saveCompany (Company company){
        companyDao.save(company);
    }
    public void saveEmployee (Employee employee){
        employeeDao.save(employee);
    }
    public void deleteCompany (Company company){
        companyDao.delete(company);
    }
    public void deleteEmployee (Employee employee){
        employeeDao.delete(employee);
    }
}
