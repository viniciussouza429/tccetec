
package br.com.projetoredatec.controller;

import br.com.projetoredatec.dao.GenericDAO;
import br.com.projetoredatec.dao.TurmaDAOImpl;
import br.com.projetoredatec.model.Professor;
import br.com.projetoredatec.model.Turma;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CadastrarTurma", urlPatterns = {"/CadastrarTurma"})
public class CadastrarTurma extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
           
            String nomeTurma = request.getParameter("nomeTurma");
            Integer idProfessor = Integer.parseInt(request.getParameter("idProfessor")); 
            

            String mensagem = null;

            Turma turma = new Turma();
            turma.setNomeTurma(nomeTurma);
            turma.setIdProfessor(new Professor(idProfessor));
            try {
                GenericDAO dao = new TurmaDAOImpl();
                if (dao.cadastrar(turma)) {
                    mensagem = "Turma cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Turma. "
                            + "Verifique os dados informados e tente novamente!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("cadastrarturma.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas no Servlet ao cadastrar Turma! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
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
