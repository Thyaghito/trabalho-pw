package Controller;

import Model.Users;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Neto
 */
@Named("loginController")
@ManagedBean
public class LoginController implements Serializable {
    private Users current;
    private UsersController controller;
    private String erro = "";
    private FacesContext fc;
    private ExternalContext ec;
    private HttpSession sessao;
    private Users userSystem;
    
    public LoginController(){
        current = new Users();
        controller = new UsersController();
        fc = FacesContext.getCurrentInstance();
        ec = fc.getExternalContext();
        sessao = (HttpSession) ec.getSession(true);
    }
    
    public void login(){   
        try{               
            userSystem = this.controller.getUser(this.current.getUsername()); 
            if(userSystem!=null){
                if(current.getPassword().equals(userSystem.getPassword())){                   
                    sessao.setMaxInactiveInterval(1800000);
                    sessao.setAttribute("sys_user", userSystem);                     
                    ec.redirect("movies/List.xhtml");
                }else{
                    setErro("Usuário e/ou Senha inválidos.");
                }
            }
        } catch(IOException ex){
            System.out.println("error:" + ex.getMessage()); 
            setErro("Ocorreu um erro ao realizar o login.");
        }
    }
    
    public void logout() throws IOException{                
        sessao.setAttribute("sys_user", null);
        ec.redirect("../index.xhtml");
    }
    
    public Users getUserSystem(){
        if(userSystem==null){
            userSystem = (Users) sessao.getAttribute("sys_user");
        }
        return userSystem;
    }

    public Users getUser() {
        return current;
    }
    public void setUser(Users user) {
        this.current = user;
    }
    public String getErro() {
        return erro;
    }
    public void setErro(String erro) {
        this.erro = erro;
    }  
}
