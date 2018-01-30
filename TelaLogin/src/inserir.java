import java.util.Map;
import java.util.HashMap;

public class inserir {
	
	public inserir () {
	Map<String, String> m = new HashMap<String, String>();
    m.put(Cadastro.nomecadastrado,Cadastro.senhacadastrada);
    System.out.println(m);
    System.out.println(m.get(Cadastro.nomecadastrado));
	}
}
