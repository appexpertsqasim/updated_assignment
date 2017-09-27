package LocalDB;

import io.realm.RealmObject;

/**
 * Created by TAE Consultant on 23/09/2017.
 */

public class CustomerModel extends RealmObject {
    public CustomerModel(String name) {

        this.name = name;
    }

    public CustomerModel() {
    }


    String name;
    public String getName(){
        return name;
    }
    public void setName(String name){  this.name=name;}
}
