/*
 *
 * Classname : Java Development (K)
 *
 *  23 June 2020
 *
 * Created by Selebynka Yurii (UzhNU)
 *
 *   Final course task.
 *   2. COMPANY Service implementation
 *
 * 1. Create a test set of companies in your main class.
 * 2. Take for this set IT-companies: Chief, Lawyer, Developer
 *    (Design,  Front-end, Back-end, DevOps). See attach.
 * 3. Take into account 4 different cases for a company
 *    (on-top, on bottom, in the node, out of chain).
 * 4. Test all this cases in your main class.
 * 5. Implement the interface in a class CompanyService.
 *
 * */

package com.company;

import java.util.List;

    //------------ 5. Implement the interface in a class CompanyService. ----\\

    /*
     * @param Company - new public class.
     *
     * @return - new public class, implements ICompanyService.
     */

public class Company implements ICompanyService{

    private Company parent;      // parent for this company is nullable,
                                // when there is no parent for this company
    private long employeesCount;

    /*
     * @param Company - new constructor.
     *
     * @return - constructor of Company with identified variables.
     */

    public Company() {
    }

    public Company(Company parent, long employeesCount) {
        this.parent = parent;
        this.employeesCount = employeesCount;
    }

    /*
     * @param {getParent... + ... setEmployeesCount} - new getters
     *                                                 and setters.
     *
     * @return - getters and setters, designed to work with objects.
     */

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = employeesCount;
    }

    /*
     * @param toString - method for Company.
     *
     * @return - information about Company.
     */

    @Override
    public String toString() {
        return "Company{" +
                "parent=" + parent +
                ", employeesCount=" + employeesCount +
                '}';
    }

    /*
     * @param getTopLevelParent - method for Company.
     *
     * @return - information about top level parent of Company,
     *           if it is existed.
     */

    @Override
    public Company getTopLevelParent(Company child) {
        return child.getParent();
    }

    /*
     * @param getEmployeeCountForCompanyAndChildren - method for Company.
     *
     * @return - number of employees of Company, and daughterly companies,
     *           if it is existed.
     */

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company
            , List<Company> companies) {
        long EmployeeCountForCompanyAndChildren = company
                .getEmployeesCount();
        for (Company company1:companies){
            if (company == company1.getParent()){
                EmployeeCountForCompanyAndChildren += company1
                        .getEmployeesCount();
            }
        }
        return EmployeeCountForCompanyAndChildren;
    }
}