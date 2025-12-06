# StudentManagementSystem
Java web project (JSP + Servlets) with Oracle DB.

## Contents
- src/: Java source files (controllers, dao, model, util)
- WebContent/: JSPs, static assets, WEB-INF
- sql/: Oracle table creation script
- README.md (this file)

## How to use
1. Import this as a Dynamic Web Project in Eclipse (or as a Maven project if you convert it).
2. Put `ojdbc8.jar` into `WebContent/WEB-INF/lib/` or into Tomcat's lib folder.
3. Configure DB credentials in `src/com/student/util/DBConnection.java`.
4. Run the SQL in `sql/create_tables.sql` on your Oracle DB.
5. Deploy to Tomcat and open `http://localhost:8080/StudentManagementSystem/`.
