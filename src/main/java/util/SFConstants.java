package util;

public interface SFConstants {

    String URL = "http://sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/";
    String DB_URL = "jdbc:mysql://localhost:3036/tablename"; // URL to connect with SourceFuse db
    String DB_USERNAME="testuser"; // SourceFuse DB username
    String DB_PASSWORD="testuser";// SourceFuse DB password
    String DB_QUERY="select * from dbname.table_name"; // SourceFuse db and table name
    String JDBC_DRIVER="com.mysql.jdbc.Driver";
    String BROWSER_NAME = "chrome";
    int PAGE_LOAD_TIMEOUT = 10;
    int IMPLICIT_WAIT = 10;
    String TABLE_COLUMN = "email_sent";
}
