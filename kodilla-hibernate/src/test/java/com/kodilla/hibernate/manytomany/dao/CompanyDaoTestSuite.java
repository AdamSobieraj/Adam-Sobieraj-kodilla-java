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
    public void testNameSearch(){
        //Given
        Employee tomTom = new Employee("Tom", "Tom");
        Employee tomekCom = new Employee("Tomek", "Com");
        Employee lizKowalski = new Employee("Liz", "Kowalski");


        employeeDao.save(tomTom);
        employeeDao.save(tomekCom);
        employeeDao.save(lizKowalski);


        //When
        List<Employee> lastName = employeeDao.retrieveEmployeeWithName("Tom");

        //Then
        Assert.assertEquals(1, lastName.size());

        //CleanUp
        employeeDao.delete(tomTom);
        employeeDao.delete(tomekCom);
        employeeDao.delete(lizKowalski);
    }

    @Test
    public void testCompanyStartWithSearch(){
        //Given
        Company companyDell = new Company("Company Dell");
        Company bitcoins = new Company("Bitcoins");
        Company softData = new Company("Soft Data");

        companyDao.save(companyDell);
        companyDao.save(bitcoins);
        companyDao.save(softData);

        //When
        List<Company> nameStartedWith = companyDao.getCompanyName("Sof");

        //Then
        Assert.assertEquals(1, nameStartedWith.size());

        //CleanUp
        companyDao.delete(companyDell);
        companyDao.delete(bitcoins);
        companyDao.delete(softData);
    }
}

