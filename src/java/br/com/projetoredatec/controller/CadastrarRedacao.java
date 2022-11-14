
package br.com.projetoredatec.controller;

import br.com.projetoredatec.dao.GenericDAO;
import br.com.projetoredatec.dao.RedacaoDAOImpl;
import br.com.projetoredatec.model.Redacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarRedacao", urlPatterns = {"/CadastrarRedacao"})
public class CadastrarRedacao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            String descRedacao = request.getParameter("descRedacao");
            //Date dataentregaRedacao = request.    COLOCAR DATE

            String mensagem = null;

            Redacao redacao = new Redacao();
            redacao.setDescRedacao(descRedacao);
          //  redacao.setDataentregaRedacao(dataentregaRedacao);
            
            try {
                GenericDAO dao = new RedacaoDAOImpl();
                if (dao.cadastrar(redacao)) {
                    mensagem = "Redação cadastrada com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar redação. "
                            + "Verifique os dados informados e tente novamente!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("cadastrarredacao.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas no Servlet ao cadastrar redação! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
