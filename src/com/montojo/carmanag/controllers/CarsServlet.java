package com.montojo.carmanag.controllers;

import com.montojo.carmanag.model.Car;
import com.montojo.carmanag.model.DatabaseUtil;
import com.montojo.carmanag.model.Owner;
import com.montojo.carmanag.model.Services;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    private DatabaseUtil databaseUtil;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("In CarsServlet");

        if (!checkLog(req)) {
            req.setAttribute("error", "Please, log in to get access");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);

        } else {
            String carsaction = req.getParameter("carsaction");

            if (carsaction != null) {
                switch (carsaction) {
                    case "newcar":
                        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/newcarform.jsp");
                        requestDispatcher.forward(req,resp);
                        break;
                    default:
                        showMainContent(req, resp);
                }
            } else {
                showMainContent(req, resp);
            }
        }
    }

    private void showMainContent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("error")!=null){
            String message = req.getParameter("error") + " due to wrong data type";
            req.setAttribute("error",message);
        }
        List<Car> carsList;
        carsList = listCars(); //retrieve owners from database
        req.setAttribute("carslist", carsList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cars.jsp");
        dispatcher.forward(req, resp);

    }

    private boolean checkLog(HttpServletRequest req) {

        HttpSession session = req.getSession();
        Boolean loggedIn = (Boolean) session.getAttribute("login");
        databaseUtil = (DatabaseUtil) session.getAttribute("databaseutil");
        if (databaseUtil == null || loggedIn == null || !loggedIn) {
            return false;
        }
//        System.out.println("LoggedIn from session y en method checkLog: " + loggedIn);
        return true;
    }

    private List<Car> listCars() {
        return databaseUtil.getCars();
    }


}
