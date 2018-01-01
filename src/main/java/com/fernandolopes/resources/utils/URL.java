package com.fernandolopes.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	//metodo para descodificar um parametro 
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	//METOdo PARA CONVERTER A LISTA DA CONSULTA PARA NUMEROS INTEIROS 
	public static List<Integer> decodeIntList(String s){
		
		  String[] vet = s.split(","); //split pega a string recorta em pedeço com base no caracter que coloca na  ("")
		 	List<Integer> 	list = 	new ArrayList<>();
		  for(int i=0;i<vet.length ;i++) {
		 	list.add(Integer.parseInt(vet[i]));
		  }
		  return list;
		 
		
		//com a essa lambda pode substituir todas as linha de codigos  
	//	return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		
		
	}
	

}
