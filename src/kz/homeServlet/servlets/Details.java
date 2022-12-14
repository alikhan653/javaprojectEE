package kz.homeServlet.servlets;

import kz.homeServlet.db.DBManager;
import kz.homeServlet.db.Items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class Details extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Long itemId = -1L;
        try {

            itemId = Long.parseLong(id);

        }catch (Exception e){
            e.printStackTrace();
        }

        Items item = DBManager.getItem(itemId);


        request.setAttribute("tovar", item);
        request.getRequestDispatcher("details.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
