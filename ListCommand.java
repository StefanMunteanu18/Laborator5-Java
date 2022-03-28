public class ListCommand implements GenericCommand{
    public void command(Catalog catalog, String parameter){
        for(Item item : catalog.getItems()){
            System.out.println(item);
        }
    }
}
