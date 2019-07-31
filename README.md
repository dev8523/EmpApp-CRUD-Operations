# EmpApp-CRUD-Operations
This is a project which is developed using:
1. Backend- JDBC, Servlets & JSP.
2. Frontend- HTML, CSS, Bootstrap, Javascript, jQuery.

# For your Understanding:
This contains 3 screenshots of the UI part:
1. index_page.JPG
2. login_page.JPG (used HTML, CSS, Bootstrap, jQuery)
3. registration_page.JPG (used HTML, CSS, Bootstrap, Javascript, jQuery)

# Requirements:
1. Any local server (eg: Pivotal tc Server/Apache Tomcat server).
2. Any Database (used Oracle 11g).

# Note:
If you want to import this project in eclipse, then please follow these steps:
1. Remove these 3 screenshots that i have mentioned above.
2. Create 2 schemas in oracle database table name- (login and registration) and give the same colomn name as i have mentioned in (EmpApp-CRUD-Operations/EmpApp/src/com/infinite/EmpApp/dao/EmployeeDaoImpl.java) & ( EmpApp-CRUD-Operations/EmpApp/src/com/infinite/EmpApp/dao/LoginDAOImpl.java).
3. Import the project as dynamic web project of module-3.0.
4. Then in login table of your DB, insert values as userId- admin, password- admin, changestatus- 0, checkstatus- a.
5. Again insert more one value as userId- user, password- user, changestatus- 0, checkstatus- u.

