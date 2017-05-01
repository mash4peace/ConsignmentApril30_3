package Constractor;

import java.util.Date;

/**
 * Created by mash4 on 4/30/2017.
 */
public class Record {
    String name;
    String phone;
    int numberOfItems;
    Date date = new Date();
    int id ;
    int congmtID;


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // Here is a new consignor's constractor
    public Record(String consgnorName, String phoneNumber){
        this.name = consgnorName;

        this.phone = phoneNumber;

    }
    // A constractot to add records to the database;
    public Record(int consignrID, String consgnorName, int consgmtID, int items, Date date){
        this.id = consignrID;
        this.name = consgnorName;
        this.numberOfItems = items;
        this.date = date;
        this.congmtID = consgmtID;
    }


}
