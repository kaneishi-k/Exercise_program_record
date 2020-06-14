package controllers.record;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Record;
import utils.DBUtil;

/**
 * Servlet implementation class RecordCreate
 */
@WebServlet("/record/create")
public class RecordCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Record r = new Record();

        Date record_date = new Date(System.currentTimeMillis());
        String rd_str = request.getParameter("record_date");
        if(rd_str != null && !rd_str.equals("")) {
            record_date = Date.valueOf(request.getParameter("report_date"));
        }
        r.setRecord_date(record_date);

        r.setMenu(request.getParameter("menu"));
        r.setComment(request.getParameter("comment"));

        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        request.getSession().setAttribute("flush", "登録が完了しました。");

        response.sendRedirect(request.getContextPath() + "/record/index");
    }


}
