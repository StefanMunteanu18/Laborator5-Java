import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Catalog {
    private String name = "aaa";
    private List<Item> items = new ArrayList<>();
    public void add(Item item){
        items.add(item);
    }


    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
