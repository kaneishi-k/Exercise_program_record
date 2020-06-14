package controllers.record;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class RecordIndex
 */
@WebServlet("/record/index")
public class RecordIndex extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }

        List<Record> records = em.createNamedQuery("getAllRecords", Record.class)
                .setFirstResult(28 * (page - 1))
                .setMaxResults(28)
                .getResultList();

        long records_count = (long)em.createNamedQuery("getRecordCount", Long.class)
                .getSingleResult();

        em.close();

        request.setAttribute("records", records);
        request.setAttribute("records_count", records_count);
        request.setAttribute("page", page);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/record/index.jsp");
        rd.forward(request, response);
    }
}

