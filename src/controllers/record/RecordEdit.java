package controllers.record;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Record;
import utils.DBUtil;

/**
 * Servlet implementation class RecordEdit
 */
@WebServlet("/record/edit")
public class RecordEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Record r = em.find(Record.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("record", r);



        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/record/edit.jsp");
        rd.forward(request, response);
    }

}
