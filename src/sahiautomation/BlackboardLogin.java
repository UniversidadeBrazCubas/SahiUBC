/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahiautomation;

import java.util.Scanner;

/**
 *
 * @author UBC
 */
public class BlackboardLogin {
    
    // Instancia do Navegador a ser usado.
    private static ClientBrowser browser = ClientBrowser.getInstance();
    // Nome do usuário
    private String username;
    // Senha do usuário
    private String password;
    // URL de login
    private final String url = "https://brazcubas.blackboard.com/";

    public BlackboardLogin() {
    }
    
    public void setCredentials() {
        Scanner s = new Scanner(System.in);
        System.out.print("Informe seu usuário: ");
        username = s.nextLine();
        System.out.print("Informe sua senha: ");
        password = s.nextLine();
    }
    
    public boolean login () {
        setCredentials();
        browser.open();
        browser.navigateTo(url);
        browser.textbox("user_id").setValue(username);
        browser.password("password").setValue(password);
        browser.submit("login").click();
        // Verificar se foi com sucesso
        if(browser.div("loginErrorMessage").exists()) {
            System.out.println(browser.div("loginErrorMessage").getText());
            return false;
        } else {
            return true;
        }
    }
    
    public boolean tryLogin () {
        Integer tentativas = 1;
        Boolean didLogin = false;
        do {
            System.out.println(String.format("Login: Tentativa %d de 3", tentativas));
            if(login()) {
                return true;
            }
            tentativas++;
        } while (tentativas <= 3 && !didLogin);
        
        System.out.println("Tentativas esgotadas!");
        return false;
    }
    
}
