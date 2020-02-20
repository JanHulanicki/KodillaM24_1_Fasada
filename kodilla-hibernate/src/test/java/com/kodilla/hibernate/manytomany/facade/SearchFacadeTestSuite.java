package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
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
    @Test
    public void testRetrieveCompanyWithAnyString(){
        Company company1= new Company("Company3");
        Company company2= new Company("Company4");
        searchFacade.saveCompany(company1);
        searchFacade.saveCompany(company2);
        List<Company> companyList =searchFacade.findCompanyWithAnyStr("y3");
        System.out.println(companyList);
        searchFacade.deleteCompany(company1);
        searchFacade.deleteCompany(company2);


    }

}
