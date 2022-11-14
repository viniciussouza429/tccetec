/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author Aluno
 */
@WebServlet(name = "AlterarAluno", urlPatterns = {"/AlterarAluno"})
public class AlterarAluno extends HttpServlet { 

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
        try (PrintWriter out = response.getWriter()) {
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            Integer idAluno = Integer.parseInt(request.getParameter("idAluno"));
            String raAluno = request.getParameter("raAluno");
            String nomeUsuario = request.getParameter("nomeUsuario");
            String emailUsuario = request.getParameter("emailUsuario");
            String telefoneUsuario = request.getParameter("telefoneUsuario");
            String loginUsuario = request.getParameter("loginUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");
            

            String mensagem = null;

            Aluno aluno = new Aluno();
            aluno.setIdUsuario(idUsuario);
            aluno.setIdAluno(idAluno);
            aluno.setRaAluno(raAluno);
            aluno.setNomeUsuario(nomeUsuario);
            aluno.setEmailUsuario(emailUsuario);
            aluno.setTelefoneUsuario(telefoneUsuario);
            aluno.setLoginUsuario(loginUsuario);
            aluno.setSenhaUsuario(senhaUsuario);
            
            try {
                GenericDAO dao = new AlunoDAOImpl();
                if (dao.alterar(aluno)) {
                    mensagem = "Aluno alterado com sucesso.";
                } else {
                    mensagem = "Problemas ao alterar Aluno.";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarAluno").forward(request, response);

            } catch (Exception e) {
                System.out.println("Problemas no Servlet ao alterar Aluno! Erro: "
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
