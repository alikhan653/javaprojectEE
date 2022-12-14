package kz.homeServlet.servlets;

import kz.homeServlet.db.DBManager;
import kz.homeServlet.db.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteItem")
public class DeleteItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Items item = DBManager.getItem(id);

        if (item != null) {
            DBManager.deleteItem(item);
        }

        response.sendRedirect("/");

    }

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
        request.getRequestDispatcher("editItem.jsp").forward(request,response);
    }


}
