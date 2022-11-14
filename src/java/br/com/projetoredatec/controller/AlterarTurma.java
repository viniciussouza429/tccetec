/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetoredatec.controller;

import br.com.projetoredatec.dao.GenericDAO;
import br.com.projetoredatec.dao.TurmaDAOImpl;
import br.com.projetoredatec.model.Turma;
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
@WebServlet(name = "AlterarTurma", urlPatterns = {"/AlterarTurma"})
public class AlterarTurma extends HttpServlet {

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
            Integer idTurma = Integer.parseInt(request.getParameter("idTurma"));
            Integer idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
            String nomeTurma = request.getParameter("nomeTurma");

            String mensagem = null;

            Turma turma = new Turma();
            turma.setIdTurma(idTurma);
//            turma.setIdProfessor(idProfessor); //revisar se precisa ter o id professor
            turma.setNomeTurma(nomeTurma);
            
            try {
                GenericDAO dao = new TurmaDAOImpl();
                if (dao.alterar(turma)) {
                    mensagem = "turma alterado com sucesso.";
                } else {
                    mensagem = "Problemas ao alterar turma.";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarTurma").forward(request, response);

            } catch (Exception e) {
                System.out.println("Problemas no Servlet ao alterar turma! Erro: "
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
