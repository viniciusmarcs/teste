package br.com.devmedia.managebeans;

import java.io.Serializable;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 *
 * @author nbuser
 */
@ManagedBean(name = "UserNumberBean")
@SessionScoped
public class UserNumberBean implements Serializable {

    Integer randomInt;
    Integer userNumber;
    String response;
    
    private static Logger logger;
    
    static {
    	logger = Logger.getLogger(UserNumberBean.class);
    }

    /** Creates a new instance of UserNumberBean */
    public UserNumberBean() {
        Random randomGR = new Random();
        randomInt = new Integer(randomGR.nextInt(10));
        
        if( logger.isDebugEnabled() ) {
        	logger.debug("Duke's number: " + randomInt);
        }
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public String getResponse() {
        if( logger.isDebugEnabled() ) {
        	logger.debug("Duke response: " + randomInt);
        }
        
        if ((userNumber != null) && (userNumber.compareTo(randomInt) == 0)) {
            //invalidate user session
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();

            return "Yay! You got it!";
        } else {

            // including HTML requires that you set escape="false" in view
            return "<p>Sorry, " + userNumber + " isn't it.</p>"
                    + "<p>Guess again...</p>";
        }
    }
}
