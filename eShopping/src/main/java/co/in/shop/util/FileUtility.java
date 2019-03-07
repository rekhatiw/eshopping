package co.in.shop.util;

import co.in.shop.bean.ShopUser;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class FileUtility
{
  public FileUtility() {}
  
  public java.util.Map loadFile() throws java.io.FileNotFoundException
  {
    ShopUser user = new ShopUser();
    HashMap<String, java.util.List> map = new HashMap();
    String[] lines = new String[100];
    java.io.File f = new java.io.File("C:\\Rekha\\userdetails.txt");
    BufferedReader br = new BufferedReader(new java.io.FileReader(f));
    
    int x = 0;
    
    String key = null;
    String values = null;
    try { String st;
      while ((st = br.readLine()) != null)
      {
        lines[x] = st;
        String[] arrOfStr = lines[x].split(":");
        int i = 0;
        for (i = 0; i < arrOfStr.length; i++) {
          key = arrOfStr[0];
          
          values = arrOfStr[1];
        }
        

        HashSet s = new HashSet();
        s.add(key);
        

        Iterator it = s.iterator();
        while (it.hasNext())
        {
          String k = it.next().toString();
          
          if (k.equalsIgnoreCase("name"))
          {
            System.out.println(values);



          }
          



        }
        



      }
      




    }
    catch (IOException e)
    {




      e.printStackTrace();
    }
    



    return map;
  }
}