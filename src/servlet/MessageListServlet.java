package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.ChatMessage;


@WebServlet(name = "MessageListServlet")
public class MessageListServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Установить кодировку HTTP-ответа UTF-8
        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();

        pw.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'/><meta http-equiv='refresh' content='10'></head>");
        pw.println("<body>");
        int i;
        for(i = messages.size()-1; i >= 0; i--) {
            ChatMessage aMessage = messages.get(i);
            double temp = (double)i / messages.size();
            if (temp > 0.6)
                pw.println("<div><strong>"+ aMessage.getAuthor().getName() + " :<style> .colortext { color:red;} </style> <span class=colortext>"+ aMessage.getMessage() +  "</span></strong></div>");
            if (temp > 0.2 && temp < 0.6)
                pw.println("<div><strong>"+ aMessage.getAuthor().getName() + " :<style> .colortext1 { color:black;} </style> <span class=colortext1>"+ aMessage.getMessage() +  "</span></strong></div>");
            if (temp < 0.2)
                pw.println("<div><strong>"+ aMessage.getAuthor().getName() + " :<style> .colortext2 { color:green;} </style> <span class=colortext2>"+ aMessage.getMessage() +  "</span></strong></div>");

        }

        pw.println("</body></html>");
    }
}