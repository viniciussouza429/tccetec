package br.com.projetoredatec.dao;

import br.com.projetoredatec.model.Mencao;
import br.com.projetoredatec.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MencaoDAOImpl implements GenericDAO {

    private Connection conn;

    public MencaoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Mencao mencao = (Mencao) object;
        PreparedStatement stmt = null;
        String sql = "Insert into mencao(nomemencao, descmencao) values ( ?, ?);"; //revisar
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, mencao.getNomeMencao());
            stmt.setString(2, mencao.getDescMencao());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar menção! Erro: " + ex.getMessage());
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
        String sql = "select a.*, m.* from mencao m, aluno a where a.idaluno = m.idaluno order by m.nomemencao;"; //revisar no banco 

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Mencao mencao = new Mencao();
                mencao.setIdMencao(rs.getInt("idmencao"));
                mencao.setNomeMencao(rs.getString("nomemencao"));
                mencao.setDescMencao(rs.getString("descmencao"));
                mencoes.add(mencao);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar menção! Erro:" + ex.getMessage());
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
        String sql = "delete from mencao where idaluno = ?; commit; delete from aluno where idaluno = ?"; //revisar
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o mencao! Erro" + ex.getMessage());
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
        Mencao mencao = null;
        String sql = "select a.*, p.* from aluno a, mencao m where a.idaluno = m.idaluno and a.idaluno = ?;"; //revisar no banco

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                mencao = new Mencao();
                mencao.setIdMencao(rs.getInt("idmencao"));
                mencao.setNomeMencao(rs.getString("nomemencao"));
                mencao.setDescMencao(rs.getString("descmencao"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar mencao! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return mencao;
    }

    @Override
    public Boolean alterar(Object object) {

        Mencao mencao = (Mencao) object;
        PreparedStatement stmt = null;
        String sql = "update mencao set nomemencao, descmencao = ?, ? where idaluno = ?;"; //revisar no banco
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, mencao.getNomeMencao());
            stmt.setString(2, mencao.getDescMencao());
            if (new UsuarioDAOImpl().alterar(mencao)) {
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar mencao! Erro: " + ex.getMessage());
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
