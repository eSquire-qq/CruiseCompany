package com.example.cruisecompany.tag;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.entity.Cruise;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class NumberCruises extends TagSupport {

    private final CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            List<Cruise> list = cruiseDAO.readAll();
            int number = list.size();
            out.print(number);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SKIP_BODY;
    }
}
