/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahiautomation;

import net.sf.sahi.client.Browser;



/**
 * Classe Browser representa o navegador que será usado pelo Sahi
 * @author UBC
 */
public final class ClientBrowser extends Browser {
    
    // default values are "ie", "firefox", "safari", "chrome", "opera" - specified in userdata/config/browser_types.xml 
    private static final String BROWSERNAME = "firefox";
    // Instancia inicia nula.
    private static final ClientBrowser browserInstance = new ClientBrowser(); 
    
    // Implementação de Sigleton
    private ClientBrowser() {
        super(BROWSERNAME);
    }
    
    // GetInstance para o Sigleton 
    public static ClientBrowser getInstance() {
        return browserInstance;   
    }
    
    // Overriding open method.
    public void open() {
        // No código fonte original o Sahi deveria verificar se um navegador já
        // está aberto e não tentar abrir ele novamente.
        // https://github.com/kevlened/Sahi/blob/master/sahi/src/net/sf/sahi/client/Browser.java#L251
        super.open();
    }
    
}
