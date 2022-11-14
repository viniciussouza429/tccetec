
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

@WebServlet(name = "CadastrarProfessor", urlPatterns = {"/CadastrarProfessor"})
public class CadastrarProfessor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            String nomeUsuario = request.getParameter("nomeUsuario");
            String emailUsuario = request.getParameter("emailUsuario");
            String telefoneUsuario = request.getParameter("telefoneUsuario");
            String rmProfessor = request.getParameter("rmProfessor");
            String loginUsuario = request.getParameter("loginUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");

            String mensagem = null;

            Professor professor = new Professor();
            professor.setNomeUsuario(nomeUsuario);
            professor.setEmailUsuario(emailUsuario);
            professor.setTelefoneUsuario(telefoneUsuario);
            professor.setRmProfessor(rmProfessor);
            professor.setLoginUsuario(loginUsuario);
            professor.setSenhaUsuario(senhaUsuario);
            
            try {
                GenericDAO dao = new ProfessorDAOImpl();
                if (dao.cadastrar(professor)) {
                    mensagem = "Professor cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Professor. "
                            + "Verifique os dados informados e tente novamente!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("cadastrarprofessor.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas no Servlet ao cadastrar Professor! Erro: " + ex.getMessage());
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
