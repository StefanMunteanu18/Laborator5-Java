import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements GenericCommand{
    public void command(Catalog catalog, String parameter) throws ViewException{
        boolean itemExists = false;
        Item itemFound = new Item();
        for(Item item: catalog.getItems()){
            if(item.getId().compareTo(parameter) == 0){
                itemExists = true;
                itemFound = item;
            }
        }
        if(itemExists){
            try{
                Desktop.getDesktop().open(new File(itemFound.getLocation()));}
            catch (IOException e){
                System.out.println("Something went wrong");
            }
        }
        else throw new ViewException();
    }
}
