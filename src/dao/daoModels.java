package dao;

import java.sql.*;

import Entity.*;

public class daoModels extends Throwable {

    private static final long serialVersionUID = 1L;



    public void insertModel(String name, String roomGroup) throws Exception {

        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
            Statement interrogazione = conn.createStatement();
            interrogazione.executeQuery("insert into models(name, roomGroup)\n "
                    + "values('" + name + "','" + roomGroup + "')");
           }
        catch (SQLException e) {e.printStackTrace();
        }
        catch (Exception e) {e.printStackTrace();
        }
        finally {
            conn.close();
        }
    }






    public void deleteModel(Modello model) throws Exception {

            String name = model.getName();
            String roomGroup = model.getroomGroup();
            Connection conn = null;
            try{
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql:databse","username","password");
                Statement interrogazione = conn.createStatement();
                interrogazione.executeQuery("delete from models room\n "
						+ "where name = '" + name + "' and roomGroup = '" + roomGroup + "')");
                }
            catch (SQLException e) {e.printStackTrace();
            }
            catch (Exception e) {e.printStackTrace();
            }
            finally {
                conn.close();
            }
      }





    public void updateNameModello(Modello model, String newName) throws Exception {

    	String oldName = model.getName();
    	model.setName(newName);
        String name = model.getName();
        String roomGroup = model.getroomGroup();
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
            Statement interrogazione = conn.createStatement();
            interrogazione.executeQuery("UPDATE modello\n "
                    + "SET name = '" + name + "'\n" + "WHERE name = '" + oldName +
                    "' and roomGroup = '" + roomGroup + "' ");
        }

        catch (SQLException e) {e.printStackTrace();
        }
        catch (Exception e) {e.printStackTrace();
        }
        finally {
            conn.close();
        }
    }



    public void updateRoomGroupModello(Modello model , String newRoomGroup ) throws Exception {

    	String oldRoomGroup = model.getroomGroup();
    	model.setroomGroup(newRoomGroup);
        String name = model.getName();
        String roomGroup = model.getroomGroup();
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
            Statement interrogazione = conn.createStatement();
            interrogazione.executeQuery("UPDATE modello\n "
                    + "SET roomGroup = '" + roomGroup + "'\n" + "WHERE name = '" + name +
                    "' and roomGroup = '" + oldRoomGroup + "' ");
        }

        catch (SQLException e) {e.printStackTrace();
        }
        catch (Exception e) {e.printStackTrace();
        }
        finally {
            conn.close();
        }
    }


}

