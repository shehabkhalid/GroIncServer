/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributes;

import java.util.List;
import javafx.scene.control.*;

/**
 *
 * @author shehab
 */
abstract public class alerts
  {

    public static void error(String title, String header, String message)
      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();  
      }
    
  }
