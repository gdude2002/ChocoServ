ChocoServ
=========

This is a fairly simple class project. It involves creating a webapp in Java.

Project spec
------------

* Create a basic website about chocolate
* Develop a hit counter for a webpage of the website - Don't use a plugin, develop your own.
* Create a comment form where visitors to your site can leave comments and they are displayed on the page -
  Again, develop your own.
* Create a web address book on another page of your site.
* Create a few page on your site for selling chocolate bars; give the user an option to purchase a number of bars
  from your site.
* Use local hosting for the project, and use a DBMS of your choice.

Compiling
---------

Just run `gradlew`, or `gradlew.bat` on Windows. The JAR file will be created in `build/libs`.

Usage
-----

If you're okay with the defaults, you can simply run the JAR and connect to **port 4567** on the computer you're running from.
However, there are some command-line arguments, if you need to specify database details.

* `--dialect` - Specify the Hibernate dialect. Defaults to `org.hibernate.dialect.MySQL5InnoDBDialect`
* `--driver` - Specify the JDBC driver to use. It should be on your classpath. Defaults to `com.mysql.jdbc.Driver`
* `--url` or `--uri` - The JDBC URL to use. Defaults to `jdbc:mysql://localhost:3306/chocolate`
* `--username` - The database username to use. Defaults to `chocolate`
* `--password` - The password for the database user. Defaults to `IFuckingLoveChocolate`
