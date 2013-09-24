/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placement.controllers;

import com.placement.business.DepartmentBLRemote;
import com.placement.entity.College;
import com.placement.entity.Department;
import com.placement.utility.EJBWrapperFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kemele
 */
public class DepartmentController extends HttpServlet {
    

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        EJBWrapperFactory factory = new EJBWrapperFactory();
       DepartmentBLRemote departmentBL = factory.getDepartmentBL();
        try {
            List<Department> departments = new ArrayList<Department>();
            if (request.getParameter("action").equals("fetchData")) {
                response.setContentType("text/xml;charset=UTF-8");
                String rows = request.getParameter("rows");
                String page = request.getParameter("page");
                try {
                    departments = departmentBL.getAll();
                    factory.close();
                    int pageIndex = 0;
                    int pageSize = 10;
                    int totalPages = 0;
                    int totalRecords = departments.size();
                    try {
                        pageIndex = Integer.parseInt(page) - 1;
                        pageSize = Integer.parseInt(rows);

                        if (totalRecords > 0) {
                            if (totalRecords % pageSize == 0) {
                                totalPages = totalRecords / pageSize;
                            } else {
                                totalPages = (totalRecords / pageSize) + 1;
                            }

                        } else {
                            totalPages = 0;

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int last = (pageIndex * pageSize) + pageSize;
                    if (last >= totalRecords) {
                        last = totalRecords;
                    }
                    int start = pageIndex * pageSize;
                    if (start < 0) {
                        start = 0;
                    }
                    List<Department> departmentls = departments.subList(start, last);
                    out.print("<?xml version='1.0' encoding='utf-8'?>\n");
                    out.print("<rows>");

                    out.print("<page>" + request.getParameter("page") + "</page>");

                    out.print("<total>" + totalPages + "</total>");
                    out.print("<records>" + totalRecords + "</records>");

                    for (Department cdo : departmentls) {
                        try {
                            out.print("<row id='" + cdo.getId() + "'>");
                            out.print("<cell>" + cdo.getId() + "</cell>");
                            out.print("<cell>" + cdo.getCode() + "</cell>");
                            out.print("<cell>" + cdo.getName() + "</cell>");
                            out.print("<cell>" + cdo.getAddress() + "</cell>");
                            out.print("<cell>" + cdo.getDescription() + "</cell>");
                            out.print("<cell>" + cdo.getCollegeId().getName() + "</cell>");
                            out.print("<cell>" + cdo.getCollegeId().getId() + "</cell>");
                            out.print("</row>");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    out.print("</rows>");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (request.getParameter("action").equals("updateData")) {
                response.setContentType("text/xml;charset=UTF-8");
                String oper = request.getParameter("oper");

                String code = request.getParameter("code");
                String name = request.getParameter("name");
                String collegeId = request.getParameter("collegeId");
                String address = request.getParameter("address");
                String desc = request.getParameter("description");
                Department d = new Department();
                d.setCollegeId(new College());
                String id = request.getParameter("id");
                if (id != null && (oper.equals("edit") || oper.equals("del"))) {
                    try {
                        d.setId(Integer.parseInt(id));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                d.setCode(code);
                d.setName(name);
                d.getCollegeId().setId(Integer.parseInt(collegeId));
                d.setAddress(address);
                d.setDescription(desc);
                if (oper.equals("edit")) {
                    try {
                        if (departmentBL.update(d)) {
                            out.print("<info>success</info>");
                        } else {
                            out.print("<info>failed</info>");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    factory.close();
                } else if (oper.equals("add")) {
                    try {
                        if (departmentBL.save(d)) {
                            out.print("<info>success</info>");
                        } else {
                            out.print("<info>failed</info>");
                        }
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    factory.close();
                } else if (oper.equals("del")) {
                    try {
                        if (departmentBL.delete(Integer.parseInt(id))) {
                            out.print("<info>success</info>");
                        } else {
                            out.print("<info>failed</info>");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    factory.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
