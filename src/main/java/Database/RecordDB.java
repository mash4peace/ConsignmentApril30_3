package Database;

import Constractor.Record;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by mash4 on 4/30/2017.
 */
public class RecordDB {
    private static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION_URL=  "jdbc:mysql://localhost:3306/records";
    private static final String USER = ("mash4peace");
    private  static final String PASSWORDS = System.getenv("MYSQL_pw");
    private static final String TABLE_NAME = "new_Consignor";

    static ArrayList<RecordDB>  allRecord = new ArrayList<>();



    public  RecordDB() {

        try {
            Class.forName(JDBC_Driver);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Can't instantiate driver class; " +
                    "check you have drives and classpath configured" +
                    " correctly?");
            cnfe.printStackTrace();
            System.exit(-1);  //No driver? Need to fix before anything else will work. So quit the program
        }
    }

    public void crearNewConsgnorTable(Record record) {
         final String CONSIGNORID_COL = "consgnrID";
         final String CONSIGNORNAME_COL = "consName";
         final String CONSGNORPHONE = "consigPhone";
        try(Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS);
            Statement statement = conn.createStatement()) {
            String createTableSQLTemp=
                    "Create Table if not exists new_Consignor( consgnrID Integer Not Null Auto_Increment,  consName Varchar (100), consigPhone int(10), Primary Key(consgnrID))";
            String createSQL = String.format(createTableSQLTemp, TABLE_NAME,CONSIGNORID_COL, CONSIGNORNAME_COL, CONSGNORPHONE, CONSIGNORID_COL);
            System.out.println(createSQL);
            statement.executeUpdate(createSQL);
            System.out.println("Consignment "+ TABLE_NAME + " table is created !!!");
            statement.close();
            conn.close();


        }catch (SQLException se){
            se.printStackTrace();
            se.getCause();
        }

    }

    public void crearNewConsgrTable(Record record) {
        final String CONSIGNORNAME_COL = "consName";
        final String CONSIGNORPHONE_COL = "consigPhone" ;
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORDS)){
            String addConsgmtSQl = "INSERT INTO "+ TABLE_NAME + "(consName,consigPhone )"+ " VALUES( ?, ?)" ;
            /*
            String addConsSQL = String.format("INSERT  INTO "+ TABLE_NAME +"( %s, %s) Values ", CONSIGNORNAME_COL, CONSIGNORPHONE_COL  );
            */
            PreparedStatement addConsPS = conn.prepareStatement(addConsgmtSQl);

            addConsPS.setString(1, record.getName());
            addConsPS.setString(2, record.getPhone());
            addConsPS.execute();
            System.out.println("Added a new consignor record into "+ TABLE_NAME +" table !!");

            addConsPS.close();
            conn.close();

        }catch (SQLException s){
            s.printStackTrace();
            s.getCause();
        }
    }
}
