
package br.com.projetoredatec.controller;

import br.com.projetoredatec.dao.AlunoDAOImpl;
import br.com.projetoredatec.dao.GenericDAO;
import br.com.projetoredatec.model.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CadastrarAluno", urlPatterns = {"/CadastrarAluno"})
public class CadastrarAluno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
            String nomeUsuario = request.getParameter("nomeUsuario");
            String emailUsuario = request.getParameter("emailUsuario");
            String telefoneUsuario = request.getParameter("telefoneUsuario");
            String raAluno = request.getParameter("raAluno");
            String loginUsuario = request.getParameter("loginUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");

            String mensagem = null;

            Aluno aluno = new Aluno();
            aluno.setNomeUsuario(nomeUsuario);
            aluno.setEmailUsuario(emailUsuario);
            aluno.setTelefoneUsuario(telefoneUsuario);
            aluno.setRaAluno(raAluno);
            aluno.setLoginUsuario(loginUsuario);
            aluno.setSenhaUsuario(senhaUsuario);
            
            try {
                GenericDAO dao = new AlunoDAOImpl();
                if (dao.cadastrar(aluno)) {
                    mensagem = "Aluno cadastrado com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Aluno. "
                            + "Verifique os dados informados e tente novamente!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("cadastraraluno.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas no Servlet ao cadastrar Aluno! Erro: " + ex.getMessage());
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
