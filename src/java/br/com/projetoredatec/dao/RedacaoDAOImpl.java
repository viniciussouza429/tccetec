package br.com.projetoredatec.dao;

import br.com.projetoredatec.model.Redacao;
import br.com.projetoredatec.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RedacaoDAOImpl implements GenericDAO {

    private Connection conn;

    public RedacaoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Redacao redacao = (Redacao) object;
        PreparedStatement stmt = null;
        String sql = "Insert into redacao(descredacao, dataentregaredacao) values ( ?, ?);"; //revisar
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, redacao.getDescRedacao());
            stmt.setString(2, redacao.getDataentregaRedacao());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar redação! Erro: " + ex.getMessage());
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
        String sql = "select a.*, m.* from redacao r, aluno a where a.idaluno = m.idaluno order by m.nomemencao;"; //revisar no banco 

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Redacao redacao = new Redacao();
                redacao.setIdRedacao(rs.getInt("idredacao"));
                redacao.setDescRedacao(rs.getString("descredacao"));
                redacao.setDataentregaRedacao(rs.getString("dataentregaredacao"));
                redacoes.add(redacao);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar redação! Erro:" + ex.getMessage());
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
        String sql = "delete from redqacao where idaluno = ?; commit; delete from aluno where idaluno = ?"; //revisar
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o redacao! Erro" + ex.getMessage());
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
        Redacao redacao = null;
        String sql = "select a.*, p.* from aluno a, mencao m where a.idaluno = m.idaluno and a.idaluno = ?;"; //revisar no banco

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                redacao = new Redacao();
                redacao.setIdRedacao(rs.getInt("idredacao"));
                redacao.setDescRedacao(rs.getString("descredacao"));
                redacao.setDataentregaRedacao(rs.getString("dataentregaredacao"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar redacao! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return redacao;
    }

    @Override
    public Boolean alterar(Object object) {

        Redacao redacao = (Redacao) object;
        PreparedStatement stmt = null;
        String sql = "update mencao set descredacao, dataentregaredacao = ?, ? where idaluno = ?;"; //revisar no banco
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, redacao.getDescRedacao());
            stmt.setString(2, redacao.getDataentregaRedacao());
            if (new UsuarioDAOImpl().alterar(redacao)) {
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar redacao! Erro: " + ex.getMessage());
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
