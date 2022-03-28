import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCommand implements GenericCommand{
    public void command(Catalog catalog, String parameter) throws AddException{
        List<String> itemAttributes = new ArrayList<String>(Arrays.asList(parameter.split(", ")));
        if(itemAttributes.size() != 4){
            throw new AddException("Invalid item to add! Item should be: id, title, location, author.");
        }
        else {
            Item item = new Item(itemAttributes.get(0), itemAttributes.get(1), itemAttributes.get(2), itemAttributes.get(3));
            catalog.add(item);
        }
    }
}
