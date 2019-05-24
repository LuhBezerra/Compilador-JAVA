package analisador_2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lexico_2 {

	public static void main(String[] args) {
		String code  = "5+4=9";
	    

	    Map<String, String> tokens = new HashMap<>();
	    	tokens.put("[0-9]+", "[Digito: ");
	        tokens.put("[/+/-]+", "[Operador: ");
	        tokens.put("[/=]+", "[Igualdade: ");
	        
	    int posicao = 0;
	   
	    	while(posicao < code.length() ) {
	    		boolean encontrou_tokens = false;
	    		for(Map.Entry<String, String> analisar : tokens.entrySet()) {
	    			
	    			
	    			Pattern TOKEN = Pattern.compile(analisar.getKey());
	    			Matcher procurar = TOKEN.matcher(code).region(posicao, code.length()); 
	    			
	    			if(procurar.find() && procurar.start() == posicao) {
	    				encontrou_tokens=true;
	    				System.out.println(analisar.getValue() + procurar.group()+"]" + "-> posi��o: " + posicao);
	    				posicao += procurar.group().length();
	    				continue; 
	    				
	    			}
	    			if(!encontrou_tokens) {
	    				System.out.println("Erro! Na posi��o: " + posicao);
	    				posicao+=code.length();
	    				break;
	    				
	    			}
	    		}
	    		
	    	} 
		}
	}
