package Data;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class ReadData {
    JSONObject jsonObject, customer,product;
    public ReadData(){
        File fileCustomer = new File(System.getProperty("user.dir")+"/src/test/data/customer.json");
        File fileProduct = new File(System.getProperty("user.dir")+"/src/test/data/product.json");
        try {
            product = new JSONObject(FileUtils.readFileToString(fileProduct,"utf-8"));
            customer = new JSONObject(FileUtils.readFileToString(fileCustomer,"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Customer getCustomer(String id) {
        jsonObject = (JSONObject) customer.get(id);
        return new Customer(jsonObject.getString("firstname"),
                jsonObject.getString("lastname"),
                jsonObject.getString("email"),
                jsonObject.getString("stress_address"),
                jsonObject.getString("city"),
                jsonObject.getString("state"),
                jsonObject.getString("country"),
                jsonObject.getString("zip_code"),
                jsonObject.getString("phone_number")
        );
    }
        public Product getProduct(String id){
            jsonObject= (JSONObject) product.get(id);
            return new Product(jsonObject.getString("url"),
                    jsonObject.getString("name"),
                    jsonObject.getString("size"),
                    jsonObject.getString("color"),
                    jsonObject.getString("price"));
        }



}
