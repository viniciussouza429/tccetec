package br.com.projetoredatec.dao;

import br.com.projetoredatec.model.Aluno;
import br.com.projetoredatec.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements GenericDAO {

    private Connection conn;

    public AlunoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Aluno aluno = (Aluno) object;
        PreparedStatement stmt = null;
        String sql = "Insert into aluno(raaluno, idusuario) values ( ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getRaAluno());
            stmt.setInt(2, new UsuarioDAOImpl().cadastrar(aluno));
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar aluno! Erro: " + ex.getMessage());
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

        List<Object> alunos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select u.*, a.* from aluno a, usuario u where u.idusuario = a.idusuario order by u.nomeusuario;";  

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idaluno"));
                aluno.setIdUsuario(rs.getInt("idusuario"));
                aluno.setNomeUsuario(rs.getString ("nomeusuario"));
                aluno.setEmailUsuario(rs.getString ("emailusuario"));
                aluno.setTelefoneUsuario(rs.getString ("telefoneusuario"));
                aluno.setRaAluno(rs.getString ("raaluno"));
                aluno.setLoginUsuario(rs.getString("loginusuario"));
                aluno.setSenhaUsuario(rs.getString("senhausuario"));
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar alunos! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return alunos;
    }

    @Override
    public Boolean excluir(int idOject) {

        PreparedStatement stmt = null;
        String sql = "delete from aluno where idusuario = ?; commit; delete from usuario where idusuario = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o aluno! Erro" + ex.getMessage());
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
        Aluno aluno = null;
        String sql = "select u.*, a.* from usuario u, aluno a where u.idusuario = a.idusuario and u.idusuaio = ?;"; //revisar no banco

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idaluno"));
                aluno.setIdUsuario(rs.getInt("idusuario"));
                aluno.setNomeUsuario(rs.getString("nomeusuario"));
                aluno.setEmailUsuario(rs.getString("emailusuario"));
                aluno.setTelefoneUsuario(rs.getString("telefoneusuario"));
                aluno.setRaAluno(rs.getString("raaluno"));
                aluno.setLoginUsuario(rs.getString("loginusuario"));
                aluno.setSenhaUsuario(rs.getString("senhausuario"));
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
        return aluno;
    }

    @Override
    public Boolean alterar(Object object) {

     Aluno aluno = (Aluno) object;
        PreparedStatement stmt = null;
        String sql = "update aluno set raaluno = ? where idusuario = ?;"; //revisar no banco
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getRaAluno());
            stmt.setInt(2, aluno.getIdUsuario());
            if (new UsuarioDAOImpl().alterar(aluno)){
                stmt.executeUpdate();
                return true;
            }else{
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar aluno! Erro: " + ex.getMessage());
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

