package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.CompanyRetriever;
import com.kodilla.hibernate.manytomany.facade.SearchFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;
    @Autowired
    private CompanyRetriever companyRetriever;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testshouldRetrieveCompanyContains() {

        List<Company> companies = companyRetriever.retrieve();
        companyDao.saveAll(companies);

        List<Company> companiesResult = searchFacade.searchCompaniesContainsArg("%dat%");

        assertEquals(44, companiesResult.size());
        System.out.println(companiesResult);

        //clean
        try {
            companyDao.deleteById(companies.get(0).getId());
            companyDao.deleteById(companies.get(1).getId());
            companyDao.deleteById(companies.get(2).getId());
        } catch (Exception e) {
            //nothing
        }
    }

    @Test
    void testshouldRetrieveEmployeeContains() {

        List<Company> companies = companyRetriever.retrieve();
        companyDao.saveAll(companies);

        List<Employee> employeesResult = searchFacade.searchEmployeesContainsArg("%ith%");

        assertEquals(47, employeesResult.size());
        System.out.println(employeesResult);

        //clean
        try {
            companyDao.deleteById(companies.get(40).getId());
            companyDao.deleteById(companies.get(41).getId());
            companyDao.deleteById(companies.get(42).getId());
        } catch (Exception e) {
            //nothing
        }
    }
}