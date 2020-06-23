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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

        public static void main(String[] args)
                throws CloneNotSupportedException {

                  //--- 1. Create a test set of companies -------------\\
                 //--- in your main class. -----------------------------\\
                //--- 2. Take for this set IT-companies: Chief, Lawyer, -\\
               //--  Developer (Design,  Front-end, Back-end, ------------\\
              //--  DevOps). See attach. ----------------------------------\\
             //---- 3. Take into account 4 different cases for a company ---\\
            //--------- (on-top, on bottom, in the node, out of chain). -----\\

            /*
             * @param companies - arraylist for companies.
             *
             * @return - list of included companies.
             */


            List<Company> companies = new ArrayList<>();
                Company chief = new Company(null, 4L);
                    companies.add(chief);

                Company developer = new Company(chief, 8L);
                    companies.add(developer);

                Company backend = new Company(developer, 3L);
                    companies.add(backend);

                Company devops = new Company(backend, 1L);
                    companies.add(devops);

                Company frontend = new Company(developer, 3L);
                    companies.add(frontend);

                Company design = new Company(frontend, 1L);
                    companies.add(design);

                Company accounting = new Company(null,5L);
                    companies.add(accounting);

                Company lawyer = new Company(chief,4L);
                    companies.add(lawyer);

            /*
             * @param service - ICompanyServiceImpl service.
             *
             * @return - methods companies.
             */

            ICompanyServiceImpl service = new ICompanyServiceImpl();

            //------------ 4. Test all this cases in your main class. -------\\

            System.out.println("Top level parent for chief is: "
                    + service.getTopLevelParent(chief));
            System.out.println("Top level parent for developer is: "
                    + service.getTopLevelParent(developer));
            System.out.println("Top level parent for backend is: "
                    + service.getTopLevelParent(backend));
            System.out.println("Top level parent for devops is: "
                    + service.getTopLevelParent(devops));
            System.out.println("Top level parent for frontend is: "
                    + service.getTopLevelParent(frontend));
            System.out.println("Top level parent for design is: "
                    + service.getTopLevelParent(design));
            System.out.println("Top level parent for lawyer is: "
                    + service.getTopLevelParent(lawyer));
            System.out.println("Top level parent for accounting is: "
                    + service.getTopLevelParent(accounting));

            System.out.println(chief
                .getEmployeeCountForCompanyAndChildren(chief, companies));
    }
}