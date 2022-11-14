package br.com.projetoredatec.dao;

import br.com.projetoredatec.model.Turma;
import br.com.projetoredatec.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAOImpl implements GenericDAO {

    private Connection conn;

    public TurmaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Turma turma = (Turma) object;
        PreparedStatement stmt = null;
        String sql = "Insert into turma(nometurma) values (?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, turma.getNomeTurma());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar turma! Erro: " + ex.getMessage());
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

        List<Object> turmas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, t.* from turma t, professor p where p.idprofessor = t.idptofessor order by u.rmprofessor;"; //revisar no banco 

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Turma turma = new Turma();
//                turma.setIdProfessor(rs.getInt("idprofessor")); //revisar
                turma.setIdTurma(rs.getInt("idturma"));
                turma.setNomeTurma(rs.getString ("nometurma"));
                turmas.add(turma); 
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar turmas! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return turmas;
    }

    @Override
    public Boolean excluir(int idOject) {

        PreparedStatement stmt = null;
        String sql = "delete from turma where idprofessor = ?; commit; delete from professor where idprofessor = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o turma! Erro" + ex.getMessage());
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
        Turma turma = null;
        String sql = "select p.*, t.* from professor p, turma t where p.idprofessor = t.idprofessor and p.idprofessor = ?;"; //revisar no banco

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                turma = new Turma();
//                turma.setIdProfessor(rs.getInt("idprofessor")); //revisar
                turma.setIdTurma(rs.getInt("idturma"));
                turma.setNomeTurma(rs.getString("nometurma"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar turma! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return turma;
    }

    @Override
    public Boolean alterar(Object object) {

     Turma turma = (Turma) object;
        PreparedStatement stmt = null;
        String sql = "update turma set nometurma = ? where idturma = ?;"; //revisar no banco
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, turma.getNomeTurma());
//            stmt.setInt(2, turma.getIdProfessor()); //perguntar prof
//            if (new UsuarioDAOImpl().alterar(turma)){
                stmt.executeUpdate();
                return true;
//            }else{
//                return false;
//            }
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar turma! Erro: " + ex.getMessage());
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
