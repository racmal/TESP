package br.unibh.persistencia;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
 


import br.unibh.entidades.Aluno;
 
public class AlunoDAO implements DAO<Aluno, Long> {
 
	
		public AlunoDAO() {
		
		}
	
        private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
 
        public Aluno find(Long id) {
                try {
                        PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
                                        "SELECT * FROM TB_ALUNO WHERE ID = ?");
                        ps.setLong(1, id);
                        ResultSet row = ps.executeQuery();
 
                        if (row.next()) {
                                return new Aluno(row.getLong("ID"), row.getLong("MATRICULA"),
                                                row.getString("NOME"), row.getString("CPF"),
                                                row.getString("DATA_ANIVERSARIO") == null ? null : df
                                                                .parse(row.getString("DATA_ANIVERSARIO")));
                        }
 
                        JDBCUtil.closeConnection();
 
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;
        }
 
        public Aluno findByCPF(String cpf) {
                try {
                        PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
                                        "SELECT * FROM TB_ALUNO WHERE CPF = ?");
                        ps.setString(1, cpf);
                        ResultSet row = ps.executeQuery();
 
                        if (row.next()) {
                                return new Aluno(row.getLong("ID"), row.getLong("MATRICULA"),
                                                row.getString("NOME"), row.getString("CPF"),
                                                row.getString("DATA_ANIVERSARIO") == null ? null : df
                                                                .parse(row.getString("DATA_ANIVERSARIO")));
                        }
 
                        JDBCUtil.closeConnection();
 
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;
        }
 
        public void insert(Aluno t) {
                try {
                        PreparedStatement ps = JDBCUtil
                                        .getConnection()
                                        .prepareStatement(
                                                        "INSERT INTO TB_ALUNO (MATRICULA, NOME, CPF, DATA_ANIVERSARIO) VALUES (?, ?, ?, ?);");
                        ps.setLong(1, t.getMatricula());
                        ps.setString(2, t.getNome());
                        ps.setString(3, t.getCpf());
                       
                        if (t.getDataAniversario() == null)
                                ps.setNull(4, Types.NULL);
                        else
                                ps.setString(4, df.format(t.getDataAniversario()));
 
                        ps.executeUpdate();
 
                        JDBCUtil.closeConnection();
                } catch (Exception e) {
 
                }
        }
 
        public void update(Aluno t) {
                // TODO Auto-generated method stub
        	try {
                PreparedStatement ps = JDBCUtil
                                .getConnection()
                                .prepareStatement(
                                                "UPDATE TB_ALUNO SET MATRICULA = ?, NOME = ?, DATA_ANIVERSARIO = ?");
                ps.setLong(1, t.getMatricula());
                ps.setString(2, t.getNome());
                               
                if (t.getDataAniversario() == null)
                        ps.setNull(3, Types.NULL);
                else
                        ps.setString(3, df.format(t.getDataAniversario()));

                ps.executeUpdate();

                JDBCUtil.closeConnection();
        } catch (Exception e) {

        }
        }
 
        public void delete(Aluno t) {
                // TODO Auto-generated method stub
        	try {
    			String sql = "DELETE FROM TB_ALUNO WHERE CPF = ? LIMIT 1;";
    			PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
    					sql);
    			ps.setString(1, t.getCpf());

    			ps.executeUpdate();

    			JDBCUtil.closeConnection();

    		} catch (Exception e) {
    		}
        }
 
        public List<Aluno> findAll() {
                // TODO Auto-generated method stub
        	ArrayList<Aluno> rows = new ArrayList<Aluno>();

    		try {
    			PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
    					"SELECT * FROM TB_ALUNO;");

    			ResultSet row = ps.executeQuery();

    			while (row.next()) {
    				rows.add(new Aluno(row.getLong("ID"), row.getLong("MATRICULA"),
    						row.getString("NOME"), row.getString("CPF"), row
    								.getString("DATA_ANIVERSARIO") == null ? null
    								: df.parse(row.getString("DATA_ANIVERSARIO"))));
    			}

    			JDBCUtil.closeConnection();
    			
    			return rows;

    		} catch (Exception e) {
    			e.printStackTrace();
    		}

    		return null;
    	}
 
}