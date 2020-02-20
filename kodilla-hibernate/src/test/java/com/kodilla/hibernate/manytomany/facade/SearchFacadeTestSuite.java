package com.kodilla.hibernate.manytomany.facade;
import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTestSuite {
    @Autowired
    SearchFacade searchFacade;
    @Autowired
    EmployeeDao employeeDao;
    @Test
    public void testRetrieveCompanyWithAnyString(){
       //Given
        Company company1= new Company("Company3");
        Company company2= new Company("Company4");
        //When
        searchFacade.saveCompany(company1);
        searchFacade.saveCompany(company2);
        List<Company> companyList =searchFacade.findCompanyWithAnyStr("y3");
        System.out.println(companyList);
        //Then
        Assert.assertEquals(1,companyList.size());
        //CleanUp
        try {
            searchFacade.deleteCompany(company1);
            searchFacade.deleteCompany(company2);
        } catch (Exception e){}
    }
    @Test
    public void testRetrieveEmployeeWithAnyString(){
       //Given
        Employee employee1 = new Employee("Name0111","Surname0222");
        Employee employee2 = new Employee("Name0333","Surname0444");
        //When
        searchFacade.saveEmployee(employee1);
        searchFacade.saveEmployee(employee2);
        List<Employee> employeeList =searchFacade.findEmployeeWithAnyStr("ame0222");
        System.out.println(employeeList);
        //Then
        Assert.assertEquals(1,employeeList.size());
        //CleanUp
        try {
            searchFacade.deleteEmployee(employee1);
            searchFacade.deleteEmployee(employee2);
        } catch (Exception e){}
    }
}
