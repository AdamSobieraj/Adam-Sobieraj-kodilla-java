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
        //try {
        //    companyDao.deleteById(softwareMachineId);
        //    companyDao.deleteById(dataMaestersId);
        //    companyDao.deleteById(greyMatterId);
        //} catch (Exception e) {
        //    //do nothing
        //}
    }


    @Test
    public void testNamedQueries() {
        //Given
        Employee jimTom = new Employee("Jim", "Tom");
        Employee tojmTom = new Employee("Tojm", "Tom");
        Employee lizKowalsky = new Employee("Liz", "Kowalsky");

        Company companySTAS = new Company("companySTAS");
        Company companyJC = new Company("companyJC");
        Company companyGim = new Company("companyGim");

        companySTAS.getEmployees().add(jimTom);
        companyJC.getEmployees().add(tojmTom);
        companyJC.getEmployees().add(lizKowalsky);
        companyGim.getEmployees().add(jimTom);
        companyGim.getEmployees().add(lizKowalsky);

        jimTom.getCompanies().add(companySTAS);
        jimTom.getCompanies().add(companyGim);
        tojmTom.getCompanies().add(companyJC);
        lizKowalsky.getCompanies().add(companyJC);
        lizKowalsky.getCompanies().add(companyGim);

        companyDao.save(companySTAS);
        int softwareMachineId = companySTAS.getId();
        companyDao.save(companyJC);
        int dataMaestersId = companyJC.getId();
        companyDao.save(companyGim);
        int greyMatterId = companyGim.getId();

        //When
        List<Company> threeFirstLetters = companyDao.retrieveWithThreeFirstLetters("com");
        List<Employee> lastname = employeeDao.retrieveWithLastname("Jim");

        //Than
        try {
            Assert.assertEquals(1, threeFirstLetters.size());
            Assert.assertEquals(1, lastname.size());
            //CleanUp
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e){
        }
    }
}

