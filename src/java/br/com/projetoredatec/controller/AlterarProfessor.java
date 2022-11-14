
package br.com.projetoredatec.controller;

import br.com.projetoredatec.dao.GenericDAO;
import br.com.projetoredatec.dao.ProfessorDAOImpl;
import br.com.projetoredatec.model.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarProfessor", urlPatterns = {"/AlterarProfessor"})
public class AlterarProfessor extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            Integer idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
            String rmProfessor = request.getParameter("rmProfessor");
            String nomeUsuario = request.getParameter("nomeUsuario");
            String emailUsuario = request.getParameter("emailUsuario");
            String telefoneUsuario = request.getParameter("telefoneUsuario");
            String loginUsuario = request.getParameter("loginUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");
            

            String mensagem = null;

            Professor professor = new Professor();
            professor.setIdUsuario(idUsuario);
            professor.setIdProfessor(idProfessor);
            professor.setRmProfessor(rmProfessor);
            professor.setNomeUsuario(nomeUsuario);
            professor.setEmailUsuario(emailUsuario);
            professor.setTelefoneUsuario(telefoneUsuario);
            professor.setLoginUsuario(loginUsuario);
            professor.setSenhaUsuario(senhaUsuario);
            
            try {
                GenericDAO dao = new ProfessorDAOImpl();
                if (dao.alterar(professor)) {
                    mensagem = "professor alterado com sucesso.";
                } else {
                    mensagem = "Problemas ao alterar professor.";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarProfessor").forward(request, response);

            } catch (Exception e) {
                System.out.println("Problemas no Servlet ao alterar professor! Erro: "
                        + e.getMessage());
                e.printStackTrace();
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
