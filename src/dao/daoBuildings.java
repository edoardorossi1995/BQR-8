package dao;

import java.sql.*;

public class daoBuildings {

	public void insertBuilding(String nome, String macroarea) throws Exception {

		Connection conn = null;
		try{
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
			Statement interrogazione = conn.createStatement();
			interrogazione.executeQuery("insert into building(nomeedificio,macroarea) "
					+ "values('" + nome + "','" + macroarea + "')");
		}
	    catch (SQLException e) {e.printStackTrace();
	    }
        catch (Exception e) {e.printStackTrace();
	    }
        finally {
        conn.close();
        }
    }

	public boolean isThere(String nome, String macroarea) throws Exception{
		Connection conn = null;
		boolean x = false;
		try{
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
			Statement interrogazione = conn.createStatement();
			ResultSet result = interrogazione.executeQuery("select * from building");
			while (result.next()){
				if (result.getString("nomeedificio").equals(nome) && result.getString("macroarea").equals(macroarea)){
					x = true;
					break;
				}

			}
		}
	    catch (SQLException e) {e.printStackTrace();
	    }
        catch (Exception e) {e.printStackTrace();
	    }
        finally {
        conn.close();
        }
		return x;
	}

	public String printBuildings() throws Exception{

		String stampa = "";
		Connection conn = null;
		try{
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
			Statement interrogazione = conn.createStatement();
			ResultSet risultato = interrogazione.executeQuery("select * from building");
			while (risultato.next()) {
				stampa = stampa + risultato.getString("nomeedificio") + "  " +  risultato.getString("macroarea")
				+ "\n";
			}
		}
	    catch (SQLException e) {e.printStackTrace();
	    }
        catch (Exception e) {e.printStackTrace();
	    }
        finally {
        conn.close();
        }
		return stampa;

    }

	public void deleteEdificio(String nomeEdificio, String macroarea) throws Exception {

        Connection conn = null;

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
            Statement interrogazione = conn.createStatement();
            interrogazione.executeQuery("DELETE FROM building\n "
                    + "WHERE nomeedificio = '" + nomeEdificio + "' and macroarea = '" + macroarea + "' ");
        }

        catch (SQLException e) {e.printStackTrace();
        }
        catch (Exception e) {e.printStackTrace();
        }
        finally {
            conn.close();
        }
    }

    public void updateNomeEdificio(String oldName,String macroarea, String newName ) throws Exception {

        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
            Statement interrogazione = conn.createStatement();
            interrogazione.executeQuery(
            		"update building\n "
                    + "set nomeedificio = '" + newName + "'\n"
            		+ "where nomeedificio = '" + oldName
            		+ "' and macroarea = '" + macroarea + "'");
        }

        catch (SQLException e) {e.printStackTrace();
        }
        catch (Exception e) {e.printStackTrace();
        }
        finally {
            conn.close();
        }
    }

    public void updateMacroareaEdificio(String name, String oldMacroarea, String newMacroarea ) throws Exception {


        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
            Statement interrogazione = conn.createStatement();
            interrogazione.executeQuery(
            		  "update building\n "
                    + "set macroarea = '" + newMacroarea + "'\n"
            		+ "where nomeedificio = '" + name
            		+ "' and macroarea = '" + oldMacroarea + "'");
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
