package com.vehicle.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TempFolder {
    public static void main(String[] args) throws IOException {
    	Set<String> check = new HashSet<String>();
    	check.add("test");
    	check.add("test1");
    	check.add("test");
    	
    	Set<String> chec2 = new HashSet<String>();
    	check.add("test2");
    	check.add("test3");
    	check.add("tes4");
    	
    	Set<String> check3 = new HashSet<String>();
    	check.add("test");
    	check.add("test1");
    	check.add("test");
    	
    	Set<String> check4= new HashSet<String>();
    	check4.addAll(check3);
    	check4.addAll(chec2);
    	check4.addAll(check);
    	
    	for(String checkn :check4){
    		System.out.println(checkn);
    	}
    }
}
