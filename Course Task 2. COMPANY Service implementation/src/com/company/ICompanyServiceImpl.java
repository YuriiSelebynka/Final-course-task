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

import java.nio.file.Paths;
import java.util.List;

public class ICompanyServiceImpl implements ICompanyService {

    /*
     * @param getTopLevelParent - method for Company.
     *
     * @return - data about top level parent of Company,
     *           if it is existed.
     */

    @Override
    public Company getTopLevelParent(Company child)
            throws CloneNotSupportedException {
        Company a = child;
        while (a.getParent() != null){
            a = a.getParent();
        }
        if (child.getParent() == null){
            return child.getParent();
        }
        return a;
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
        for (Company company1 : companies) {
            if (company == company1.getParent()) {
                EmployeeCountForCompanyAndChildren += company1
                        .getEmployeesCount();
            }
        }
        return EmployeeCountForCompanyAndChildren;

    }
}