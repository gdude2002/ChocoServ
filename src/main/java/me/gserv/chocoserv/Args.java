package me.gserv.chocoserv;

import com.beust.jcommander.Parameter;

public class Args {
    @Parameter(names = {"--dialect"})
    public String hibernateDialect = "org.hibernate.dialect.MySQL5InnoDBDialect";

    @Parameter(names = {"--driver"})
    public String driverClass = "com.mysql.jdbc.Driver";

    @Parameter(names = {"--url", "--uri"})
    public String url = "jdbc:mysql://localhost:3306/chocolate";

    @Parameter(names = {"--username"})
    public String username = "chocolate";

    @Parameter(names = {"--password"})
    public String password = "IFuckingLoveChocolate";
}
