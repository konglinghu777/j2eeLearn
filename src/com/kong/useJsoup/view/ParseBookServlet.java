package com.kong.useJsoup.view;

import com.kong.useJsoup.model.parseBookDetial;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ParseBookServlet")
public class ParseBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookid");
        //System.out.println(bookId);
        parseBookDetial pbd = new parseBookDetial();
        pbd.setBookId(bookId);


        request.setAttribute("bookname",pbd.getBookName());
        request.setAttribute("author",pbd.getAuthorName());
        request.setAttribute("updatetime",pbd.getUpdateTime());
        request.setAttribute("intro",pbd.bookIntro());
        request.setAttribute("img",pbd.bookImg());

        //章节列表
        List chapter = pbd.parseChapter();

        request.setAttribute("allChapter",chapter);
        request.getRequestDispatcher("bookDetial.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
