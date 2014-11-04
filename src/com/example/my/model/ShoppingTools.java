package com.example.my.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingTools {
   private static List<ShoppingCartModel>listshoppings;
   private ShoppingTools(){
   }
   
   public static List<ShoppingCartModel> getListInstance(){
	   if(listshoppings==null){
		   listshoppings = new ArrayList<ShoppingCartModel>();
	   }
	   return listshoppings;
   }
}
