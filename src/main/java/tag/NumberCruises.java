package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class NumberCruises extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("HELLO WORLD !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SKIP_BODY;
    }
}
