package br.com.projetoredatec.dao;

import br.com.projetoredatec.model.Professor;
import br.com.projetoredatec.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAOImpl implements GenericDAO {

    private Connection conn;

    public ProfessorDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Professor professor = (Professor) object;
        PreparedStatement stmt = null;
        String sql = "Insert into professor(rmprofessor, idusuario) values ( ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getRmProfessor());
            stmt.setInt(2, new UsuarioDAOImpl().cadastrar(professor));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar professor! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {

        List<Object> professores = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select u.*, p.* from professor p, usuario u where u.idusuario = p.idusuario order by u.nomeusuario;"; //revisar no banco 

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();
                professor.setIdProfessor(rs.getInt("idprofessor"));
                professor.setIdUsuario(rs.getInt("idusuario"));
                professor.setNomeUsuario(rs.getString ("nomeusuario"));
                professor.setEmailUsuario(rs.getString ("emailusuario"));
                professor.setTelefoneUsuario(rs.getString ("telefoneususario"));
                professor.setRmProfessor(rs.getString ("rmprofessor"));
                professor.setLoginUsuario(rs.getString("loginusuario"));
                professor.setSenhaUsuario(rs.getString("senhausuario"));
                professores.add(professor); 
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar professores! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return professores;
    }

    @Override
    public Boolean excluir(int idOject) {

        PreparedStatement stmt = null;
        String sql = "delete from professor where idusuario = ?; commit; delete from usuario where idusuario = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o professor! Erro" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Professor professor = null;
        String sql = "select u.*, p.* from usuario u, professor p where u.idusuario = p.idusuario and u.idusuaio = ?;"; //revisar no banco

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                professor = new Professor();
                professor.setIdProfessor(rs.getInt("idprofessor"));
                professor.setIdUsuario(rs.getInt("idusuario"));
                professor.setNomeUsuario(rs.getString("nomeusuario"));
                professor.setEmailUsuario(rs.getString("emailusuario"));
                professor.setTelefoneUsuario(rs.getString("telefoneusuario"));
                professor.setRmProfessor(rs.getString("rmprofessor"));
                professor.setLoginUsuario(rs.getString("loginusuario"));
                professor.setSenhaUsuario(rs.getString("senhausuario"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar aluno! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return professor;
    }

    @Override
    public Boolean alterar(Object object) {

     Professor professor = (Professor) object;
        PreparedStatement stmt = null;
        String sql = "update professor set rmprofessor = ? where idusuario = ?;"; //revisar no banco
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getRmProfessor());
            stmt.setInt(2, professor.getIdUsuario());
            if (new UsuarioDAOImpl().alterar(professor)){
                stmt.executeUpdate();
                return true;
            }else{
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar professor! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: "
                        + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

