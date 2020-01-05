package com.kodilla.hibernate.manytomany.dao;
import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);
        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);
        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
        //    //do nothing
            }
    }
    @Test
    public void testRetrieveEmployeesWithLastName(){
        //Given
        Employee johnSmith1 = new Employee("John3", "Smith3");
        //When
        employeeDao.save(johnSmith1);
        int johnSmith1Id = johnSmith1.getId();
        List<Employee> employeesWithLastName= employeeDao.retrieveEmployeesWithLastName("Smith3");
        //Then
        try {
            Assert.assertEquals(1, employeesWithLastName.size());

        } finally {
        //CleanUp
            employeeDao.deleteById( johnSmith1Id);
        }
    }
    @Test
    public void testRetrieveCompaniesWithFirst3Chars(){
        Company softwareMachine1 = new Company("XYZSoftware Machine");
        //When
        companyDao.save(softwareMachine1);
        int softwareMachine1Id = softwareMachine1.getId();
        List<Company> companiesWithFirst3Chars= companyDao.retrieveCompaniesWithFirst3Chars("XYZ");
        //Then
        try {
            Assert.assertEquals(1, companiesWithFirst3Chars.size());

        } finally {
            //CleanUp
            companyDao.deleteById( softwareMachine1Id);
        }
    }
}