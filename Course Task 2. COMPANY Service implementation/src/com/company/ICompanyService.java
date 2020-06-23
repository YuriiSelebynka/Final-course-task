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

public interface ICompanyService {

    /*
     *  @param child - company for which we are searching
     *  the top level parent
     *  (parent of parent of ...)
     *  @return top level paren
     *
     */

    Company getTopLevelParent(Company child) throws CloneNotSupportedException;

    /*
     *
     *  @param company  - company for which we are searching the count of
     *  employees
     *  (count of this company employees +
     *  count employees of all children and their children employees )
     *  @param companies  - list of all available companies
     *  @return count of employees
     *
     */

    long getEmployeeCountForCompanyAndChildren(Company company
            , List<Company> companies);


}