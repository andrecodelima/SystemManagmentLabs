import br.com.maven.systemlabs.service.Db;

public class Main {

	public static void main(String[] args) {
		
		//Teste Banco
		Db conn = new Db();
		conn.conect();

	}

}
