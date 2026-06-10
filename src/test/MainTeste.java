package test;
 
import models.Bd;
import models.LoginDAO;
import models.TipoOperacaoBd;
import models.Login;

 
public class MainTeste {
 
    public static void main(String[] args) {
 
        // 1. Cria o objeto Login
        Login login = new Login();
        login.setId(1);
        login.setCodigo("admin");
        login.setSenhaHash("1234"); // vai ser convertido para hash automaticamente
 
        // 2. Cria o BD e o DAO
        Bd bd = new Bd();
        LoginDAO loginDao = new LoginDAO();
        loginDao.setBD(bd);
        loginDao.setLogin(login);
 
        // 3. Insere no banco
        String resultado = loginDao.atualizar(TipoOperacaoBd.INCLUSAO);
        System.out.println("Resultado: " + resultado);
 
        // 4. Testa o localizar
        Login loginBusca = new Login();
        loginBusca.setId(1);
 
        LoginDAO loginDao2 = new LoginDAO();
        loginDao2.setBD(bd);
        loginDao2.setLogin(loginBusca);
 
        boolean encontrou = loginDao2.localizar();
        System.out.println("Encontrou: " + encontrou);
 
        // 5. Testa o validarLogin
        System.out.println("Login valido: " + loginBusca.validarLogin("admin", "1234"));
        System.out.println("Login invalido: " + loginBusca.validarLogin("admin", "senhaerrada"));
    }
}
