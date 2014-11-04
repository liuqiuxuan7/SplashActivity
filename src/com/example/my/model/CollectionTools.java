package com.example.my.model;

import java.util.ArrayList;
import java.util.List;

public class CollectionTools {
  private static List<CollectionModel>listCollections;
  private CollectionTools(){
	  
  }
  public static List<CollectionModel> getInstance(){
	  if(listCollections==null){
		   listCollections = new ArrayList<CollectionModel>();
	   }
	   return listCollections;
  }
}
