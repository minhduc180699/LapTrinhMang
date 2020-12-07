/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverv2;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import rmiv2.IControl;

/**
 *
 * @author minhduc
 */
public class G {
    public static Connection connection = Connector.getConnection();
    public static Map<String,String> user = new HashMap<>();
}
