package br.com.projetoredatec.dao;

import br.com.projetoredatec.model.Usuario;
import br.com.projetoredatec.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOImpl {

    private Connection conn;

    public UsuarioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Integer cadastrar(Usuario usuario) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idUsuario = null;

        String sql = "Insert into usuario(nomeusuario, emailusuario, telefoneusuario) values ( ?, ?, ?) returning idusuario;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getTelefoneUsuario());
            rs = stmt.executeQuery();

            if (rs.next()) {
                idUsuario = rs.getInt("idusuario");
            }

        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar usuário! Erro: " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }

            return idUsuario; 
        }
    }
    
    
     public Boolean alterar(Usuario usuario) {
        PreparedStatement stmt = null;
        String sql = "update usuario set nomeusuario = ?, emailusuario = ?, telefoneusuario = ? where idusuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getTelefoneUsuario());
            stmt.setInt(4, usuario.getIdUsuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Usuario! Erro" + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os perâmetros de conexão! Erro" + ex.getMessage());
            }
        }
    }
     public Object logarUsuario(String login, String senha) {

 

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        String sql = "select a.*,p.*, u.* from aluno a,professor p, usuario u "
                + "where u.idusuario = a.idusuario and u.idusuario = p.idusuario and loginusuario = ? "
                + "and senhausuario = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setLoginUsuario(rs.getString("loginusuario"));
                usuario.setSenhaUsuario(rs.getString("senhausuario"));
                usuario.setNomeUsuario(rs.getString("nomeusuario"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao encontrar usuario. ERRO : " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! ERRO: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return usuario;
    }
}
