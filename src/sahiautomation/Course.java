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
public class Course {
    
    // Obtem instancia do navegador.
    public static final ClientBrowser cb = ClientBrowser.getInstance();
    
    public Course() {
    }
    
    /**
     * Ativa a edição da página de um curso.
     * @return boolean se conseguiu ou não.
     */
    public static boolean enableEditing () {

        // Verifica se existe o botão.
        if(!cb.link("editModeToggleLink").exists()) {
            System.out.println("Esta página não possui botão de edição / ou seu usuário não possui permissão.");
            return false;
        }
        
        // Tenta obter texto atual do botão
        String label = cb.span("statusText").in(cb.link("editModeToggleLink")).getText();
        if(label.equals("ATIVAR")) {
            System.out.println("Edição já estava ativada!");
            return true;
        } else {
            cb.link("editModeToggleLink").click();
            return true;
        }

    }
    
    /**
     * Abre a página de um curso, dado um id inteiro;
     * @param course_id ID do curso número inteiro
     */
    public static void navigateToCourse(int course_id) {
        // Monta URL
        String courseUrl = String.format("https://brazcubas.blackboard.com/webapps/blackboard/execute/launcher?type=Course&id=_%d_1&url=",course_id);
        // Navega para URL
        cb.navigateTo(courseUrl);
    }
    
    /**
     * Abre página de um curso dado um id em formato de string;
     * @param course_id ID do curso em formato de string _IDNUMERICO_1
     */
    public static void navigateToCourse(String course_id) {
        // Monta URL
        String courseUrl = String.format("https://brazcubas.blackboard.com/webapps/blackboard/execute/launcher?type=Course&id=%s&url=",course_id);
        // Navega para URL
        cb.navigateTo(courseUrl);
    }
    
    public static void openAddContentForm(String contentType) {
        // Seletor do botão mainButton 
        cb.link("Criar conteúdo").mouseOver();
        cb.link(contentType).in(cb.div("#bcMenu")).click();
    }
}
