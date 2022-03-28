import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String args[]){
        HashMap<String, Catalog> listOfCatalogs = new HashMap<>();

        Item book = new Item("3jx", "Cartea vietii", "location/path", "Catalin Maruta");
        Item book2 = new Item("3jx", "Cartea vietii", "location/path", "Catalin Maruta");
        Catalog catalog = new Catalog();
        catalog.add(book);
        catalog.add(book2);
        System.out.println(catalog);
        listOfCatalogs.put(catalog.getName(), catalog);
        CatalogUtil util = new CatalogUtil();
        try{
            util.save(catalog, "JsonTest2.json");
        }
        catch (IOException e){
            System.out.println("I/O Error" + e);
        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }

        Catalog catalog2 = new Catalog();
        try{
            catalog2 = util.load("JsonTest22.json");
        }
        catch (IOException e){
            System.out.println("I/O Error" + e);
        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }
        AddCommand add = new AddCommand();
        try{add.command(catalog,"aaaa, bbbb, cccc, dddd");}
        catch (AddException e){
            System.out.println(e);
        }

        try{Desktop.getDesktop().open(new File("D:\\Desktop\\Java_lab_5\\JsonTest.json"));}
        catch (IOException e){
            System.out.println("Something went wrong");
        }



         try {
            Configuration cfg = new Configuration();
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            cfg.setDirectoryForTemplateLoading(new File("."));
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("name", catalog.getName());
            model.put("content", catalog.getItems().toString());
            Template template = cfg.getTemplate("TestTemplate.ftl");
            StringWriter stringWriter = new StringWriter();
            template.process(model, stringWriter);
            String string = stringWriter.toString();
            System.out.println(string);
            PrintWriter out = new PrintWriter("filename.html");
            out.println(string);
            out.close();
         }
         catch (IOException e){
             System.out.println("IO!!!");
         }
         catch (TemplateException e){
             System.out.println("Template!!!");
         }




        System.out.println(catalog2);
    }
}
