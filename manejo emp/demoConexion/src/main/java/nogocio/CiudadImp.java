package nogocio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import demoConexion.conexion;
import modelo.Ciudad;

public class CiudadImp extends conexion {
	 //atributos
	private PreparedStatement pstCiudades=null;
	private ResultSet rsCiudades=null;
	private String query="";
	private List<Ciudad> listaCiudades=new ArrayList<>();
	
	
	public  List<Ciudad> findAll(){
		this.query="SELECT*FROM ciudades";
		
		try {
			if(this.getConnection()!=null) {
				this.pstCiudades=this.getConnection().prepareStatement(query);
				this.rsCiudades=this.pstCiudades.executeQuery();
				while(this.rsCiudades.next()) {
					Ciudad ciudad=new Ciudad();
					ciudad.setId(this.rsCiudades.getLong("id"));
					ciudad.setNombre_ciudad(this.rsCiudades.getString("nombre_ciudad"));
					ciudad.setCodigo_ciudad(this.rsCiudades.getString("codigo_ciudad"));
					this.listaCiudades.add(ciudad);
				}
				
			}else {
				System.out.println("fallo  la connexion");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return this.listaCiudades;
		
	}

}
