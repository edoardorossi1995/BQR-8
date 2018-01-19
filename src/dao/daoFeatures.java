package dao;

import java.sql.*;

import Control.FeatureController;
import Entity.Feature;
import Entity.Room;

public class daoFeatures extends Throwable {

	private static final long serialVersionUID = 1L;



			public void insertNewFeature(String name, String description) throws Exception {

				Connection conn = null;
				try{
					if (checkForInsertion(name,description) == false){
						int newId = getNewId();

						Class.forName("org.postgresql.Driver");
						conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
						Statement interrogazione = conn.createStatement();
						interrogazione.executeQuery("insert into feature(nomefeature,description,codicefeature) "
								+ "values('" + name + "','" + description + "'," + newId + ")");
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



			public boolean checkForInsertion(String name,String description) throws Exception{
				boolean x = false;
				Connection conn = null;
				try{
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet res = interrogazione.executeQuery(
							  "select * from feature");
					while (res.next()){
						if (res.getString("nomefeature").equals(name)
								&& res.getString("description").equals(description)){
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




			public int getFeatureCode(String nomeFeature,String description) throws Exception{

				Connection conn = null;
				int featureCode = 0;

				try{

					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet result = interrogazione.executeQuery(
							  "select codicefeature\n"
							+ "from feature "
							+ "where nomefeature = '" + nomeFeature
							+ "' and description = '" + description + "'"  );
					while (result.next()){
						featureCode = result.getInt("codicefeature");
					}

				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();
		        }
				return featureCode;

			}




			public void addFeaturesToRoomArray(Room room) throws Exception{
				int roomCode = room.getCodiceStanza();
				Connection conn = null;
				try{
					FeatureController fc = new FeatureController();
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet featureCodes = interrogazione.executeQuery(
							"select codicefeature\n"
							+ "from featureofroom\n"
							+ "where codicestanza = '"+ roomCode + "'");
					while (featureCodes.next()){
						room.addFeatures(fc.getFeature(featureCodes.getInt("codicefeature")));
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

			public String getFeatureName(int codiceFeature) throws Exception {
				Connection conn = null;
				String result = "";
				try{

					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet res = interrogazione.executeQuery(
							"select nomefeature \n"
							+ "from feature \n"
							+ "where codicefeature = " + codiceFeature + "");
					result = res.getString("nomefeature");
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


			public String getFeatureDescription(int codiceFeature) throws Exception {
				Connection conn = null;
				String result = "";
				try{

					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					ResultSet res = interrogazione.executeQuery(
							"select description \n"
							+ "from feature \n"
							+ "where codicefeature = " + codiceFeature + "");
					while (res.next()){
						result = res.getString("description");
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





			public void insertFeatureIntoRoom(Feature feature) throws Exception {

				String nome = feature.getName();
				int numberOfInstances = feature.getNumberOfInstances();
				int codiceStanza = feature.getCodiceStanza();
				String description = feature.getDescription();
				int codiceFeature = feature.getCodiceFeature();

				Connection conn = null;
				try{
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
					Statement interrogazione = conn.createStatement();
					interrogazione.executeQuery("insert into featureofroom(nomecaratteristica,numberofinstances,"
							+ "codicestanza,descrizione,codicefeature) "
							+ "values('"
							+ nome
							+ "',"
							+ numberOfInstances
							+ ","
							+ codiceStanza
							+ ",'"
							+ description
							+ "',"
							+ codiceFeature
							+")");
				}
			    catch (SQLException e) {e.printStackTrace();
			    }
		        catch (Exception e) {e.printStackTrace();
			    }
		        finally {
		        conn.close();
		        }
            }





			public void deleteFeature(int codiceFeature) throws Exception {

	            Connection conn = null;
	            try{
	                Class.forName("org.postgresql.Driver");
	                conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
	                Statement interrogazione = conn.createStatement();
	                interrogazione.executeQuery("delete from feature\n "
							+ "where codicefeature = " + codiceFeature );
	                }
	            catch (SQLException e) {e.printStackTrace();
	            }
	            catch (Exception e) {e.printStackTrace();
	            }
	            finally {
	                conn.close();
	            }
	        }



			public void deleteAllFeatures() throws Exception{

				Connection conn = null;
	            try{
	                Class.forName("org.postgresql.Driver");
	                conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
	                Statement interrogazione = conn.createStatement();
	                interrogazione.executeQuery("delete from feature ");
	                }
	            catch (SQLException e) {e.printStackTrace();
	            }
	            catch (Exception e) {e.printStackTrace();
	            }
	            finally {
	                conn.close();
	            }

			}



			public String printFeatures() throws Exception{

				Connection conn = null;
				String result = "";
	            try{
	                Class.forName("org.postgresql.Driver");
	                conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
	                Statement interrogazione = conn.createStatement();
	                ResultSet res = interrogazione.executeQuery(
	                		"select nomefeature,description,codicefeature"
	                		+ " from feature\n " );
	                while (res.next()){
	                	result = result + res.getString("nomefeature") +"  "
	                	+ res.getString("description") + "  "
	                	+ res.getString("codicefeature") + "\n";
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



//			public String printFeaturesOfRoom() throws Exception{
//
//				String stampa = "";
//				Connection conn = null;
//				try{
//					Class.forName("org.postgresql.Driver");
//					conn = DriverManager.getConnection("jdbc:postgresql:BQRdb","postgres","totigimmi");
//					Statement interrogazione = conn.createStatement();
//					ResultSet risultato = interrogazione.executeQuery("select * from room");
//					while (risultato.next()) {
//						stampa = stampa + risultato.getString("nome") + "  " +  risultato.getString("roomGroup")
//						+ "  " +  risultato.getString("nomeedificio") + "  " +  risultato.getString("macroarea") +
//						" " + risultato.getInt("codicestanza") + "\n";
//					}
//				}
//			    catch (SQLException e) {e.printStackTrace();
//			    }
//		        catch (Exception e) {e.printStackTrace();
//			    }
//		        finally {
//		        conn.close();
//		        }
//				return stampa;
//
//		    }



			public int getNewId() throws Exception {

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
					interrogazione.executeQuery(
							"update codicestanzagenerator\n"
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