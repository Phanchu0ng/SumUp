package Data;

public class Product {
    String url;
    String name;
    String size;
    String color;
    String price;
    public  Product(String url, String name, String size, String color, String price){
        super();
        this.url =url;
        this.name = name;
        this.size=size;
        this.color = color;
        this.price =price;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String toString() {


        return "url: " + url + "\n"
                + "name: " + name + "\n"
                + "price: " + price + "\n"
                + "color: " + color + "\n"
                + "size: " + size + "\n";


    }
}


