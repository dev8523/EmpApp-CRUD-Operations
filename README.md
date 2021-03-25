# EmpApp-CRUD-Operations
This is a J2EE project which is developed using:
1. Backend- JDBC, Servlets & JSP, Singleton Deign Pattern.
2. Frontend- HTML, CSS, Bootstrap, Javascript.

# For your Understanding:
This contains 3 screenshots of the UI part:
1. index_page.JPG
2. login_page.JPG (used HTML, CSS, Bootstrap, jQuery)
3. registration_page.JPG (used HTML, CSS, Bootstrap, Javascript, jQuery)

# Requirements:
1. Any local server (eg: Apache Tomcat server).
2. Any Database (used Oracle 11g).

# Note:
If you want to import this project in eclipse, then please follow these steps:
1. Remove these 3 screenshots that i have mentioned above.
2. Create 2 schemas in oracle database table name- (login and registration) and give the same column name as i have mentioned in (EmpApp-CRUD-Operations/EmpApp/src/com/infinite/EmpApp/dao/EmployeeDaoImpl.java) & ( EmpApp-CRUD-Operations/EmpApp/src/com/infinite/EmpApp/dao/LoginDAOImpl.java).
3. Import the project as dynamic web project of module-3.0.
4. Then in login table of your DB, insert values as (Column name-> userId- admin, password- admin, userstatus- 0, usertype- a).
5. Again insert more one value in login table as (Column name-> userId- user, password- user, userstatus- 0, usertype- u).
6. Now import the project into eclipse and make sure there are no errors in the project.
7. Start your local server and deploy the project into the server and run it.
