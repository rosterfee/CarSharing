package ru.itis.javalab.servlets;

import ru.itis.javalab.models.Car;
import ru.itis.javalab.services.CarsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/catalog_filter")
public class CatalogFilterServlet extends HttpServlet {

    CarsService carsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        carsService = (CarsService) config.getServletContext().getAttribute("carsService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Car> firstList = new ArrayList<>();

        String ls_0_to_100 = req.getParameter("ls_0_to_100");
        String ls_100_to_250 = req.getParameter("ls_100_to_250");
        String ls_250_to_500 = req.getParameter("ls_250_to_500");
        String ls_500_plus = req.getParameter("ls_500_plus");

        if (ls_0_to_100 != null || ls_100_to_250 != null || ls_250_to_500 != null || ls_500_plus != null) {
            if (req.getParameter("ls_0_to_100") != null) {
                firstList.addAll(carsService.getAllByLs(0, 100));
            }
            if (req.getParameter("ls_100_to_250") != null) {
                firstList.addAll(carsService.getAllByLs(100, 250));
            }
            if (req.getParameter("ls_250_to_500") != null) {
                firstList.addAll(carsService.getAllByLs(250, 500));
            }
            if (req.getParameter("ls_500_plus") != null) {
                firstList.addAll(carsService.getAllByLs(500));
            }
        }
        else firstList.addAll(carsService.getAll());

        List<Car> secondList;
        List<Car> thirdList;
        boolean flag;
        for (int i = 1; i < 5; i++) {
            flag = true;
            secondList = new ArrayList<>();
            thirdList = new ArrayList<>();
            if (i == 1) {
                if (req.getParameter("price_0_to_10000") != null) {
                    secondList.addAll(carsService.getAllByPrice(0, 10000));
                }
                else if (req.getParameter("price_10000_to_50000") != null) {
                    secondList.addAll(carsService.getAllByPrice(10000, 50000));
                }
                else if (req.getParameter("price_50000_plus") != null) {
                    secondList.addAll(carsService.getAllByPrice(50000));
                }
                else flag = false;
            }
            else if (i == 2) {
                if (req.getParameter("mark_bmw") != null) {
                    secondList.addAll(carsService.getAllByMark("BMW"));
                }
                else if (req.getParameter("mark_nissan") != null) {
                    secondList.addAll(carsService.getAllByMark("Nissan"));
                }
                else if (req.getParameter("mark_porsche") != null) {
                    secondList.addAll(carsService.getAllByMark("Porsche"));
                }
                else if (req.getParameter("mark_other") != null) {
                    secondList.addAll(carsService.getAllExceptMarks("BMW", "Nissan", "Porsche"));
                } else flag = false;
            }
            else if (i == 3) {
                if (req.getParameter("engine_before_1") != null) {
                    secondList.addAll(carsService.getAllByEngine(0, 1));
                }
                else if (req.getParameter("engine_1_to_2.5") != null) {
                    secondList.addAll(carsService.getAllByEngine(1, 2.5));
                }
                else if (req.getParameter("engine_2.5_plus") != null) {
                    secondList.addAll(carsService.getAllByEngine(2.5));
                } else flag = false;
            }
            else {
                if (req.getParameter("mechanic") != null) {
                    secondList.addAll(carsService.getAllByBox("Механика"));
                }
                else if (req.getParameter("automatic") != null) {
                    secondList.addAll(carsService.getAllByBox("Автомат"));
                } else flag = false;
                System.out.println("второй лист: " + secondList);
            }

            if (!secondList.isEmpty() || flag) {
                for (Car car : firstList) {
                    for (Car car1 : secondList) {
                        if (car.getId() == car1.getId()) {
                            thirdList.add(car);
                            break;
                        }
                    }
                }
                firstList = thirdList;
            }
        }

        req.setAttribute("catalog", "kostil");
        req.setAttribute("cars", firstList);
        req.getRequestDispatcher("freemarker/catalog.ftl").forward(req, resp);
    }
}
