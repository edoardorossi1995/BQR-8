package dao;

import java.sql.*;

import Control.RoomController;
import Entity.Edificio;

public class daoRooms extends Throwable {

	private static final long serialVersionUID = 1L;



			public void insertRoom(String name, String roomGroup, String nomeEdificio, String macroarea) throws Exception {

				Connection conn = null;
				try{
					int newRoomId = getNewRoomId();

					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					interrogazione.executeQuery("insert into room(nome,roomgroup,nomeedificio,macroarea,codicestanza) "
							+ "values('" + name + "','" + roomGroup + "','" + nomeEdificio  + "','" + macroarea +"',"
							+ newRoomId + ")");

				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();
		        }
            }





			public int getRoomCode(String name, String roomGroup, String nomeEdificio, String macroarea) throws Exception {
				Connection conn = null;
				int result = 0;

				try{

					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet res = interrogazione.executeQuery(
							"select codicestanza \n"
							+ "from room \n"
							+ "where nome = '" + name
							+ "' and roomgroup = '" + roomGroup
							+ "' and nomeedificio = '" + nomeEdificio
							+ "' and macroarea = '" + macroarea + "'");

					while (res.next()){
						result = res.getInt("codicestanza");
					}
				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();
		        }
				return result;
            }

			public void addRoomsToBuildingArray(Edificio building) throws Exception{
				String nomeEdificio = building.getName();
				String macroarea = building.getMacroArea();
				Connection conn = null;
				try{
					RoomController rc = new RoomController();
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet roomCodes = interrogazione.executeQuery(
							"select codicestanza\n"
							+ "from room\n"
							+ "where nomeedificio = '" + nomeEdificio + "'"
							+ "and macroarea = '" + macroarea + "'");
					while (roomCodes.next()){
						building.addRoom(rc.getRoom(roomCodes.getInt("codicestanza")));
					}

				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();
		        }

			}

			public void deleteAllRooms() throws Exception{

				Connection conn = null;
	            try{
	                Class.forName("org.postgresql.Driver");
	                conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
	                Statement interrogazione = conn.createStatement();
	                interrogazione.executeQuery(
	                		"delete from room");
	                }
	            catch (SQLException e) {e.printStackTrace();
	            }
	            catch (Exception e) {e.printStackTrace();
	            }
	            finally {
	                conn.close();
	            }

			}

			public String getRoomName(int codicestanza) throws Exception {
				Connection conn = null;
				String result = "";
				try{

					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet res = interrogazione.executeQuery(
							"select nome \n"
							+ "from room \n"
							+ "where codicestanza = '" + codicestanza + "'");
					result = res.getString("nome");
				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();
		        }
				return result;
            }


			public String getRoomroomgroup(int codicestanza) throws Exception {
				Connection conn = null;
				String result = "";
				try{

					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet res = interrogazione.executeQuery(
							"select roomgroup \n"
							+ "from room \n"
							+ "where codicestanza = '" + codicestanza + "'");
					while (res.next()){
						result = res.getString("roomgroup");
					}
				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();
		        }
				return result;
            }




			public String getRoomNomeEdificio(int codicestanza) throws Exception {
				Connection conn = null;
				String result = "";
				try{

					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet res = interrogazione.executeQuery(
							"select nomeedificio \n"
							+ "from room \n"
							+ "where codicestanza = '" + codicestanza + "'");
					result = res.getString("nomeedificio");
				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();
		        }
				return result;
            }


			public String getRoomMacroarea(int codicestanza) throws Exception {
				Connection conn = null;
				String result = "";
				try{

					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet res = interrogazione.executeQuery(
							"select macroarea \n"
							+ "from room \n"
							+ "where codicestanza = '" + codicestanza + "'");
					result = res.getString("macroarea");
				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();
		        }
				return result;
            }



			public void deleteRoom(int codicestanza) throws Exception {

	            Connection conn = null;
	            try{
	                Class.forName("org.postgresql.Driver");
	                conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
	                Statement interrogazione = conn.createStatement();
	                interrogazione.executeQuery(
	                		"delete from room\n "
							+ "where codicestanza = '" + codicestanza + "'" );
	                }
	            catch (SQLException e) {e.printStackTrace();
	            }
	            catch (Exception e) {e.printStackTrace();
	            }
	            finally {
	                conn.close();
	            }
	      }




			public String printRooms() throws Exception{

				String stampa = "";
				Connection conn = null;
				try{
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet risultato = interrogazione.executeQuery("select * from room");
					while (risultato.next()) {
						stampa = stampa + risultato.getString("nome") + "  " +  risultato.getString("roomGroup")
						+ "  " +  risultato.getString("nomeedificio") + "  " +  risultato.getString("macroarea") +
						" " + risultato.getInt("codicestanza") + "\n";
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



			public int getNewRoomId() throws Exception {

				int CodiceStanza = 0;
				Connection conn = null;

				try{
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");

					Statement interrogazione = conn.createStatement();
					ResultSet OldCodiceStanza = interrogazione.executeQuery("select * from codicestanzagenerator");
					while (OldCodiceStanza.next()){
						CodiceStanza = OldCodiceStanza.getInt("identita") + 1;
					}
					interrogazione.executeQuery("update codicestanzagenerator\n"
							+ "set identita = " + CodiceStanza);
				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();

		        }
				return CodiceStanza;

			}





}