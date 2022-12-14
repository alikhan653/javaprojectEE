package kz.homeServlet.servlets;

import kz.homeServlet.db.Countries;
import kz.homeServlet.db.DBManager;
import kz.homeServlet.db.Items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/additem")
public class AddItemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Countries> countries = DBManager.getAllCountries();
        request.setAttribute("stranalar", countries);
        request.getRequestDispatcher("/additem.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long countryId = Long.parseLong(request.getParameter("country_id"));
        String name = request.getParameter("item_name");
        String price = request.getParameter("item_price");
        String amount = request.getParameter("item_amount");

        Countries checkCountry = DBManager.getCountry(countryId);

        if(checkCountry!=null) {

            Items item = new Items();
            item.setName(name);
            item.setAmount(Integer.parseInt(amount));
            item.setPrice(Double.parseDouble(price));
            item.setCountry(checkCountry);

            DBManager.addItems(item);
        }
        response.sendRedirect("/");

    }
}
