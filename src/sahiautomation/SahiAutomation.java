/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahiautomation;

/**
 *
 * @author UBC
 */
public class SahiAutomation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Definindo as configurações.
        String sahiBasePath = "C:\\Users\\UBC\\sahi";
        String sahiUserDataDir = "C:\\Users\\UBC\\sahi\\userdata";
        // Inicianlizando o Sahi.
        net.sf.sahi.config.Configuration.initJava(sahiBasePath, sahiUserDataDir);
        
        BlackboardLogin bl = new BlackboardLogin();
        bl.tryLogin();
        
        // Navega na disciplina do henrique
        Course.navigateToCourse("_10121_1");
        Course.enableEditing();
        Course.openAddContentForm("Item");
                
        // Fechando navegador ao fim do teste;
        ClientBrowser cb = ClientBrowser.getInstance();
        cb.waitFor(10);
        cb.close();
        
    }
    
}
