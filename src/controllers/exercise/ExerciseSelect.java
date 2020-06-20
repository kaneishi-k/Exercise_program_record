package controllers.exercise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Exercise;
import utils.DBUtil;

/**
 * Servlet implementation class ExerciseSelect
 */
@WebServlet("/select")
public class ExerciseSelect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExerciseSelect() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //リクエストパラメータを取得する
        String body_parts = request.getParameter("body_parts");
        String duration = request.getParameter("duration");

      //データベースからエクササイズリストを取得する
        EntityManager em = DBUtil.createEntityManager();

        List<Exercise> exercises = em.createNamedQuery("getAllExercises", Exercise.class).getResultList();
        List<Exercise> trunkExercises = em.createNamedQuery("getAllTrunkExercises", Exercise.class).getResultList();
        List<Exercise> lowerExercises = em.createNamedQuery("getAllLowerExercises", Exercise.class).getResultList();
        List<Exercise> upperExercises = em.createNamedQuery("getAllUpperExercises", Exercise.class).getResultList();

        em.close();

        List<Exercise> menu = new ArrayList<Exercise>(); //ランダムに選択された要素を持たせるリスト

        if(duration == "2" && body_parts == "3") {
            //各exerciseからランダムに1つずつ取得
            Collections.shuffle(trunkExercises);
            menu.set(0, trunkExercises.get(0));

            Collections.shuffle(lowerExercises);
            menu.set(1, lowerExercises.get(0));

            Collections.shuffle(upperExercises);
            menu.set(2, upperExercises.get(0));

            request.setAttribute("menu", menu );


        } else if (duration == "2" && body_parts == "2"){
            //trunkExerciseからランダムに3つ取得

            Collections.shuffle(trunkExercises);
            for(int i =0; i < 3; i++){
                menu.set(i, trunkExercises.get(i));
            request.setAttribute("menu", menu);
            }

        } else if (duration =="2" && body_parts == "1") {
            //loweExerciseから3つ取得
            Collections.shuffle(lowerExercises);
            for(int i =0; i < 3; i++){
                menu.set(i, lowerExercises.get(i));
            request.setAttribute("menu", menu);
            }


        } else if (duration == "2" && body_parts == "0") {
            //upperExerciseから3つ取得
            Collections.shuffle(upperExercises);
            for(int i =0; i < 3; i++){
                menu.set(i, upperExercises.get(i));
            request.setAttribute("menu", menu);
            }


        } else if (duration == "1" && body_parts == "3") {
            //exerciseからランダムに2つ取得
            Collections.shuffle(exercises);
            for(int i =0; i < 2; i++){
                menu.set(i, exercises.get(i));
            request.setAttribute("menu", menu);
            }

        } else if (duration == "1" && body_parts == "2") {
            //trunkExerciseからランダムに2つ取得
            Collections.shuffle(trunkExercises);
            for(int i =0; i < 2; i++){
                menu.set(i, trunkExercises.get(i));
            request.setAttribute("menu", menu);
            }

        } else if (duration == "1" && body_parts == "1") {
            //lowerExerciseからランダムに2つ取得
            Collections.shuffle(lowerExercises);
            for(int i =0; i < 2; i++){
                menu.set(i, lowerExercises.get(i));
            request.setAttribute("menu", menu);
            }

        } else if (duration == "1" && body_parts == "0") {
            //upperExerciseからランダムに2つ取得
            Collections.shuffle(upperExercises);
            for(int i =0; i < 2; i++){
                menu.set(i, upperExercises.get(i));
            request.setAttribute("menu", menu);
            }


        } else if (duration == "0" && body_parts == "3") {
            //exerciseからランダムに1つ取得
            Collections.shuffle(exercises);
            for(int i =0; i < 1; i++){
                menu.set(i, exercises.get(i));
            request.setAttribute("menu", menu);
            }

        } else if (duration == "0" && body_parts == "2") {
            //trunkExerciseからランダムに1つ取得
            Collections.shuffle(trunkExercises);
            for(int i =0; i < 1; i++){
                menu.set(i, trunkExercises.get(i));
            request.setAttribute("menu", menu);
            }

        } else if (duration == "0" && body_parts == "1") {
            //lowerExerciseからランダムに1つ取得
            Collections.shuffle(lowerExercises);
            for(int i =0; i < 1; i++){
                menu.set(i, lowerExercises.get(i));
            request.setAttribute("menu", menu);
            }

        } else if (duration == "0" && body_parts == "0") {
            //upperExerciseからランダムに1つ取得
            Collections.shuffle(upperExercises);
            for(int i =0; i < 1; i++){
                menu.set(i, upperExercises.get(i));
            request.setAttribute("menu", menu);
        }




      //ビューとなるJSPを指定して表示する
       RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/menu.jsp");
       rd.forward(request, response);

       }
    }
}
