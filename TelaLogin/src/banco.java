import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class banco  {
	public static String usuario, senha, x, y;
	public static String user = "";
	public static String password = "";
	public static boolean tag = false;
	public static String letra[];
	
	public banco () throws IOException {
		usuario = Inicio.userdigit;
		senha = Inicio.passdigit;
		user = "";
		password = "";
		String txt = "C:\\Users\\jorge\\OneDrive\\Documentos\\leilao-auction-\\pass.txt";
		/*FileWriter arq = new FileWriter("C:\\Users\\jorge\\OneDrive\\Documentos\\leilao-auction-\\pass.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.printf ("%s:%s", x, y);
	    arq.close();*/
	    
	    try {
	    	int cont;
	        FileReader arq = new FileReader(txt);
	        BufferedReader lerArq = new BufferedReader(arq);
	        String linha = lerArq.readLine();
	        for(cont = 0; cont < linha.length(); cont++){  
	        letra = linha.split(":");
		    }
	        user = letra[0];
		    password = letra[1];
		  
	       validate aut = new validate ();
	       Map<String, String> m = new HashMap<String, String>();
	       m.put(Cadastro.nomecadastrado,Cadastro.senhacadastrada);
	       System.out.println(m.get(Cadastro.nomecadastrado));
	       
	      
	    
	        arq.close();
	      } catch (IOException e) {
	          System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
	      }
		
		
		
	}

}